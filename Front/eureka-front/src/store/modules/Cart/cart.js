// 장바구니 store 모듈
export const cart = {
  namespaced: true,
  state: () => ({
    items: [
      {
        id: 1,
        image: 'https://picsum.photos/720/960/?image=476',
        title: 'Herschel supply co 25l',
        link: '',
        price: 75000,
        badge: 'new',
        quantity: 1,
        deliveryCharge: 2500,
        ead: '2012-07-13T18:25:43.511Z',
      },
      {
        id: 2,
        image: 'https://picsum.photos/720/960/?image=478',
        title: 'Denim jacket blue',
        link: '',
        price: 92500,
        badge: null,
        quantity: 2,
        deliveryCharge: 3000,
        ead: '2016-04-23T18:25:43.511Z',
      },
      {
        id: 3,
        image: 'https://picsum.photos/720/960/?image=479',
        title: 'Coach slim easton black',
        link: '',
        price: 165900,
        badge: null,
        quantity: 3,
        deliveryCharge: 5000,
        ead: '2020-12-30T18:25:43.511Z',
      },
    ], // 장바구니 리스트
    totalProductCounts: 0, // 장바구니에 담긴 전체 상품 종류 수
    selectedProductCounts: 0, // 선택된 상품 종류 수
    isAllChecked: true, // 전체 선택 체크 여부
  }),
  getters: {},
  mutations: {
    DELETE_ITEM(state, id) {
      // items를 업데이트
      // filter : 콜백함수에 지정된 조건에 맞는 요소를 새롭게 반환
      state.items = state.items.filter((item) => item.id !== id);
    },
    // 수량 변경 - 상품의 수량을 quantity의 값으로 변경한다.
    CHANGE_QUANTITY(state, { id, quantity }) {
      // id에 해당하는 상품을 참조
      const cartItem = state.items.filter((cartItem) => cartItem.id === id);

      // id에 해당하는 상품이 있으면
      if (cartItem.length !== 0) {
        // 수량이 0 밑으로 내려가면 해당 아이템을 리스트에서 삭제
        if (cartItem[0].quantity + quantity <= 0) {
          const index = state.items.findIndex((cartItem) => cartItem.id === id);

          state.items.splice(index, 1);
        } else {
          cartItem[0].quantity += quantity;
        }
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
  },
};
