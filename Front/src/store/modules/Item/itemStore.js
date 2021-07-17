import axios from "axios";

export const itemStore = {
  namespaced: true,
  state: () => ({
    searchText: "",
    rawSearchItems: [],
    searchItems: [],
    HomeCarousel: [],
    selectItems: [],
    pageCount: null,
    categoryHotItems: [],
    rawCategoryItems: [],
    categoryItems: [],
    categoryIndex: null,
    maxPrice: 0,
    filtery: 0, // filtery가 0이면 검색이 최근, 1이면 카테고리가 최근.
  }),
  getters: {
  },
  mutations: {
    SEARCH_ITEM(state, {products, searchText, pageCount} ) {
      state.maxPrice = 0
      for(let i = 0; i < products.length; i++) {
        if (state.maxPrice < Number(products[i]['product_price'])) {
          state.maxPrice = Number(products[i]['product_price'])
        }
      }
      state.rawSearchItems = products
      state.searchItems = products
      state.searchText = searchText
      state.pageCount = pageCount
      state.filtery = 0
    },
    SET_CATEGORY_HOT_ITEMS(state, payload) {
      state.categoryHotItems = payload
    },
    SET_CATEGORY_ITEMS(state, {products, searchText, pageCount, categoryNum} ) {
      state.maxPrice = 0
      for(let i = 0; i < products.length; i++) {
        if (state.maxPrice < Number(products[i]['product_price'])) {
          state.maxPrice = Number(products[i]['product_price'])
        }
      }
      state.rawCategoryItems = products
      state.categoryItems = products
      state.searchText = searchText
      state.pageCount = pageCount
      state.categoryIndex = categoryNum
      state.filtery = 1
    },
    SET_FILTER_ITEM(state, filterQuery ) {
      if (state.filtery === 0){
        state.searchItems = []
        if (filterQuery.rate != null){
          for(let i = 0; i < state.rawSearchItems.length; i++){
            if (filterQuery.startPrice <= state.rawSearchItems[i].product_price &&
               state.rawSearchItems[i].product_price <= filterQuery.endPrice &&
               state.rawSearchItems[i].product_rating == filterQuery.rate){
              state.searchItems.push(state.rawSearchItems[i])
            }
          }
        } else {
          for(let i = 0; i < state.rawSearchItems.length; i++){
            if (filterQuery.startPrice <= state.rawSearchItems[i].product_price &&
               state.rawSearchItems[i].product_price <= filterQuery.endPrice){
              state.searchItems.push(state.rawSearchItems[i])
            }
          }
        }
      } else {
        state.categoryItems = []
        if (filterQuery.rate != null){
          for(let i = 0; i < state.rawCategoryItems.length; i++){
            if (filterQuery.startPrice <= state.rawCategoryItems[i].product_price && 
              state.rawCategoryItems[i].product_price <= filterQuery.endPrice &&
              state.rawCategoryItems[i].product_rating == filterQuery.rate){
              state.categoryItems.push(state.rawCategoryItems[i])
            }
          }
        } else {
          for(let i = 0; i < state.rawCategoryItems.length; i++){
            if (filterQuery.startPrice <= state.rawCategoryItems[i].product_price && 
              state.rawCategoryItems[i].product_price <= filterQuery.endPrice){
              state.categoryItems.push(state.rawCategoryItems[i])
            }
          }
        }
      }
    }
  },
  actions: {
    searchItem({ commit }, { searchText, val } ){
      axios({
        method: 'get',
        url: `http://localhost/product/search?keyword=${searchText}&page=${ val }`,
      }).
        then(res =>{
          // console.log(res.data['products'])
          const products = res.data['products']
          const pageCount = res.data['count']
          commit('SEARCH_ITEM', {products, searchText, pageCount})
        })
        .catch(err => {
          console.log(err)
        })
    },
    clickCategory({ commit }, { searchText, categoryNum, val } ){
      axios({ // top5 상품들
        method: 'get',
        url: `http://localhost/product/categorytops/${ categoryNum }`,
      }).
        then(res =>{
          const products = res.data
          commit('SET_CATEGORY_HOT_ITEMS', products)
        })
        .catch(err => {
          console.log(err)
        })

        axios({ // category 상품들
          method: 'get',
          url: `http://localhost/product/listview?category=${ categoryNum }&page=${ val }`,
        }).
          then(res =>{
            const products = res.data['products']
            const pageCount = res.data['count']
            commit('SET_CATEGORY_ITEMS', {products, searchText, pageCount, categoryNum})
          })
          .catch(err => {
            console.log(err)
          })
    },
    selectItem({ commit }, searchText){
      axios({
        method: "get",
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
      commit('SET_FILTER_ITEM', filterQuery)
    },
  }
};
