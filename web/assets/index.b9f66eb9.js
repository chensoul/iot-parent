import { b as listAllProductInfo } from './productInfo.427251c3.js';
import { b as listAllDeviceInfo } from './deviceInfo.c4decd11.js';
import { g as listModelAttrList, h as listModelServiceList, p as propertySet, s as service } from './productModel.4d2a878c.js';
import { _ as _export_sfc } from './index.4cfe0fe4.js';
import { r as ref, p as resolveComponent, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, R as createTextVNode, S as toDisplayString, K as createBaseVNode, m as createBlock, L as createCommentVNode, $ as pushScopeId, a0 as popScopeId, F as Fragment, Q as renderList } from './element-plus.aa5fe574.js';

var log_vue_vue_type_style_index_0_scoped_true_lang = '';

const _withScopeId$1 = n => (pushScopeId("data-v-34758300"),n=n(),popScopeId(),n);
const _hoisted_1$1 = { class: "app-container" };
const _hoisted_2$1 = /*#__PURE__*/ _withScopeId$1(() => /*#__PURE__*/createBaseVNode("div", {
  class: "text-large font-600 mr-3",
  style: {"font-size":"16px","padding":"10px 0","margin":"10px 0"}
}, "在线日志", -1));

// eslint-disable-next-line no-undef

const _sfc_main$1 = {
  props: {
  // 数据
  pageId: null
},
  setup(__props) {

const props = __props;



const deviceOptionLogList = ref([]);

function sliceString(str, length) {
  if(null == str || "" == str) return ''
  if(str.length < length) return str
  return str.slice(0, length) + (str.length > length ? '...' : '');
}

function jsonString(str) {
  if(null == str || "" == str) return ''
  return JSON.parse(str);
}

//WebSocket
let ws = new WebSocket("ws://"+window.location.host+"/platform/websocket/"+props.pageId);

ws.onopen=()=>{
  console.log("网络连接成功");
};

ws.onmessage=(e)=>{
  console.log("接收到服务器发送的数据");

  let _data = JSON.parse(e.data);
  console.log(_data);

  let isExist = false;
  deviceOptionLogList.value.forEach(item => {
    if(item.id == _data.id && _data.responseTime != null) {
      isExist = true;
      item.responseTime = _data.responseTime;
      item.responseData = _data.responseData;
    }
  });
  if (!isExist) {
    deviceOptionLogList.value.splice(0, 0, _data);

    deviceOptionLogList.value.forEach(item => {
      // eslint-disable-next-line no-debugger
      debugger

      if(item.requestTime && item.requestTime.length > 18) {
        item.requestTime = item.requestTime.substring(10, item.requestTime.length);
      }
      if(item.responseTime && item.responseTime.length > 18) {
        item.responseTime = item.responseTime.substring(10, item.responseTime.length);
      }
    });
  }
};

ws.onerror=(e)=>{
  console.log("当websocket建立网络连接失败时触发",e);
};
ws.onclose=(e)=>{
  console.log("当websocket被关闭时时触发",e);
};

//ws.send(JSON.stringify({content:'hello'}));

return (_ctx, _cache) => {
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_tag = resolveComponent("el-tag");
  const _component_el_popover = resolveComponent("el-popover");
  const _component_el_table = resolveComponent("el-table");

  return (openBlock(), createElementBlock("div", _hoisted_1$1, [
    _hoisted_2$1,
    createVNode(_component_el_table, {
      data: deviceOptionLogList.value,
      style: {"width":"100%"}
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          label: "设备名称",
          prop: "deviceName",
          width: "120"
        }),
        createVNode(_component_el_table_column, {
          label: "操作类型",
          prop: "optionType",
          width: "80"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.optionType == '1' ? '属性' : scope.row.optionType == '2' ? '服务' : '事件'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          label: "Topic",
          prop: "topic",
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
          label: "请求参数",
          prop: "requestParams"
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
                    createTextVNode(toDisplayString(sliceString(scope.row.requestParams, 30)), 1)
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
          width: "120"
        }),
        createVNode(_component_el_table_column, {
          label: "响应数据",
          prop: "responseData"
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
                        createTextVNode(toDisplayString(sliceString(scope.row.responseData, 30)), 1)
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
          width: "120"
        })
      ]),
      _: 1
    }, 8, ["data"])
  ]))
}
}

};
var Log = /*#__PURE__*/_export_sfc(_sfc_main$1, [['__scopeId',"data-v-34758300"]]);

