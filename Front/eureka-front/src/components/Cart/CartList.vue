<template>
  <div class="container-table-cart pos-relative">
    <div class="wrap-table-shopping-cart bgwhite">
      <table class="table-shopping-cart">
        <!-- thead -->
        <tr class="table-head">
          <th class="column-1">
            <input
              type="checkbox"
              title="모든 상품을 결제상품으로 설정"
              id="allCheck"
              v-model="isAllChecked"
            />
          </th>
          <th class="column-3" @click="sortBy('productName')">상품정보</th>
          <th class="column-4" @click="sortBy('price')">개당가격</th>
          <th class="column-5 p-l-70" @click="sortBy('quantity')">수량</th>
          <th class="column-6" @click="sortBy('totalPrice')">총금액</th>
          <th class="column-7" @click="sortBy('deliveryCharge')">배송비</th>
          <th class="column-7" @click="sortBy('expectedArrivalDate')">
            도착예정일
          </th>
        </tr>

        <!-- 상품 하나 정보 -->
        <template v-for="(item, index) in items" :key="`${index}_item`">
          <tr class="table-row">
            <!-- 체크 박스 -->
            <td class="column-1">
              <input
                type="checkbox"
                :value="`${index}`"
                v-model="checkedIndex"
              />
            </td>
            <!-- 이미지 - 클릭 시 삭제 -->
            <td class="column-2">
              <div
                class="cart-img-product b-rad-4 o-f-hidden"
                @click="deleteItem(item.id)"
              >
                <img :src="item.image" alt="IMG-PRODUCT" />
              </div>
            </td>
            <!-- 상품명 -->
            <td class="column-2">{{ item.title }}</td>
            <!-- 상품 개당 가격 -->
            <td class="column-3">{{ $filters.price(item.price) }}개</td>
            <!-- 수량 -->
            <td class="column-4">
              <div class="flex-w bo5 of-hidden w-size17">
                <button
                  class="btn-num-product-down color1 flex-c-m size7 bg8 eff2"
                  @click="decreaseQuantity(item.id)"
                >
                  <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                </button>

                <input
                  class="size8 m-text18 t-center num-product"
                  type="number"
                  name="num-product1"
                  :value="item.quantity"
                />

                <button
                  class="btn-num-product-up color1 flex-c-m size7 bg8 eff2"
                  @click="increaseQuantity(item.id)"
                >
                  <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                </button>
              </div>
              <!-- 총 금액 => 개당 금액 * 수량 -->
            </td>
            <td class="column-5">
              {{ $filters.price(item.price * item.quantity) }}원
            </td>
            <!-- 배송비 -->
            <td class="column-6">
              {{ $filters.price(item.deliveryCharge) }}원
            </td>
            <!-- 도착예정일 -->
            <td class="column-7">
              {{ $filters.date(item.ead) }}
            </td>
          </tr>
        </template>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      checkedIndex: [], // 여러 체크박스를 한 배열에 바인딩
    };
  },
  computed: {
    // // 전체선택 체크박스 체크 여부 state에서 가져오기
    // isAllChecked() {
    //   get() {
    //     for (var i = 0; i < items.length; i++) {
    //       if (!items[i].checked) {
    //         return false;
    //       }
    //       return true;
    //     }
    //   },
    //   set(val) {
    //     items.forEach((item) => item.checked = val;)
    //   }
    // },
    // 장바구니 리스트 가져오기
    items() {
      return this.$store.state.cart.items;
    },
  },
  methods: {
    // 리스트에서 해당 상품 삭제
    deleteItem(id) {
      this.$store.dispatch('cart/deleteItem', id);
    },
    // 해당 상품 수량 증가
    increaseQuantity(id) {
      this.$store.dispatch('cart/increaseQuantity', id);
    },
    // 해당 상품 수량 감소
    decreaseQuantity(id) {
      this.$store.dispatch('cart/decreaseQuantity', id);
    },
  },
};
</script>

<style></style>
