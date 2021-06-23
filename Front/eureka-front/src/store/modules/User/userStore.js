// index.js에서 import 필요

import http from '@/utils/http-common';

// const userStore = {
//   namespaced: true,
//   state: () => ({
//     user: {
//       userid: 'mind@gmail.com',
//       name: '김구라',
//       address: '',
//       phone: '010-1010-7777',
//     },
//   }),
//   getters: {
//     user(state) {
//       return state.user;
//     },
//   },
//   mutations: {},
//   actions: {},
//   modules: {},
// };

// export default userStore;

// axios({
//   method: 'post',
//   url: "",
//   data: {
//     'userid': this.userid,
//     'userpwd': this.userpwd,
//     'username': this.username,
//     'phone': this.phone,
//     'address': this.address,
//   }
// })
// .then((res) => {
//   console.log(res)
// })
// .catch((err) => {
//   console.log(err)
// })

export const userStore = {
  namespaced: true,
  state: () => ({
    user: {
      userid: 'mind@gmail.com',
      name: '김구라',
      address: '',
      phone: '010-1010-7777',
    },
  }),

  mutations: {
    REGISTER(state, data) {
      console.log(state.user);
      console.log(data);
    },
  },
  actions: {
    register({ commit }, data) {
      http
        .post('/member', data)
        .then((response) => {
          console.log(response);
          if (response.status == 200) {
            commit('REGISTER', response.data);
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
  modules: {},
};