var index_vue_vue_type_style_index_0_scoped_true_lang = '';

const _withScopeId = n => (pushScopeId("data-v-ccb42edc"),n=n(),popScopeId(),n);
const _hoisted_1 = {
  class: "app-container",
  style: {"background-color":"#ffffff","padding":"10px 10px"}
};
const _hoisted_2 = /*#__PURE__*/ _withScopeId(() => /*#__PURE__*/createBaseVNode("span", {
  class: "text-large font-600 mr-3",
  style: {"font-size":"18px"}
}, "在线调试 ", -1));
const _hoisted_3 = /*#__PURE__*/ _withScopeId(() => /*#__PURE__*/createBaseVNode("p", null, "在线调试只支持调试在线设备，不支持离线设备！", -1));
const _hoisted_4 = {
  key: 0,
  style: {"color":"#1ab394"}
};
const _hoisted_5 = { key: 1 };
const _hoisted_6 = { style: {"margin-top":"20px","margin-left":"30px"} };
const _hoisted_7 = { style: {"font-size":"14px","font-weight":"normal","padding-top":"10px"} };
const _hoisted_8 = { key: 0 };
const _hoisted_9 = { key: 1 };
const _hoisted_10 = { key: 2 };
const _hoisted_11 = { style: {"font-size":"14px","font-weight":"normal","padding-top":"10px"} };
const _hoisted_12 = /*#__PURE__*/createTextVNode(" ");
const _hoisted_13 = /*#__PURE__*/createTextVNode("提 交");
const _hoisted_14 = { style: {"margin-top":"20px","margin-left":"30px"} };
const _hoisted_15 = /*#__PURE__*/ _withScopeId(() => /*#__PURE__*/createBaseVNode("div", { style: {"font-size":"14px","font-weight":"normal","padding-top":"10px"} }, "服务", -1));
const _hoisted_16 = { style: {"font-size":"14px","font-weight":"normal","padding-top":"6px"} };
const _hoisted_17 = { key: 0 };
const _hoisted_18 = { key: 1 };
const _hoisted_19 = { key: 2 };
const _hoisted_20 = /*#__PURE__*/createTextVNode(" ");
const _hoisted_21 = /*#__PURE__*/createTextVNode("提 交");


