import { createStore } from "vuex";

// import modules

import { cart } from '@/store/modules/Cart/cart';
import { itemStore } from "@/store/modules/Item/itemStore";
import { userStore } from "@/store/modules/User/userStore";
import { CSQnaStore } from "@/store/modules/CSQna/CSQnaStore";
import { order } from '@/store/modules/Order/order';
import { adminStore } from '@/store/modules/Admin/adminStore';

import createPersistedState from "vuex-persistedstate"

export default createStore({
  state: {
  },
  mutations: {},
  actions: {},
  modules: { cart, itemStore, userStore, order, adminStore, CSQnaStore },
  plugins: [
    createPersistedState({
      paths: ['userStore', 'adminStore', 'itemStore']
    })
  ],
});
