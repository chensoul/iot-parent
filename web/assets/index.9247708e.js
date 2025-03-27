import { f as findNodes, g as getSysMenu, u as updateSysMenu, a as addSysMenu, b as delSysMenu } from './sysMenu.a0380117.js';
import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, K as createBaseVNode, j as createVNode, n as withCtx, N as withDirectives, m as createBlock, R as createTextVNode, S as toDisplayString, u as unref, H as ElMessage, a9 as ElMessageBox } from './element-plus.aa5fe574.js';
import './index.4cfe0fe4.js';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = { class: "tools-row" };
const _hoisted_3 = /*#__PURE__*/createTextVNode("新增");
const _hoisted_4 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_5 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_6 = /*#__PURE__*/createTextVNode("菜单");
const _hoisted_7 = /*#__PURE__*/createTextVNode("按钮");
const _hoisted_8 = /*#__PURE__*/createTextVNode("正常");
const _hoisted_9 = /*#__PURE__*/createTextVNode("停用");
const _hoisted_10 = { class: "dialog-footer" };
const _hoisted_11 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_12 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const sysMenuList = ref([]);
const open = ref(false);
const loading = ref(true);
ref(true);
const ids = ref([]);
ref(true);
ref(true);
const title = ref("");
const menuOptions = ref([]);

const data = reactive({
  form: {},

  rules: {
    parentId: [
      { required: true, message: "上级菜单不能为空", trigger: "blur" }
    ],
    title: [
      { required: true, message: "菜单标题不能为空", trigger: "blur" }
    ],
    component: [
      { required: true, message: "路由名称不能为空", trigger: "blur" }
    ],
    perms: [
      { required: true, message: "权限标识不能为空", trigger: "blur" }
    ],
    sortValue: [
      { required: true, message: "排序不能为空", trigger: "blur" }
    ],
  }
});

const { form, rules } = toRefs(data);

/** 查询菜单列表 */
function getList() {
  loading.value = true;
  findNodes().then(response => {
    sysMenuList.value = response.data;
    loading.value = false;
  });
}

/** 查询菜单下拉树结构 */
function getTreeselect() {
  menuOptions.value = [];
  findNodes().then(response => {
    const menu = { id: 0, title: "主类目", children: [] };
    menu.children = response.data;
    menuOptions.value.push(menu);
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
  //清空校验提示
  if(sysMenuRef.value) {
    sysMenuRef.value.resetFields();
  }
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  getTreeselect();
  form.parentId = 0;
  form.value.type = 1;
  form.value.status = 1;
  open.value = true;
  title.value = "添加菜单";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  getTreeselect();
  const _id = row.id || ids.value;
  getSysMenu(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改菜单";
    console.log(form.value);
  });
}

/** 提交按钮 */
const sysMenuRef = ref(null);
function submitForm() {
  sysMenuRef.value.validate((valid) => {
    if (valid) {
      if (form.value.id != null) {
        updateSysMenu(form.value).then(response => {
          ElMessage.success("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addSysMenu(form.value).then(response => {
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
  ElMessageBox.confirm('是否确认删除菜单编号为"' + _ids + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delSysMenu(_ids);
  }).then(() => {
    getList();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

getList();

return (_ctx, _cache) => {
  const _component_el_button = resolveComponent("el-button");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_tree_select = resolveComponent("el-tree-select");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_radio = resolveComponent("el-radio");
  const _component_el_radio_group = resolveComponent("el-radio-group");
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _directive_permission = resolveDirective("permission");
  const _directive_loading = resolveDirective("loading");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    createBaseVNode("div", _hoisted_2, [
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
                  _hoisted_3
                ]),
                _: 1
              })), [
                [_directive_permission, 'sysMenu.add']
              ])
            ]),
            _: 1
          }, 8, ["span"])
        ]),
        _: 1
      })
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: sysMenuList.value,
      style: {"width":"100%","margin-bottom":"20px"},
      "row-key": "id",
      border: "",
      "default-expand-all": ""
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          prop: "title",
          label: "菜单标题"
        }),
        createVNode(_component_el_table_column, {
          prop: "type",
          label: "菜单类型"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.type == 1 ? '菜单' : '按钮'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          prop: "component",
          label: "路由名称",
          width: "160"
        }),
        createVNode(_component_el_table_column, {
          prop: "perms",
          label: "权限标识",
          width: "190"
        }),
        createVNode(_component_el_table_column, {
          prop: "sortValue",
          label: "排序"
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
          width: "160",
          "class-name": "small-padding fixed-width"
        }, {
          default: withCtx((scope) => [
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleUpdate(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_4
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysMenu.edit']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_5
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'sysMenu.remove']
            ])
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["data"])), [
      [_directive_loading, loading.value]
    ]),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[7] || (_cache[7] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_10, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitForm
          }, {
            default: withCtx(() => [
              _hoisted_11
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_12
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref_key: "sysMenuRef",
          ref: sysMenuRef,
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "上级菜单",
              prop: "parentId"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_tree_select, {
                  modelValue: unref(form).parentId,
                  "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(form).parentId) = $event)),
                  data: menuOptions.value,
                  props: { value: 'id', label: 'title', children: 'children' },
                  "value-key": "id",
                  placeholder: "选择上级菜单",
                  "check-strictly": ""
                }, null, 8, ["modelValue", "data"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "菜单类型",
              prop: "type"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_radio_group, {
                  modelValue: unref(form).type,
                  "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(form).type) = $event))
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_radio, { label: 1 }, {
                      default: withCtx(() => [
                        _hoisted_6
                      ]),
                      _: 1
                    }),
                    createVNode(_component_el_radio, { label: 2 }, {
                      default: withCtx(() => [
                        _hoisted_7
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "菜单标题",
              prop: "title"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).title,
                  "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((unref(form).title) = $event)),
                  placeholder: "请输入菜单标题"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, { label: "组件名称" }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).component,
                  "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => ((unref(form).component) = $event)),
                  placeholder: "请输入组件名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, { label: "权限标识" }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).perms,
                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).perms) = $event)),
                  placeholder: "请输入权限标识",
                  maxlength: "100"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "排序",
              prop: "sortValue"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).sortValue,
                  "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).sortValue) = $event)),
                  placeholder: "请输入排序"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, { label: "状态" }, {
              default: withCtx(() => [
                createVNode(_component_el_radio_group, {
                  modelValue: unref(form).status,
                  "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).status) = $event))
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_radio, { label: 1 }, {
                      default: withCtx(() => [
                        _hoisted_8
                      ]),
                      _: 1
                    }),
                    createVNode(_component_el_radio, { label: 0 }, {
                      default: withCtx(() => [
                        _hoisted_9
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }, 8, ["modelValue"])
              ]),
              _: 1
            })
          ]),
          _: 1
        }, 8, ["model", "rules"])
      ]),
      _: 1
    }, 8, ["title", "modelValue"])
  ]))
}
}

};

export { _sfc_main as default };
