<template>
  <div class="container-table-cart pos-relative">
    <div class="wrap-table-shopping-cart">
      <table class="table-shopping-cart" v-if="items.length">
        <!-- thead -->
        <tr class="table-head">
          <th class="column-1">
            <input
              type="checkbox"
              title="모든 상품을 결제상품으로 설정"
              v-model="checkAll"
              @click="allCheck"
            />
          </th>
          <th class="column-2"></th>
          <th class="column-3" @click="sortBy('product_name')">상품정보</th>
          <th class="column-4" @click="sortBy('product_price')">개당가격</th>
          <th class="column-5 p-l-70" @click="sortBy('quantity')">수량</th>
          <th class="column-6" @click="sortBy('totalPrice')">총금액</th>
          <th class="column-7" @click="sortBy('product_deliveryprice')">
            배송비
          </th>
        </tr>

        <!-- 상품 하나 정보 -->
        <template v-for="(item, index) in items" :key="`${index}_item`">
          <tr class="table-row">
            <!-- 체크 박스 -->
            <td class="column-1">
              <input
                type="checkbox"
                :value="item.product_id"
                v-model="checked"
              />
            </td>
            <!-- 이미지 - 클릭 시 삭제 -->
            <td class="column-2">
              <div
                class="cart-img-product b-rad-4 o-f-hidden"
                @click="deleteItem(item.product_id)"
              >
                <img :src="item.product_img" alt="IMG-PRODUCT" />
              </div>
            </td>
            <!-- 상품명 -->
            <td class="column-3">
              <router-link
                style="text-decoration: none"
                :to="'/item/item-detail?product_id=' + item.product_id"
                >{{ item.product_name }}</router-link
              >
            </td>
            <!-- 상품 개당 가격 -->
            <td class="column-4">{{ $filters.price(item.product_price) }}원</td>
            <!-- 수량 -->
            <td class="column-5" style="padding-left: 70px">
              <div class="flex-w bo5 of-hidden w-size17" style="border: 0px">
                <!-- <button
                  class="btn-num-product-down color1 flex-c-m size7 bg8 eff2"
                  value="-"
                  
                >
                  <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                </button> -->
                <el-button
                  icon="el-icon-minus"
                  circle
                  @click="decreaseQuantity(item.product_id, item.quantity - 1)"
                ></el-button>

                <input
                  class="size8 m-text18 t-center num-product bo5 of-hidden"
                  type="number"
                  name="num-product1"
                  :value="item.quantity"
                  @blur="updateQuantity(item.product_id, $event)"
                />

                <el-button
                  icon="el-icon-plus"
                  circle
                  @click="increaseQuantity(item.product_id, item.quantity + 1)"
                ></el-button>
                <!-- <button
                  class="btn-num-product-up color1 flex-c-m size7 bg8 eff2"
                  
                >
                  <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                </button> -->
              </div>
              <!-- 총 금액 => 개당 금액 * 수량 -->
            </td>
            <td class="column-6">
              {{ $filters.price(item.product_price * item.quantity) }}원
            </td>
            <!-- 배송비 -->
            <td class="column-7">
              {{ $filters.price(item.product_deliveryprice) }}원
            </td>
          </tr>
        </template>
      </table>
      <div v-else>장바구니가 비어 있습니다.</div>
    </div>
  </div>
</template>
<script>
export default {
  computed: {
    // 장바구니 리스트 가져오기
    items: {
      get() {
        return this.$store.state.cart.items;
      },
      set(value) {
        this.$store.state.cart.items = value;
      },
    },
    checkAll: {
      get() {
        return this.$store.state.cart.checkAll;
      },
      set(value) {
        this.$store.state.cart.checkAll = value;
      },
    },
    checked: {
      get() {
        return this.$store.state.cart.checked;
      },
      set(value) {
        this.$store.state.cart.checked = value;
      },
    },
  },
  methods: {
    // 리스트에서 해당 상품 삭제
    deleteItem(id) {
      this.$store.dispatch('cart/deleteItem', {
        id: id,
        userid: this.$store.state.userStore.user.member_userid,
      });
    },
    // 해당 상품 수량 증가
    increaseQuantity(id, quantity) {
      this.$store.dispatch('cart/updateQuantity', {
        product_id: id,
        member_userid: this.$store.state.userStore.user.member_userid,
        quantity: quantity,
      });
    },
    // 해당 상품 수량 감소
    decreaseQuantity(id, quantity) {
      if (quantity < 1) {
        // 상품 삭제
        this.$store.dispatch('cart/deleteItem', {
          id: id,
          userid: this.$store.state.userStore.user.member_userid,
        });
      } else {
        this.$store.dispatch('cart/updateQuantity', {
          product_id: id,
          member_userid: this.$store.state.userStore.user.member_userid,
          quantity: quantity,
        });
      }
    },
    // 전체 선택
    allCheck() {
      // 일단 모두 체크 해제
      let checkedIndex = [];
      // 이미 체크 되어 있으면 눌렀을 때 모두 체크 해제
      if (this.checkAll) {
        this.$store.dispatch('cart/updateChecked', checkedIndex);
      } else {
        this.items.forEach((item) => {
          checkedIndex.push(item.product_id);
        });
        this.$store.dispatch('cart/updateChecked', checkedIndex);
      }
    },
    // 정렬
    sortBy(key) {
      // 총금액에 대해 정렬하려면
      if (key == 'totalPrice') {
        this.items.sort((a, b) => {
          return a.product_price * a.quantity - b.product_price * b.quantity;
        });
      } else {
        this.items.sort(function (a, b) {
          return a[key] - b[key];
        });
      }
    },
    // 수량 업데이트
    updateQuantity(id, e) {
      let inputQuantity = e.target.value;
      if (inputQuantity <= 0) {
        // 상품 삭제
        this.$store.dispatch('cart/deleteItem', {
          id: id,
          userid: this.$store.state.userStore.user.member_userid,
        });
      } else {
        this.$store.dispatch('cart/updateQuantity', {
          product_id: id,
          member_userid: this.$store.state.userStore.user.member_userid,
          quantity: inputQuantity,
        });
      }
    },
  },
};
</script>

