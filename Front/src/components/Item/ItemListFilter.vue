<template>
  <div class="all">
    <div class="row" style="height:50px; box-sizing: border-box;">
    <div class="col-sm-6" id="filter" style="padding:10px;">필터</div>
    <div class="col-sm-4">
      <el-button icon="el-icon-search" @click="resetFilter" style="background-color:#b0eacd; color:white;">초기화</el-button>
    </div>
    </div>
    <hr>
    <p class="rate">별점</p>
    <div class="block">
      <button type="button" class="btn btn-outline-success" @click="resetRate" >별점 전체</button>
      <br><br>
      <el-rate
        v-model="value2"
        :colors="colors">
      </el-rate>
    </div>
    <hr>
    <p>가격</p>
    <div class="block">
      <button type="button" class="btn btn-outline-success" @click="resetPrice">가격 전체</button>
      <br>
      <el-slider
        v-model="value"
        range
        :step="10000"
        show-stops
        :max="maxPrice"
        style="color: green;">
      </el-slider>
    </div>
    <hr>
    <!-- <p>배송료</p>
    <div>
      <p>배송료 전체</p>
    </div> -->
    <div>

    </div>
    <el-button icon="el-icon-search" @click="filterItem" style="background-color:#b0eacd; color:white;">Filter</el-button>
  </div>
</template>

<script>
import { mapState } from 'vuex' 
export default {
  data: function() {
    return {
      active: false,
      value: [0, 20000],
      value2: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'] // same as { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' }
    }
  },
  methods: {
    filterItem: function () {
      // console.log(this.value)
      const filterQuery = {
        'startPrice': this.value[0],
        'endPrice': this.value[1],
        'rate': this.value2
      }
      console.log(filterQuery)
      this.$store.dispatch('itemStore/filterItem', filterQuery)
    },
    resetRate: function () {
      this.value2 = null
    },
    resetPrice: function () {
      this.value = [0, this.maxPrice]
    },
    resetFilter: function () {
      this.value = [0, this.maxPrice]
      this.value2 = null
    }
  },
  computed: {
    ...mapState( 'itemStore', ['maxPrice'])
  },
}
</script>

<style>

@font-face {
     font-family: 'S-CoreDream-6Bold';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-6Bold.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}

.all {
  font-family: S-CoreDream-6Bold
}

#filter {
  font-weight: 900;
  font-size: 24px;
  color: #21bf73;
}
.category {
  font-size: 20px;
}
.hover {
  font-weight: bold;
}
</style>