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
        price: 14000,
        img: 'https://picsum.photos/720/960/?image=476',
        rating: 2.5,
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
    filterItems: [

    ],
    searchItems: [
      
    ],
    HomeCarousel: [
      
    ],
    selectItems: [],
  }),
  getters: {
    searchText (state) {
      return state.searchText
    },
    searchItems (state) {
      console.log(state.searchItems)
      return state.searchItems
    }
  },
  mutations: {
    SEARCH_ITEM(state, searchText ) {
      axios({
        method: 'get',
        url: `http://localhost:8080/product/search?keyword=${searchText}&page=1`,
      }).
        then(res =>{
          console.log(11111111111)
          console.log(res)
          state.searchItems = res
          console.log(res)
        })
        .catch(err => {
          console.log(err)
        })
      console.log(state.searchText)
    },
    // 아직 완성 못한 filterquery
    // FILTER_ITEM(state, filterQuery ) {
    //   state.filterItems = []
    //   const pricetmp = null
    //   if (filterQuery.maxprice !== null){
    //     pricetmp = state.searchItems.find((searchItem) => {
    //       return (filterQuery.minprice <= searchItem.price && searchItem.price <= filterQuery.maxprice)
    //     })
    //   }
    //   else {
        
    //   }
    // }
  },
  actions: {
    searchItem({ commit }, searchText ){
      console.log(1)
      axios.get('http://localhost/product/search?keyword='+ searchText + '&page=1')
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
      // axios({
      //   method: 'get',
      //   url: `http://localhost/product/search?keyword=${searchText}&page=1`,
      // }).
      //   then(res =>{
      //     console.log(11111111111)
      //     console.log(res)
      //     console.log(res)
      //   })
      //   .catch(err => {
      //     console.log(err)
      //   })
      commit('SEARCH_ITEM', searchText)
    },
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
    },
    filterItem({ commit }, filterQuery ){
      commit('FILTER_ITEM', filterQuery)
      console.log(filterQuery)
    },
  }
};
