import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, u as unref, a3 as withKeys, K as createBaseVNode, N as withDirectives, m as createBlock, R as createTextVNode, S as toDisplayString, L as createCommentVNode, F as Fragment, Q as renderList, H as ElMessage, a9 as ElMessageBox } from './element-plus.aa5fe574.js';
import { k as service, _ as _export_sfc, c as useApp } from './index.4cfe0fe4.js';
import { t as toAssign, b as doAssign } from './sysRole.28ce83dd.js';

// 查询用户列表
function listSysUser(query) {
  return service({
    url: '/system/sysUser/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
function getSysUser(id) {
  return service({
    url: '/system/sysUser/' + id,
    method: 'get'
  })
}

// 新增用户
function addSysUser(data) {
  return service({
    url: '/system/sysUser',
    method: 'post',
    data: data
  })
}

// 修改用户
function updateSysUser(data) {
  return service({
    url: '/system/sysUser',
    method: 'put',
    data: data
  })
}

// 删除用户
function delSysUser(id) {
  return service({
    url: '/system/sysUser/' + id,
    method: 'delete'
  })
}

function exportSysUserData(query) {
  return service({
    url: `/system/sysUser/exportData`,
    method: 'get',
    params: query,
    responseType: 'blob'  // // 这里指定响应类型为blob类型,二进制数据类型，用于表示大量的二进制数据
  })
}

var index_vue_vue_type_style_index_0_scoped_true_lang = '';

var index_vue_vue_type_style_index_1_lang = '';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");
const _hoisted_4 = { class: "tools-row" };
const _hoisted_5 = /*#__PURE__*/createTextVNode("新增");
const _hoisted_6 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_7 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_8 = /*#__PURE__*/createTextVNode("导出");
const _hoisted_9 = ["src"];
const _hoisted_10 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_11 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_12 = /*#__PURE__*/createTextVNode("分配角色");
const _hoisted_13 = ["src"];
const _hoisted_14 = { class: "dialog-footer" };
const _hoisted_15 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_16 = /*#__PURE__*/createTextVNode("取 消");
const _hoisted_17 = { class: "dialog-footer" };
const _hoisted_18 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_19 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const sysUserList = ref([]);
const open = ref(false);
const loading = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);

const { authorization } = useApp();
const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    keyword: null,
    beginTime: null,
    endTime: null
  },
  rules: {
    keyword: [
      { required: true, message: "用户关键字不能为空", trigger: "blur" }
    ],
    password: [
      { required: true, message: "密码不能为空", trigger: "blur" }
    ]
  },
  imgUpload: {
    // 设置上传的请求头部
    headers: {
      Authorization: `Bearer ${authorization.token}`
    },
    // 图片上传的方法地址:
    url: `/system/file/upload`
  }
});

const { queryParams, form, rules, imgUpload } = toRefs(data);

