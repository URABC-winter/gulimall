<template>
    <el-tree :data="menus" :props="defaultProps" node-key="catId" ref="menuTree" @node-click="nodeClick"></el-tree>
</template>

<script>
import {getCategory} from "@/api/system/product"
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
            getCategory(this.queryParams).then(response => {
                this.menus = response.data;
            });
        },
        nodeClick(data, node, component) {
            //console.log("data,node,component = ",data, node, component)
            this.$emit('node-click', data, node, component)
        },
    }
}
</script>

<style></style>