<style scoped>
.color1 {
  color: #888888;
}

.flex-c-m {
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  justify-content: center;
  -ms-align-items: center;
  align-items: center;
}

.size7 {
  width: 42px;
  height: 41px;
}

.bg8 {
  background-color: white;
}

.eff2:active {
  background-color: #e65540;
  color: white;
}

.size8 {
  width: 50px;
  height: 41px;
}
.m-text18 {
  font-family: Montserrat-Regular;
  font-size: 16px;
  color: #666666;
  line-height: 1.2;
}
.t-center {
  text-align: center;
}
input.num-product {
  -moz-appearance: textfield;
  appearance: none;
  -webkit-appearance: none;
}

input.num-product::-webkit-outer-spin-button,
input.num-product::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.wrap-table-shopping-cart {
  overflow: auto; /* 박스에 내용이 더 길때 어떻게 보일지 지정. 내용이 잘릴 때만 스크롤바가 보임*/
  background-color: white;
}

.bo5 {
  border: 2px solid #e6e6e6;
  border-radius: 3px;
}

.w-size17 {
  width: 138px;
}

.of-hidden {
  overflow: hidden;
}

/* 가상 요소 지정. 태그 대신에 가상으로 처리 */
.container-table-cart::before {
  content: ''; /* 필수 요소 */
  display: block;
  position: absolute; /* 독립된 배치 문맥을 가짐 */
  width: 1px;
  height: calc(100% - 51px); /* 반응형 높이 영역 지정 */
  background-color: #e6e6e6;
  top: 51px; /* 상단 기준점에서 몇 px 만큼 밑으로 내려 위치시킬지 지정*/
  left: 0;
}

.pos-relative {
  position: relative;
}

.container-table-cart::after {
  content: '';
  display: block;
  position: absolute;
  width: 1px;
  height: calc(100% - 51px);
  background-color: #e6e6e6;
  top: 51px;
  right: 0;
}

.table-shopping-cart {
  border-collapse: collapse; /* 테이블의 테두리와 셀 테두리 사이의 간격을 없앰 */
  width: 100%;
  min-width: 992px;
}

.table-shopping-cart .table-row {
  border-top: 1px solid #e6e6e6;
  border-bottom: 1px solid #e6e6e6;
}

.table-shopping-cart .column-1 {
  width: 100px;
  padding-left: 30px;
}
.table-shopping-cart .column-2 {
  width: 125px;
  padding-left: 50px;
}
.table-shopping-cart .column-3 {
  width: 330px;
  padding-right: 30px;
}
.table-shopping-cart .column-4 {
  width: 133px;
  padding-right: 30px;
}
.table-shopping-cart .column-5 {
  width: 355px;
  padding-right: 30px;
}
.table-shopping-cart .column-6 {
  width: 155px;
  padding-right: 20px;
}
.table-shopping-cart .column-7 {
  width: 150px;
  padding-right: 40px;
}
.table-shopping-cart .column-8 {
  widows: 100px;
  padding-left: 20px;
  padding-right: 30px;
}

.flex-w {
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-wrap: wrap;
  -moz-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  -o-flex-wrap: wrap;
  flex-wrap: wrap;
}

.table-shopping-cart .table-head th {
  font-family: Montserrat-Bold;
  font-size: 13px;
  color: #555555;
  line-height: 1.5;
  text-transform: uppercase;
  padding-top: 16px;
  padding-bottom: 16px;
}

.table-shopping-cart td {
  font-family: Montserrat-Regular;
  font-size: 16px;
  color: #555555;
  line-height: 1.5;
  padding-top: 37px;
  padding-bottom: 30px;
}

.table-shopping-cart .table-row .column-2 {
  font-size: 15px;
}

/* ------------------------------------ */
.cart-img-product {
  width: 90px;
  position: relative;
}

.cart-img-product img {
  width: 100%;
}

.cart-img-product::after {
  content: 'x';
  font-family: Linearicons;
  font-size: 16px;
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
  -o-transition: all 0.3s;
  -moz-transition: all 0.3s;
  opacity: 0;
}

.cart-img-product:hover:after {
  cursor: pointer;
  opacity: 1;
}
</style>
