import { r as ref, q as reactive, C as toRefs, p as resolveComponent, P as resolveDirective, l as openBlock, J as createElementBlock, j as createVNode, n as withCtx, u as unref, a3 as withKeys, N as withDirectives, m as createBlock, R as createTextVNode, S as toDisplayString } from './element-plus.aa5fe574.js';
import { k as service } from './index.4cfe0fe4.js';

// 查询操作日志记录列表
function listSysLoginLog(query) {
  return service({
    url: '/system/sysLoginLog/list',
    method: 'get',
    params: query
  })
}

const _hoisted_1 = { class: "app-container" };
const _hoisted_2 = /*#__PURE__*/createTextVNode("搜索");
const _hoisted_3 = /*#__PURE__*/createTextVNode("重置");


const _sfc_main = {
  setup(__props) {

const sysLoginLogList = ref([]);
const loading = ref(true);
const total = ref(0);
const dateRange = ref([]);

const data = reactive({
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    username: null,
    beginTime: null,
    endTime: null
  }
});

const { queryParams } = toRefs(data);

/** 查询操作日志记录列表 */
function getList() {
  loading.value = true;
  if (dateRange.value.length == 2) {
    queryParams.value.beginTime = dateRange.value[0];
    queryParams.value.endTime = dateRange.value[1];
  }
  listSysLoginLog(queryParams.value).then(response => {
    sysLoginLogList.value = response.data.records;
    total.value = response.data.total;
    loading.value = false;
  });
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  handleQuery();
  handleQuery();
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
          label: "用户名",
          prop: "title"
        }, {
          default: withCtx(() => [
            createVNode(_component_el_input, {
              modelValue: unref(queryParams).username,
              "onUpdate:modelValue": _cache[0] || (_cache[0] = $event => ((unref(queryParams).username) = $event)),
              placeholder: "请输入用户名",
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
    withDirectives((openBlock(), createBlock(_component_el_table, { data: sysLoginLogList.value }, {
      default: withCtx(() => [
        createVNode(_component_el_table_column, {
          prop: "username",
          label: "登录账号"
        }),
        createVNode(_component_el_table_column, {
          prop: "ipaddr",
          label: "登录IP地址"
        }),
        createVNode(_component_el_table_column, {
          prop: "msg",
          label: "提示信息"
        }),
        createVNode(_component_el_table_column, {
          label: "状态",
          width: "80"
        }, {
          default: withCtx((scope) => [
            createTextVNode(toDisplayString(scope.row.status === 1 ? '成功' : '失败'), 1)
          ]),
          _: 1
        }),
        createVNode(_component_el_table_column, {
          prop: "createTime",
          label: "创建时间",
          width: "160"
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
    }, null, 8, ["current-page", "page-size", "total"])
  ]))
}
}

};

export { _sfc_main as default };
