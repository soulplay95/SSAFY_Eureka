import axios from 'axios'
import JWTcommon from "@/utils/JWT-common";
import { getAccessToken } from '../../../utils/JWT-common';

export const CSQnaStore = {
  namespaced: true,
  state: () => ({
    myQnaHistory: [
      {
        category: 2,
        title: '주문이요',
        content: '바꿔줘요'
      }
    ],
    setToken: getAccessToken
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
      axios({
        method: 'post',
        url: `http://localhost/qna`,
        data: query,
        headers: JWTcommon.getAccessToken,
      }).
        then(res =>{
          console.log(res)
        })
      commit('SUBMIT_QNA', query)
    },
  }
};