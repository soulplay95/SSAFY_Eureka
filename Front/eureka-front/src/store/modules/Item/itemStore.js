export const itemStore = {
  namespaced: true,
  state: () => ({
    searchText: '',
    dogImage: [
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
      'https://placedog.net/200/200?random',
    ],
  }),
  getters: {},
  mutations: {
    SEARCH_ITEM(state, searchText) {
      state.searchText = searchText;
    },
  },
  actions: {
    // 카테고리 목차를 만든다. 그런데 카테고리는 이중이다
    // 예를 들어, '잡화 - 신발'이 그 예이다.
    // 그런데 카테고리는 하나만 주어진다.
    searchItem({ commit }, searchText) {
      commit('SEARCH_ITEM', searchText);
    },
  },
};
