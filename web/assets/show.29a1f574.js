import { k as service, b as useRoute, u as useRouter } from './index.4cfe0fe4.js';
import { g as getProductInfo } from './productInfo.427251c3.js';
import { r as ref, q as reactive, C as toRefs, p as resolveComponent, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, K as createBaseVNode, u as unref, F as Fragment, Q as renderList, m as createBlock, R as createTextVNode, P as resolveDirective, S as toDisplayString, N as withDirectives, H as ElMessage, a9 as ElMessageBox, L as createCommentVNode } from './element-plus.aa5fe574.js';
import { l as listProductModel, u as updateProductModel, a as addProductModel, d as delProductModel } from './productModel.4d2a878c.js';

// 查询产品Topic列表
function listProductTopic(productId) {
  return service({
    url: '/platform/productTopic/list/'+productId,
    method: 'get'
  })
}

// 新增产品信息
function addProductTopic(data) {
  return service({
    url: '/platform/productTopic',
    method: 'post',
    data: data
  })
}

// 修改产品信息
function updateProductTopic(data) {
  return service({
    url: '/platform/productTopic',
    method: 'put',
    data: data
  })
}

// 删除产品信息
function delProductTopic(id) {
  return service({
    url: '/platform/productTopic/' + id,
    method: 'delete'
  })
}

const _hoisted_1$3 = { style: {"margin-top":"-30px","margin-left":"-30px"} };
const _hoisted_2$2 = /*#__PURE__*/createTextVNode("添加自定义Topic");
const _hoisted_3$1 = /*#__PURE__*/createBaseVNode("p", null, "自定义Topic默认前缀：custom/${productKey}/${clientId}/${自定义Topic}", -1);
const _hoisted_4$1 = { class: "dialog-footer" };
const _hoisted_5$1 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_6$1 = /*#__PURE__*/createTextVNode("取 消");

// eslint-disable-next-line no-undef

