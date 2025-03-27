import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, K as createBaseVNode, S as toDisplayString, R as createTextVNode, L as createCommentVNode, F as Fragment, Q as renderList, m as createBlock, N as withDirectives, a6 as vShow, u as unref } from './element-plus.aa5fe574.js';
import { k as service, b as useRoute, u as useRouter } from './index.4cfe0fe4.js';
import { g as getDeviceInfo } from './deviceInfo.c4decd11.js';
import { b as listModelAttrValue, c as listDeviceAtrrData, e as listDeviceEventData, f as listDeviceServiceData } from './productModel.4d2a878c.js';

// 查询设备订阅的topic列表
function listDeviceSubscribeTopic(deviceId) {
  return service({
    url: '/platform/deviceSubscribeTopic/list/'+deviceId,
    method: 'get'
  })
}

var show_vue_vue_type_style_index_0_lang = '';

const _hoisted_1 = {
  class: "app-container",
  style: {"background-color":"#ffffff","padding":"10px 10px"}
};
const _hoisted_2 = { class: "text-large font-600 mr-3" };
const _hoisted_3 = {
  key: 0,
  style: {"color":"#1ab394"}
};
const _hoisted_4 = { key: 1 };
const _hoisted_5 = /*#__PURE__*/createTextVNode("已订阅 Topic 列表");
const _hoisted_6 = { style: {"padding":"5px"} };
const _hoisted_7 = /*#__PURE__*/createTextVNode("查看数据");
const _hoisted_8 = { class: "dialog-footer" };
const _hoisted_9 = /*#__PURE__*/createTextVNode("取 消");