const _sfc_main = {
  setup(__props) {

const activeName = ref('atrr');
function handleClick (tab, event) {
  console.log(tab, event);
}

const productId = ref('');
const deviceId = ref('');
const productInfoList = ref([]);
const deviceInfoList = ref([]);
const modelAtrrList = ref([]);
const modelServiceList = ref([]);

function getAllProductInfo() {
  listAllProductInfo().then(response => {
    productInfoList.value = response.data;
  });
}
getAllProductInfo();

function selectProduct() {
  deviceInfoList.value = [];
  runStatus.value = '';

  listAllDeviceInfo(productId.value).then(response => {
    deviceInfoList.value = response.data;
  });
}

const runStatus = ref('');
function selectDevice() {
  modelAtrrList.value = [];
  modelServiceList.value = [];

  deviceInfoList.value.forEach(item => {
    if(item.id == deviceId.value) {
      runStatus.value = item.runStatus;
    }
  });

  if(runStatus.value == '1') {
    listModelAttrList(productId.value).then(response => {
      modelAtrrList.value = response.data;
      modelAtrrList.value.forEach(item => {
        item.typeParams = JSON.parse(item.typeParams);
      });
    });
    listModelServiceList(productId.value).then(response => {
      modelServiceList.value = response.data;
    });
  }
}

//属性设置
const formData = ref({});
function submitForm() {
  console.log(formData.value);

  let data = {
    deviceId: deviceId.value,
    params: formData.value,
    pageId: pageId.value
  };
  console.log(data);
  propertySet(data).then(response => {
    formData.value = {};
  });
}

//服务调用
const formServiceData = ref({});
const identifier = ref('');
const serviceParamsList = ref([]);
function selectIdentifier() {
  modelServiceList.value.forEach(item => {
    if(item.identifier == identifier.value) {
      serviceParamsList.value = JSON.parse(item.inputParams);
    }
  });
}
function submitServiceForm() {
  console.log(formServiceData.value);

  let data = {
    deviceId: deviceId.value,
    identifier: identifier.value,
    params: formServiceData.value,
    pageId: pageId.value
  };
  console.log(data);
  service(data).then(response => {
    formServiceData.value = {};
  });
}

const pageId = ref('');
function generateUUID() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0,
        v = c === 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}
pageId.value = generateUUID();

return (_ctx, _cache) => {
  const _component_el_alert = resolveComponent("el-alert");
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_space = resolveComponent("el-space");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_input_number = resolveComponent("el-input-number");
  const _component_el_input = resolveComponent("el-input");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_tab_pane = resolveComponent("el-tab-pane");
  const _component_el_tabs = resolveComponent("el-tabs");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    _hoisted_2,
    createVNode(_component_el_form, {
      inline: true,
      "label-width": "88px",
      style: {"margin-top":"20px","background-color":"#f4f4f5","padding-top":"20px"}
    }, {
      default: withCtx(() => [
        createVNode(_component_el_space, { fill: "" }, {
          default: withCtx(() => [
            createVNode(_component_el_alert, {
              type: "info",
              "show-icon": "",
              closable: false
            }, {
              default: withCtx(() => [
                _hoisted_3
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, { label: "选择设备：" }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: productId.value,
                  "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((productId).value = $event)),
                  onChange: selectProduct,
                  placeholder: "选择产品",
                  style: {"width":"42%","margin-right":"5px"}
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
                }, 8, ["modelValue"]),
                createVNode(_component_el_select, {
                  modelValue: deviceId.value,
                  "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((deviceId).value = $event)),
                  onChange: selectDevice,
                  placeholder: "选择设备",
                  style: {"width":"42%","margin-right":"5px"}
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(deviceInfoList.value, (item) => {
                      return (openBlock(), createBlock(_component_el_option, {
                        key: item.id,
                        label: item.name,
                        value: item.id
                      }, null, 8, ["label", "value"]))
                    }), 128))
                  ]),
                  _: 1
                }, 8, ["modelValue"]),
                (runStatus.value == '1')
                  ? (openBlock(), createElementBlock("span", _hoisted_4, " 在线"))
                  : createCommentVNode("", true),
                (runStatus.value == '0')
                  ? (openBlock(), createElementBlock("span", _hoisted_5, " 离线"))
                  : createCommentVNode("", true)
              ]),
              _: 1
            })
          ]),
          _: 1
        })
      ]),
      _: 1
    }),
    createVNode(_component_el_row, {
      gutter: 10,
      class: "mb8"
    }, {
      default: withCtx(() => [
        createVNode(_component_el_col, { span: 10 }, {
          default: withCtx(() => [
            createVNode(_component_el_tabs, {
              modelValue: activeName.value,
              "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => ((activeName).value = $event)),
              class: "demo-tabs",
              onTabClick: handleClick
            }, {
              default: withCtx(() => [
                createVNode(_component_el_tab_pane, {
                  label: "属性调试",
                  name: "atrr",
                  style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-20px","width":"90%"}
                }, {
                  default: withCtx(() => [
                    createBaseVNode("div", _hoisted_6, [
                      (openBlock(true), createElementBlock(Fragment, null, renderList(modelAtrrList.value, (item) => {
                        return (openBlock(), createBlock(_component_el_row, {
                          key: item.id,
                          gutter: 10,
                          class: "mb8",
                          style: {"margin-bottom":"10px"}
                        }, {
                          default: withCtx(() => [
                            createVNode(_component_el_col, { span: 5 }, {
                              default: withCtx(() => [
                                createBaseVNode("div", _hoisted_7, toDisplayString(item.name), 1)
                              ]),
                              _: 2
                            }, 1024),
                            createVNode(_component_el_col, { span: 17 }, {
                              default: withCtx(() => [
                                (item.dataTypeId == 1 || item.dataTypeId == 2)
                                  ? (openBlock(), createElementBlock("div", _hoisted_8, [
                                      createVNode(_component_el_input_number, {
                                        modelValue: formData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formData.value[item.identifier]) = $event),
                                        min: item.typeParams.min,
                                        max: item.typeParams.max,
                                        step: item.typeParams.step
                                      }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "max", "step"])
                                    ]))
                                  : createCommentVNode("", true),
                                (item.dataTypeId == 3)
                                  ? (openBlock(), createElementBlock("div", _hoisted_9, [
                                      createVNode(_component_el_input, {
                                        modelValue: formData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formData.value[item.identifier]) = $event),
                                        placeholder: '请输入'+item.name
                                      }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])
                                    ]))
                                  : createCommentVNode("", true),
                                (item.dataTypeId == 4)
                                  ? (openBlock(), createElementBlock("div", _hoisted_10, [
                                      createVNode(_component_el_select, {
                                        modelValue: formData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formData.value[item.identifier]) = $event),
                                        placeholder: "请选择枚举项",
                                        style: {"width":"100%"}
                                      }, {
                                        default: withCtx(() => [
                                          (openBlock(true), createElementBlock(Fragment, null, renderList(item.typeParams.enumList, (item) => {
                                            return (openBlock(), createBlock(_component_el_option, {
                                              key: item.value,
                                              label: item.name,
                                              value: item.value
                                            }, null, 8, ["label", "value"]))
                                          }), 128))
                                        ]),
                                        _: 2
                                      }, 1032, ["modelValue", "onUpdate:modelValue"])
                                    ]))
                                  : createCommentVNode("", true)
                              ]),
                              _: 2
                            }, 1024),
                            createVNode(_component_el_col, { span: 2 }, {
                              default: withCtx(() => [
                                createBaseVNode("div", _hoisted_11, toDisplayString(item.dataUnit), 1)
                              ]),
                              _: 2
                            }, 1024)
                          ]),
                          _: 2
                        }, 1024))
                      }), 128)),
                      (modelAtrrList.value.length > 0)
                        ? (openBlock(), createBlock(_component_el_row, {
                            key: 0,
                            gutter: 10,
                            class: "mb8",
                            style: {"margin-top":"20px"}
                          }, {
                            default: withCtx(() => [
                              createVNode(_component_el_col, { span: 4 }, {
                                default: withCtx(() => [
                                  _hoisted_12
                                ]),
                                _: 1
                              }),
                              createVNode(_component_el_col, { span: 16 }, {
                                default: withCtx(() => [
                                  createVNode(_component_el_button, {
                                    type: "primary",
                                    plain: "",
                                    size: "small",
                                    onClick: submitForm
                                  }, {
                                    default: withCtx(() => [
                                      _hoisted_13
                                    ]),
                                    _: 1
                                  })
                                ]),
                                _: 1
                              })
                            ]),
                            _: 1
                          }))
                        : createCommentVNode("", true)
                    ])
                  ]),
                  _: 1
                }),
                createVNode(_component_el_tab_pane, {
                  label: "服务调用",
                  name: "service",
                  style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-20px","width":"90%"}
                }, {
                  default: withCtx(() => [
                    createBaseVNode("div", _hoisted_14, [
                      (modelServiceList.value.length > 0)
                        ? (openBlock(), createBlock(_component_el_row, {
                            key: 0,
                            gutter: 10,
                            class: "mb8"
                          }, {
                            default: withCtx(() => [
                              createVNode(_component_el_col, { span: 4 }, {
                                default: withCtx(() => [
                                  _hoisted_15
                                ]),
                                _: 1
                              }),
                              createVNode(_component_el_col, { span: 20 }, {
                                default: withCtx(() => [
                                  createVNode(_component_el_select, {
                                    modelValue: identifier.value,
                                    "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((identifier).value = $event)),
                                    onChange: selectIdentifier,
                                    placeholder: "选择服务",
                                    style: {"margin-right":"5px","width":"100%"}
                                  }, {
                                    default: withCtx(() => [
                                      (openBlock(true), createElementBlock(Fragment, null, renderList(modelServiceList.value, (item) => {
                                        return (openBlock(), createBlock(_component_el_option, {
                                          key: item.identifier,
                                          label: item.name,
                                          value: item.identifier
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
                          }))
                        : createCommentVNode("", true),
                      (openBlock(true), createElementBlock(Fragment, null, renderList(serviceParamsList.value, (item) => {
                        return (openBlock(), createBlock(_component_el_row, {
                          key: item.id,
                          gutter: 10,
                          class: "mb8",
                          style: {"margin-top":"20px"}
                        }, {
                          default: withCtx(() => [
                            createVNode(_component_el_col, { span: 4 }, {
                              default: withCtx(() => [
                                createBaseVNode("div", _hoisted_16, toDisplayString(item.name), 1)
                              ]),
                              _: 2
                            }, 1024),
                            createVNode(_component_el_col, { span: 20 }, {
                              default: withCtx(() => [
                                (item.dataTypeId == 1 || item.dataTypeId == 2)
                                  ? (openBlock(), createElementBlock("div", _hoisted_17, [
                                      createVNode(_component_el_input_number, {
                                        modelValue: formServiceData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formServiceData.value[item.identifier]) = $event),
                                        min: item.typeParams.min,
                                        max: item.typeParams.max,
                                        step: item.typeParams.step
                                      }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "max", "step"])
                                    ]))
                                  : createCommentVNode("", true),
                                (item.dataTypeId == 3)
                                  ? (openBlock(), createElementBlock("div", _hoisted_18, [
                                      createVNode(_component_el_input, {
                                        modelValue: formServiceData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formServiceData.value[item.identifier]) = $event),
                                        placeholder: '请输入'+item.name
                                      }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])
                                    ]))
                                  : createCommentVNode("", true),
                                (item.dataTypeId == 4)
                                  ? (openBlock(), createElementBlock("div", _hoisted_19, [
                                      createVNode(_component_el_select, {
                                        modelValue: formServiceData.value[item.identifier],
                                        "onUpdate:modelValue": $event => ((formServiceData.value[item.identifier]) = $event),
                                        placeholder: "请选择枚举项",
                                        style: {"width":"100%"}
                                      }, {
                                        default: withCtx(() => [
                                          (openBlock(true), createElementBlock(Fragment, null, renderList(item.typeParams.enumList, (item) => {
                                            return (openBlock(), createBlock(_component_el_option, {
                                              key: item.value,
                                              label: item.name,
                                              value: item.value
                                            }, null, 8, ["label", "value"]))
                                          }), 128))
                                        ]),
                                        _: 2
                                      }, 1032, ["modelValue", "onUpdate:modelValue"])
                                    ]))
                                  : createCommentVNode("", true)
                              ]),
                              _: 2
                            }, 1024)
                          ]),
                          _: 2
                        }, 1024))
                      }), 128)),
                      (modelServiceList.value.length > 0)
                        ? (openBlock(), createBlock(_component_el_row, {
                            key: 1,
                            gutter: 10,
                            class: "mb8",
                            style: {"margin-top":"20px"}
                          }, {
                            default: withCtx(() => [
                              createVNode(_component_el_col, { span: 4 }, {
                                default: withCtx(() => [
                                  _hoisted_20
                                ]),
                                _: 1
                              }),
                              createVNode(_component_el_col, { span: 20 }, {
                                default: withCtx(() => [
                                  createVNode(_component_el_button, {
                                    type: "primary",
                                    plain: "",
                                    size: "small",
                                    onClick: submitServiceForm
                                  }, {
                                    default: withCtx(() => [
                                      _hoisted_21
                                    ]),
                                    _: 1
                                  })
                                ]),
                                _: 1
                              })
                            ]),
                            _: 1
                          }))
                        : createCommentVNode("", true)
                    ])
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }, 8, ["modelValue"])
          ]),
          _: 1
        }),
        createVNode(_component_el_col, { span: 14 }, {
          default: withCtx(() => [
            createVNode(Log, { pageId: pageId.value }, null, 8, ["pageId"])
          ]),
          _: 1
        })
      ]),
      _: 1
    })
  ]))
}
}

};
var index = /*#__PURE__*/_export_sfc(_sfc_main, [['__scopeId',"data-v-ccb42edc"]]);

export { index as default };