/** 查询用户列表 */
function getList() {
  loading.value = true;
  if (dateRange.value.length == 2) {
    queryParams.value.beginTime = dateRange.value[0];
    queryParams.value.endTime = dateRange.value[1];
  }
  listSysUser(queryParams.value).then(response => {
    sysUserList.value = response.data.records;
    total.value = response.data.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {};
  queryParams.value = {};
  //清空校验提示
  if(sysUserRef.value) {
    sysUserRef.value.resetFields();
  }
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  queryParams.value = {};
  dateRange.value = [];
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加用户";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value;
  getSysUser(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改用户";
  });
}

/** 提交按钮 */
const sysUserRef = ref(null);
function submitForm() {
  sysUserRef.value.validate((valid) => {
    if (valid) {
      if (form.value.id != null) {
        updateSysUser(form.value).then(response => {
          ElMessage.success("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addSysUser(form.value).then(response => {
          ElMessage.success("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  ElMessageBox.confirm('是否确认删除用户编号为"' + _ids + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delSysUser(_ids);
  }).then(() => {
    getList();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  if (dateRange.value.length == 2) {
    queryParams.value.beginTime = dateRange.value[0];
    queryParams.value.endTime = dateRange.value[1];
  }
  // 调用 ExportCategoryData() 方法获取导出数据
  exportSysUserData(queryParams.value).then(res => {
    // 创建 Blob 对象，用于包含二进制数据
    const blob = new Blob([res]);
    // 创建 a 标签元素，并将 Blob 对象转换成 URL
    const link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    // 设置下载文件的名称
    link.download = 'data.xlsx';
    // 模拟点击下载链接
    link.click();
  });
}

//上传
function handleAvatarSuccess (response, uploadFile) {
  console.log(response);
  console.log(uploadFile);
  form.value.avatar = response.data;
}

getList();


//分配角色
const roleOpen = ref(false);
const roleForm = ref({});
const roleOptions = ref([]);
function handleAssignRole(row) {
  roleOpen.value = true;

  roleForm.value.userId = row.id;
  roleForm.value.username = row.username;
  roleForm.value.roleIdList = [];

  toAssign(row.id).then(response => {
    roleOptions.value = response.data.allRolesList;
    let roleIdList = [];
    response.data.assginRoleList.forEach(item => {
      roleIdList.push(item.id);
    });
    roleForm.value.roleIdList = roleIdList;
  });
}

function submitRoleForm() {
  doAssign(roleForm.value).then(response => {
    ElMessage.success("分配成功");
    roleOpen.value = false;
    getList();
  });
}
// 取消按钮
function roleCancel() {
  roleOpen.value = false;
}

return (_ctx, _cache) => {
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_date_picker = resolveComponent("el-date-picker");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_pagination = resolveComponent("el-pagination");
  const _component_Plus = resolveComponent("Plus");
  const _component_el_icon = resolveComponent("el-icon");
  const _component_el_upload = resolveComponent("el-upload");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _directive_permission = resolveDirective("permission");
  const _directive_loading = resolveDirective("loading");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    createVNode(_component_el_form, {
      model: unref(queryParams),
      ref: "queryRef",
      inline: true,
      "label-width": "68px",
      class: "query-from"
    }, {
      default: withCtx(() => [
        createVNode(_component_el_form_item, {
          label: "关键字",
          prop: "keyword"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).keyword,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).keyword) = $event)),
              placeholder: "请输入用户关键字",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "创建时间",
          style: {"width":"308px"}
        }, {
          default: withCtx(() => [
            createVNode(_component_el_date_picker, {
              modelValue: dateRange.value,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((dateRange).value = $event)),
              "value-format": "YYYY-MM-DD",
              type: "daterange",
              "range-separator": "-",
              "start-placeholder": "开始日期",
              "end-placeholder": "结束日期"
            }, null, 8, ["modelValue"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, null, {
          default: withCtx(() => [
            createVNode(_component_el_button, {
              type: "primary",
              icon: "Search",
              onClick: handleQuery
            }, {
              default: withCtx(() => [
                _hoisted_2
              ]),
              _: 1
            }),
            createVNode(_component_el_button, {
              icon: "Refresh",
              onClick: resetQuery
            }, {
              default: withCtx(() => [
                _hoisted_3
              ]),
              _: 1
            })
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["model"]),
    createBaseVNode("div", _hoisted_4, [
      createVNode(_component_el_row, { gutter: 10 }, {
        default: withCtx(() => [
          createVNode(_component_el_col, { span: 1.5 }, {
            default: withCtx(() => [
              withDirectives((openBlock(), createBlock(_component_el_button, {
                type: "primary",
                plain: "",
                icon: "Plus",
                onClick: handleAdd
              }, {
                default: withCtx(() => [
                  _hoisted_5
                ]),
                _: 1
              })), [
                [_directive_permission, 'sysUser.add']
              ])
            ]),
            _: 1
          }, 8, ["span"]),
          createVNode(_component_el_col, { span: 1.5 }, {
            default: withCtx(() => [
              withDirectives((openBlock(), createBlock(_component_el_button, {
                type: "success",
                plain: "",
                icon: "Edit",
                disabled: single.value,
                onClick: handleUpdate
              }, {
                default: withCtx(() => [
                  _hoisted_6
                ]),
                _: 1
              }, 8, ["disabled"])), [
                [_directive_permission, 'sysUser.edit']
              ])
            ]),
            _: 1
          }, 8, ["span"]),
          createVNode(_component_el_col, { span: 1.5 }, {
            default: withCtx(() => [
              withDirectives((openBlock(), createBlock(_component_el_button, {
                type: "danger",
                plain: "",
                icon: "Delete",
                disabled: multiple.value,
                onClick: handleDelete
              }, {
                default: withCtx(() => [
                  _hoisted_7
                ]),
                _: 1
              }, 8, ["disabled"])), [
                [_directive_permission, 'sysUser.remove']
              ])
            ]),
            _: 1
          }, 8, ["span"]),
          createVNode(_component_el_col, { span: 1.5 }, {
            default: withCtx(() => [
              createVNode(_component_el_button, {
                type: "warning",
                plain: "",
                icon: "Download",
                onClick: handleExport
              }, {
                default: withCtx(() => [
                  _hoisted_8
                ]),
                _: 1
              })
            ]),
            _: 1
          }, 8, ["span"])
        ]),
        _: 1
      })
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: sysUserList.value,
      onSelectionChange: handleSelectionChange
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          type: "selection",
          width: "55",
          align: "center"
        }),
        createVNode(_component_el_table_column, {
          prop: "username",
          label: "用户名"
        }),
        createVNode(_component_el_table_column, {
          prop: "name",
          label: "姓名"
        }),
        createVNode(_component_el_table_column, {
          prop: "phone",
          label: "手机"
        }),
        createVNode(_component_el_table_column, {
          prop: "avatar",
          label: "头像"
        }, {
          default: withCtx((scope) => [
            createBaseVNode("img", {
              src: scope.row.avatar,
              width: "50"
            }, null, 8, _hoisted_9)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          prop: "description",
          label: "描述"
        }),
        createVNode(_component_el_table_column, {
          prop: "status",
          label: "状态"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.status == 1 ? '正常' : '停用'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          prop: "createTime",
          label: "创建时间",
          width: "160"
        }),
        createVNode(_component_el_table_column, {
          label: "操作",
          align: "center",
          "class-name": "small-padding fixed-width",
          width: "200"
        }, {
          default: withCtx((scope) => [
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleUpdate(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_10
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysUser.edit']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_11
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysUser.remove']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleAssignRole(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_12
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysUser.assignRole']
            ])
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["data"])), [
      [_directive_loading, loading.value]
    ]),
    createVNode(_component_el_pagination, {
      "current-page": unref(queryParams).pageNum,
      "onUpdate:current-page": _cache[2] || (_cache[2] = $event => ((unref(queryParams).pageNum) = $event)),
      "page-size": unref(queryParams).pageSize,
      "onUpdate:page-size": _cache[3] || (_cache[3] = $event => ((unref(queryParams).pageSize) = $event)),
      "page-sizes": [10, 20, 50, 100],
      layout: "total, sizes, prev, pager, next",
      total: total.value,
      onSizeChange: getList,
      onCurrentChange: getList
    }, null, 8, ["current-page", "page-size", "total"]),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[9] || (_cache[9] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_14, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitForm
          }, {
            default: withCtx(() => [
              _hoisted_15
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_16
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref_key: "sysUserRef",
          ref: sysUserRef,
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "用户名",
              prop: "username"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).username,
                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).username) = $event)),
                  placeholder: "请输入用户名"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            (unref(form).id == null)
              ? (openBlock(), createBlock(_component_el_form_item, {
                  key: 0,
                  label: "密码",
                  prop: "password"
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_input, {
                      modelValue: unref(form).password,
                      "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).password) = $event)),
                      placeholder: "请输入密码"
                    }, null, 8, ["modelValue"])
                  ]),
                  _: 1
                }))
              : createCommentVNode("", true),
            createVNode(_component_el_form_item, {
              label: "姓名",
              prop: "name"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).name,
                  "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).name) = $event)),
                  placeholder: "请输入姓名"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "手机",
              prop: "phone"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).phone,
                  "onUpdate:modelValue": _cache[7] || (_cache[7] = $event => ((unref(form).phone) = $event)),
                  placeholder: "请输入手机"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "头像",
              prop: "avatar"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_upload, {
                  class: "avatar-uploader",
                  action: unref(imgUpload).url,
                  headers: unref(imgUpload).headers,
                  "show-file-list": false,
                  "on-success": handleAvatarSuccess
                }, {
                  default: withCtx(() => [
                    (unref(form).avatar)
                      ? (openBlock(), createElementBlock("img", {
                          key: 0,
                          src: unref(form).avatar,
                          class: "avatar"
                        }, null, 8, _hoisted_13))
                      : (openBlock(), createBlock(_component_el_icon, {
                          key: 1,
                          class: "avatar-uploader-icon"
                        }, {
                          default: withCtx(() => [
                            createVNode(_component_Plus)
                          ]),
                          _: 1
                        }))
                  ]),
                  _: 1
                }, 8, ["action", "headers"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "描述",
              prop: "description"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).description,
                  "onUpdate:modelValue": _cache[8] || (_cache[8] = $event => ((unref(form).description) = $event)),
                  placeholder: "请输入描述"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            })
          ]),
          _: 1
        }, 8, ["model", "rules"])
      ]),
      _: 1
    }, 8, ["title", "modelValue"]),
    createVNode(_component_el_dialog, {
      title: "分配角色",
      modelValue: roleOpen.value,
      "onUpdate:modelValue": _cache[12] || (_cache[12] = $event => ((roleOpen).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_17, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitRoleForm
          }, {
            default: withCtx(() => [
              _hoisted_18
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: roleCancel }, {
            default: withCtx(() => [
              _hoisted_19
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref_key: "sysUserRef",
          ref: sysUserRef,
          model: roleForm.value,
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "用户名",
              prop: "username"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: roleForm.value.username,
                  "onUpdate:modelValue": _cache[10] || (_cache[10] = $event => ((roleForm.value.username) = $event)),
                  disabled: "",
                  placeholder: "请输入用户名"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, { label: "角色" }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: roleForm.value.roleIdList,
                  "onUpdate:modelValue": _cache[11] || (_cache[11] = $event => ((roleForm.value.roleIdList) = $event)),
                  multiple: "",
                  placeholder: "请选择",
                  style: {"width":"100%"}
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(roleOptions.value, (item) => {
                      return (openBlock(), createBlock(_component_el_option, {
                        key: item.id,
                        label: item.roleName,
                        value: item.id
                      }, null, 8, ["label", "value"]))
                    }), 128))
                  ]),
                  _: 1
                }, 8, ["modelValue"])
              ]),
              _: 1
            })
          ]),
          _: 1
        }, 8, ["model"])
      ]),
      _: 1
    }, 8, ["modelValue"])
  ]))
}
}

};
var index = /*#__PURE__*/_export_sfc(_sfc_main, [['__scopeId',"data-v-5f8655ba"]]);

export { index as default };
