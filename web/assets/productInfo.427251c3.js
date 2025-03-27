import { k as service } from './index.4cfe0fe4.js';

// 查询产品信息列表
function listProductInfo(query) {
  return service({
    url: '/platform/productInfo/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息详细
function getProductInfo(id) {
  return service({
    url: '/platform/productInfo/' + id,
    method: 'get'
  })
}

// 新增产品信息
function addProductInfo(data) {
  return service({
    url: '/platform/productInfo',
    method: 'post',
    data: data
  })
}

// 修改产品信息
function updateProductInfo(data) {
  return service({
    url: '/platform/productInfo',
    method: 'put',
    data: data
  })
}

// 删除产品信息
function delProductInfo(id) {
  return service({
    url: '/platform/productInfo/' + id,
    method: 'delete'
  })
}

function listAllProductInfo() {
  return service({
    url: '/platform/productInfo/listAll',
    method: 'get'
  })
}

export { addProductInfo as a, listAllProductInfo as b, delProductInfo as d, getProductInfo as g, listProductInfo as l, updateProductInfo as u };
