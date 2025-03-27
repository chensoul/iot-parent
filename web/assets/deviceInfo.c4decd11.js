import { k as service } from './index.4cfe0fe4.js';

// 查询设备信息列表
function listDeviceInfo(query) {
  return service({
    url: '/platform/deviceInfo/list',
    method: 'get',
    params: query
  })
}

// 查询设备信息详细
function getDeviceInfo(id) {
  return service({
    url: '/platform/deviceInfo/' + id,
    method: 'get'
  })
}

// 新增设备信息
function addDeviceInfo(data) {
  return service({
    url: '/platform/deviceInfo',
    method: 'post',
    data: data
  })
}

// 修改设备信息
function updateDeviceInfo(data) {
  return service({
    url: '/platform/deviceInfo',
    method: 'put',
    data: data
  })
}

// 删除设备信息
function delDeviceInfo(id) {
  return service({
    url: '/platform/deviceInfo/' + id,
    method: 'delete'
  })
}

function listAllDeviceInfo(productId) {
  return service({
    url: '/platform/deviceInfo/listAll/'+productId,
    method: 'get'
  })
}

export { addDeviceInfo as a, listAllDeviceInfo as b, delDeviceInfo as d, getDeviceInfo as g, listDeviceInfo as l, updateDeviceInfo as u };