const _sfc_main$3 = {
  props: {
  // 数据
  productId: null
},
  emits: ['closeTopic'],
  setup(__props, { emit }) {

const props = __props;


// eslint-disable-next-line no-undef


const open = ref(false);
const title = ref('');

const data = reactive({
  form: {},
  rules: {
    groupName: [
      { required: true, message: "Topic名称不能为空", trigger: "blur" }
    ],
    topic: [
      { required: true, message: "Topic不能为空", trigger: "blur" },
      { pattern: /^[a-zA-Z0-9]+$/, message: 'Topic只能包含字母和数字', trigger: 'blur' },
    ],
    optionType: [
      { required: true, message: "设备操作权限不能为空", trigger: "change" }
    ]
  },
  optionTypeList: [
    { id: 1, name: '发布'},
    { id: 2, name: '订阅'},
    { id: 3, name: '发布与订阅'}
  ]
});

const { form, rules, optionTypeList } = toRefs(data);

// 表单重置
function reset() {
  form.value = {
    id: null,
    productId: props.productId,
    topicType: '3',
    groupName: '',
    topic: null,
    optionType: 1,
    status: '1',
    remark: null
  };
  //proxy.resetForm("topicRef");
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加自定义Topic";
}

/** 提交按钮 */
function submitForm() {
  // proxy.$refs["topicRef"].validate(valid => {
  //   if (valid) {
      if (form.value.id != null) {
        updateProductTopic(form.value).then(response => {
          // proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          //getList();
          emit('closeTopic', '1');
        });
      } else {
        addProductTopic(form.value).then(response => {
          // proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          emit('closeTopic', '2');
        });
      }
  //   }
  // });
}

return (_ctx, _cache) => {
  const _component_el_button = resolveComponent("el-button");
  const _component_el_input = resolveComponent("el-input");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_alert = resolveComponent("el-alert");
  const _component_el_space = resolveComponent("el-space");
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_dialog = resolveComponent("el-dialog");

  return (openBlock(), createElementBlock("div", _hoisted_1$3, [
    createVNode(_component_el_button, {
      type: "primary",
      plain: "",
      onClick: handleAdd,
      style: {"font-size":"12px"}
    }, {
      default: withCtx(() => [
        _hoisted_2$2
      ]),
      _: 1
    }),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_4$1, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitForm
          }, {
            default: withCtx(() => [
              _hoisted_5$1
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_6$1
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref: "topicRef",
          model: unref(form),
          rules: unref(rules),
          "label-width": "120px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "Topic名称",
              prop: "groupName"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).groupName,
                  "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(form).groupName) = $event)),
                  placeholder: "请输入Topic名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_space, { fill: "" }, {
              default: withCtx(() => [
                createVNode(_component_el_alert, {
                  type: "info",
                  "show-icon": "",
                  closable: false
                }, {
                  default: withCtx(() => [
                    _hoisted_3$1
                  ]),
                  _: 1
                }),
                createVNode(_component_el_form_item, {
                  label: "Topic",
                  prop: "topic"
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_input, {
                      modelValue: unref(form).topic,
                      "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(form).topic) = $event)),
                      placeholder: "请输入Topic"
                    }, null, 8, ["modelValue"])
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "设备操作权限",
              prop: "optionType"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: unref(form).optionType,
                  "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((unref(form).optionType) = $event)),
                  class: "m-2",
                  placeholder: "设备操作权限"
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(unref(optionTypeList), (item) => {
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
              label: "描述",
              prop: "remark"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).remark,
                  "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => ((unref(form).remark) = $event)),
                  type: "textarea",
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
    }, 8, ["title", "modelValue"])
  ]))
}
}

};

const _hoisted_1$2 = /*#__PURE__*/createTextVNode("删除");

// eslint-disable-next-line no-undef

const _sfc_main$2 = {
  props: {
  // 数据
  productId: null
},
  setup(__props) {

const props = __props;



const productTopicList1 = ref([]);
const productTopicList2 = ref([]);
const productTopicList3 = ref([]);
function handleShowTopic() {
  productTopicList1.value = [];
  productTopicList2.value = [];
  productTopicList3.value = [];
  listProductTopic(props.productId).then(response => {
    response.data.forEach(item => {
      if(item.topicType == 1) {
        productTopicList1.value.push(item);
      }
      if(item.topicType == 2) {
        productTopicList2.value.push(item);
      }
      if(item.topicType == 3) {
        productTopicList3.value.push(item);
      }
    });
  });
}
handleShowTopic();

const activeTopicName = ref('first');
function handleTopicClick (tab, event) {
  console.log(tab, event);
}

function closeTopic(type) {
  //proxy.$refs["productTopicRef"].close()
  console.log('close:'+ type);
  if(type == '1') {
    ElMessage.success("添加成功");
  } else {
    ElMessage.success("修改成功");
  }
  handleShowTopic();
}
function handleTopicDelete(row) {
  const _ids = row.id;
  ElMessageBox.confirm('是否确认删除自定义Topic信息编号为"' + _ids + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delProductTopic(_ids);
  }).then(() => {
    handleShowTopic();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

return (_ctx, _cache) => {
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_tab_pane = resolveComponent("el-tab-pane");
  const _component_el_button = resolveComponent("el-button");
  const _component_el_tabs = resolveComponent("el-tabs");
  const _directive_permission = resolveDirective("permission");

  return (openBlock(), createElementBlock("div", null, [
    createVNode(_component_el_tabs, {
      modelValue: activeTopicName.value,
      "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((activeTopicName).value = $event)),
      type: "card",
      class: "demo-tabs",
      onTabClick: handleTopicClick
    }, {
      default: withCtx(() => [
        createVNode(_component_el_tab_pane, {
          label: "基础通信 Topic",
          name: "first"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_table, {
              data: productTopicList1.value,
              border: "",
              style: {"margin-left":"-30px","margin-top":"-20px"}
            }, {
              default: withCtx(() => [
                createVNode(_component_el_table_column, {
                  label: "功能",
                  prop: "groupName",
                  width: "100"
                }),
                createVNode(_component_el_table_column, {
                  label: "Topic类",
                  prop: "topic",
                  width: ""
                }),
                createVNode(_component_el_table_column, {
                  prop: "optionType",
                  label: "操作权限",
                  width: "100"
                }, {
                  default: withCtx((scope) => [
                    createTextVNode(toDisplayString(scope.row.optionType == 1 ? '发布' : '订阅'), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_table_column, {
                  label: "描述",
                  prop: "remark",
                  width: "250"
                })
              ]),
              _: 1
            }, 8, ["data"])
          ]),
          _: 1
        }),
        createVNode(_component_el_tab_pane, {
          label: "物模型通信 Topic",
          name: "second"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_table, {
              data: productTopicList2.value,
              border: "",
              style: {"margin-left":"-30px","margin-top":"-20px"}
            }, {
              default: withCtx(() => [
                createVNode(_component_el_table_column, {
                  label: "功能",
                  prop: "groupName",
                  width: "100"
                }),
                createVNode(_component_el_table_column, {
                  label: "Topic类",
                  prop: "topic",
                  width: ""
                }),
                createVNode(_component_el_table_column, {
                  prop: "optionType",
                  label: "操作权限",
                  width: "100"
                }, {
                  default: withCtx((scope) => [
                    createTextVNode(toDisplayString(scope.row.optionType == 1 ? '发布' : '订阅'), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_table_column, {
                  label: "描述",
                  prop: "remark",
                  width: "250"
                })
              ]),
              _: 1
            }, 8, ["data"])
          ]),
          _: 1
        }),
        createVNode(_component_el_tab_pane, {
          label: "自定义 Topic",
          name: "third"
        }, {
          default: withCtx(() => [
            createVNode(_sfc_main$3, {
              productId: __props.productId,
              onCloseTopic: closeTopic
            }, null, 8, ["productId"]),
            createVNode(_component_el_table, {
              data: productTopicList3.value,
              border: "",
              style: {"margin-left":"-30px","margin-top":"20px"}
            }, {
              default: withCtx(() => [
                createVNode(_component_el_table_column, {
                  label: "功能",
                  prop: "groupName",
                  width: "100"
                }),
                createVNode(_component_el_table_column, {
                  label: "Topic类",
                  prop: "topic",
                  width: ""
                }),
                createVNode(_component_el_table_column, {
                  prop: "optionType",
                  label: "操作权限",
                  width: "100"
                }, {
                  default: withCtx((scope) => [
                    createTextVNode(toDisplayString(scope.row.optionType == 1 ? '发布' : '订阅'), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_table_column, {
                  label: "描述",
                  prop: "remark",
                  width: "250"
                }),
                createVNode(_component_el_table_column, {
                  label: "操作",
                  align: "center",
                  "class-name": "small-padding fixed-width",
                  width: "160"
                }, {
                  default: withCtx((scope) => [
                    withDirectives((openBlock(), createBlock(_component_el_button, {
                      link: "",
                      type: "primary",
                      onClick: $event => (handleTopicDelete(scope.row))
                    }, {
                      default: withCtx(() => [
                        _hoisted_1$2
                      ]),
                      _: 2
                    }, 1032, ["onClick"])), [
                      [_directive_permission, 'productInfo.edit']
                    ])
                  ]),
                  _: 1
                })
              ]),
              _: 1
            }, 8, ["data"])
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

const _hoisted_1$1 = /*#__PURE__*/createTextVNode("添加自定义功能");
const _hoisted_2$1 = { key: 0 };
const _hoisted_3 = { key: 1 };
const _hoisted_4 = { key: 0 };
const _hoisted_5 = { key: 1 };
const _hoisted_6 = /*#__PURE__*/createTextVNode(" 枚举值：");
const _hoisted_7 = /*#__PURE__*/createTextVNode("编辑");
const _hoisted_8 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_9 = /*#__PURE__*/createTextVNode("属性");
const _hoisted_10 = /*#__PURE__*/createTextVNode("服务");
const _hoisted_11 = /*#__PURE__*/createTextVNode("事件");
const _hoisted_12 = { key: 0 };
const _hoisted_13 = { style: {"display":"flex"} };
const _hoisted_14 = /*#__PURE__*/createTextVNode("  ~  ");
const _hoisted_15 = /*#__PURE__*/createTextVNode(" ~  ");
const _hoisted_16 = /*#__PURE__*/createTextVNode(" 删除");
const _hoisted_17 = { style: {"margin-bottom":"5px"} };
const _hoisted_18 = /*#__PURE__*/createTextVNode("添加枚举项");
const _hoisted_19 = /*#__PURE__*/createTextVNode("读写");
const _hoisted_20 = /*#__PURE__*/createTextVNode("只读");
const _hoisted_21 = { key: 1 };
const _hoisted_22 = /*#__PURE__*/createTextVNode("异步");
const _hoisted_23 = /*#__PURE__*/createTextVNode("同步");
const _hoisted_24 = { style: {"width":"300px","border":"1px solid lavender","padding":"0px 5px","background-color":"#f4f4f5"} };
const _hoisted_25 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_26 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_27 = /*#__PURE__*/createTextVNode("+新增参数");
const _hoisted_28 = { key: 2 };
const _hoisted_29 = /*#__PURE__*/createTextVNode("信息");
const _hoisted_30 = /*#__PURE__*/createTextVNode("警告");
const _hoisted_31 = /*#__PURE__*/createTextVNode("故障");
const _hoisted_32 = { key: 3 };
const _hoisted_33 = { style: {"width":"300px","border":"1px solid lavender","padding":"0px 5px","background-color":"#f4f4f5"} };
const _hoisted_34 = /*#__PURE__*/createTextVNode("修改");
const _hoisted_35 = /*#__PURE__*/createTextVNode("删除");
const _hoisted_36 = /*#__PURE__*/createTextVNode("+新增参数");
const _hoisted_37 = { class: "dialog-footer" };
const _hoisted_38 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_39 = /*#__PURE__*/createTextVNode("取 消");
const _hoisted_40 = { style: {"display":"flex"} };
const _hoisted_41 = /*#__PURE__*/createTextVNode("  ~  ");
const _hoisted_42 = /*#__PURE__*/createTextVNode(" ~  ");
const _hoisted_43 = /*#__PURE__*/createTextVNode(" 删除");
const _hoisted_44 = { style: {"margin-bottom":"5px"} };
const _hoisted_45 = /*#__PURE__*/createTextVNode("添加枚举项");
const _hoisted_46 = { class: "dialog-footer" };
const _hoisted_47 = /*#__PURE__*/createTextVNode("确 定");
const _hoisted_48 = /*#__PURE__*/createTextVNode("取 消");


// eslint-disable-next-line no-undef

const _sfc_main$1 = {
  props: {
  // 数据
  productId: null
},
  setup(__props) {

const props = __props;



const productModelList = ref([]);
function handleShowModel() {
  productModelList.value = [];
  listProductModel(props.productId).then(response => {
    response.data.productModelAttrList.forEach(item => {
      let dataType = item.dataTypeId == '1' ? 'int32 (整数型)' : item.dataTypeId == '2' ? 'double (双精度浮点型)' : item.dataTypeId == '3' ? 'text (字符串)' : 'enum (枚举型)';
      productModelList.value.push({
        id: item.id,
        productId: item.productId,
        modelType: 1,
        modelTypeName: '属性',
        name: item.name,
        identifier: item.identifier,
        dataTypeId: item.dataTypeId,
        typeParams: JSON.parse(item.typeParams),
        dataUnit: item.dataUnit,
        dataType: dataType,
        dataParams: '',
        optionStatus: parseInt(item.optionStatus),
        remark: item.remark
      });
    });
    response.data.productModelServiceList.forEach(item => {
      let dataParams = item.callType == '1' ? '异步' : '同步';
      productModelList.value.push({
        id: item.id,
        modelType: 2,
        modelTypeName: '服务',
        name: item.name,
        identifier: item.identifier,
        dataType: '',
        dataParams: '调用方式：' + dataParams,
        callType: parseInt(item.callType),
        inputParams: item.inputParams,
        outputParams: item.outputParams
      });
    });
    response.data.productModelEventList.forEach(item => {
      let dataParams = item.eventType == '1' ? '信息' : item.eventType == '2' ? '告警' : '故障';
      productModelList.value.push({
        id: item.id,
        modelType: 3,
        modelTypeName: '事件',
        name: item.name,
        identifier: item.identifier,
        dataType: '',
        dataParams: '事件类型：' + dataParams,
        eventType: parseInt(item.eventType),
        outputParams: item.outputParams
      });
    });
  });
}
handleShowModel();

const title = ref("");
const open = ref(false);
const data = reactive({
  form: {},
  rules: {
    modelType: [
      { required: true, message: "功能类型必须选择", trigger: "blur" }
    ],
    name: [
      { required: true, message: "设备名称不能为空", trigger: "blur" }
    ],
    identifier: [
      { required: true, message: "标识符不能为空", trigger: "blur" },
      { pattern: /^[a-zA-Z0-9]+$/, message: '标识符只能包含字母和数字', trigger: 'blur' },
    ],
    dataTypeId: [
      { required: true, message: "数据类型必须选择", trigger: "blur" }
    ],
    typeParams: {
      min: [
        { required: true, message: "最小值不能为空", trigger: "blur" },
        { validator: validateNumberRange, trigger: 'blur' }
      ],
      max: [
        { required: true, message: "最大值不能为空", trigger: "blur" },
        { validator: validateNumberRange, trigger: 'blur' }
      ],
      step: [
        { required: true, message: "步长不能为空", trigger: "blur" },
        { pattern:/^\d+(\.\d+)?$/, message: '请输入整数或小数', trigger: 'blur' },
      ],
      enumList: [
        { required: true, message: "枚举项不能为空", trigger: "blur" }
      ]
    }
  },
  dataTypeList: [
    {id:1, name:"int32 (整数型)"},
    {id:2, name:"double (双精度浮点型)"},
    {id:3, name:"text (字符串)"},
    {id:4, name:"enum (枚举型)"},
  ]
});

function validateNumberRange(rule, value, callback) {
  // debugger
  if(form.value.dataTypeId == 1) {
    if (!value) {
      callback(new Error('请输入数字'));
    } else if (isNaN(value)) {
      callback(new Error('请输入有效数字'));
    } else if (value % 1 !== 0) {
      callback(new Error('请输入整数'));
    }
  }
  if(form.value.dataTypeId == 2) {
    if (!value) {
      callback(new Error('请输入数字'));
    } else if (isNaN(value)) {
      callback(new Error('请输入有效数字'));
    } else if (!value.includes('.')) {
      callback(new Error('请输入小数'));
    }
  }
  if(form.value.typeParams.min != null && form.value.typeParams.max != null) {
    if(form.value.typeParams.min >= form.value.typeParams.max) {
      callback(new Error('最小值不能大于等于最大值'));
    }
  }
  callback();
}

const { form, rules, dataTypeList } = toRefs(data);
// 表单重置
function reset() {
  form.value = {
    id: null,
    modelType: 1,
    productId: props.productId,
    name: null,
    identifier: null,
    dataTypeId: 1,
    typeParams: {
      step: null,
      min: null,
      max: null,
      enumList: [{
        id: 1,
        name: '',
        value: ''
      }]
    },
    dataUnit: ' ',
    optionStatus: 1,

    remark: null,

    callType:1,
    inputParams: [],
    outputParams: [],

    eventType: 1
  };
  inputParamList.value = [];
  outputParamList.value = [];
  //proxy.resetForm("productModelRef");
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  console.log(form.value);
  open.value = true;
  title.value = "添加自定义功能";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();

  form.value = row;
  if(row.inputParams) {
    inputParamList.value = JSON.parse(row.inputParams);
  }
  if(row.outputParams) {
    outputParamList.value = JSON.parse(row.outputParams);
  }
  // if(row.typeParams) {
  //   form.value.typeParams = JSON.parse(row.typeParams)
  // }

  open.value = true;
  title.value = "修改自定义功能";
  console.log(form.value);
}

function addEnum() {
  form.value.typeParams.enumList.push({
    id: Math.floor(Math.random() * 1000),
    name: '',
    value: ''
  });
}
function delEnum(id) {
  let arr = [];
  form.value.typeParams.enumList.forEach(item => {
    if(item.id != id) {
      arr.push(item);
    }
  });
  form.value.typeParams.enumList = arr;
}
/** 提交按钮 */
function submitForm() {
  // proxy.$refs["productModelRef"].validate(valid => {
  //   if (valid) {
      form.value.inputParams = JSON.stringify(inputParamList.value);
      form.value.outputParams = JSON.stringify(outputParamList.value);
      form.value.typeParams = JSON.stringify(form.value.typeParams);
      if (form.value.id != null) {
        updateProductModel(form.value).then(response => {
          ElMessage.success("修改成功");
          open.value = false;
          handleShowModel();
        });
      } else {
        addProductModel(form.value).then(response => {
          ElMessage.success("新增成功");
          open.value = false;
          handleShowModel();
        });
      }
  //   }
  // });
}
/** 删除按钮操作 */
function handleDelete(row) {
  ElMessageBox.confirm('是否确认删除设备信息编号为"' + row.id + '"的数据项？', "系统提示", {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: "warning",
  }).then(function() {
    return delProductModel(row.modelType, row.id);
  }).then(() => {
    handleShowModel();
    ElMessage.success("删除成功");
  }).catch(() => {});
}

// 取消按钮
function cancel() {
  open.value = false;
  //reset();
}

//------------
const atrrTitle = ref("");
const attrOpen = ref(false);
const inputParamList = ref([]);
const outputParamList = ref([]);
const attrData = reactive({
  atrrForm: {},
  atrrRules: {
    name: [
      { required: true, message: "设备名称不能为空", trigger: "blur" }
    ],
    identifier: [
      { required: true, message: "标识符不能为空", trigger: "blur" }
    ],
    dataTypeId: [
      { required: true, message: "数据类型必须选择", trigger: "blur" }
    ],
    typeParams: {
      min: [
        { required: true, message: "最小值不能为空", trigger: "blur" },
        { validator: validateNumberRangeAtrr, trigger: 'blur' }
      ],
      max: [
        { required: true, message: "最大值不能为空", trigger: "blur" },
        { validator: validateNumberRangeAtrr, trigger: 'blur' }
      ],
      step: [
        { required: true, message: "步长不能为空", trigger: "blur" },
        { pattern:/^\d+(\.\d+)?$/, message: '请输入整数或小数', trigger: 'blur' },
      ],
      enumList: [
        { required: true, message: "枚举项不能为空", trigger: "blur" }
      ]
    }
  }
});
function validateNumberRangeAtrr(rule, value, callback) {
  if(atrrForm.value.dataTypeId == 1) {
    if (!value) {
      callback(new Error('请输入数字'));
    } else if (isNaN(value)) {
      callback(new Error('请输入有效数字'));
    } else if (value % 1 !== 0) {
      callback(new Error('请输入整数'));
    }
  }
  if(atrrForm.value.dataTypeId == 2) {
    if (!value) {
      callback(new Error('请输入数字'));
    } else if (isNaN(value)) {
      callback(new Error('请输入有效数字'));
    } else if (!value.includes('.')) {
      callback(new Error('请输入小数'));
    }
  }
  if(atrrForm.value.typeParams.min != null && atrrForm.value.typeParams.max != null) {
    if(atrrForm.value.typeParams.min >= atrrForm.value.typeParams.max) {
      callback(new Error('最小值不能大于等于最大值'));
    }
  }
  callback();
}

const { atrrForm, atrrRules } = toRefs(attrData);
// 表单重置
function resetAtrr() {
  atrrForm.value = {
    id: null,
    name: null,
    identifier: null,
    dataTypeId: 1,
    typeParams: {
      step: null,
      min: null,
      max: null,
      enumList: [{
        id: 1,
        name: '',
        value: ''
      }]
    },
  };
  atrrType.value = 1;
  //proxy.resetForm("productAtrrRef");
}

/** 新增按钮操作 */
const atrrType = ref(1);
function handleAddAtrr(type) {
  resetAtrr();
  attrOpen.value = true;
  atrrTitle.value = "添加参数";
  atrrType.value = type;
}

/** 修改按钮操作 */
function handleUpdateAtrr(row, type) {
  resetAtrr();
  atrrType.value = type;
  atrrForm.value = row;
  console.log(atrrForm.value);
  attrOpen.value = true;
  atrrTitle.value = "修改参数";
}
function handleDeleteAtrr(row, type) {
  resetAtrr();
  atrrType.value = type;
  if(atrrType.value == 1) {
    let arr = [];
    inputParamList.value.forEach(item => {
      if(item.id != row.id) {
        arr.push(item);
      }
    });
    inputParamList.value = arr;
  } else {
    let arr = [];
    outputParamList.value.forEach(item => {
      if(item.id != row.id) {
        arr.push(item);
      }
    });
    outputParamList.value = arr;
  }
}

function addAtrrEnum() {
  atrrForm.value.typeParams.enumList.push({
    id: Math.floor(Math.random() * 1000),
    name: '',
    value: ''
  });
}
function delAtrrEnum(id) {
  let arr = [];
  atrrForm.value.typeParams.enumList.forEach(item => {
    if(item.id != id) {
      arr.push(item);
    }
  });
  atrrForm.value.typeParams.enumList = arr;
}

/** 提交按钮 */
function submitAtrrForm() {
  // proxy.$refs["productAtrrRef"].validate(valid => {
  //   if (valid) {
      if (atrrForm.value.id != null) {
        if(atrrType.value == 1) {
          console.log(atrrForm.value);
          inputParamList.value.forEach(item => {
            if(item.id == atrrForm.value.id) {
              item = {
                id: atrrForm.value.id,
                name: atrrForm.value.name,
                identifier: atrrForm.value.identifier,
                dataTypeId: atrrForm.value.dataTypeId,
                typeParams: atrrForm.value.typeParams
              };
            }
          });
        } else {
          outputParamList.value.forEach(item => {
            if(item.id == atrrForm.value.id) {
              item = {
                id: atrrForm.value.id,
                name: atrrForm.value.name,
                identifier: atrrForm.value.identifier,
                dataTypeId: atrrForm.value.dataTypeId,
                typeParams: atrrForm.value.typeParams
              };
            }
          });
        }
        attrOpen.value = false;
      } else {
        console.log(atrrForm.value);
        if(atrrType.value == 1) {
          inputParamList.value.push({
            id: Math.floor(Math.random() * 1000),
            name: atrrForm.value.name,
            identifier: atrrForm.value.identifier,
            dataTypeId: atrrForm.value.dataTypeId,
            typeParams: atrrForm.value.typeParams
          });
        } else {
          outputParamList.value.push({
            id: Math.floor(Math.random() * 1000),
            name: atrrForm.value.name,
            identifier: atrrForm.value.identifier,
            dataTypeId: atrrForm.value.dataTypeId,
            typeParams: atrrForm.value.typeParams
          });
        }
        attrOpen.value = false;
      }
  //   }
  // });
}

// 取消按钮
function cancelAtrr() {
  attrOpen.value = false;
  //resetAtrr();
}

return (_ctx, _cache) => {
  const _component_el_button = resolveComponent("el-button");
  const _component_el_table_column = resolveComponent("el-table-column");
  const _component_el_table = resolveComponent("el-table");
  const _component_el_radio = resolveComponent("el-radio");
  const _component_el_radio_group = resolveComponent("el-radio-group");
  const _component_el_form_item = resolveComponent("el-form-item");
  const _component_el_input = resolveComponent("el-input");
  const _component_el_option = resolveComponent("el-option");
  const _component_el_select = resolveComponent("el-select");
  const _component_el_row = resolveComponent("el-row");
  const _component_el_form = resolveComponent("el-form");
  const _component_el_dialog = resolveComponent("el-dialog");
  const _directive_permission = resolveDirective("permission");

  return (openBlock(), createElementBlock("div", null, [
    withDirectives((openBlock(), createBlock(_component_el_button, {
      type: "primary",
      onClick: handleAdd,
      plain: "",
      style: {"margin-left":"-30px","margin-top":"-50px","font-size":"12px"}
    }, {
      default: withCtx(() => [
        _hoisted_1$1
      ]),
      _: 1
    })), [
      [_directive_permission, 'productInfo.edit']
    ]),
    createVNode(_component_el_table, {
      data: productModelList.value,
      border: "",
      style: {"margin-left":"-30px","margin-top":"0px"}
    }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          label: "功能类型",
          prop: "modelTypeName",
          width: "90"
        }),
        createVNode(_component_el_table_column, {
          label: "功能名称（全部）",
          prop: "name",
          width: "180"
        }),
        createVNode(_component_el_table_column, {
          label: "标识符",
          prop: "identifier",
          width: "180"
        }),
        createVNode(_component_el_table_column, {
          label: "数据类型",
          prop: "dataType",
          width: ""
        }),
        createVNode(_component_el_table_column, {
          label: "数据定义",
          prop: "dataParams",
          width: ""
        }, {
          default: withCtx((scope) => [
            (scope.row.modelType == 2 || scope.row.modelType == 3)
              ? (openBlock(), createElementBlock("div", _hoisted_2$1, toDisplayString(scope.row.dataParams), 1))
              : createCommentVNode("", true),
            (scope.row.modelType == 1)
              ? (openBlock(), createElementBlock("div", _hoisted_3, [
                  (scope.row.dataTypeId == 1 || scope.row.dataTypeId == 2)
                    ? (openBlock(), createElementBlock("div", _hoisted_4, " 取值范围：" + toDisplayString(scope.row.typeParams.min) + " ~ 取值范围：" + toDisplayString(scope.row.typeParams.max), 1))
                    : createCommentVNode("", true),
                  (scope.row.dataTypeId == 4)
                    ? (openBlock(), createElementBlock("div", _hoisted_5, [
                        _hoisted_6,
                        (openBlock(true), createElementBlock(Fragment, null, renderList(scope.row.typeParams.enumList, (item, index) => {
                          return (openBlock(), createElementBlock("div", { key: index }, toDisplayString(item.value) + "：" + toDisplayString(item.name), 1))
                        }), 128))
                      ]))
                    : createCommentVNode("", true)
                ]))
              : createCommentVNode("", true)
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
              onClick: $event => (handleUpdate(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_7
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'productInfo.edit']
            ]),
            withDirectives((openBlock(), createBlock(_component_el_button, {
              link: "",
              type: "primary",
              onClick: $event => (handleDelete(scope.row))
            }, {
              default: withCtx(() => [
                _hoisted_8
              ]),
              _: 2
            }, 1032, ["onClick"])), [
              [_directive_permission, 'productInfo.edit']
            ])
          ]),
          _: 1
        })
      ]),
      _: 1
    }, 8, ["data"]),
    createVNode(_component_el_dialog, {
      title: title.value,
      modelValue: open.value,
      "onUpdate:modelValue": _cache[14] || (_cache[14] = $event => ((open).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_37, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitForm
          }, {
            default: withCtx(() => [
              _hoisted_38
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancel }, {
            default: withCtx(() => [
              _hoisted_39
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref: "productModelRef",
          model: unref(form),
          rules: unref(rules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "功能类型",
              prop: "modelType"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_radio_group, {
                  modelValue: unref(form).modelType,
                  "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(form).modelType) = $event)),
                  disabled: unref(form).id != null
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_radio, { label: 1 }, {
                      default: withCtx(() => [
                        _hoisted_9
                      ]),
                      _: 1
                    }),
                    createVNode(_component_el_radio, { label: 2 }, {
                      default: withCtx(() => [
                        _hoisted_10
                      ]),
                      _: 1
                    }),
                    createVNode(_component_el_radio, { label: 3 }, {
                      default: withCtx(() => [
                        _hoisted_11
                      ]),
                      _: 1
                    })
                  ]),
                  _: 1
                }, 8, ["modelValue", "disabled"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "功能名称",
              prop: "name"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).name,
                  "onUpdate:modelValue": _cache[1] || (_cache[1] = $event => ((unref(form).name) = $event)),
                  placeholder: "请输入功能名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "标识符",
              prop: "identifier"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).identifier,
                  "onUpdate:modelValue": _cache[2] || (_cache[2] = $event => ((unref(form).identifier) = $event)),
                  placeholder: "请输入标识符"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            (unref(form).modelType == 1)
              ? (openBlock(), createElementBlock("div", _hoisted_12, [
                  createVNode(_component_el_form_item, {
                    label: "数据类型",
                    prop: "dataTypeId"
                  }, {
                    default: withCtx(() => [
                      createVNode(_component_el_select, {
                        modelValue: unref(form).dataTypeId,
                        "onUpdate:modelValue": _cache[3] || (_cache[3] = $event => ((unref(form).dataTypeId) = $event)),
                        class: "m-2",
                        placeholder: "数据类型",
                        onChange: _ctx.selectdataType
                      }, {
                        default: withCtx(() => [
                          (openBlock(true), createElementBlock(Fragment, null, renderList(unref(dataTypeList), (item) => {
                            return (openBlock(), createBlock(_component_el_option, {
                              key: item.id,
                              label: item.name,
                              value: item.id
                            }, null, 8, ["label", "value"]))
                          }), 128))
                        ]),
                        _: 1
                      }, 8, ["modelValue", "onChange"])
                    ]),
                    _: 1
                  }),
                  (unref(form).dataTypeId == 1 || unref(form).dataTypeId == 2)
                    ? (openBlock(), createBlock(_component_el_form_item, {
                        key: 0,
                        label: "取值范围"
                      }, {
                        default: withCtx(() => [
                          createBaseVNode("div", _hoisted_13, [
                            createVNode(_component_el_form_item, { prop: "typeParams.min" }, {
                              default: withCtx(() => [
                                createVNode(_component_el_input, {
                                  modelValue: unref(form).typeParams.min,
                                  "onUpdate:modelValue": _cache[4] || (_cache[4] = $event => ((unref(form).typeParams.min) = $event)),
                                  placeholder: "最小值",
                                  style: {"width":"98%"}
                                }, null, 8, ["modelValue"])
                              ]),
                              _: 1
                            }),
                            _hoisted_14,
                            createVNode(_component_el_form_item, { prop: "typeParams.max" }, {
                              default: withCtx(() => [
                                createVNode(_component_el_input, {
                                  modelValue: unref(form).typeParams.max,
                                  "onUpdate:modelValue": _cache[5] || (_cache[5] = $event => ((unref(form).typeParams.max) = $event)),
                                  placeholder: "最大值",
                                  style: {"width":"95%"}
                                }, null, 8, ["modelValue"])
                              ]),
                              _: 1
                            })
                          ])
                        ]),
                        _: 1
                      }))
                    : createCommentVNode("", true),
                  (unref(form).dataTypeId == 1 || unref(form).dataTypeId == 2)
                    ? (openBlock(), createBlock(_component_el_form_item, {
                        key: 1,
                        label: "步长",
                        prop: "typeParams.step"
                      }, {
                        default: withCtx(() => [
                          createVNode(_component_el_input, {
                            modelValue: unref(form).typeParams.step,
                            "onUpdate:modelValue": _cache[6] || (_cache[6] = $event => ((unref(form).typeParams.step) = $event)),
                            placeholder: "步长"
                          }, null, 8, ["modelValue"])
                        ]),
                        _: 1
                      }))
                    : createCommentVNode("", true),
                  (unref(form).dataTypeId == 4)
                    ? (openBlock(), createBlock(_component_el_form_item, {
                        key: 2,
                        label: "枚举项",
                        prop: "typeParams.enumList"
                      }, {
                        default: withCtx(() => [
                          (openBlock(true), createElementBlock(Fragment, null, renderList(unref(form).typeParams.enumList, (item, index) => {
                            return (openBlock(), createElementBlock("div", {
                              key: index,
                              style: {"margin-bottom":"5px"}
                            }, [
                              createVNode(_component_el_input, {
                                modelValue: item.value,
                                "onUpdate:modelValue": $event => ((item.value) = $event),
                                placeholder: "参数值",
                                style: {"width":"40%"}
                              }, null, 8, ["modelValue", "onUpdate:modelValue"]),
                              _hoisted_15,
                              createVNode(_component_el_input, {
                                modelValue: item.name,
                                "onUpdate:modelValue": $event => ((item.name) = $event),
                                placeholder: "参数描述",
                                style: {"width":"40%"}
                              }, null, 8, ["modelValue", "onUpdate:modelValue"]),
                              createVNode(_component_el_button, {
                                type: "danger",
                                link: "",
                                onClick: $event => (delEnum(item.id))
                              }, {
                                default: withCtx(() => [
                                  _hoisted_16
                                ]),
                                _: 2
                              }, 1032, ["onClick"])
                            ]))
                          }), 128)),
                          createBaseVNode("div", _hoisted_17, [
                            createVNode(_component_el_button, {
                              type: "primary",
                              link: "",
                              onClick: addEnum
                            }, {
                              default: withCtx(() => [
                                _hoisted_18
                              ]),
                              _: 1
                            })
                          ])
                        ]),
                        _: 1
                      }))
                    : createCommentVNode("", true),
                  createVNode(_component_el_form_item, {
                    label: "单位",
                    prop: "dataUnit"
                  }, {
                    default: withCtx(() => [
                      createVNode(_component_el_input, {
                        modelValue: unref(form).dataUnit,
                        "onUpdate:modelValue": _cache[7] || (_cache[7] = $event => ((unref(form).dataUnit) = $event)),
                        placeholder: "请输入单位"
                      }, null, 8, ["modelValue"])
                    ]),
                    _: 1
                  }),
                  createVNode(_component_el_form_item, {
                    label: "读写类型",
                    prop: "optionStatus"
                  }, {
                    default: withCtx(() => [
                      createVNode(_component_el_radio_group, {
                        modelValue: unref(form).optionStatus,
                        "onUpdate:modelValue": _cache[8] || (_cache[8] = $event => ((unref(form).optionStatus) = $event))
                      }, {
                        default: withCtx(() => [
                          createVNode(_component_el_radio, { label: 1 }, {
                            default: withCtx(() => [
                              _hoisted_19
                            ]),
                            _: 1
                          }),
                          createVNode(_component_el_radio, { label: 2 }, {
                            default: withCtx(() => [
                              _hoisted_20
                            ]),
                            _: 1
                          })
                        ]),
                        _: 1
                      }, 8, ["modelValue"])
                    ]),
                    _: 1
                  })
                ]))
              : createCommentVNode("", true),
            (unref(form).modelType == 2)
              ? (openBlock(), createElementBlock("div", _hoisted_21, [
                  createVNode(_component_el_form_item, {
                    label: "调用方式",
                    prop: "callType"
                  }, {
                    default: withCtx(() => [
                      createVNode(_component_el_radio_group, {
                        modelValue: unref(form).callType,
                        "onUpdate:modelValue": _cache[9] || (_cache[9] = $event => ((unref(form).callType) = $event))
                      }, {
                        default: withCtx(() => [
                          createVNode(_component_el_radio, { label: 1 }, {
                            default: withCtx(() => [
                              _hoisted_22
                            ]),
                            _: 1
                          }),
                          createVNode(_component_el_radio, { label: 2 }, {
                            default: withCtx(() => [
                              _hoisted_23
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
                    label: "输入参数",
                    prop: "optionStatus1"
                  }, {
                    default: withCtx(() => [
                      (openBlock(true), createElementBlock(Fragment, null, renderList(inputParamList.value, (item) => {
                        return (openBlock(), createBlock(_component_el_row, {
                          key: item.id,
                          style: {"width":"100%"}
                        }, {
                          default: withCtx(() => [
                            createVNode(_component_el_row, { span: 18 }, {
                              default: withCtx(() => [
                                createBaseVNode("span", _hoisted_24, "参数名称：" + toDisplayString(item.name) + "【" + toDisplayString(item.identifier) + "】", 1)
                              ]),
                              _: 2
                            }, 1024),
                            createVNode(_component_el_row, { span: 6 }, {
                              default: withCtx(() => [
                                createVNode(_component_el_button, {
                                  link: "",
                                  type: "primary",
                                  onClick: $event => (handleUpdateAtrr(item,1))
                                }, {
                                  default: withCtx(() => [
                                    _hoisted_25
                                  ]),
                                  _: 2
                                }, 1032, ["onClick"]),
                                createVNode(_component_el_button, {
                                  link: "",
                                  type: "primary",
                                  onClick: $event => (handleDeleteAtrr(item,1))
                                }, {
                                  default: withCtx(() => [
                                    _hoisted_26
                                  ]),
                                  _: 2
                                }, 1032, ["onClick"])
                              ]),
                              _: 2
                            }, 1024)
                          ]),
                          _: 2
                        }, 1024))
                      }), 128)),
                      createVNode(_component_el_row, { style: {"width":"100%","margin-top":"5px"} }, {
                        default: withCtx(() => [
                          createVNode(_component_el_row, { span: 24 }, {
                            default: withCtx(() => [
                              createVNode(_component_el_button, {
                                link: "",
                                type: "primary",
                                onClick: _cache[10] || (_cache[10] = $event => (handleAddAtrr(1)))
                              }, {
                                default: withCtx(() => [
                                  _hoisted_27
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
                  })
                ]))
              : createCommentVNode("", true),
            (unref(form).modelType == 3)
              ? (openBlock(), createElementBlock("div", _hoisted_28, [
                  createVNode(_component_el_form_item, {
                    label: "事件类型",
                    prop: "eventType"
                  }, {
                    default: withCtx(() => [
                      createVNode(_component_el_radio_group, {
                        modelValue: unref(form).callType,
                        "onUpdate:modelValue": _cache[11] || (_cache[11] = $event => ((unref(form).callType) = $event))
                      }, {
                        default: withCtx(() => [
                          createVNode(_component_el_radio, { label: 1 }, {
                            default: withCtx(() => [
                              _hoisted_29
                            ]),
                            _: 1
                          }),
                          createVNode(_component_el_radio, { label: 2 }, {
                            default: withCtx(() => [
                              _hoisted_30
                            ]),
                            _: 1
                          }),
                          createVNode(_component_el_radio, { label: 3 }, {
                            default: withCtx(() => [
                              _hoisted_31
                            ]),
                            _: 1
                          })
                        ]),
                        _: 1
                      }, 8, ["modelValue"])
                    ]),
                    _: 1
                  })
                ]))
              : createCommentVNode("", true),
            (unref(form).modelType == 2 || unref(form).modelType == 3)
              ? (openBlock(), createElementBlock("div", _hoisted_32, [
                  createVNode(_component_el_form_item, {
                    label: "输出参数",
                    prop: "optionStatus2"
                  }, {
                    default: withCtx(() => [
                      (openBlock(true), createElementBlock(Fragment, null, renderList(outputParamList.value, (item) => {
                        return (openBlock(), createBlock(_component_el_row, {
                          key: item.id,
                          style: {"width":"100%"}
                        }, {
                          default: withCtx(() => [
                            createVNode(_component_el_row, { span: 18 }, {
                              default: withCtx(() => [
                                createBaseVNode("span", _hoisted_33, "参数名称：" + toDisplayString(item.name) + "【" + toDisplayString(item.identifier) + "】", 1)
                              ]),
                              _: 2
                            }, 1024),
                            createVNode(_component_el_row, { span: 6 }, {
                              default: withCtx(() => [
                                createVNode(_component_el_button, {
                                  link: "",
                                  type: "primary",
                                  onClick: $event => (handleUpdateAtrr(item,2))
                                }, {
                                  default: withCtx(() => [
                                    _hoisted_34
                                  ]),
                                  _: 2
                                }, 1032, ["onClick"]),
                                createVNode(_component_el_button, {
                                  link: "",
                                  type: "primary",
                                  onClick: $event => (handleDeleteAtrr(item,2))
                                }, {
                                  default: withCtx(() => [
                                    _hoisted_35
                                  ]),
                                  _: 2
                                }, 1032, ["onClick"])
                              ]),
                              _: 2
                            }, 1024)
                          ]),
                          _: 2
                        }, 1024))
                      }), 128)),
                      createVNode(_component_el_row, { style: {"width":"100%","margin-top":"5px"} }, {
                        default: withCtx(() => [
                          createVNode(_component_el_row, { span: 24 }, {
                            default: withCtx(() => [
                              createVNode(_component_el_button, {
                                link: "",
                                type: "primary",
                                onClick: _cache[12] || (_cache[12] = $event => (handleAddAtrr(2)))
                              }, {
                                default: withCtx(() => [
                                  _hoisted_36
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
                  })
                ]))
              : createCommentVNode("", true),
            createVNode(_component_el_form_item, {
              label: "描述",
              prop: "remark"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(form).remark,
                  "onUpdate:modelValue": _cache[13] || (_cache[13] = $event => ((unref(form).remark) = $event)),
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
    }, 8, ["title", "modelValue"]),
    createVNode(_component_el_dialog, {
      title: atrrTitle.value,
      modelValue: attrOpen.value,
      "onUpdate:modelValue": _cache[21] || (_cache[21] = $event => ((attrOpen).value = $event)),
      width: "500px",
      "append-to-body": ""
    }, {
      footer: withCtx(() => [
        createBaseVNode("div", _hoisted_46, [
          createVNode(_component_el_button, {
            type: "primary",
            onClick: submitAtrrForm
          }, {
            default: withCtx(() => [
              _hoisted_47
            ]),
            _: 1
          }),
          createVNode(_component_el_button, { onClick: cancelAtrr }, {
            default: withCtx(() => [
              _hoisted_48
            ]),
            _: 1
          })
        ])
      ]),
      default: withCtx(() => [
        createVNode(_component_el_form, {
          ref: "productAtrrRef",
          model: unref(atrrForm),
          rules: unref(atrrRules),
          "label-width": "80px"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_form_item, {
              label: "名称",
              prop: "name"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(atrrForm).name,
                  "onUpdate:modelValue": _cache[15] || (_cache[15] = $event => ((unref(atrrForm).name) = $event)),
                  placeholder: "请输入参数名称"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "标识符",
              prop: "identifier"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_input, {
                  modelValue: unref(atrrForm).identifier,
                  "onUpdate:modelValue": _cache[16] || (_cache[16] = $event => ((unref(atrrForm).identifier) = $event)),
                  placeholder: "请输入标识符"
                }, null, 8, ["modelValue"])
              ]),
              _: 1
            }),
            createVNode(_component_el_form_item, {
              label: "数据类型",
              prop: "dataTypeId"
            }, {
              default: withCtx(() => [
                createVNode(_component_el_select, {
                  modelValue: unref(atrrForm).dataTypeId,
                  "onUpdate:modelValue": _cache[17] || (_cache[17] = $event => ((unref(atrrForm).dataTypeId) = $event)),
                  class: "m-2",
                  placeholder: "数据类型"
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(unref(dataTypeList), (item) => {
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
            (unref(atrrForm).dataTypeId == 1 || unref(atrrForm).dataTypeId == 2)
              ? (openBlock(), createBlock(_component_el_form_item, {
                  key: 0,
                  label: "取值范围"
                }, {
                  default: withCtx(() => [
                    createBaseVNode("div", _hoisted_40, [
                      createVNode(_component_el_form_item, { prop: "typeParams.min" }, {
                        default: withCtx(() => [
                          createVNode(_component_el_input, {
                            modelValue: unref(atrrForm).typeParams.min,
                            "onUpdate:modelValue": _cache[18] || (_cache[18] = $event => ((unref(atrrForm).typeParams.min) = $event)),
                            placeholder: "最小值",
                            style: {"width":"98%"}
                          }, null, 8, ["modelValue"])
                        ]),
                        _: 1
                      }),
                      _hoisted_41,
                      createVNode(_component_el_form_item, { prop: "typeParams.max" }, {
                        default: withCtx(() => [
                          createVNode(_component_el_input, {
                            modelValue: unref(atrrForm).typeParams.max,
                            "onUpdate:modelValue": _cache[19] || (_cache[19] = $event => ((unref(atrrForm).typeParams.max) = $event)),
                            placeholder: "最大值",
                            style: {"width":"95%"}
                          }, null, 8, ["modelValue"])
                        ]),
                        _: 1
                      })
                    ])
                  ]),
                  _: 1
                }))
              : createCommentVNode("", true),
            (unref(atrrForm).dataTypeId == 1 || unref(atrrForm).dataTypeId == 2)
              ? (openBlock(), createBlock(_component_el_form_item, {
                  key: 1,
                  label: "步长",
                  prop: "typeParams.step"
                }, {
                  default: withCtx(() => [
                    createVNode(_component_el_input, {
                      modelValue: unref(atrrForm).typeParams.step,
                      "onUpdate:modelValue": _cache[20] || (_cache[20] = $event => ((unref(atrrForm).typeParams.step) = $event)),
                      placeholder: "步长"
                    }, null, 8, ["modelValue"])
                  ]),
                  _: 1
                }))
              : createCommentVNode("", true),
            (unref(atrrForm).dataTypeId == 4)
              ? (openBlock(), createBlock(_component_el_form_item, {
                  key: 2,
                  label: "枚举项",
                  prop: "typeParams.enumList"
                }, {
                  default: withCtx(() => [
                    (openBlock(true), createElementBlock(Fragment, null, renderList(unref(atrrForm).typeParams.enumList, (item, index) => {
                      return (openBlock(), createElementBlock("div", {
                        key: index,
                        style: {"margin-bottom":"5px"}
                      }, [
                        createVNode(_component_el_input, {
                          modelValue: item.value,
                          "onUpdate:modelValue": $event => ((item.value) = $event),
                          placeholder: "参数值",
                          style: {"width":"40%"}
                        }, null, 8, ["modelValue", "onUpdate:modelValue"]),
                        _hoisted_42,
                        createVNode(_component_el_input, {
                          modelValue: item.name,
                          "onUpdate:modelValue": $event => ((item.name) = $event),
                          placeholder: "参数描述",
                          style: {"width":"40%"}
                        }, null, 8, ["modelValue", "onUpdate:modelValue"]),
                        createVNode(_component_el_button, {
                          type: "danger",
                          link: "",
                          onClick: $event => (delAtrrEnum(item.id))
                        }, {
                          default: withCtx(() => [
                            _hoisted_43
                          ]),
                          _: 2
                        }, 1032, ["onClick"])
                      ]))
                    }), 128)),
                    createBaseVNode("div", _hoisted_44, [
                      createVNode(_component_el_button, {
                        type: "primary",
                        link: "",
                        onClick: addAtrrEnum
                      }, {
                        default: withCtx(() => [
                          _hoisted_45
                        ]),
                        _: 1
                      })
                    ])
                  ]),
                  _: 1
                }))
              : createCommentVNode("", true)
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

var show_vue_vue_type_style_index_0_lang = '';

const _hoisted_1 = {
  class: "app-container",
  style: {"background-color":"#ffffff","padding":"10px 10px"}
};
const _hoisted_2 = { class: "text-large font-600 mr-3" };


const _sfc_main = {
  setup(__props) {

const route = useRoute();

const productInfo = ref({});
/** 查看按钮操作 */
const id = ref(route.params.id);

handleShow(id.value);
function handleShow() {
  getProductInfo(id.value).then(response => {
    productInfo.value = response.data;
  });
}

const activeName = ref('product');
function handleClick (tab, event) {
  console.log(tab, event);
}

const router = useRouter();
function goBack() {
  router.push("/productInfo");
}


return (_ctx, _cache) => {
  const _component_el_page_header = resolveComponent("el-page-header");
  const _component_el_descriptions_item = resolveComponent("el-descriptions-item");
  const _component_el_descriptions = resolveComponent("el-descriptions");
  const _component_el_tab_pane = resolveComponent("el-tab-pane");
  const _component_el_tabs = resolveComponent("el-tabs");

  return (openBlock(), createElementBlock("div", _hoisted_1, [
    createVNode(_component_el_page_header, {
      title: "返回",
      onBack: goBack
    }, {
      content: withCtx(() => [
        createBaseVNode("span", _hoisted_2, toDisplayString(productInfo.value.name), 1)
      ]),
      _: 1
    }),
    createVNode(_component_el_descriptions, {
      style: {"margin-top":"20px"},
      column: "2"
    }, {
      default: withCtx(() => [
        createVNode(_component_el_descriptions_item, { label: "产品KEY" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(productInfo.value.productKey), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_descriptions_item, { label: "节点类型" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(productInfo.value.nodeType == 1 ? '直连设备' : productInfo.value.nodeType == 2 ? '网关子设备' : '网关设备'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_descriptions_item, { label: "设备数量" }, {
          default: withCtx(() => [
            createTextVNode(toDisplayString(productInfo.value.deviceNum), 1)
          ]),
          _: 1
        })
      ]),
      _: 1
    }),
    createVNode(_component_el_tabs, {
      modelValue: activeName.value,
      "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((activeName).value = $event)),
      class: "demo-tabs",
      onTabClick: handleClick
    }, {
      default: withCtx(() => [
        createVNode(_component_el_tab_pane, {
          label: "产品信息",
          name: "product",
          style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-10px"}
        }, {
          default: withCtx(() => [
            createVNode(_component_el_descriptions, { title: "产品信息" }, {
              default: withCtx(() => [
                createVNode(_component_el_descriptions_item, { label: "产品名称" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(productInfo.value.name), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "产品KEY" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(productInfo.value.productKey), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "节点类型" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(productInfo.value.nodeType == 1 ? '直连设备' : productInfo.value.nodeType == 2 ? '网关子设备' : '网关设备'), 1)
                  ]),
                  _: 1
                }),
                createVNode(_component_el_descriptions_item, { label: "创建时间" }, {
                  default: withCtx(() => [
                    createTextVNode(toDisplayString(productInfo.value.createTime), 1)
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
          label: "Topic类列表",
          name: "topic",
          style: {"border":"0px solid red","margin-left":"-30px","margin-top":"-20px"}
        }, {
          default: withCtx(() => [
            createVNode(_sfc_main$2, { productId: id.value }, null, 8, ["productId"])
          ]),
          _: 1
        }),
        createVNode(_component_el_tab_pane, {
          label: "功能定义",
          name: "model"
        }, {
          default: withCtx(() => [
            createVNode(_sfc_main$1, { productId: id.value }, null, 8, ["productId"])
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
