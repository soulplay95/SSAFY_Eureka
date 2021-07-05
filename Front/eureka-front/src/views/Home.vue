<template>
  <div>
    <img :src='pic'>
    <br><br><br><br><br>
    <h1>지금 뜨는 상품</h1>
    <Carousel :items-to-show="5" :wrap-around="true">
    <Slide v-for="(item, idx) in hotItems" :key="idx">
      <div class="carousel__item">
        <img
        :src="item.product_img"
        >
      </div>
    </Slide>
    <template #addons>
      <Navigation />
    </template>
  </Carousel>
    <br><br><br>
  </div>
</template>

<script>
// import _ from 'lodash'
import axios from 'axios'
import pic from '@/assets/main.png'
import 'vue3-carousel/dist/carousel.css';
import { Carousel, Navigation, Slide } from 'vue3-carousel';
// import Slide from '@/components/Carousel/Slide'

export default {
  data: function () {
    return {
      pic: pic,
      hotItems: [],
    }
  },
  components: {
    Slide,
    Carousel,
    Navigation,
  },
  setup() {
    const handleSelection = (selectedItem) => {
      console.log(selectedItem);
    };
    return {
      handleSelection,
    };
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
    },
    // questions: function () {
    //   return this.$store.state.CSQnaStore.myQnaHistory
    // },
  }, 
  created: function () {
    axios({
      method: 'get',
      url: `http://localhost/home/recommend`,
    })
      .then(res =>{
        this.hotItems = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}

</script>



<style>
@font-face {
    font-family: 'EliceDigitalBaeum_Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/EliceDigitalBaeum_Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
</style>
