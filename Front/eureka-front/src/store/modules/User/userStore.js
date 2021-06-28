import axios from 'axios';
import router from '@/router';
// JWT 토큰 가져오는 용도
import JWTcommon from '@/utils/JWT-common';

// index.js에서 import 필요
export const userStore = {
  namespaced: true,
  state: {
    // 서버와의 통신이 끝난 후 JWT 관련 내용
    // persistedState 의문?
    user: {},
    isAuthenticated: false,
  },
  mutations: {
    SET_AUTH(state, data) {
      // userid, name, phone, address 정보 받아옴
      state.user = data.data;
      state.isAuthenticated = true;
      JWTcommon.saveTokens(data.auth_token);
      console.log('토큰설정', state.user, state.isAuthenticated);
    },
    DESTROY_AUTH(state) {
      state.user = {};
      state.isAuthenticated = false;
      JWTcommon.destroyTokens();
      console.log('토큰삭제', state.user, state.isAuthenticated);
    },
  },
  actions: {
    register({ dispatch, commit }, credentials) {
      console.log('회원가입', credentials);
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
        },
      })
        .then((res) => {
          dispatch('login', credentials);
          console.log('회원가입통과', res);
        })
        .catch((err) => {
          alert(err);
        })
        .then((res) => {
          commit('SET_AUTH', res.data);
          console.log(res);
        })
        .catch((err) => {
          alert(err);
        });
    },

    login({ commit }, credentials) {
      console.log('로그인', credentials);
      axios({
        method: 'POST',
        url: 'http://localhost/member/login',
        data: {
          member_userid: credentials.userid,
          member_userpwd: credentials.password,
        },
      })
        .then((res) => {
          console.log('백에서 통신옴');
          commit('SET_AUTH', res.data);
          router.push({ name: 'Home' });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    logout({ commit, state }) {
      console.log(state);
      axios({
        url: `http://localhost/member/logout/${state.user.member_userid}`,
      }).then((res) => {
        commit('DESTROY_AUTH');
        console.log(res);
      });
    },
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    },
    isAdmin(state) {
      return state.user.member_type === '관리자';
    },
  },
  modules: {},
};
