import { k as service$1 } from './index.4cfe0fe4.js';

// 查询产品信息列表
function listProductModel(productId) {
  return service$1({
    url: '/platform/productModel/list/'+productId,
    method: 'get'
  })
}

// 新增产品信息
function addProductModel(data) {
  return service$1({
    url: '/platform/productModel',
    method: 'post',
    data: data
  })
}

// 修改产品信息
function updateProductModel(data) {
  return service$1({
    url: '/platform/productModel',
    method: 'put',
    data: data
  })
}

// 删除产品信息
function delProductModel(modelType, id) {
  return service$1({
    url: '/platform/productModel/' + modelType + '/' + id,
    method: 'delete'
  })
}




function listModelAttrValue(productId, deviceId) {
  return service$1({
    url: '/platform/productModel/modelAttrValueList/'+productId+'/'+deviceId,
    method: 'get'
  })
}

function listDeviceAtrrData(query) {
  return service$1({
    url: '/platform/productModel/deviceAtrrDataList',
    method: 'get',
    params: query
  })
}

function listDeviceEventData(query) {
  return service$1({
    url: '/platform/productModel/deviceEventDataList',
    method: 'get',
    params: query
  })
}

function listDeviceServiceData(query) {
  return service$1({
    url: '/platform/productModel/deviceServiceDataList',
    method: 'get',
    params: query
  })
}

function listModelAttrList(productId) {
  return service$1({
    url: '/platform/productModel/modelAttrList/'+productId,
    method: 'get'
  })
}

function listModelServiceList(productId) {
  return service$1({
    url: '/platform/productModel/modelServiceList/'+productId,
    method: 'get'
  })
}

function propertySet(propertyDto) {
  return service$1({
    url: '/platform/productModel/propertySet',
    method: 'post',
    data: propertyDto
  })
}

function service(serviceDto) {
  return service$1({
    url: '/platform/productModel/service',
    method: 'post',
    data: serviceDto
  })
}

export { addProductModel as a, listModelAttrValue as b, listDeviceAtrrData as c, delProductModel as d, listDeviceEventData as e, listDeviceServiceData as f, listModelAttrList as g, listModelServiceList as h, listProductModel as l, propertySet as p, service as s, updateProductModel as u };
