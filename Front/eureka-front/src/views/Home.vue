<template>
  <div>
     <!--<button class="btn btn-primary" 
            data-bs-target="#collapseTarget" 
            data-bs-toggle="collapse">
            Bootstrap collapse
        </button>
        <div class="collapse py-2" id="collapseTarget">
            This is the toggle-able content!
        </div> -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container"><!--fluid에서 그냥 container로 바꿈 -->
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <div style=float:none;>
          <form class="d-flex">
            <!-- <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"> -->
            <input class="form-control me-2" type="search" v-model.trim="searchText" @keyup.enter="searchItem">
            <button class="btn btn-outline-success" type="submit" @click="searchItem">Search</button>
          </form>
        </div>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              마이유레카
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#">주문목록</a></li>
              <li><a class="dropdown-item" href="#">취소/반품</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">찜리스트</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">장바구니</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <img :src='pic'>
    <br><br><br><br><br>
    <h1>카테고리 별 추천 상품</h1>
    <Carousel :items-to-show="2.5" :wrap-around="true">
    <Slide v-for="slide in 10" :key="slide">
      <div class="carousel__item">{{ slide }}</div>
    </Slide>

    <template #addons>
      <Navigation />
    </template>
  </Carousel>
    <br><br><br>
    <Carousel :items-to-show="2.5" :wrap-around="true">
    <Slide v-for="slide in 10" :key="slide">
      <div class="carousel__item">{{ slide }}</div>
    </Slide>

    <template #addons>
      <Navigation />
    </template>
  </Carousel>
      <!-- <vue-position-sticky :offsetTop="0" sticky-class="myClass" />
    
    <vue-position-sticky :offsetBottom="30" @change="handleStickyChange" />
    
    <vue-position-sticky>
        <span>sticky slot<span>
    </vue-position-sticky> -->
  </div>
</template>

<script>
import pic from '@/assets/food.png'
// import { defineComponent } from 'vue';
// import vuePositionSticky from 'vue-position-sticky'
import { Carousel, Navigation, Slide } from 'vue3-carousel';
import 'vue3-carousel/dist/carousel.css';

export default {
  data: function() {
    return {
      pic: pic,
      searchText: '',
    }
  },
  components: {
    Carousel,
    Slide,
    Navigation,
    // vuePositionSticky,
  },
  methods: {
    searchItem: function () {
      this.$store.dispatch("itemStore/searchItem", this.searchText)
      this.$router.push({ name: 'ItemList' })
    }
  }
}
</script>

<style>

</style>