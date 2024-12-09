<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId" 
    :default-expanded-keys="expandedkey">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button v-if="node.level <= 2" type="text" size="mini" @click="append(data)">Append</el-button>
          <el-button type="text" size="mini" @click="edit(data)">Edit</el-button>
          <el-button v-if="node.childNodes.length==0" type="text" size="mini"  @click="remove(node, data)">Delete</el-button>
        </span>
      </span>
    </el-tree>

    <el-dialog :title="title" :visible.sync="dialogVisible" width="30%">
      <el-form :model="category">
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
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
import {category, addCategory , deleteCategory} from "@/api/system/product"
export default {
  data() {
      return {
        title: "",
        dialogType: "",
        category: {name:"", parentCid: 0, catLevel: 0, showStatus: 1, sort: 0, catId: 0},
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

      edit(data) {
        this.title = "修改"
        this.dialogType = "edit"
        this.dialogVisible = true
        this.category.name = data.name
        this.category.catId = data.catId
        console.log("edit", data)
      },

      append(data) {
        this.title = "添加"
        this.dialogType = "add"
        this.dialogVisible = true
        this.category.parentCid = data.catId
        this.category.catLevel = data.catLevel*1 + 1
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
        console.log("addCategory", this.category)
        addCategory(this.category).then(response => {
          console.log("addCategory", response),
          this.$message({
            message: '菜单删除成功',
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