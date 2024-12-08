<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId" 
    :default-expanded-keys="expandedkey">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button v-if="node.level <= 2" type="text" size="mini" @click="append(data)">Append</el-button>
          <el-button v-if="node.childNodes.length==0" type="text" size="mini"  @click="remove(node, data)">Delete</el-button>
        </span>
      </span></el-tree>
  </div>
</template>

<script>
import {category ,addCategory ,deleteCategory} from "@/api/system/product"
export default {
  data() {
      return {
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

      append(data) {
        addCategory(data).then(response => {
          console.log("append", response)
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