<template>
  <div>
    <!-- header -->
    <section
      class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
      style="background-image: url(https://picsum.photos/1920/239/?image=122)"
    >
      <h2 class="l-text2 t-center">Cart</h2>
    </section>

    <!-- contents -->
    <section class="cart bgwhite p-t-70 p-b-100">
      <div class="container">
        <!-- Cart List -->
        <cart-list />

        <!-- Total Order -->
        <total-order />
      </div>
    </section>
  </div>
</template>

<script>
// 하위 components import
import CartList from '@/components/Cart/CartList.vue';
import TotalOrder from '@/components/Cart/TotalOrder.vue';
// Vuex 사용
// import { useStore } from 'vuex';

export default {
  name: 'cartView',
  // 하위 components 등록
  components: {
    CartList,
    TotalOrder,
  },
  // local data
  data: function () {
    return {};
  },
  // 초기 data setting
  created() {
    // Vuex 세팅
    // const store = useStore();
    // const rows = computed(() => store.state.cart.cartList); // 장바구니 리스트 불러오기
    // console.log(rows);
  },
  methods: {
    // 정렬
    sortBy(key) {
      console.log(key);
    },
  },
};
</script>

<style scoped></style>
