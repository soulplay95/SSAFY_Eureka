// 장바구니 store 모듈
export const cart = {
  namespaced: true,
  state: () => ({
    // 장바구니 리스트
    // 회원의 경우 userid로 서버와 통신하여 얻어온다.
    // 비회원의 경우
    // 상품 id, 수량
    items: [
      {
        id: 1,
        image: 'https://picsum.photos/720/960/?image=476',
        title: '비비고 열무김치',
        price: 75000,
        badge: 'new',
        quantity: 1,
        deliveryCharge: 2500,
        ead: '2012-07-13T18:25:43.511Z',
      },
      {
        id: 2,
        image: 'https://picsum.photos/720/960/?image=478',
        title: '동원 비엔나',
        price: 92500,
        badge: null,
        quantity: 2,
        deliveryCharge: 3000,
        ead: '2016-04-23T18:25:43.511Z',
      },
      {
        id: 3,
        image: 'https://picsum.photos/720/960/?image=479',
        title: '에어팟 프로',
        price: 165900,
        badge: null,
        quantity: 3,
        deliveryCharge: 5000,
        ead: '2020-12-30T18:25:43.511Z',
      },
    ],
    checkAll: false, // 전체 선택
    checked: [], // 선택된 상품 id
    totalProductPrice: 0, // (선택된) 전체 상품 금액
    totalDeliveryPrice: 0, // (선택된) 전체 배송비
  }),
  getters: {
    // (선택된) 전체 상품 금액
    totalProductPrice(state) {
      let sum = 0;
      for (let i = 0; i < state.checked.length; i++) {
        for (let j = 0; j < state.items.length; j++) {
          if (state.items[j].id === state.checked[i]) {
            sum += state.items[j].price * state.items[j].quantity;
          }
        }
      }
      state.totalProductPrice = sum;
      return sum;
    },
    // (선택된) 전체 배송비
    totalDeliveryPrice(state) {
      let sum = 0;
      for (let i = 0; i < state.checked.length; i++) {
        for (let j = 0; j < state.items.length; j++) {
          if (state.items[j].id === state.checked[i]) {
            sum += state.items[j].deliveryCharge;
          }
        }
      }
      state.totalDeliveryPrice = sum;
      return sum;
    },
    // 주문시 총 결제 금액
    totalPrice(state) {
      return state.totalProductPrice + state.totalDeliveryPrice;
    },
  },
  mutations: {
    DELETE_ITEM(state, id) {
      // items를 업데이트
      // filter : 콜백함수에 지정된 조건에 맞는 요소를 새롭게 반환
      state.items = state.items.filter((item) => item.id !== id);
      // checkd 업데이트
      const index = state.checked.findIndex((iid) => iid === id);

      state.checked.splice(index, 1);
    },
    // 사용자가 입력한 수량으로 변경
    UPDATE_QUANTITY(state, { id, quantity }) {
      const cartItem = state.items.filter((cartItem) => cartItem.id === id);

      // id에 해당하는 상품이 있으면
      if (cartItem.length !== 0) {
        // 수량이 0 밑으로 내려가면 해당 아이템을 리스트에서 삭제
        if (quantity <= 0) {
          const index = state.checked.findIndex((iid) => iid === id);

          state.checked.splice(index, 1);
          // 삭제
          const index2 = state.items.findIndex(
            (cartItem) => cartItem.id === id
          );

          state.items.splice(index2, 1);
        } else {
          cartItem[0].quantity = quantity;
        }
      }
    },
    // 수량 변경 - 상품의 수량을 quantity의 값으로 변경한다.
    CHANGE_QUANTITY(state, { id, quantity }) {
      // id에 해당하는 상품을 참조
      quantity = Number(quantity);
      const cartItem = state.items.filter((cartItem) => cartItem.id === id);

      // id에 해당하는 상품이 있으면
      if (cartItem.length !== 0) {
        // 수량이 0 밑으로 내려가면 해당 아이템을 리스트에서 삭제
        if (cartItem[0].quantity + quantity <= 0) {
          // checkd 업데이트
          const index = state.checked.findIndex((iid) => iid === id);

          state.checked.splice(index, 1);
          // 삭제
          const index2 = state.items.findIndex(
            (cartItem) => cartItem.id === id
          );

          state.items.splice(index2, 1);
        } else {
          let cc = Number(cartItem[0].quantity);
          cartItem[0].quantity = cc + quantity;
        }
      }
    },
    UPDATE_CHECKED(state, value) {
      // 일단 비우고 업데이트
      state.checked = [];

      for (let i = 0; i < value.length; i++) {
        state.checked.push(value[i]);
      }
    },
  },
  actions: {
    // 아이템 삭제 - id로 장바구니 리스트에서 해당 아이템을 삭제한다.
    deleteItem({ commit }, id) {
      commit('DELETE_ITEM', id);
    },
    // 수량 1증가 - id에 해당하는 상품의 수량을 1 증가시킨다.
    increaseQuantity({ commit }, id) {
      commit('CHANGE_QUANTITY', {
        id,
        quantity: 1,
      });
    },
    // 수량 1감소 - id에 해당하는 상품의 수량을 1 감소시킨다.
    decreaseQuantity({ commit }, id) {
      commit('CHANGE_QUANTITY', {
        id,
        quantity: -1,
      });
    },
    // checked 수정
    updateChecked({ commit }, value) {
      commit('UPDATE_CHECKED', value);
    },
  },
};