const _sfc_main = {
  setup(__props) {

const deviceInfo = ref({productInfo:{}});
const productTopicList = ref([]);
const productModelAttrValueList = ref([]);

/** 查看按钮操作 */
const route = useRoute();
const id = ref(route.params.id);
// const id = ref(1)
handleShow(id.value);
function handleShow() {
  getDeviceInfo(id.value).then(response => {
    deviceInfo.value = response.data;

    listModelAttrValue(deviceInfo.value.productId, id.value).then(response => {
      productModelAttrValueList.value = response.data;
    });
  });

  listDeviceSubscribeTopic(id.value).then(response => {
    productTopicList.value = response.data;
  });
}

const data = reactive({
  queryAtrrParams: {
    pageNum: 1,
    pageSize: 10,
    deviceId: id.value,
    modelAttrId: null
  },
  queryEventParams: {
    pageNum: 1,
    pageSize: 10,
    deviceId: id.value
  },
  queryServiceParams: {
    pageNum: 1,
    pageSize: 10,
    deviceId: id.value
  },
});
const {  queryAtrrParams, queryEventParams, queryServiceParams } = toRefs(data);


const deviceAtrrDataList = ref([]);
const loadingAtrr = ref(false);
const totalAtrr = ref(0);
function getDeviceAtrrDataList(row) {
  loadingAtrr.value = true;

  queryAtrrParams.value.modelAttrId = row.id;

  listDeviceAtrrData(queryAtrrParams.value).then(response => {
    deviceAtrrDataList.value = response.data.records;
    totalAtrr.value = response.data.total;
    loadingAtrr.value = false;
  });
}

const deviceEventDataList = ref([]);
const loadingEvent = ref(false);
const totalEvent = ref(0);
function getDeviceEventDataList() {
  loadingEvent.value = true;

  listDeviceEventData(queryEventParams.value).then(response => {
    deviceEventDataList.value = response.data.records;
    totalEvent.value = response.data.total;
    loadingEvent.value = false;
  });
}
getDeviceEventDataList();

const deviceServiceDataList = ref([]);
const loadingService = ref(false);
const totalService = ref(0);
function getDeviceServiceDataList() {
  loadingService.value = true;

  listDeviceServiceData(queryServiceParams.value).then(response => {
    deviceServiceDataList.value = response.data.records;
    totalService.value = response.data.total;
    loadingService.value = false;
  });
}
getDeviceServiceDataList();

const router = useRouter();
function goBack() {
  router.push("/deviceInfo");
}

const activeName = ref('device');
function handleClick (tab, event) {
  console.log(tab, event);
}

const open = ref(false);
const title = ref("");
function handleShowData(row) {
  deviceAtrrDataList.value = [];
  open.value = true;
  title.value = "查看数据";

  getDeviceAtrrDataList(row);
}
// 取消按钮
function cancel() {
  open.value = false;
}

const activeModelName = ref('first');

function handleModelClick (tab, event) {
  console.log(tab, event);
}

// import { useClipboard } from '@vueuse/core'
// const { isSupported, copy, copied } = useClipboard()
// function copyText(content) {
//   if(!isSupported) {
//     ElMessage.warning("浏览器不支持")
//   }
//   copy(content)
//   if (copied) {
//     ElMessage.success("复制成功");
//   } else {
//     ElMessage.info("复制失败");
//   }
// }

return (_ctx, _cache) => {
  const _component_el_page_header = resolveComponent("el-page-header");
  const _component_el_descriptions_item = resolveComponent("el-descriptions-item");
  const _component_el_descriptions = resolveComponent("el-descriptions");
  const _component_el_tab_pane = resolveComponent("el-tab-pane");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_col = resolveComponent("el-col");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_card = resolveComponent("el-card");
  const _component_pagination = resolveComponent("pagination");
  const _component_el_tabs = resolveComponent("el-tabs");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _directive_loading = resolveDirective("loading");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    createVNode(_component_el_page_header, {
      title: "返回",
      onBack: goBack
    }, {
      content: withCtx(() => [
        createBaseVNode("span", _hoisted_2, toDisplayString(deviceInfo.value.name), 1)
      ]),
      _: 1
    }),
    createVNode(_component_el_descriptions, {
      style: {"margin-top":"20px"},
      column: "2"
    }, {
      default: withCtx(() => [
        createVNode(_component_el_descriptions_item, { label: "产品名称" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(deviceInfo.value.productInfo.name), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_descriptions_item, { label: "产品KEY" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(deviceInfo.value.productInfo.productKey), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_descriptions_item, { label: "节点类型" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(deviceInfo.value.productInfo.nodeType == 1 ? '直连设备' : deviceInfo.value.productInfo.nodeType == 2 ? '网关子设备' : '网关设备'), 1)
          ]),
          _: 1
        })
      ]),
      _: 1
    }),
    createVNode(_component_el_tabs, {
      modelValue: activeName.value,
      "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((activeName).value = $event)),
      class: "demo-tabs",
      onTabClick: handleClick
    }, {
      default: withCtx(() => [
        createVNode(_component_el_tab_pane, {
          label: "设备信息",
          name: "device",
          style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-10px"}
        }, {
          default: withCtx(() => [
            createVNode(_component_el_descriptions, { title: "设备信息" }, {
              default: withCtx(() => [
                createVNode(_component_el_descriptions_item, { label: "设备名称" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.name), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "在线状态" }, {
                  default: withCtx(() => [
                    (deviceInfo.value.runStatus == 1)
                      ? (openBlock(), createElementBlock("span", _hoisted_3, "在线"))
                      : createCommentVNode("", true),
                    (deviceInfo.value.runStatus == 0)
                      ? (openBlock(), createElementBlock("span", _hoisted_4, "离线"))
                      : createCommentVNode("", true)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "最后连接时间" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.lastConnectTime), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "客户端ID" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.clientId), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "客户端用户名" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.username), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "客户端密码" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.password), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "创建时间" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(deviceInfo.value.createTime), 1)
                  ]),
                  _: 1
                })
              ]),
              _: 1
            })
          ]),
          _: 1
        }),
        createVNode(_component_el_tab_pane, {
          label: "Topic列表",
          name: "topic",
          style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-10px"}
        }, {
          default: withCtx(() => [
            createVNode(_component_el_button, {
              type: "primary",
              link: "",
              style: {"margin-left":"0px","margin-top":"-30px"}
            }, {
              default: withCtx(() => [
                _hoisted_5
              ]),
              _: 1
            }),
            createVNode(_component_el_table, {
              data: productTopicList.value,
              border: "",
              style: {"margin-left":"0px","margin-top":"0px"}
            }, {
              default: withCtx(() => [
                createVNode(_component_el_table_column, {
                  label: "序号",
                  type: "index",
                  width: "80"
                }),
                createVNode(_component_el_table_column, {
                  label: "Topic类",
                  prop: "topic"
                })
              ]),
              _: 1
            }, 8, ["data"])
          ]),
          _: 1
        }),
        createVNode(_component_el_tab_pane, {
          label: "物模型数据",
          name: "model",
          style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-10px"}
        }, {
          default: withCtx(() => [
            createVNode(_component_el_tabs, {
              modelValue: activeModelName.value,
              "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((activeModelName).value = $event)),
              type: "card",
              class: "demo-tabs",
              onTabClick: handleModelClick
            }, {
              default: withCtx(() => [
                createVNode(_component_el_tab_pane, {
                  label: "运行状态",
                  name: "first"
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_row, {
                      gutter: 12,
                      style: {"margin-left":"-35px","margin-top":"-20px"}
                    }, {
                      default: withCtx(() => [
                        (openBlock(true), createElementBlock(Fragment, null, renderList(productModelAttrValueList.value, (item, index) => {
                          return (openBlock(), createBlock(_component_el_col, {
                            span: 6,
                            key: item.id
                          }, {
                            default: withCtx(() => [
                              createVNode(_component_el_card, { style: {"margin-bottom":"10px"} }, {
                                default: withCtx(() => [
                                  createBaseVNode("div", _hoisted_6, [
                                    createVNode(_component_el_row, { style: {"margin-bottom":"10px"} }, {
                                      default: withCtx(() => [
                                        createVNode(_component_el_col, { span: 16 }, {
                                          default: withCtx(() => [
                                            createTextVNode(toDisplayString(item.name) + "（" + toDisplayString(item.identifier) + "）", 1)
                                          ]),
                                          _: 2
                                        }, 1024),
                                        createVNode(_component_el_col, { span: 8 }, {
                                          default: withCtx(() => [
                                            createVNode(_component_el_button, {
                                              link: "",
                                              type: "primary",
                                              disabled: item.deviceId == null,
                                              onClick: $event => (handleShowData(item))
                                            }, {
                                              default: withCtx(() => [
                                                _hoisted_7
                                              ]),
                                              _: 2
                                            }, 1032, ["disabled", "onClick"])
                                          ]),
                                          _: 2
                                        }, 1024)
                                      ]),
                                      _: 2
                                    }, 1024),
                                    createVNode(_component_el_row, { style: {"margin-bottom":"10px"} }, {
                                      default: withCtx(() => [
                                        createVNode(_component_el_col, { span: 24 }, {
                                          default: withCtx(() => [
                                            createTextVNode(toDisplayString(item.dataValue == null ? '--' : item.dataValue + item.dataUnit) + " ", 1)
                                          ]),
                                          _: 2
                                        }, 1024)
                                      ]),
                                      _: 2
                                    }, 1024),
                                    createVNode(_component_el_row, null, {
                                      default: withCtx(() => [
                                        createVNode(_component_el_col, { span: 24 }, {
                                          default: withCtx(() => [
                                            createTextVNode(toDisplayString(item.lastCreateTime == null ? '--' : item.lastCreateTime) + " ", 1)
                                          ]),
                                          _: 2
                                        }, 1024)
                                      ]),
                                      _: 2
                                    }, 1024)
                                  ])
                                ]),
                                _: 2
                              }, 1024)
                            ]),
                            _: 2
                          }, 1024))
                        }), 128))
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }),
                createVNode(_component_el_tab_pane, {
                  label: "事件管理",
                  name: "second"
                }, {
                  default: withCtx(() => [
                    withDirectives((openBlock(), createBlock(_component_el_table, {
                      data: deviceEventDataList.value,
                      border: "",
                      style: {"margin-left":"-30px","margin-top":"-20px"}
                    }, {
                      default: withCtx(() => [
                        createVNode(_component_el_table_column, {
                          label: "时间",
                          prop: "createTime",
                          width: "160"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "标识符",
                          prop: "identifier",
                          width: "180"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "事件名称",
                          prop: "name",
                          width: "150"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "输出参数值",
                          prop: "outputValues"
                        })
                      ]),
                      _: 1
                    }, 8, ["data"])), [
                      [_directive_loading, loadingEvent.value]
                    ]),
                    withDirectives(createVNode(_component_pagination, {
                      total: totalEvent.value,
                      page: unref(queryEventParams).pageNum,
                      "onUpdate:page": _cache[0] || (_cache[0] = $event => ((unref(queryEventParams).pageNum) = $event)),
                      limit: unref(queryEventParams).pageSize,
                      "onUpdate:limit": _cache[1] || (_cache[1] = $event => ((unref(queryEventParams).pageSize) = $event)),
                      onPagination: getDeviceEventDataList
                    }, null, 8, ["total", "page", "limit"]), [
                      [vShow, totalEvent.value>0]
                    ])
                  ]),
                  _: 1
                }),
                createVNode(_component_el_tab_pane, {
                  label: "服务调用",
                  name: "third"
                }, {
                  default: withCtx(() => [
                    withDirectives((openBlock(), createBlock(_component_el_table, {
                      data: deviceServiceDataList.value,
                      border: "",
                      style: {"margin-left":"-30px","margin-top":"-20px"}
                    }, {
                      default: withCtx(() => [
                        createVNode(_component_el_table_column, {
                          label: "时间",
                          prop: "createTime",
                          width: "160"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "标识符",
                          prop: "identifier",
                          width: "120"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "事件名称",
                          prop: "name",
                          width: "120"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "传入参数值",
                          prop: "inputValues"
                        }),
                        createVNode(_component_el_table_column, {
                          label: "返回值",
                          prop: "outputValues"
                        })
                      ]),
                      _: 1
                    }, 8, ["data"])), [
                      [_directive_loading, loadingService.value]
                    ]),
                    withDirectives(createVNode(_component_pagination, {
                      total: totalService.value,
                      page: unref(queryServiceParams).pageNum,
                      "onUpdate:page": _cache[2] || (_cache[2] = $event => ((unref(queryServiceParams).pageNum) = $event)),
                      limit: unref(queryServiceParams).pageSize,
                      "onUpdate:limit": _cache[3] || (_cache[3] = $event => ((unref(queryServiceParams).pageSize) = $event)),
                      onPagination: getDeviceServiceDataList
                    }, null, 8, ["total", "page", "limit"]), [
                      [vShow, totalService.value>0]
                    ])
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
    }, 8, ["modelValue"]),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[8] || (_cache[8] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_8, [
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_9
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        withDirectives((openBlock(), createBlock(_component_el_table, { data: deviceAtrrDataList.value }, {
          default: withCtx(() => [
            createVNode(_component_el_table_column, {
              label: "更新时间",
              prop: "createTime",
              width: "180"
            }),
            createVNode(_component_el_table_column, {
              label: "原始值",
              prop: "dataValue"
            })
          ]),
          _: 1
        }, 8, ["data"])), [
          [_directive_loading, loadingAtrr.value]
        ]),
        withDirectives(createVNode(_component_pagination, {
          total: totalAtrr.value,
          page: unref(queryAtrrParams).pageNum,
          "onUpdate:page": _cache[6] || (_cache[6] = $event => ((unref(queryAtrrParams).pageNum) = $event)),
          limit: unref(queryAtrrParams).pageSize,
          "onUpdate:limit": _cache[7] || (_cache[7] = $event => ((unref(queryAtrrParams).pageSize) = $event)),
          onPagination: getDeviceAtrrDataList,
          background: "",
          layout: "total, prev, pager, next"
        }, null, 8, ["total", "page", "limit"]), [
          [vShow, totalAtrr.value>0]
        ])
      ]),
      _: 1
    }, 8, ["title", "modelValue"])
  ]))
}
}

};

export { _sfc_main as default };
