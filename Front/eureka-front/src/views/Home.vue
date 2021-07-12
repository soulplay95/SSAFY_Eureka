<template>
  <div>
    <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in items" :key="item">
        <img :src="item" alt="EUREKA" class="item">
      </el-carousel-item>
    </el-carousel>
    <br><br><br><br><br>
        <img :src="pic" alt="EUREKA" class="star">
    <Carousel :items-to-show="5" :wrap-around="true">
    <Slide v-for="(item, idx) in hotItems" :key="idx" >
      <div class="carousel__item">
        <img
        :src="item.product_img"
        @click="selectItem"
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
import pic from '@/assets/star.png'
import random from '@/assets/random.png'
import main2 from '@/assets/main2.png'
import main3 from '@/assets/main3.png'
import main4 from '@/assets/main4.png'
import 'vue3-carousel/dist/carousel.css';
import { Carousel, Navigation, Slide } from 'vue3-carousel';
// import Slide from '@/components/Carousel/Slide'

export default {
  data: function () {
    return {
      pic: pic,
      random: random,
      items: [
        main2,
        main3,
        main4
      ],
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
    selectItem: function () {
      // this.$store.dispatch('itemStore/selectItem', this.searchText);
      this.$router.push({ name: 'ItemDetail' });
    },
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

.today {
  color: #b0eacd;
}

.item {
  /* width: 70px; eureka2*/
  /* width: 100px; eureka3 */
  width: 1400px;
  height: auto;
  background-size: contain;
  /* margin: 20px 70px 20px 80px; */
}

.star{
  /* width: 70px; eureka2*/
  /* width: 100px; eureka3 */
  width: 350px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: 90px 70px 70px 180px;
  /* margin: 20px 70px 20px 80px; */
}

.random{
  /* width: 70px; eureka2*/
  /* width: 100px; eureka3 */
  width: 350px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: 0px 70px 70px 180px;
  /* margin: 20px 70px 20px 80px; */
}

.item1 {
  width: 150px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: 90px 70px 70px 90px;
}
.item2 {
  width: 150px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: 90px 70px 70px 90px;
}
.item3 {
  width: 150px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: 90px 70px 70px 90px;
}
</style>
