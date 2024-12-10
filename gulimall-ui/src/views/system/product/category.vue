<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId" 
    :default-expanded-keys="expandedkey" draggable :allow-drag="allowDrop">
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
import {category, addCategory, deleteCategory, getInfo, updateCategory} from "@/api/system/product"
export default {
  data() {
      return {
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

      allowDrop(draggingNode, dropNode, type) {
        this.countNodeLevel(draggingNode.data)
        //当前拖动节点 + 父节点所在深度不大于3
        let deep = this.maxLevel - draggingNode.data.catLevel + 1

        if(type == "inner") {
          return (deep + dropNode.level) <= 3
        } else {
          return (deep + dropNode.parent.level) <= 3
        }
      },

      countNodeLevel(node) {
        if (node.children != null && node.children.length > 0) {
          for (let i = 0; i < node.children.length; i++) {
            if (node.children[i].catLevel > this.maxLevel) {
              this.maxLevel = node.children[i].catLevel
            }
          }
          this.countNodeLevel(node.children[i])
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