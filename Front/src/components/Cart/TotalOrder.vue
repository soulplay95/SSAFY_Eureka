<template>
  <!-- 주문표 -->
  <el-card class="box-card" style="margin-top: 30px">
    <template #header>
      <div class="card-header">
        <span>결제 예정 금액</span>
      </div>
    </template>
    <div class="text item">
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
      <div class="flex-w flex-sb-m p-t-26 p-b-30" style="margin-top: 10px">
        <span class="m-text22 w-size19 w-full-sm">
          <strong>Total: </strong></span
        >

        <span
          class="m-text21 w-size20 w-full-sm"
          style="color: blue; font-size: 20px"
        >
          <strong>{{ $filters.price(totalPrice) }}원</strong>
        </span>
      </div>

      <div class="size15 trans-0-4" style="margin-top: 10px">
        <!-- Button -->
        <el-button type="primary" round @click="go(checked)"
          >결제하기</el-button
        >
      </div>
    </div>
  </el-card>
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
    async go(checked) {
      if (checked.length == 0) {
        alert('1개 이상의 상품을 선택해주세요');
      } else {
        try {
          await this.$router.push({ name: 'OrderView' });
        } catch (err) {
          throw new Error(`Problem handling something: ${err}.`);
        }
      }
    },
  },
};
</script>

<style></style>
