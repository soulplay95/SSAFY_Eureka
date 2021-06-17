import { createStore } from "vuex";
import { itemStore } from "@/store/modules/Item/itemStore";
// import { userStore } from "@/store/modules/User/userStore";

export default createStore({
  modules: { itemStore }
});
