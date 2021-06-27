<template>
  <div>
    <NavBar/>
    <img :src='pic'>
    <br><br><br><br><br>
    <h1>카테고리 별 추천 상품</h1>
    <Carousel :items-to-show="2.5" :wrap-around="true">
    <Slide v-for="(dog, idx) in dogImg" :key="idx">
      <div class="carousel__item">
        <img
        :src="dog"
        >
      </div>
    </Slide>
    <template #addons>
      <Navigation />
    </template>
  </Carousel>
    <br><br><br>
    <Carousel :items-to-show="2.5" :wrap-around="true">
    <Slide v-for="slide in 10" :key="slide" @click="onClick">
      <div class="carousel__item">{{ slide }}</div>
    </Slide>

    <template #addons>
      <Navigation />
    </template>
  </Carousel>
  </div>
</template>

<script>
import pic from '@/assets/food.png'
import 'vue3-carousel/dist/carousel.css';
import NavBar from '@/components/Bar/NavBar'
import { Carousel, Navigation, Slide } from 'vue3-carousel';
// import Slide from '@/components/Carousel/Slide'

export default {
  data: function() {
    return {
      pic: pic,
      dogImg: this.$store.state.itemStore.dogImage,
    }
  },
  components: {
    Slide,
    NavBar,
    Carousel,
    Navigation,
    // vuePositionSticky,
  },
  methods: {
    onClick: function () {
      this.$router.push({ name: 'ItemDetail' });
    }
  },
  computed: {
    // 계산된 getter
    reversedMessage: function () {
      // `this` 는 vm 인스턴스를 가리킵니다.
      return this.message.split('').reverse().join('')
    }
  },  
}

</script>

<style>

</style>