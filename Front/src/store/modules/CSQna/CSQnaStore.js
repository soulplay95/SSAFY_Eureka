// import axios from 'axios'
// import JWTcommon from "@/utils/JWT-common";
import JWTservice from '@/utils/JWT-common'
// import { getAccessToken } from '../../../utils/JWT-common';

export const CSQnaStore = {
  namespaced: true,
  state: () => ({
    myQnaHistory: [
      {
        qna_category: '주문',
        qna_qtitle: '주문이요',
        qna_qcontent: '바꿔줘요'
      }
    ],
    setToken: JWTservice.getAccessToken()
  }),
  mutations: {
    SET_QNA(state, payload) {
      state.myQnaHistory.push(payload)
      console.log(state.myQnaHistory)
    },
  },
  actions: {
    postQna({ commit }, data ){
      commit('SET_QNA', data)
    },
    // submitQna({ commit }, query){
    //   axios({
    //     method: 'post',
    //     url: `http://localhost/qna`,
    //     data: query,
    //     headers: JWTcommon.getAccessToken,
    //   }).
    //     then(res =>{
    //       console.log(res)
    //     })
    //   commit('SUBMIT_QNA', query)
    // },
  }
};