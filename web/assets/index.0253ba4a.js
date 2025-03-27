import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, u as unref, a3 as withKeys, N as withDirectives, m as createBlock, R as createTextVNode, S as toDisplayString, K as createBaseVNode } from './element-plus.aa5fe574.js';
import { k as service } from './index.4cfe0fe4.js';

// 查询操作日志记录列表
function listSysOperLog(query) {
  return service({
    url: '/system/sysOperLog/list',
    method: 'get',
    params: query
  })
}

// 查询操作日志记录详细
function getSysOperLog(id) {
  return service({
    url: '/system/sysOperLog/' + id,
    method: 'get'
  })
}

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");
const _hoisted_4 = /*#__PURE__*/createTextVNode("详情");
const _hoisted_5 = { class: "dialog-footer" };
const _hoisted_6 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const sysOperLogList = ref([]);
const open = ref(false);
const loading = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    title: null,
    operName: null,
    beginTime: null,
    endTime: null
  }
});

const { form, queryParams } = toRefs(data);

/** 查询操作日志记录列表 */
function getList() {
  loading.value = true;
  if (dateRange.value.length == 2) {
    queryParams.value.beginTime = dateRange.value[0];
    queryParams.value.endTime = dateRange.value[1];
  }
  listSysOperLog(queryParams.value).then(response => {
    sysOperLogList.value = response.data.records;
    total.value = response.data.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  handleQuery();
  dateRange.value = [];
}

/** 修改按钮操作 */
function handleShow(row) {
  getSysOperLog(row.id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "操作日志记录";
  });
}

getList();

return (_ctx, _cache) => {
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_date_picker = resolveComponent("el-date-picker");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_pagination = resolveComponent("el-pagination");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_dialog = resolveComponent("el-dialog");
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
          label: "模块标题",
          prop: "title"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).title,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).title) = $event)),
              placeholder: "请输入模块标题",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "操作人员",
          prop: "operName"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).operName,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(queryParams).operName) = $event)),
              placeholder: "请输入操作人员",
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
              "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((dateRange).value = $event)),
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
    withDirectives((openBlock(), createBlock(_component_el_table, { data: sysOperLogList.value }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          prop: "title",
          label: "系统模块",
          width: "120"
        }),
        createVNode(_component_el_table_column, {
          prop: "requestMethod",
          label: "请求方式",
          width: "80"
        }),
        createVNode(_component_el_table_column, {
          prop: "operName",
          label: "操作人员",
          width: "90"
        }),
        createVNode(_component_el_table_column, {
          prop: "operIp",
          label: "操作IP",
          width: "130"
        }),
        createVNode(_component_el_table_column, {
          prop: "method",
          label: "请求方法"
        }),
        createVNode(_component_el_table_column, {
          label: "操作状态",
          width: "80"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.status === 1 ? '成功' : '失败'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          prop: "createTime",
          label: "操作时间",
          width: "160"
        }),
        createVNode(_component_el_table_column, {
          label: "操作",
          align: "center",
          "class-name": "small-padding fixed-width",
          width: "120"
        }, {
          default: withCtx((scope) => [
            createVNode(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleShow(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_4
              ]),
              _: 2
            }, 1032, ["onClick"])
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
      "onUpdate:current-page": _cache[3] || (_cache[3] = $event => ((unref(queryParams).pageNum) = $event)),
      "page-size": unref(queryParams).pageSize,
      "onUpdate:page-size": _cache[4] || (_cache[4] = $event => ((unref(queryParams).pageSize) = $event)),
      "page-sizes": [10, 20, 50, 100],
      layout: "total, sizes, prev, pager, next",
      total: total.value,
      onSizeChange: getList,
      onCurrentChange: getList
    }, null, 8, ["current-page", "page-size", "total"]),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((open).value = $event)),
      width: "50%",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_5, [
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_6
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref: "sysOperLogRef",
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "操作模块" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).title), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }),
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "请求地址" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).operUrl), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "操作人员" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).operName), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }),
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "请求IP" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).operIp), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 24 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "操作方法" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).method), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 24 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "请求参数" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).operParam), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 24 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "返回参数" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).jsonResult), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_row, null, {
              default: withCtx(() => [
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "操作状态" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).status === 1 ? '成功' : '失败'), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }),
                createVNode(_component_el_col, { span: 12 }, {
                  default: withCtx(() => [
                    createVNode(_component_el_form_item, { label: "操作时间" }, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(unref(form).createTime), 1)
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                })
              ]),
              _: 1
            })
          ]),
          _: 1
        }, 512)
      ]),
      _: 1
    }, 8, ["title", "modelValue"])
  ]))
}
}

};

export { _sfc_main as default };
