<template>
  <div>
    <!-- Header - title -->
    <section
      class="bg-title-page flex-col-c-m"
      style="background-image: url(https://picsum.photos/1920/239/?image=122)"
    >
      <h2 class="l-text2 t-center">Cart</h2>
    </section>

    <!-- Contents - 장바구니 리스트, 주문표 -->
    <section class="cart bgwhite">
      <div class="container">
        <!-- 장바구니 리스트 -->
        <cart-list />

        <!-- 주문표 -->
        <total-order />
      </div>
    </section>
  </div>
</template>

<script>
// 하위 components import
import CartList from '@/components/Cart/CartList.vue';
import TotalOrder from '@/components/Cart/TotalOrder.vue';

export default {
  name: 'cartView',
  components: {
    CartList,
    TotalOrder,
  },
  created() {
    // 초기 data setting
    // TODO: user id로 장바구니 리스트 불러오기
  },
};
</script>

<style scoped>
.container {
  max-width: 1500px; /* 최대 너비 지정 */
}

/* ############################### Header - 간판 ############################### */
.bg-title-page {
  width: 100%; /* 부모 요소의 너비에 맞춰 100% 늘어남 */
  min-height: 239px; /* element의 최소 높이를 지정. 이 값보다 작아지는 것을 방지 */
  /* 내부 자식 요소와의 간격 */
  padding-left: 15px;
  padding-right: 15px;
  padding-top: 40px;
  padding-bottom: 50px;
  background-repeat: no-repeat; /* 이미지가 반복 배열되지 않음 */
  background-position: center 0; /* 배경 이미지 위치를 지정. 가운데 상단 */
  background-size: cover; /* 배경 이미지 크기를 조절. 가능한 크게 해서 지역이 이미지로 완전히 덮이도록 함. */
}

@media (max-width: 576px) {
  /* 미디어 쿼리. 반응형 레이아웃 작성에 사용. */
  /* 브라우저의 너비가 최대 576px 까지는 .bg-title-page 클래스가 {}안의 css 따르라는 의미 */
  .bg-title-page .l-text2 {
    font-size: 35px;
  }
  .bg-title-page .m-text13 {
    font-size: 16px;
  }
}

.flex-col-c-m {
  display: flex; /* Flex Container로 지정 */
  flex-direction: column; /* Container 내부 items 들의 주 축(main-axis)을 설정 */
  align-items: center; /* 교차 축에서 items의 정렬 방법을 설정 */
  justify-content: center; /* 주 축의 정렬 방법을 설정 */
}

.t-center {
  text-align: center; /* 텍스트의 정렬 방향을 center로 설정 */
}

.l-text2 {
  font-family: fantasy; /* 글꼴을 설정 */
  font-size: 50px; /* 폰트 크기 속성. px은 문자의 높이를 지정 */
  color: white; /* 색상 지정. 정확히는 글자의 색상 지정 */
  line-height: normal; /* 줄 높이를 정하는 속성 */
  text-transform: uppercase; /* 대문자 또는 소문자로 바꾸는 속성 */
}

/* ############################### Contents ############################### */
.bgwhite {
  background-color: white;
  padding-top: 70px;
  padding-bottom: 100px;
}
</style>
