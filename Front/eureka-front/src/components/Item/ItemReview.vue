<template>
  <div>
    <!-- 평점 + 통계 -->
    <div>
      <h2>평점 :</h2>
      <star-rating
        :rating="Number(average_rating)"
        :read-only="true"
        :show-rating="false"
        :increment="0.1"
        style="display: inline-block"
      ></star-rating>
      {{ $filters.price(reviews.length) }}
    </div>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';

export default {
  name: 'itemReview',
  components: {
    StarRating,
  },
  computed: {
    // 평점
    average_rating() {
      return this.$store.getters['itemDetail/productInfo'].product
        .product_rating;
    },
    // 리뷰s
    reviews() {
      return this.$store.getters['itemDetail/productInfo'].review;
    },
  },
};
</script>

<style></style>
