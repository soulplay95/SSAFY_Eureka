<template>
  <div>
    <h2>주문상품 정보</h2>
    <!-- Card 형식으로 여러개 띄워준다. -->
    <div
      class="card mb-3"
      style="max-width: 540px"
      v-for="(item, index) in selectedProducts"
      :key="`${index}_item`"
    >
      <div class="row g-0">
        <div class="col-md-4">
          <img
            :src="item.product_img"
            class="img-fluid rounded-start"
            alt="상품 메인 이미지"
          />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <!-- <h5 class="card-title">{{ item.title }}</h5> -->
            <p class="card-text">
              {{ item.seller_name }}
            </p>
            <p class="card-text">
              {{ item.product_name }}
            </p>
            <p class="card-text">
              <del v-if="item.product_discount > 0">
                {{ $filters.price(item.price * item.quantity) }}원
              </del>
              <b v-else> {{ $filters.price(item.price * item.quantity) }}원 </b>
              /
              <b> {{ item.quantity }}개 </b>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'payInfo',
  computed: {
    // 주문 예정(장바구니에서 선택된) 상품 정보
    selectedProducts() {
      let items = this.$store.state.cart.items;
      let checked = this.$store.state.cart.checked;
      let selectedItems = [];

      // checked 배열을 순회하여 선택된 id와 일치하는 상품을 push한다.
      checked.forEach((id) => {
        selectedItems.push(items.filter((item) => item.id === id));
      });

      return selectedItems;
    },
  },
};
</script>

<style></style>
