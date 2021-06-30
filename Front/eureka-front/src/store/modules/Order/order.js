import http from '@/utils/http-common';

export const order = {
  namespaced: true,
  state: () => ({
    // 로그인된 유저의 배송 주소록
    addressBook: [
      {
        id: 1,
        name: '전도명',
        address: '경기도 안양시',
        phone: '010-4412-2231',
        request: '문 앞',
        type: 1,
        member_id: 'ab@naver.com',
      },
      {
        id: 2,
        name: '김구라',
        address: '서울시',
        phone: '010-2222-2331',
        request: '경비실',
        type: 2,
        member_id: 'ab@naver.com',
      },
      {
        id: 3,
        name: '유재석',
        address: '광주광역시',
        phone: '010-3333-2231',
        request: '택배함',
        type: 2,
        member_id: 'ab@naver.com',
      },
    ],
    // 받는사람정보(배송 주소록 리스트 중 선택된 주소록)
    receiverInfo: {},
  }),
  getters: {},
  mutations: {
    // 받아온 배송 주소록 state에 저장
    GET_ADDRESS_BOOK(state, list) {
      state.addressBook = list;
    },
    // 기본 배송지로 초기화
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
        state.receiverInfo = state.addressBook[0]; // 주소록의 맨 첫번째 주소를 기본 배송지로
      }
    },
    // 리시버 정보 변경
    UPDATE_RECEIVER(state, addr) {
      state.receiverInfo = addr;
    },
    // 기본 배송지 -> 일반 배송지로 변경
    RESET_DEFAULT_ADDRESS(state) {
      // 기존 기본 배송지 일반 배송지로 바꾸기
      for (let i = 0; i < state.addressBook.length; i++) {
        if (state.addressBook[i].type == 1) {
          state.addressBook[i].type = 2;
          break;
        }
      }
    },
  },
  actions: {
    // 유저 id에 해당하는 배송 주소록 받아오기
    getAddressBook({ commit }, id) {
      // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력
      http
        .get('--', id)
        .then((response) => {
          // 응답 status 체크
          if (response.status == 200) {
            // 성공
            commit('GET_ADDRESS_BOOK', response.data);
          } else {
            // 실패
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
    // 기본 배송지 -> 일반 배송지로 변경
    resetDefaultAddress({ commit }) {
      commit('RESET_DEFAULT_ADDRESS');
    },
    // 배송 주소록 추가
    addAddress(addr) {
      // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력
      http
        .post('--', addr)
        .then((response) => {
          if (response.status == 200) {
            // 성공하면 addressBook 업데이트
            this.getAddressBook(addr.member_id);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 배송 주소록 수정
    modifyAddress(addr) {
      // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력
      http
        .put('--', addr)
        .then((response) => {
          if (response.status == 200) {
            // 성공하면 addressBook 업데이트
            this.getAddressBook(addr.member_id);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 배송 주소록 삭제
    deleteAddress(id, userid) {
      // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TODO: 백엔드에서 정해진 url 입력
      http
        .delete('--/' + id)
        .then((response) => {
          if (response.status == 200) {
            // 성공하면 addressBook 업데이트
            this.getAddressBook(userid);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
