export const itemStore = {
  namespaced: true,
  state: () => ({
    searchText: '',
  }),
  mutations: {
    // increment(state) {
    //   state.count++;
    // }
    SEARCH_ITEM(state, searchText){
      state.searchText = searchText
    }
  },
  // getters: {
  //   doubleCount(state, getters, rootState) {
  //     return state.count * 2;
  //   }
  // },
  actions: {
    // incrementIfOddOnRootSum(state, commit, rootState) {
    //   if ((state.count + rootState.count) % 2 === 1) {
    //     commit("increment");
    //   }
    // }
    searchItem({ commit }, searchText){
      commit('SEARCH_ITEM', searchText)
    }
  }
};