// import axios from 'axios'

export const CSQnaStore = {
  namespaced: true,
  state: () => ({
    myQnaHistory: [],
  }),
  mutations: {
    SUBMIT_QNA( state, query) {
      state.myQnaHistory.push(query)
      // console.log(state.myQnaHistory)
      console.log(state.myQnaHistory)
    }
  },
  actions: {
    submitQna({ commit }, query){
      commit('SUBMIT_QNA', query)
    },
  }
};