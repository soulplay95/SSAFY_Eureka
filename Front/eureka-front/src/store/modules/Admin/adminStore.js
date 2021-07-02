import http from '@/utils/http-common'
import router from '@/router'

export const adminStore = {
    namespaced: true,
    state: {
        userInfo: [],
        itemsInfo: [],
        itemListCount: 0,
        // 상품 등록 및 수정
        initItemInfo: {
          product_brand: '',
          product_name: '',
          seller_name: '',
          product_category: 0,
          product_count: 0,
          product_price: 0,
          product_deliveryprice: 0,
          product_discount: 0,
        },
        modifyItemInfo: {
          product_brand: '',
          product_name: '',
          seller_name: '',
          product_category: 0,
          product_count: 0,
          product_price: 0,
          product_deliveryprice: 0,
          product_discount: 0,
        },
        mode: "",
    },
    mutations: {
        SET_USERINFO(state, data) {
          state.userInfo = data 
        },
        SET_ITEMSINFO(state, data) {
          state.itemListCount = data.count
          state.itemsInfo = data.products
        },
        SET_MODE(state, data) {
          state.mode = data
        },
        GET_ITEM(state, data) {
          for (let key in state.modifyItemInfo) {
            state.modifyItemInfo[key] = data[key]
          }
        },
    },
    actions: {
        setUserInfo({commit}) {
          http
            .get('admin/member')
            .then((res) => {
              commit('SET_USERINFO', res.data)
            })
            .catch((err) => {
              console.log(err)
            })
        },
        setItemsInfo({commit}, clickedPageNum) {
          http
            .get('admin/product/' + clickedPageNum)
            .then((res) => {
              commit('SET_ITEMSINFO', res.data)
            })
            .catch((err) => {
              console.log(err)
            })
        },
        changeMode({commit}, selectedMode) {
          commit('SET_MODE', selectedMode)
        },
        getItemInfo({commit, state}, itemId) {
          const itemInfo = state.itemsInfo[itemId]
          commit('GET_ITEM', itemInfo)
          router.push({name: 'AdminItemModify'})
        }
        
    },
    getters: {
      userInfo(state) {
        return state.userInfo
      },
      itemsInfo(state) {
        return state.itemsInfo
      },
      possiblePage(state) {
        return Math.ceil(state.itemListCount / 100)
      },
      itemFormInfo(state) {
        if (state.mode === "modify") {
          return state.modifyItemInfo
        } else {
          return state.initItemInfo
        }
      },
      currentMode(state) {
        return state.mode
      }
    }
}