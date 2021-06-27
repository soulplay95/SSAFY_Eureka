import axios from 'axios'

export const itemStore = {
  namespaced: true,
  state: () => ({
    searchText: '',
    allData: [
      {
        id: 1,
        name: '파인애플',
        category: '과일',
        price: 30000,
        img: 'https://picsum.photos/720/960/?image=476',
        rating: 4.5,
        brand: '삼성',
        deliveryprice: 2500,
        detailimg: null,
        count: 100,
      },
      {
        id: 2,
        name: '파인애플',
        category: '과일',
        price: 30000,
        img: 'https://picsum.photos/720/960/?image=476',
        rating: 4.5,
        brand: '삼성',
        deliveryprice: 2500,
        detailimg: null,
        count: 100,
      },
      {
        id: 3,
        name: '사과',
        category: '과일',
        price: 30000,
        img: 'https://picsum.photos/720/960/?image=476',
        rating: 4.5,
        brand: '삼성',
        deliveryprice: 2500,
        detailimg: null,
        count: 100,
      },
      {
        id: 4,
        name: '사과',
        category: '과일',
        price: 30000,
        img: 'https://picsum.photos/720/960/?image=476',
        rating: 4.5,
        brand: '삼성',
        deliveryprice: 2500,
        detailimg: null,
        count: 100,
      },
    ],
    searchItems: [
      
    ],
    selectItems: [],
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
    // SEARCH_ITEM(state, { searchItems, searchText } ) {
    //   state.searchText = searchText
    //   state.searchItems = searchItems
    // },
    SEARCH_ITEM(state, searchText ) {
      state.searchItems = []
      state.searchText = searchText
      const temp = state.allData.filter(item => {
        if (item.name === searchText) {
          state.searchItems.push(item)
        }
      })
      console.log(state.searchItems)
      return temp
    }
  },
  actions: {
  // 카테고리 목차를 만든다. 그런데 카테고리는 이중이다
  // 예를 들어, '잡화 - 신발'이 그 예이다.
  // 그런데 카테고리는 하나만 주어진다.
    searchItem({ commit }, searchText ){
      commit('SEARCH_ITEM', searchText)
      console.log(searchText)
    },
    // searchItem({ commit }, searchText){
    //   axios({
    //     method: 'get',
    //     url: `http://localhost/product/search?keyword=${searchText}`,
    //   })
    //   .then(res => {
    //     console.log(res.data)
    //     commit('SEARCH_ITEM', ( res.data, searchText))
    //   })
    //   .catch(err => {
    //     console.log(err)
    //   })
    //   commit('SEARCH_ITEM', searchText)
    // },
    selectItem({ commit }, searchText){
      axios({
        method: 'get',
        url: `http://localhost/product/search?keyword=${searchText}`,
      })
      .then(res => {
        console.log(res.data)
        commit('SEARCH_ITEM', res.data)
      })
      .catch(err => {
        console.log(err)
      })
      commit('SEARCH_ITEM', searchText)
    }
  }
};
