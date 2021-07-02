<template>
  <div>
    <!-- Header - title -->
    <section
      class="bg-title-page flex-col-c-m"
      style="background-image: url(https://picsum.photos/1920/239/?image=1031)"
    >
      <h2 class="l-text2 t-center">주문/결제</h2>
    </section>

    <!-- Contents -->
    <section class="cart bgwhite">
      <div class="container">
        <!-- 고객정보 -->
        <customer-info />

        <!-- 상품정보 -->
        <product-info />

        <!-- 결제정보 -->
        <pay-info />
      </div>
    </section>
  </div>
</template>

<script>
import CustomerInfo from "@/components/Order/CustomerInfo.vue";
import ProductInfo from "@/components/Order/ProductInfo.vue";
import PayInfo from "@/components/Order/PayInfo.vue";

export default {
  name: "orderView",
  components: {
    CustomerInfo,
    ProductInfo,
    PayInfo,
  },
};
</script>

<style></style>
