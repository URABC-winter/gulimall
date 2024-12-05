<template>
  <div>
    <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
  </div>
</template>

<script>
import {category  } from "@/api/system/product"
export default {
  data() {
      return {
        data: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },
    created() {
      this.getMenu()
    },
    methods: {
      handleNodeClick(data) {
        console.log(data);
      },
      getMenu() {
        this.loading = true;
        category().then(response => {

          }
        );
      }
    }
}
</script>

<style>

</style>