import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, u as unref, a3 as withKeys, K as createBaseVNode, N as withDirectives, m as createBlock, R as createTextVNode, H as ElMessage, a9 as ElMessageBox } from './element-plus.aa5fe574.js';
import { l as listSysRole, g as getSysRole, u as updateSysRole, a as addSysRole, d as delSysRole } from './sysRole.28ce83dd.js';
import { t as toAssign, d as doAssign } from './sysMenu.a0380117.js';
import './index.4cfe0fe4.js';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");
const _hoisted_4 = { class: "tools-row" };
const _hoisted_5 = /*#__PURE__*/createTextVNode("新增");
const _hoisted_6 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_7 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_8 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_9 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_10 = /*#__PURE__*/createTextVNode("分配菜单");
const _hoisted_11 = { class: "dialog-footer" };
const _hoisted_12 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_13 = /*#__PURE__*/createTextVNode("取 消");
const _hoisted_14 = { class: "dialog-footer" };
const _hoisted_15 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_16 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const sysRoleList = ref([]);
const open = ref(false);
const loading = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    roleName: null,
    roleCode: null,
    description: null,
  },
  rules: {
    roleName: [
      { required: true, message: "角色名称不能为空", trigger: "blur" }
    ],
    roleCode: [
      { required: true, message: "角色编码", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询角色列表 */
function getList() {
  loading.value = true;
  listSysRole(queryParams.value).then(response => {
    sysRoleList.value = response.data.records;
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
  if(sysRoleRef.value) {
    sysRoleRef.value.resetFields();
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
  title.value = "添加角色";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value;
  getSysRole(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改角色";
  });
}

/** 提交按钮 */
const sysRoleRef = ref(null);
function submitForm() {
  sysRoleRef.value.validate((valid) => {
    if (valid) {
      if (form.value.id != null) {
        updateSysRole(form.value).then(response => {
          ElMessage.success("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addSysRole(form.value).then(response => {
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
  ElMessageBox.confirm('是否确认删除角色编号为"' + _ids + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delSysRole(_ids);
  }).then(() => {
    getList();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

getList();


//分配菜单
const defaultProps = {
  children: 'children',
  label: 'title',
};
const menuOpen = ref(false);
const sysMenuTreeList = ref([]);
const checkedIdList = ref([]);
//const selectIdList = ref([])
const menuForm = ref({});
function handleAssignMenu(row) {
  //menuForm.value = {}
  menuForm.value.roleId = row.id;
  menuForm.value.menuIdList = [];

  checkedIdList.value = [];
  menuOpen.value = true;

  toAssign(row.id).then(response => {
    sysMenuTreeList.value = response.data;

    checkedIdList.value = getCheckedIdList(sysMenuTreeList.value);
    menuForm.value.menuIdList = checkedIdList.value;
  });


}

//循环获取选中的子节点id
function getCheckedIdList(auths, initArr = []) {
  return auths.reduce((pre, item) => {
    if (item.select && item.children.length === 0) {
      pre.push(item.id);
    } else if (item.children) {
      getCheckedIdList(item.children, initArr);
    }
    return pre
  }, initArr)
}

const handleCheckChange = (data, checked, indeterminate) => {
  if (checked || indeterminate) {
    menuForm.value.menuIdList.push(data.id);
  } else {
    menuForm.value.menuIdList.splice(menuForm.value.menuIdList.indexOf(data.id), 1);
  }
  console.log(data, checked, indeterminate, menuForm.value.menuIdList);
};

function submitMenuForm() {
  doAssign(menuForm.value).then(response => {
    ElMessage.success("操作成功");
    menuOpen.value = false;
  });
}

function menuCancel() {
  menuOpen.value = false;
}

return (_ctx, _cache) => {
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_pagination = resolveComponent("el-pagination");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _component_el_tree = resolveComponent("el-tree");
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
          label: "角色名称",
          prop: "roleName"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).roleName,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).roleName) = $event)),
              placeholder: "请输入角色名称",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "角色编码",
          prop: "roleCode"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).roleCode,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(queryParams).roleCode) = $event)),
              placeholder: "请输入角色编码",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
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
                [_directive_permission, 'sysRole.add']
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
                [_directive_permission, 'sysRole.edit']
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
                [_directive_permission, 'sysRole.remove']
              ])
            ]),
            _: 1
          }, 8, ["span"])
        ]),
        _: 1
      })
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: sysRoleList.value,
      onSelectionChange: handleSelectionChange
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          type: "selection",
          width: "55",
          align: "center"
        }),
        createVNode(_component_el_table_column, {
          label: "角色名称",
          prop: "roleName"
        }),
        createVNode(_component_el_table_column, {
          label: "角色编码",
          prop: "roleCode"
        }),
        createVNode(_component_el_table_column, {
          label: "描述",
          prop: "description"
        }),
        createVNode(_component_el_table_column, {
          label: "操作",
          align: "center",
          "class-name": "small-padding fixed-width"
        }, {
          default: withCtx((scope) => [
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleUpdate(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_8
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysRole.edit']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_9
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysRole.remove']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleAssignMenu(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_10
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysRole.assignMenu']
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
      "onUpdate:modelValue": _cache[7] || (_cache[7] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_11, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitForm
          }, {
            default: withCtx(() => [
              _hoisted_12
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_13
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref_key: "sysRoleRef",
          ref: sysRoleRef,
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "角色名称",
              prop: "roleName"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).roleName,
                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).roleName) = $event)),
                  placeholder: "请输入角色名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "角色编码",
              prop: "roleCode"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).roleCode,
                  "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).roleCode) = $event)),
                  placeholder: "请输入角色编码"
                }, null, 8, ["modelValue"])
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
                  "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).description) = $event)),
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
      title: "分配菜单",
      modelValue: menuOpen.value,
      "onUpdate:modelValue": _cache[8] || (_cache[8] = $event => ((menuOpen).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_14, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitMenuForm
          }, {
            default: withCtx(() => [
              _hoisted_15
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: menuCancel }, {
            default: withCtx(() => [
              _hoisted_16
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, { "label-width": "80px" }, {
          default: withCtx(() => [
            createVNode(_component_el_tree, {
              data: sysMenuTreeList.value,
              "show-checkbox": "",
              "default-expand-all": "",
              "node-key": "id",
              "default-checked-keys": checkedIdList.value,
              props: defaultProps,
              onCheckChange: handleCheckChange
            }, null, 8, ["data", "default-checked-keys"])
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["modelValue"])
  ]))
}
}

};

export { _sfc_main as default };
