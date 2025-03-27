import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, K as createBaseVNode, F as Fragment, Q as renderList, m as createBlock, n as withCtx, S as toDisplayString, u as unref, j as createVNode, a3 as withKeys, N as withDirectives, R as createTextVNode, H as ElMessage, a9 as ElMessageBox } from './element-plus.aa5fe574.js';
import { u as useRouter } from './index.4cfe0fe4.js';
import { l as listProductInfo, u as updateProductInfo, a as addProductInfo, d as delProductInfo } from './productInfo.427251c3.js';

var index_vue_vue_type_style_index_0_lang = '';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = { style: {"background-color":"#ffffff","padding":"0 10px"} };
const _hoisted_3 = /*#__PURE__*/createBaseVNode("div", { style: {"padding":"10px 0","font-weight":"bold"} }, "设备接入流程概览", -1);
const _hoisted_4 = { class: "card-container" };
const _hoisted_5 = { class: "card-header" };
const _hoisted_6 = { style: {"color":"#e6a23c","padding-right":"10px","font-weight":"1000","font-size":"26px"} };
const _hoisted_7 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_8 = /*#__PURE__*/createTextVNode("重置");
const _hoisted_9 = { class: "tools-row" };
const _hoisted_10 = /*#__PURE__*/createTextVNode("新增");
const _hoisted_11 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_12 = /*#__PURE__*/createTextVNode("查看");
const _hoisted_13 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_14 = { class: "dialog-footer" };
const _hoisted_15 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_16 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const productInfoList = ref([]);
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
    name: null,
    productKey: null,
    nodeType: null,
    status: null,
  },
  rules: {
    name: [
      { required: true, message: "产品名称不能为空", trigger: "blur" }
    ],
    nodeType: [
      { required: true, message: "节点类型不能为空", trigger: "change" }
    ]
  },
  nodeTypeList: [
    {id: 1, name: "直连设备"}
    // {id: 2, name: "网关子设备"},
    // {id: 3, name: "网关设备"}
  ],
  titleList: [
      {id: 1, title: "创建产品", desc: "产品是同品类设备的集合"},
      {id: 2, title: "创建设备", desc: "创建设备获取连接平台所需的身份信息"},
      {id: 3, title: "编辑物模型", desc: "产品下的设备都会继承产品的物模型"},
      {id: 4, title: "设备端开发", desc: "集成Link SDK，开发设备端程序"},
      {id: 5, title: "查看上报数据", desc: "查看设备上报的属性数据"}
  ]
});

const { queryParams, form, rules, nodeTypeList, titleList } = toRefs(data);

/** 查询产品信息列表 */
function getList() {
  loading.value = true;
  listProductInfo(queryParams.value).then(response => {
    productInfoList.value = response.data.records;
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
  if(productInfoRef.value) {
    productInfoRef.value.resetFields();
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
  title.value = "添加产品信息";
}

const router = useRouter();
/** 查看按钮操作 */
function handleShow(row) {
  router.push("/productShow/"+row.id);
}

/** 提交按钮 */
const productInfoRef = ref(null);
function submitForm() {
  productInfoRef.value.validate((valid) => {
    if (valid) {
      if (form.value.id != null) {
        updateProductInfo(form.value).then(response => {
          ElMessage.success("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addProductInfo(form.value).then(response => {
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
  ElMessageBox.confirm('是否确认删除设备信息编号为"' + _ids + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delProductInfo(_ids);
  }).then(() => {
    getList();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

getList();

return (_ctx, _cache) => {
  const _component_el_card = resolveComponent("el-card");
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_pagination = resolveComponent("el-pagination");
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _directive_permission = resolveDirective("permission");
  const _directive_loading = resolveDirective("loading");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    createBaseVNode("div", _hoisted_2, [
      _hoisted_3,
      createBaseVNode("div", _hoisted_4, [
        (openBlock(true), createElementBlock(Fragment, null, renderList(unref(titleList), (item) => {
          return (openBlock(), createBlock(_component_el_card, {
            key: item.id
          }, {
            header: withCtx(() => [
              createBaseVNode("div", _hoisted_5, [
                createBaseVNode("span", _hoisted_6, toDisplayString(item.id), 1),
                createBaseVNode("span", null, toDisplayString(item.title), 1)
              ])
            ]),
            default: withCtx(() => [
              (openBlock(), createElementBlock(Fragment, null, renderList(1, (o) => {
                return createBaseVNode("p", {
                  key: o,
                  class: "text item",
                  style: {"color":"#b4bccc","font-size":"12px"}
                }, toDisplayString(item.desc), 1)
              }), 64))
            ]),
            _: 2
          }, 1024))
        }), 128))
      ])
    ]),
    createVNode(_component_el_form, {
      model: unref(queryParams),
      ref: "queryRef",
      inline: true,
      "label-width": "68px",
      class: "query-from"
    }, {
      default: withCtx(() => [
        createVNode(_component_el_form_item, {
          label: "产品名称",
          prop: "name"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).name,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).name) = $event)),
              placeholder: "请输入产品名称",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "产品key",
          prop: "productKey"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).productKey,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(queryParams).productKey) = $event)),
              placeholder: "请输入产品key",
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
                _hoisted_7
              ]),
              _: 1
            }),
            createVNode(_component_el_button, {
              icon: "Refresh",
              onClick: resetQuery
            }, {
              default: withCtx(() => [
                _hoisted_8
              ]),
              _: 1
            })
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["model"]),
    createBaseVNode("div", _hoisted_9, [
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
                  _hoisted_10
                ]),
                _: 1
              })), [
                [_directive_permission, 'productInfo.add']
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
                  _hoisted_11
                ]),
                _: 1
              }, 8, ["disabled"])), [
                [_directive_permission, 'productInfo.remove']
              ])
            ]),
            _: 1
          }, 8, ["span"])
        ]),
        _: 1
      })
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: productInfoList.value,
      onSelectionChange: handleSelectionChange
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          type: "selection",
          width: "55",
          align: "center"
        }),
        createVNode(_component_el_table_column, {
          label: "产品名称",
          prop: "name",
          width: "150"
        }),
        createVNode(_component_el_table_column, {
          label: "产品KEY",
          prop: "productKey"
        }),
        createVNode(_component_el_table_column, {
          prop: "nodeType",
          label: "节点类型",
          width: "100"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.nodeType == 1 ? '直连设备' : scope.row.nodeType == 2 ? '网关子设备' : '网关设备'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "操作",
          align: "center",
          "class-name": "small-padding fixed-width",
          width: "250"
        }, {
          default: withCtx((scope) => [
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleShow(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_12
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'productInfo.show']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_13
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'productInfo.remove']
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
          ref_key: "productInfoRef",
          ref: productInfoRef,
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "产品名称",
              prop: "name"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).name,
                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).name) = $event)),
                  placeholder: "请输入产品名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "节点类型",
              prop: "nodeType"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: unref(form).nodeType,
                  "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).nodeType) = $event)),
                  class: "m-2",
                  placeholder: "节点类型"
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(unref(nodeTypeList), (item) => {
                      return (openBlock(), createBlock(_component_el_option, {
                        key: item.id,
                        label: item.name,
                        value: item.id
                      }, null, 8, ["label", "value"]))
                    }), 128))
                  ]),
                  _: 1
                }, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "产品描述",
              prop: "remark"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).remark,
                  "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).remark) = $event)),
                  type: "textarea",
                  placeholder: "请输入产品描述"
                }, null, 8, ["modelValue"])
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
