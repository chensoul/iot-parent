import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, u as unref, a3 as withKeys, K as createBaseVNode, N as withDirectives, m as createBlock, L as createCommentVNode, R as createTextVNode, S as toDisplayString, F as Fragment, Q as renderList, H as ElMessage, a9 as ElMessageBox } from './element-plus.aa5fe574.js';
import { u as useRouter } from './index.4cfe0fe4.js';
import { l as listDeviceInfo, u as updateDeviceInfo, a as addDeviceInfo, d as delDeviceInfo } from './deviceInfo.c4decd11.js';
import { b as listAllProductInfo } from './productInfo.427251c3.js';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");
const _hoisted_4 = { class: "tools-row" };
const _hoisted_5 = /*#__PURE__*/createTextVNode("新增");
const _hoisted_6 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_7 = {
  key: 0,
  style: {"color":"#1ab394"}
};
const _hoisted_8 = { key: 1 };
const _hoisted_9 = /*#__PURE__*/createTextVNode("查看");
const _hoisted_10 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_11 = { class: "dialog-footer" };
const _hoisted_12 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_13 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const deviceInfoList = ref([]);
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
    productName: null
  },
  rules: {
    name: [
      { required: true, message: "设备名称不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询设备信息列表 */
function getList() {
  loading.value = true;
  listDeviceInfo(queryParams.value).then(response => {
    deviceInfoList.value = response.data.records;
    total.value = response.data.total;
    loading.value = false;
  });
}

const productInfoList = ref([]);
function getAllProductInfo() {
  listAllProductInfo().then(response => {
    productInfoList.value = response.data;
  });
}
getAllProductInfo();

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
  if(deviceInfoRef.value) {
    deviceInfoRef.value.resetFields();
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
  title.value = "添加设备信息";
}

const router = useRouter();
/** 查看按钮操作 */
function handleShow(row) {
  router.push("/deviceShow/"+row.id);
}

/** 提交按钮 */
const deviceInfoRef = ref(null);
function submitForm() {
  deviceInfoRef.value.validate((valid) => {
    if (valid) {
      if (form.value.id != null) {
        updateDeviceInfo(form.value).then(response => {
           ElMessage.success("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addDeviceInfo(form.value).then(response => {
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
    return delDeviceInfo(_ids);
  }).then(() => {
    getList();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

getList();

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
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _component_el_dialog = resolveComponent("el-dialog");
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
          label: "产品名称",
          prop: "productName"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).productId,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).productId) = $event)),
              placeholder: "请输入产品名称",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "设备名称",
          prop: "name"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).name,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(queryParams).name) = $event)),
              placeholder: "请输入设备名称",
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
                [_directive_permission, 'deviceInfo.add']
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
                  _hoisted_6
                ]),
                _: 1
              }, 8, ["disabled"])), [
                [_directive_permission, 'deviceInfo.remove']
              ])
            ]),
            _: 1
          }, 8, ["span"])
        ]),
        _: 1
      })
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: deviceInfoList.value,
      onSelectionChange: handleSelectionChange
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          type: "selection",
          width: "55",
          align: "center"
        }),
        createVNode(_component_el_table_column, {
          label: "设备名称",
          prop: "name",
          width: "150"
        }),
        createVNode(_component_el_table_column, {
          label: "客户端ID",
          prop: "clientId",
          width: "200"
        }),
        createVNode(_component_el_table_column, {
          label: "设备所属产品",
          prop: "productName",
          width: "200"
        }),
        createVNode(_component_el_table_column, {
          label: "设备状态",
          width: "100"
        }, {
          default: withCtx((scope) => [
            (scope.row.runStatus == 1)
              ? (openBlock(), createElementBlock("span", _hoisted_7, "在线"))
              : createCommentVNode("", true),
            (scope.row.runStatus == 0)
              ? (openBlock(), createElementBlock("span", _hoisted_8, "离线"))
              : createCommentVNode("", true)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "最后连接时间",
          align: "center",
          prop: "lastConnectTime"
        }),
        createVNode(_component_el_table_column, {
          label: "状态",
          prop: "status",
          width: "100"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.status == 1 ? '启用' : '禁用'), 1)
          ]),
          _: 1
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
              onClick: $event => (handleShow(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_9
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'deviceInfo.show']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_10
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'deviceInfo.remove']
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
          ref_key: "deviceInfoRef",
          ref: deviceInfoRef,
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "产品",
              prop: "productId"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: unref(form).productId,
                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).productId) = $event)),
                  class: "m-2",
                  placeholder: "请选择产品"
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(productInfoList.value, (item) => {
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
              label: "设备名称",
              prop: "name"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).name,
                  "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).name) = $event)),
                  placeholder: "请输入设备名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "备注",
              prop: "remark"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).remark,
                  "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).remark) = $event)),
                  type: "textarea",
                  placeholder: "请输入内容"
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
