<template>
  <!-- 주문표 -->
  <div
    class="
      bo9
      w-size18
      p-l-40 p-r-40 p-t-30 p-b-38
      m-t-30 m-r-0 m-l-auto
      p-lr-15-sm
    "
  >
    <h5 class="m-text20 p-b-24">주문표</h5>

    <!--  -->
    <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
      <span class="s-text18 w-size19 w-full-sm"> 총 상품수 : </span>
      <span class="m-text21 w-size20 w-full-sm">
        {{ checked.length }}
      </span>
    </div>
    <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
      <span class="s-text18 w-size19 w-full-sm"> 총 상품금액 : </span>
      <span class="m-text21 w-size20 w-full-sm">
        {{ $filters.price(totalProductPrice) }}원
      </span>
    </div>
    <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
      <span class="s-text18 w-size19 w-full-sm"> 총 할인금액: </span>
      <span class="m-text21 w-size20 w-full-sm">
        {{ $filters.price(totalDiscountPrice) }}원
      </span>
    </div>
    <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
      <span class="s-text18 w-size19 w-full-sm"> 총 배송비: </span>
      <span class="m-text21 w-size20 w-full-sm">
        {{ $filters.price(totalDeliveryPrice) }}원
      </span>
    </div>

    <!--  -->
    <div class="flex-w flex-sb-m p-t-26 p-b-30">
      <span class="m-text22 w-size19 w-full-sm"> Total: </span>

      <span class="m-text21 w-size20 w-full-sm">
        {{ $filters.price(totalPrice) }}원
      </span>
    </div>

    <div class="size15 trans-0-4">
      <!-- Button -->
      <button
        class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"
        @click="go()"
      >
        구매하기
      </button>
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
    checked: {
      get() {
        return this.$store.state.cart.checked;
      },
      set(value) {
        this.$store.state.cart.checked = value;
      },
    },
    totalProductPrice() {
      return this.$store.getters['cart/totalProductPrice'];
    },
    totalDeliveryPrice() {
      return this.$store.getters['cart/totalDeliveryPrice'];
    },
    totalPrice() {
      return this.$store.getters['cart/totalPrice'];
    },
    totalDiscountPrice() {
      return this.$store.getters['cart/totalDiscountPrice'];
    },
  },
  methods: {
    go() {
      this.$router.push('/order');
    },
  },
};
</script>

<style></style>
