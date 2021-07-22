<template>
  <div>
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
import CustomerInfo from '@/components/Order/CustomerInfo.vue';
import ProductInfo from '@/components/Order/ProductInfo.vue';
import PayInfo from '@/components/Order/PayInfo.vue';

export default {
  name: 'OrderView',
  components: {
    CustomerInfo,
    ProductInfo,
    PayInfo,
  },
};
</script>

<style></style>
