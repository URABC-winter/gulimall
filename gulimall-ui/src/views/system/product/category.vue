<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button v-if="node.level <= 2" type="text" size="mini" @click="() => append(data)">Append</el-button>
          <el-button v-if="node.childNodes.length==0" type="text" size="mini"  @click="() => remove(node, data)">Delete</el-button>
        </span>
      </span></el-tree>
  </div>
</template>

<script>
import {category  } from "@/api/system/product"
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
        // const newChild = { id: id++, label: 'testtest', children: [] };
        // if (!data.children) {
        //   this.$set(data, 'children', []);
        // }
        // data.children.push(newChild);
        console.log(data)
      },

      remove(node, data) {
        // const parent = node.parent;
        // const children = parent.data.children || parent.data;
        // const index = children.findIndex(d => d.id === data.id);
        // children.splice(index, 1);
        console.log(node, data)
      },
    }
}
</script>

<style>

</style>