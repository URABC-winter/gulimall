import request from '@/utils/request'

// 查询商品各级别
export function getCategory(query) {
    return request({
        url: 'product/category/list/tree',
        method: 'get',
        params: query
    })
}

//添加商品
export function addCategory(category) {
    return request({
        url: 'product/category',
        method: 'post',
        data: category
    })
}

//删除商品
export function deleteCategory(catId) {
    return request({
        url: 'product/category/' + catId,
        method: 'delete'
    })
}

//修改商品
export function updateCategory(category) {
    return request({
        url: 'product/category',
        method: 'put',
        data: category
    })
}

//批量修改商品
export function updateCategories(Categories) {
    return request({
        url: 'product/category/update',
        method: 'put',
        data: Categories
    })
}

//批量删除商品

//获取详情信息
export function getInfo(catId) {
    return request({
        url: 'product/category/' + catId,
        method: 'get'
    })
}