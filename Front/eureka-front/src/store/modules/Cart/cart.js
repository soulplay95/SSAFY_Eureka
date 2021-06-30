import http from '@/utils/http-common';

// 장바구니 store 모듈
export const cart = {
  namespaced: true,
  state: () => ({
    items: [], // 장바구니 리스트
    checkAll: false, // 전체 선택 check 여부
    checked: [], // check된 상품 id
    totalProductPrice: 0, // (선택된) 전체 상품 금액
    totalDeliveryPrice: 0, // (선택된) 전체 배송비
    totalDiscountPrice: 0, // (선택된) 전체 할인 금액
  }),
  getters: {
    // (선택된) 전체 상품 금액
    totalProductPrice(state) {
      let sum = 0;
      for (let i = 0; i < state.checked.length; i++) {
        for (let j = 0; j < state.items.length; j++) {
          if (state.items[j].product_id === state.checked[i]) {
            sum += state.items[j].product_price * state.items[j].quantity;
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
          if (state.items[j].product_id === state.checked[i]) {
            sum += Number(state.items[j].product_deliveryprice);
          }
        }
      }
      state.totalDeliveryPrice = sum;
      return sum;
    },
    // 총 할인 금액
    totalDiscountPrice(state) {
      let sum = 0;
      for (let i = 0; i < state.checked.length; i++) {
        for (let j = 0; j < state.items.length; j++) {
          if (state.items[j].product_id === state.checked[i]) {
            sum +=
              state.items[j].product_price *
              (state.items[j].product_discount / 100);
          }
        }
      }

      let ret = Math.floor(sum);
      ret = Math.floor(ret / 10) * 10;
      state.totalDiscountPrice = ret;
      return ret;
    },
    // 주문시 총 결제 금액
    totalPrice(state) {
      return (
        state.totalProductPrice +
        state.totalDeliveryPrice -
        state.totalDiscountPrice
      );
    },
  },
  mutations: {
    // 장바구니 불러오기
    GET_ITEMS(state, list) {
      state.items = list;
    },
    DELETE_ITEM(state, id) {
      // items를 업데이트
      // filter : 콜백함수에 지정된 조건에 맞는 요소를 새롭게 반환
      state.items = state.items.filter((item) => item.product_id !== id);
      // checkd 업데이트
      const index = state.checked.findIndex((iid) => iid === id);

      state.checked.splice(index, 1);
    },
    // 사용자가 입력한 수량으로 변경
    UPDATE_QUANTITY(state, { id, quantity }) {
      const cartItem = state.items.filter(
        (cartItem) => cartItem.product_id === id
      );

      // id에 해당하는 상품이 있으면
      if (cartItem.length !== 0) {
        // 수량이 0 밑으로 내려가면 해당 아이템을 리스트에서 삭제
        if (quantity <= 0) {
          const index = state.checked.findIndex((iid) => iid === id);

          state.checked.splice(index, 1);
          // 삭제
          const index2 = state.items.findIndex(
            (cartItem) => cartItem.product_id === id
          );

          state.items.splice(index2, 1);
        } else {
          cartItem[0].quantity = quantity;
        }
      }
    },
    // 수량 변경 - 상품의 수량을 quantity의 값으로 변경한다.
    // CHANGE_QUANTITY(state, { id, quantity }) {
    //   // id에 해당하는 상품을 참조
    //   quantity = Number(quantity);
    //   const cartItem = state.items.filter(
    //     (cartItem) => cartItem.product_id === id
    //   );

    //   // id에 해당하는 상품이 있으면
    //   if (cartItem.length !== 0) {
    //     // 수량이 0 밑으로 내려가면 해당 아이템을 리스트에서 삭제
    //     if (cartItem[0].quantity + quantity <= 0) {
    //       // checkd 업데이트
    //       const index = state.checked.findIndex((iid) => iid === id);

    //       state.checked.splice(index, 1);
    //       // 삭제
    //       const index2 = state.items.findIndex(
    //         (cartItem) => cartItem.product_id === id
    //       );

    //       state.items.splice(index2, 1);
    //     } else {
    //       let cc = Number(cartItem[0].quantity);
    //       cartItem[0].quantity = cc + quantity;
    //     }
    //   }
    // },
    UPDATE_CHECKED(state, value) {
      // 일단 비우고 업데이트
      state.checked = [];

      for (let i = 0; i < value.length; i++) {
        state.checked.push(value[i]);
      }
    },
  },
  actions: {
    // 장바구니 불러오기
    getItems({ commit }, userid) {
      http
        .get('/cart/' + userid)
        .then((response) => {
          console.log(response.data);
          commit('GET_ITEMS', response.data);
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    // 아이템 삭제 - id로 장바구니 리스트에서 해당 아이템을 삭제한다.
    deleteItem({ commit }, ids) {
      // @RequestParam => member_userid, product_id
      http
        .delete(
          '/cart/delete?member_userid=' + ids.userid + '&product_id=' + ids.id
        )
        .then((response) => {
          if (response.status == 200) {
            this.getItems(ids.userid);
            commit('DELETE_ITEM', ids.id);
          } else {
            alert('삭제 실패!');
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    // 상품 수량 변경
    updateQuantity({ commit }, info) {
      console.log(info);
      http
        .put('/cart', info)
        .then((response) => {
          if (response.status == 200) {
            commit('UPDATE_QUANTITY', {
              id: info.product_id,
              quantity: info.quantity,
            });
          } else {
            alert('상품 수량 변경 실패!');
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    // checked 수정
    updateChecked({ commit }, value) {
      commit('UPDATE_CHECKED', value);
    },
  },
};
