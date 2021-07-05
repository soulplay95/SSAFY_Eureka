<template>
  <div>
    <img :src="itemDetailImage" alt="IMG-PRODUCT" />
  </div>
</template>

<script>
export default {
  name: 'itemDetailImage',
  computed: {
    itemDetailImage() {
      return this.$store.getters['itemDetail/productInfo'].product
        .product_detailimg;
    },
  },
};
</script>

<style></style>
