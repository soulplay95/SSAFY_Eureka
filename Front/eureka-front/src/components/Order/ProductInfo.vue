<template>
  <div>
    <h2>주문상품 정보</h2>
    <!-- Card 형식으로 여러개 띄워준다. -->
    <div
      class="card mb-3"
      style="max-width: 100%; justify-content: center; align-items: center"
      v-for="(item, index) in selectedProducts"
      :key="`${index}_item`"
    >
      <div class="row g-0" style="justify-content: center; align-items: center">
        <div class="col-md-4">
          <img
            :src="item.product_img"
            class="img-fluid rounded-start"
            alt="상품 메인 이미지"
            @click="showDetail(item.product_id)"
          />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <!-- <h5 class="card-title">{{ item.title }}</h5> -->
            <p class="card-text">
              {{ item.seller_name }}
            </p>
            <p class="card-text">
              <router-link
                style="text-decoration: none"
                :to="'/item/item-detail?product_id=' + item.product_id"
                >{{ item.product_name }}</router-link
              >
            </p>
            <p class="card-text">
              <del v-if="item.product_discount > 0">
                {{ $filters.price(item.product_price * item.quantity) }}원
                <br />
              </del>
              <b v-if="item.product_discount > 0">
                {{
                  $filters.price(
                    Math.floor(
                      (item.product_price *
                        (1 - item.product_discount / 100) *
                        item.quantity) /
                        10
                    ) * 10
                  )
                }}원
              </b>
              <b v-else>
                {{ $filters.price(item.product_price * item.quantity) }}원
              </b>
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
  name: 'productInfo',
  computed: {
    // 주문 예정(장바구니에서 선택된) 상품 정보
    selectedProducts() {
      return this.$store.getters['cart/selectedProducts'];
    },
  },
  methods: {
    showDetail(productId) {
      this.$router.push('/item/item-detail?product_id=' + productId);
      // this.$router.push({ name: 'ItemDetail', query: productId });
    },
  },
};
</script>

<style></style>
