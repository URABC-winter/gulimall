import request from '@/utils/request'

// 查询商品各级别
export function category(query) {
    return request({
        url: 'product/category/list/tree',
        method: 'get',
        params: query
    })
}

//添加商品
export function addCategory(query) {
    return request({
        url: 'product/category',
        method: 'post',
        params: query
    })
}

//删除商品
export function deleteCategory(catId) {
    return request({
        url: 'product/category/' + catId,
        method: 'delete'
    })
}