import { u as useRouter, b as useRoute } from './index.4cfe0fe4.js';
import { h } from './element-plus.aa5fe574.js';

const _sfc_main = {
  setup() {
    const router = useRouter();
    const route = useRoute();
    router.replace(route.fullPath.replace(/^\/redirect/, ''));
  },
  render() {
    return h('div')
  },
};

export { _sfc_main as default };
