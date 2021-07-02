import http from '@/utils/http-common'
import router from '@/router'

export const adminStore = {
    namespaced: true,
    state: {
      userInfo: [],
      itemsInfo: [],
      itemListCount: 0,
      // 상품 등록시 필요한 빈 정보
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
      // 상품 수정시 필요한 상품 정보
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
      // 상품 등록 or 수정 mode
      mode: "",
      // 상품 현황 page
      currentPage: 0,
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
      // 회원현황
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
      // 상품 현황 pagination에 따른 정보 불러오기
      setItemsInfo({commit}, clickedPageNum) {
        http
          .get('admin/product/' + clickedPageNum)
          .then((res) => {
            commit('SET_ITEMSINFO', res.data)
            this.currentPage = clickedPageNum
          })
          .catch((err) => {
            console.log(err)
          })
      },
      // 상품 등록 or 상품 수정
      changeMode({commit}, selectedMode) {
        commit('SET_MODE', selectedMode)
      },
      // 상품 수정 하기 위해 상품 정보 받아오기
      getItemInfo({commit, state}, itemId) {
        const itemInfo = state.itemsInfo[itemId]
        commit('GET_ITEM', itemInfo)
        router.push({name: 'AdminItemModify'})
      },
      // 상품 삭제
      deleteItem({dispatch}, itemId) {
        http
        .delete('admin/delete/' + itemId)
        .then((res) => {
          dispatch('setItemsInfo', this.currentPage)
          console.log(res)
        })
      }     
    },
    getters: {
      userInfo(state) {
        return state.userInfo
      },
      itemsInfo(state) {
        return state.itemsInfo
      },
      // 가능한 pages
      possiblePage(state) {
        return Math.ceil(state.itemListCount / 100)
      },
      // 상품 등록 or 수정시 Form에 기입해놓을 정보
      itemFormInfo(state) {
        if (state.mode === "modify") {
          return state.modifyItemInfo
        } else {
          return state.initItemInfo
        }
      },
      // 상품 등록인지 수정인지 확인하는 mode
      currentMode(state) {
        return state.mode
      }
    }
}