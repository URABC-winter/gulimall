import request from '@/utils/request'

// 查询用户列表
export function category(query) {
    return request({
        url: '/product/category/list/tree',
        method: 'get',
        params: query
    })
}