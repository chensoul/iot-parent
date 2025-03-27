import { k as service } from './index.4cfe0fe4.js';

// 查询角色列表
function listSysRole(query) {
  return service({
    url: '/system/sysRole/list',
    method: 'get',
    params: query
  })
}

// 查询角色详细
function getSysRole(id) {
  return service({
    url: '/system/sysRole/' + id,
    method: 'get'
  })
}

// 新增角色
function addSysRole(data) {
  return service({
    url: '/system/sysRole',
    method: 'post',
    data: data
  })
}

// 修改角色
function updateSysRole(data) {
  return service({
    url: '/system/sysRole',
    method: 'put',
    data: data
  })
}

// 删除角色
function delSysRole(id) {
  return service({
    url: '/system/sysRole/' + id,
    method: 'delete'
  })
}

// 获取角色信息
function toAssign(userId) {
  return service({
    url: `/system/sysRole/toAssign/${userId}`,
    method: 'get',
  })
}

// 分配角色
function doAssign(assginRole) {
  return service({
    url: `/system/sysRole/doAssign`,
    method: 'post',
    data: assginRole,
  })
}

export { addSysRole as a, doAssign as b, delSysRole as d, getSysRole as g, listSysRole as l, toAssign as t, updateSysRole as u };
