import request from '@/utils/request'

// 查询商品属性分类列表
export function listCategory(query) {
  return request({
    url: '/info/category/list',
    method: 'get',
    params: query
  })
}

// 查询商品属性分类详细
export function getCategory(id) {
  return request({
    url: '/info/category/' + id,
    method: 'get'
  })
}

// 新增商品属性分类
export function addCategory(data) {
  return request({
    url: '/info/category',
    method: 'post',
    data: data
  })
}

// 修改商品属性分类
export function updateCategory(data) {
  return request({
    url: '/info/category',
    method: 'put',
    data: data
  })
}

// 删除商品属性分类
export function delCategory(id) {
  return request({
    url: '/info/category/' + id,
    method: 'delete'
  })
}
