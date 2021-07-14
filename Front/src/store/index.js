import { createStore } from 'vuex';

// import modules

import { cart } from '@/store/modules/Cart/cart';
import { itemStore } from '@/store/modules/Item/itemStore';
import { userStore } from '@/store/modules/User/userStore';
import { CSQnaStore } from '@/store/modules/CSQna/CSQnaStore';
import { order } from '@/store/modules/Order/order';
import { productReview } from '@/store/modules/productReview/productReview';
import { itemDetail } from '@/store/modules/Item/itemDetail';
import { adminStore } from '@/store/modules/Admin/adminStore';
import { myPageStore } from '@/store/modules/MyPage/myPageStore';

import createPersistedState from 'vuex-persistedstate';

export default createStore({
  state: {
  },
  mutations: {},
  actions: {},
  modules: {
    cart,
    itemStore,
    userStore,
    order,
    CSQnaStore,
    productReview,
    itemDetail,
  adminStore,
  myPageStore
  },
  plugins: [
    createPersistedState({
      paths: ['userStore', 'itemStore', 'cart', 'order', 'adminStore.modifyItemInfo'],
    }),
  ],
});
