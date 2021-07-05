import http from '@/utils/http-common';

export const productReview = {
  namespaced: true,
  state: () => ({
    // 유저가 작성한 리뷰 목록
    reviewList: [
      // for test
      {
        member_userid: 'ft@naver.com',
        product_id: '30',
        review_content: '깨끗해여~',
        review_date: '2012-01-02',
        review_id: 1,
        review_img:
          'https://gdimg.gmarket.co.kr/1157707109/still/280?ver=1617807538',
        review_liked: '12',
        review_rating: '2',
        review_title: '꼭 사세요 두번 사세요',
      },
      {
        member_userid: 'ft@naver.com',
        product_id: '30',
        review_content: '깨끗해여~',
        review_date: '2012-01-02',
        review_id: 2,
        review_img:
          'https://gdimg.gmarket.co.kr/1157707109/still/280?ver=1617807538',
        review_liked: '3',
        review_rating: '4',
        review_title: 'zzz adsdas 두번 사세요',
      },
    ],
    // 작성한 리뷰의 product_id에 해당하는 상품 상세 정보들
    product_details: {},
  }),
  getters: {
    reviewList(state) {
      return state.reviewList;
    },
    product_details(state) {
      return state.product_details;
    },
  },
  mutations: {
    GET_REVIEW_LIST(state, data) {
      state.reviewList = data;
    },
    GET_PRODUCT_DETAILS(state, data) {
      state.product_details = data;
    },
  },
  actions: {
    // 유저가 작성한 리뷰 목록을 받아온다.
    getReviewList({ dispatch, commit }, member_userid) {
      http
        .get('/review/' + member_userid)
        .then((res) => {
          let list = res.data; // 리뷰 리스트
          let ids = [];

          // list에 있는 product_id들로 배열을 만든다.
          list.forEach((item) => {
            ids.push(item.product_id);
          });

          const set = new Set(ids);
          console.log(set);
          dispatch('getProductDetails', set);

          commit('GET_REVIEW_LIST', list);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    // 리뷰 목록에 있는 상품들의 상세 정보를 받아온다.
    getProductDetails({ commit }, ids) {
      let details = {};

      ids.forEach((product_id) => {
        http
          .get('/review/' + ids)
          .then((res) => {
            details[product_id] = res.data.product;
          })
          .catch((err) => {
            console.err(err);
          });
      });

      commit('GET_PRODUCT_DETAILS', details);
    },
  },
};
