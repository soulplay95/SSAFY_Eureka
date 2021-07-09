import router from '@/router'
// JWT 토큰 가져오는 용도
import JWTservice from "@/utils/JWT-common"
import http from '@/utils/http-common'
import Swal from 'sweetalert2'

// index.js에서 import 필요
export const userStore = {
  namespaced: true,
  state: {
    // 서버와의 통신이 끝난 후 JWT 관련 내용
    // persistedState 의문?
    user: {
      // @도명 for testing
      // member_userid: 'jejin009@gmail.com',
      // member_name: '테스트맨',
      // member_address: '서울시 용산구',
      // member_phone: '010-1234-5678',
    },
    isAuthenticated: false,
  },
  mutations: {
    SET_AUTH(state, data) {
      // userid, name, phone, address 정보 받아옴
      state.user = data.data
      state.isAuthenticated = true
      JWTservice.saveTokens(data.auth_token)
      console.log('토큰설정', state.user, state.isAuthenticated)
    },
    DESTROY_AUTH (state) {
      state.user = {}
      state.isAuthenticated = false
      JWTservice.destroyTokens()
      console.log('토큰삭제', state.user, state.isAuthenticated)
    },
  },
  actions: {
    register ({dispatch}, credentials) {
      const data = {
        member_userid: credentials.userid,
        member_userpwd: credentials.userpwd,
        member_name: credentials.name,
        member_phone: credentials.phone,
        member_address: credentials.address,
        member_type: credentials.type
      }
      http
        .post('member/regist', data)
        .then((res) => {
          console.log('회원가입통과', res)
          dispatch("login", credentials)
        })
        .catch((err) => {
          alert(err)
        })
    },
    login ({commit}, credentials) {
      const data = {
        member_userid: credentials.userid,
        member_userpwd: credentials.userpwd
      }
      http
        .post('member/login', data)
        .then((res) => {
          commit("SET_AUTH", res.data)
          router.push({ name: "Home" })
        })
        .catch((err) => {
          Swal.fire({
            icon: 'error',
            title: '로그인 실패😥',
            text: '아이디 또는 비밀번호를 다시 확인해주세요'
          })
          console.log(err)
        })
    },
    logout({commit, state}) {
      http
        .get('member/logout/' + state.user.member_userid)
        .then((res) => {
          commit("DESTROY_AUTH")
          router.push({ name: "Home" })
          console.log('로그아웃 성공', res)
        })
        .catch((err) => {
          console.log(err)
        })
    },
    modifyuserinfo({dispatch}, currentUser) {
      const data = {
        member_userid: currentUser.member_userid,
        member_name: currentUser.member_name,
        member_phone: currentUser.member_phone
      }
      http
        .put('member/modify', data)
        .then((res) => {
          console.log(res)
          dispatch('logout')
        })
        .then((err) => {
          console.log(err)
        })
    },
    modifyuserpwd({dispatch}, credentials) {
      const data = {
        member_userid: credentials.userid,
        member_userpwd: credentials.userpwd,
        member_newpwd: credentials.newpwd
      }
      http
        .put('member/updatepwd', data)
        .then((res) => {
          dispatch('logout')
          console.log(res)
        })
        .then((err) => {
          console.log(err)
        })
    }
  },
  getters: {
    currentUser(state) {
      return state.user
    },
    isAuthenticated(state) {
      return state.isAuthenticated;
    },
    isAdmin(state) {
      return state.user.member_type === '관리자';
    },
  },
  modules: {},
};