
import { createStore } from 'vuex';

// import modules
import { cart } from '@/store/modules/Cart/cart';
import { itemStore } from "@/store/modules/Item/itemStore";

export default createStore({
  state: {
    // 유저 정보
    // 장바구니 (로그인할 때 리셋)
    // 검색 정보
    // 메인 페이지 상품 정보
    // Footer 정보
  },
  mutations: {},
  actions: {},
  modules: { cart, itemStore },
});


