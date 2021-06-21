// 위처럼 namespaced를 넣어주면 사용하는 컴포넌트에서는 getters, mutation, action을 부르는 방법이 조금 달라집니다. 하지만 훨씬 알아보기 쉽습니다.

// state는 기존대로 state.moduleName.stateName으로 부릅니다.
// getters는 computed(() => store.getters["moduleName/getterName"])으로 부릅니다.
// mutation은 store.commit("moduleName/mutationName", params)으로 부릅니다.
// action은 store.dispatch("moduleName/actionName", params)으로 부릅니다. `


import axios from 'axios'

// index.js에서 import 필요
export const userStore = {
  namespaced: true,
  state: {
    // 서버와의 통신이 끝난 후 JWT 관련 내용
    // user 내용
    user: {},
    isAuthenticated : '',
  },
  mutations: {
    SET_AUTH (state, data) {
      // userid, name, phone, address 정보 받아옴
      state.user = data.user
      state.isAuthenticated = true
      window.localStorage.setItem('refreshToken', data.refreshToken)
      window.localStorage.setItem('accessToken', data.accessToken)
    }
  },
  actions: {
    register (commit, credentials) {
      console.log(credentials)
      axios({
        // 백엔드에 전달할 변수명 확인 필요
        method: 'post',
        url: 'site url',
        data: {
          credentials
        }
      })
      .then((res) => {
        commit("SET_AUTH", res.data)
      })
      .catch((err) => {
        alert(err)
      })
    },
    login (commit, credentials) {
      console.log(credentials)
      axios({
        methods: 'get',
        url: 'siteurl',
        data: {
          credentials
        }
      })
      .then((res) => {
        commit("SET_AUTH", res.data)
      })
    }
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated
    }
  },
  modules: {},
};
