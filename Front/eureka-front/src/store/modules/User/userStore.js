// 위처럼 namespaced를 넣어주면 사용하는 컴포넌트에서는 getters, mutation, action을 부르는 방법이 조금 달라집니다. 하지만 훨씬 알아보기 쉽습니다.

// state는 기존대로 state.moduleName.stateName으로 부릅니다.
// getters는 computed(() => store.getters["moduleName/getterName"])으로 부릅니다.
// mutation은 store.commit("moduleName/mutationName", params)으로 부릅니다.
// action은 store.dispatch("moduleName/actionName", params)으로 부릅니다. `



// index.js에서 import 필요

export const userStore = {
  namespaced: true,
  state: {},
  mutations: {},
  actions: {
    register (commit, credentials) {
      console.log(commit, credentials)
      // axios({
      //   method: 'post',
      //   url: '',
      //   data() {
      //     return {
            
      //     }
      //   }

      // })
    }
  },
  modules: {},
};



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
