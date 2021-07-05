import http from '@/utils/http-common';

export const order = {
  namespaced: true,
  state: () => ({
    // 로그인된 유저의 배송 주소록
    addressBook: [],
    // 받는사람정보(배송 주소록 리스트 중 선택된 주소록)
    receiverInfo: {},
    // 전체 주문 목록
    orderList: [],
    // 리팩토링
    // 전체 주문 목록 상품들의 details
    product_details: [],
  }),
  getters: {
    addressBook(state) {
      return state.addressBook;
    },
    receiverInfo(state) {
      return state.receiverInfo;
    },
    orderList(state) {
      return state.orderList;
    },
    product_details(state) {
      return state.product_details;
    },
  },
  mutations: {
    GET_ADDRESS_BOOK(state, list) {
      state.addressBook = list;
    },

    INIT_RECEIVER_INFO(state) {
      let size = state.addressBook.length;
      if (size != 0) {
        // let basicAddress = state.addressBook.filter((addr) => addr.type === 1); // 기본 배송지로 설정
        for (let i = 0; i < size; i++) {
          if (state.addressBook[i].type == 1) {
            state.receiverInfo = state.addressBook[i];
            return;
          }
        }
        // 기본 배송지가 없으면
        state.receiverInfo = state.addressBook[0]; // 주소록의 맨 첫번째 주소를 받는 사람 정보로 설정
      }
    },

    UPDATE_RECEIVER(state, addr) {
      state.receiverInfo = addr;
    },

    GET_ORDER_LIST(state, data) {
      state.orderList = data;
    },

    ADD_ADDRESS(state, data) {
      state.addressBook.push(data);
    },

    MODIFY_ADDRESS(state, data) {
      let list = state.addressBook;

      for (let i = 0; i < list.size; i++) {
        if (list[i].shipaddress_id == data.shipaddress_id) {
          list[i] = data;
          break;
        }
      }
    },

    DELETE_ADDRESS(state, data) {
      let index = state.addressBook.findIndex((i) => i.shipaddress_id == data);
      state.addressBook.splice(index, 1);
    },

    GET_PRODUCT_DETAILS(state, data) {
      state.product_details.push(data);
    },
  },
  actions: {
    // 유저 id에 해당하는 배송 주소록 받아오기
    getAddressBook({ commit }, userid) {
      http
        .get('/shipping/list/' + userid)
        .then((response) => {
          // 응답 status 체크
          if (response.status == 200) {
            // state에 저장
            commit('GET_ADDRESS_BOOK', response.data);
          } else {
            alert('배송 주소록 받아오기 실패!');
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },

    // 초기 받는사람정보를 초기화한다. 로그인된 유저의 기본 배송지로
    initReceiverInfo({ commit }) {
      commit('INIT_RECEIVER_INFO');
    },

    // 리시버 정보를 변경한다
    updateReceiver({ commit }, addr) {
      commit('UPDATE_RECEIVER', addr);
    },

    // 배송 주소록 추가
    addAddress({ commit }, addr) {
      console.log(addr);
      http
        .post('/shipping/add', addr)
        .then((response) => {
          if (response.status == 200) {
            commit('ADD_ADDRESS', addr);
          } else {
            alert('주소록 추가 실패!');
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },

    // 배송 주소록 수정
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    modifyAddress({ commit }, addr) {
      http
        .put('--', addr)
        .then((response) => {
          if (response.status == 200) {
            commit('MODIFY_ADDRESS', addr);
          } else {
            alert('주소록 수정 실패!');
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },

    // 배송 주소록 삭제
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    deleteAddress({ commit }, id) {
      http
        .delete('--/' + id)
        .then((response) => {
          if (response.status == 200) {
            commit('DELETE_ADDRESS', id);
          } else {
            alert('주소록 삭제 실패!');
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },

    // 전체 주문 목록을 받아온다.
    getOrderList({ commit }, userid) {
      http
        .get('/order/' + userid)
        .then((res) => {
          if (res.status == 200) {
            commit('GET_ORDER_LIST', res.data);
          } else {
            alert('주문목록을 받아오는데 실패하였습니다.');
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // get product_details
    getProductDetails({ commit }, product_id) {
      http
        .get('/product/detailview/' + product_id)
        .then((res) => {
          if (res.status == 200) {
            commit('GET_PRODUCT_DETAILS', res.data);
          } else {
            alert('상품정보 로딩 실패');
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
