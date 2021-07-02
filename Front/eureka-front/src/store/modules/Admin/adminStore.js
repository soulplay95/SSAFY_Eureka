import http from '@/utils/http-common'

export const adminStore = {
    namespaced: true,
    state: {
        userInfo: [],
        itemInfo: [],
        itemListCount: 0,
    },
    mutations: {
        SET_USERINFO(state, data) {
          state.userInfo = data 
        },
        SET_ITEMINFO(state, data) {
          state.itemListCount = data.count
          state.itemInfo = data.products
        }
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
        setItemInfo({commit}, clickedPageNum) {
          http
            .get('admin/product/' + clickedPageNum)
            .then((res) => {
              commit('SET_ITEMINFO', res.data)
            })
            .catch((err) => {
              console.log(err)
            })
        }
        
    },
    getters: {
      userInfo(state) {
        return state.userInfo
      },
      itemInfo(state) {
        return state.itemInfo
      },
      possiblePage(state) {
        return Math.ceil(state.itemListCount / 100)
      }
    }
}