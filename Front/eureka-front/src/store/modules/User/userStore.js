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
    register ({commit}, credentials) {
      console.log(credentials)
      axios({
        // 백엔드에 전달할 변수명 확인 필요
        method: 'POST',
        url: 'http://localhost/member/regist',
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
        commit("SET_AUTH", res.data)
        console.log(res)
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
