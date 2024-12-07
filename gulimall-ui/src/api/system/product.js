import request from '@/utils/request'

// 查询商品各级别
export function category(query) {
    return request({
        url: '/product/category/list/tree',
        method: 'get',
        params: query
    })
}