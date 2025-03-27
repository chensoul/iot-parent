import { k as service } from './index.4cfe0fe4.js';

// 分页列表
const findNodes = () => {
  return service({
    url: `/system/sysMenu/findNodes`,
    method: 'get',
  })
};

// 查询菜单详细
function getSysMenu(id) {
  return service({
    url: '/system/sysMenu/' + id,
    method: 'get'
  })
}

// 新增菜单
function addSysMenu(data) {
  return service({
    url: '/system/sysMenu',
    method: 'post',
    data: data
  })
}

// 修改菜单
function updateSysMenu(data) {
  return service({
    url: '/system/sysMenu',
    method: 'put',
    data: data
  })
}

// 删除菜单
function delSysMenu(id) {
  return service({
    url: '/system/sysMenu/' + id,
    method: 'delete'
  })
}

// 获取菜单信息
function toAssign(roleId) {
  return service({
    url: `/system/sysMenu/toAssign/${roleId}`,
    method: 'get',
  })
}

// 分配菜单
function doAssign(assginMenu) {
  return service({
    url: `/system/sysMenu/doAssign`,
    method: 'post',
    data: assginMenu,
  })
}

export { addSysMenu as a, delSysMenu as b, doAssign as d, findNodes as f, getSysMenu as g, toAssign as t, updateSysMenu as u };
