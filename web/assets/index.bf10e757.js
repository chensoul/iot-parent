import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, N as withDirectives, a6 as vShow, j as createVNode, n as withCtx, u as unref, a3 as withKeys, m as createBlock, R as createTextVNode, S as toDisplayString, K as createBaseVNode, L as createCommentVNode } from './element-plus.aa5fe574.js';
import { k as service, _ as _export_sfc } from './index.4cfe0fe4.js';

// 查询设备信息列表
function listDeviceOptionLog(query) {
  return service({
    url: '/platform/deviceOptionLog/list',
    method: 'get',
    params: query
  })
}

var index_vue_vue_type_style_index_0_scoped_true_lang = '';

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");


const _sfc_main = {
  setup(__props) {

const deviceOptionLogList = ref([]);
const loading = ref(true);
const showSearch = ref(true);
const total = ref(0);
ref("");

const data = reactive({
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    productName: null,
    deviceName: null,
    messageId: null
  }
});

const { queryParams } = toRefs(data);

/** 查询设备信息列表 */
function getList() {
  loading.value = true;
  listDeviceOptionLog(queryParams.value).then(response => {
    deviceOptionLogList.value = response.data.records;
    total.value = response.data.total;
    loading.value = false;
  });
}

function sliceString(str, length) {
  if(null == str || "" == str) return ''
  if(str.length < length) return str
  return str.slice(0, length) + (str.length > length ? '...' : '');
}

function jsonString(str) {
  if(null == str || "" == str) return ''
  return JSON.parse(str);
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  //proxy.resetForm("queryRef");
  handleQuery();
}

getList();

return (_ctx, _cache) => {
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_tag = resolveComponent("el-tag");
  const _component_el_popover = resolveComponent("el-popover");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_pagination = resolveComponent("el-pagination");
  const _directive_loading = resolveDirective("loading");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    withDirectives(createVNode(_component_el_form, {
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
          prop: "deviceName"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).deviceId,
              "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(queryParams).deviceId) = $event)),
              placeholder: "请输入设备名称",
              clearable: "",
              onKeyup: withKeys(handleQuery, ["enter"])
            }, null, 8, ["modelValue", "onKeyup"])
          ]),
          _: 1
        }),
        createVNode(_component_el_form_item, {
          label: "消息id",
          prop: "messageId"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).messageId,
              "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((unref(queryParams).messageId) = $event)),
              placeholder: "请输入消息id",
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
    }, 8, ["model"]), [
      [vShow, showSearch.value]
    ]),
    withDirectives((openBlock(), createBlock(_component_el_table, {
      data: deviceOptionLogList.value,
      style: {"width":"100%"}
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          label: "产品名称",
          prop: "productName",
          fixed: "",
          width: "120"
        }),
        createVNode(_component_el_table_column, {
          label: "设备名称",
          prop: "deviceName",
          fixed: "",
          width: "120"
        }),
        createVNode(_component_el_table_column, {
          label: "操作类型",
          prop: "optionType",
          width: "80"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.optionType == '1' ? '属性' : scope.row.optionType == '2' ? '服务' : scope.row.optionType == '3' ? '事件' : '自定义'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "Topic",
          prop: "topic",
          width: "160"
        }, {
          default: withCtx((scope) => [
            createVNode(_component_el_popover, {
              effect: "light",
              trigger: "hover",
              placement: "top",
              width: "auto"
            }, {
              default: withCtx(() => [
                createBaseVNode("div", null, toDisplayString(scope.row.topic), 1)
              ]),
              reference: withCtx(() => [
                createVNode(_component_el_tag, null, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(sliceString(scope.row.topic, 20)), 1)
                  ]),
                  _: 2
                }, 1024)
              ]),
              _: 2
            }, 1024)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "消息ID",
          prop: "messageId",
          width: "120"
        }, {
          default: withCtx((scope) => [
            createVNode(_component_el_popover, {
              effect: "light",
              trigger: "hover",
              placement: "top",
              width: "auto"
            }, {
              default: withCtx(() => [
                createBaseVNode("div", null, toDisplayString(scope.row.messageId), 1)
              ]),
              reference: withCtx(() => [
                createVNode(_component_el_tag, null, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(sliceString(scope.row.messageId, 30)), 1)
                  ]),
                  _: 2
                }, 1024)
              ]),
              _: 2
            }, 1024)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "请求参数",
          prop: "requestParams",
          width: "250"
        }, {
          default: withCtx((scope) => [
            createVNode(_component_el_popover, {
              effect: "light",
              trigger: "hover",
              placement: "top",
              width: "auto"
            }, {
              default: withCtx(() => [
                createBaseVNode("pre", null, toDisplayString(jsonString(scope.row.requestParams)), 1)
              ]),
              reference: withCtx(() => [
                createVNode(_component_el_tag, null, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(sliceString(scope.row.requestParams, 60)), 1)
                  ]),
                  _: 2
                }, 1024)
              ]),
              _: 2
            }, 1024)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "请求时间",
          prop: "requestTime",
          width: "160"
        }),
        createVNode(_component_el_table_column, {
          label: "响应数据",
          prop: "responseData",
          width: "250"
        }, {
          default: withCtx((scope) => [
            (scope.row.responseData != null)
              ? (openBlock(), createBlock(_component_el_popover, {
                  key: 0,
                  effect: "light",
                  trigger: "hover",
                  placement: "top",
                  width: "auto"
                }, {
                  default: withCtx(() => [
                    createBaseVNode("pre", null, toDisplayString(jsonString(scope.row.responseData)), 1)
                  ]),
                  reference: withCtx(() => [
                    createVNode(_component_el_tag, null, {
                      default: withCtx(() => [
                        createTextVNode(toDisplayString(sliceString(scope.row.responseData, 60)), 1)
                      ]),
                      _: 2
                    }, 1024)
                  ]),
                  _: 2
                }, 1024))
              : createCommentVNode("", true)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "响应时间",
          prop: "responseTime",
          width: "160"
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
    }, null, 8, ["current-page", "page-size", "total"])
  ]))
}
}

};
var index = /*#__PURE__*/_export_sfc(_sfc_main, [['__scopeId',"data-v-7d35d092"]]);

export { index as default };
