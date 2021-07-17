import http from '@/utils/http-common';

export const itemDetail = {
  namespaced: true,
  state: () => ({
    // 상품 정보
    productInfo: {},
  }),
  getters: {
    productInfo(state) {
      return state.productInfo;
    },
  },
  mutations: {
    GET_PRODUCT_INFO(state, data) {
      state.productInfo = data;
    },
  },
  actions: {
    async getProductInfo({ commit }, product_id) {
      await http
        .get('/product/detailview/' + product_id)
        .then((res) => {
          if (res.status == 200) {
            commit('GET_PRODUCT_INFO', res.data);
          } else {
            alert('상품 정보 로딩 실패');
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
