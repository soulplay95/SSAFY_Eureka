export const itemStore = {
  namespaced: true,
  state: () => ({
    searchText: '',
  }),
  mutations: {
    SEARCH_ITEM(state, searchText){
      state.searchText = searchText
    }
  },
  actions: {
    searchItem({ commit }, searchText){
      commit('SEARCH_ITEM', searchText)
    }
  }
};