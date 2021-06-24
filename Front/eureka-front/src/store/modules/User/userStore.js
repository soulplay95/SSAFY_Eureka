// 위처럼 namespaced를 넣어주면 사용하는 컴포넌트에서는 getters, mutation, action을 부르는 방법이 조금 달라집니다. 하지만 훨씬 알아보기 쉽습니다.

// state는 기존대로 state.moduleName.stateName으로 부릅니다.
// getters는 computed(() => store.getters["moduleName/getterName"])으로 부릅니다.
// mutation은 store.commit("moduleName/mutationName", params)으로 부릅니다.
// action은 store.dispatch("moduleName/actionName", params)으로 부릅니다. `


import axios from 'axios'
import router from '@/router'

// index.js에서 import 필요
export const userStore = {
  namespaced: true,
  state: {
    // 서버와의 통신이 끝난 후 JWT 관련 내용
    // user 내용
    user: {},
    isAuthenticated : false,
  },
  mutations: {
    SET_AUTH (state, data) {
      console.log('토큰설정', data)
      // userid, name, phone, address 정보 받아옴
      state.user = data
      state.isAuthenticated = true
      window.localStorage.setItem('refreshJws', data.auth_token.refreshJws)
      window.localStorage.setItem('accessJws', data.auth_token.accessJws)
    },
    DESTROY_AUTH (state) {
      state.user = {}
      state.isAuthenticated = false
      window.localStorage.removeItem('refreshJws')
      window.localStorage.removeItem('accessJws')
    }
    
  },
  actions: {
    register ({dispatch}, credentials) {
      console.log('회원가입', credentials)
      axios({
        // 백엔드에 전달할 변수명 확인 필요
        method: 'POST',
        url: 'http://localhost/member',
        data: {
          member_userid: credentials.userid,
          member_userpwd: credentials.userpwd,
          member_name: credentials.name,
          member_phone: credentials.phone,
          member_address: credentials.address,
          member_type: credentials.type,
        }
      })
      .then((res) => {
        dispatch("login", credentials)
        console.log('회원가입통과', res)
      })
      .catch((err) => {
        alert(err)
      })
    },
    login ({commit}, credentials) {
      console.log('로그인', credentials)
      axios({
        method: 'POST',
        url: 'http://localhost/member/login',
        data: {
          member_userid: credentials.userid,
          member_userpwd: credentials.password
        }
      })
      .then((res) => {
        commit("SET_AUTH", res.data)
        router.push({ name: "Home" })
      })
      .catch((err) => {
        console.log(err)
      })
    },
    logout({commit}) {
      console.log(this)
      axios({
        url: "http://localhost/member/${this.user.userid}"
      })
      .then((res) => {
        commit("DESTROY_AUTH")
        console.log(res)
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
