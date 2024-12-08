<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId">
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
        var ids = [data.catId]
        deleteCategory(ids).then(response => {
          console.log("删除成功",response)
          this.getMenu()
        })
        console.log("remove", node, data)
      },
    }
}
</script>

<style>

</style>