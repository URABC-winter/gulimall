<template>
  <div>
    <el-switch v-model="draggable" active-text="开启拖拽" inactive-text="关闭拖拽"></el-switch>
    <el-button v-if="draggable" @click="batchSave()">批量保存</el-button>
    <el-button type="danger" @click="batchDelete()">批量删除</el-button>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId" 
    :default-expanded-keys="expandedkey" 
    :draggable="draggable" 
    :allow-drop="allowDrop" @node-drop="handleDrop" ref="menuTree">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button v-if="node.level <= 2" type="text" size="mini" @click="append(data)">Append</el-button>
          <el-button type="text" size="mini" @click="edit(data)">Edit</el-button>
          <el-button v-if="node.childNodes.length==0" type="text" size="mini"  @click="remove(node, data)">Delete</el-button>
        </span>
      </span>
    </el-tree>

    <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" :close-on-click-modal="false">
      <el-form :model="category">
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图标">
          <el-input v-model="category.icon" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="计量单位">
          <el-input v-model="category.productUnit" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitType()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {category, addCategory, deleteCategory, getInfo, updateCategory, updateCategories} from "@/api/system/product"
export default {
  data() {
      return {
        draggable: false,
        pCid: [],
        updateNodes: [],
        maxLevel: 0,
        title: "",
        dialogType: "",
        category: {
          name:"", 
          parentCid: 0, 
          catLevel: 0, 
          showStatus: 1, 
          icon: "",
          productUnit: "",
          sort: 0, 
          catId: 0},
        dialogVisible: false,
        menus: [],
        expandedkey: [],
        defaultProps: {
          children: 'childrens',
          label: 'name'
        }
      };
    },
    created() {
      this.getMenu()
    },
    methods: {
      getMenu() {
        this.loading = true;
        category(this.queryParams).then(response => {
            this.menus = response.data;
          }
        );
      },

      batchSave() {
        updateCategories(this.updateNodes).then(response => {
          this.$message({
            message: '菜单顺序修改成功',
            type: 'success'
          });
          this.getMenu();
          this.expandedkey = [this.pCid]
          this.updateNodes = [];
          this.maxLevel = 0
        });
      },

      batchDelete() {
        let catIds = []
        let checkedNodes = this.$refs.menuTree.getCheckedNodes()
        for (let i = 0; i < checkedNodes.length; i++) {
          catIds.push(checkedNodes[i].catId)
        }
        this.$confirm('是否删除【'+catIds+'】菜单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteCategory(catIds).then(response => {
            this.$message({
              message: '菜单删除成功',
              type: 'success'
            });
            this.getMenu()
          })
        }).catch(() => {

        });

      },

      allowDrop(draggingNode, dropNode, type) {
        if (type == "inner" && dropNode.data.parentCid == 0) {
          return false;
        }
        this.countNodeLevel(draggingNode.data)
        //当前拖动节点 + 父节点所在深度不大于3
        let deep = (this.maxLevel - draggingNode.level) + 1
        console.log("deep: ",deep)

        if(type == "inner") {
          return (deep + dropNode.level) <= 3;
        } else {
          return (deep + dropNode.parent.level) <= 3;
        }
      },

      countNodeLevel(node) {
        if (node.childNodes == null) {
          this.maxLevel = 1
        } else if (node.childrens != null && node.childrens.length > 0) {
          for (let i = 0; i < node.childrens.length; i++) {
            if (node.childrens[i].level > this.maxLevel) {
              this.maxLevel = node.childrens[i].level
            }
          }
        } else {
          this.maxLevel = node.catLevel
        }
      },

      handleDrop(draggingNode, dropNode, dropType, ev) {
      //1、当前节点最新的父节点id
      let pCid = 0;
      let siblings = null;
      if (dropType == "before" || dropType == "after") {
        pCid =dropNode.parent.data.catId == undefined? 0 : dropNode.parent.data.catId;
        siblings = dropNode.parent.childNodes;
      } else {
        pCid = dropNode.data.catId;
        siblings = dropNode.childNodes;
      }
      this.pCid.push(pCid);

      //2、当前拖拽节点的最新顺序，
      for (let i = 0; i < siblings.length; i++) {
        if (siblings[i].data.catId == draggingNode.data.catId) {
          //如果遍历的是当前正在拖拽的节点
          let catLevel = draggingNode.level;
          if (siblings[i].level != draggingNode.level) {
            //当前节点的层级发生变化
            catLevel = siblings[i].level;
            //修改他子节点的层级
            this.updateChildNodeLevel(siblings[i]);
          }
          this.updateNodes.push({ catId: siblings[i].data.catId, sort: i, parentCid: pCid, catLevel: catLevel});
        } else {
          this.updateNodes.push({ catId: siblings[i].data.catId, sort: i });
        }
      }
    },

    updateChildNodeLevel(node) {
      if (node.childNodes.length > 0) {
        for (let i = 0; i < node.childNodes.length; i++) {
          var cNode = node.childNodes[i].data;
          this.updateNodes.push({catId: cNode.catId,catLevel: node.childNodes[i].level});
          this.updateChildNodeLevel(node.childNodes[i]);
        }
      }
    },


      edit(data) {
        this.title = "修改"
        this.dialogType = "edit"
        this.dialogVisible = true
        getInfo(data.catId).then(response => {
          this.category.name = data.name
          this.category.catId = data.catId
          this.category.icon = response.data.icon
          this.category.productUnit = response.data.productUnit
          this.category.parentCid = response.data.parentCid
        })
      },

      append(data) {
        this.title = "添加"
        this.dialogType = "add"
        this.dialogVisible = true
        this.category.parentCid = data.catId
        this.category.catLevel = data.catLevel*1 + 1

        //清除之前数据
        this.category.name = ""
        this.category.icon = ""
        this.category.productUnit = ""
        this.category.catId = null
        this.category.sort = 0
        this.category.showStatus = 1
      },

      submitType(){
        if(this.dialogType == "add"){
          this.appendCategory()
        }
        if(this.dialogType == "edit"){
          this.editCategory()
        }
      },

      appendCategory() {
        addCategory(this.category).then(response => {
          console.log("addCategory", response),
          this.$message({
            message: '菜单添加成功',
            type: 'success'
          }),
          this.dialogVisible = false
          this.getMenu()
          this.expandedkey = [this.category.parentCid]
        })
      },

      editCategory() {
        var {catId, name, icon, productUnit} = this.category
        var data = {catId, name, icon, productUnit}
        updateCategory(data).then(response => {
          console.log("updateCategory", response),
          this.$message({
            message: '菜单更新成功',
            type: 'success'
          }),
          this.dialogVisible = false
          this.getMenu()
          this.expandedkey = [this.category.parentCid]
        })
      },

      remove(node, data) {
        this.loading = true;
        this.$confirm('是否删除【'+ data.name +'】菜单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          var ids = [data.catId]
          deleteCategory(ids).then(response => {
            console.log("deleteCategory", response),
            this.$message({
              message: '菜单删除成功',
              type: 'success'
            });
            this.getMenu()
            this.expandedkey = [node.parent.data.catId]
          })
        }).catch(() => {

        });
        console.log("remove", node, data)
      },
    }
}
</script>

<style>

</style>