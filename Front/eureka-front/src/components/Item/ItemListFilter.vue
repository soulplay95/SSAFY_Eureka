<template>
  <div>
    <div class="row">
    <div class="col-sm-6" id="filter">필터</div>
    <div class="col-sm-4">
      <el-button type="primary" icon="el-icon-search" @click="filterItem">초기화</el-button>
    </div>
    </div>
    <hr>
    <p>별점</p>
    <div class="block">
      <button type="button" class="btn btn-outline-success" @click="onRateClick">별점 전체</button>
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
        :max="maxPrice">
      </el-slider>
    </div>
    <hr>
    <p>배송료</p>
    <div>
      <p>배송료 전체</p>
    </div>
    <div>

    </div>
    <el-button type="primary" icon="el-icon-search" @click="filterItem">Filter</el-button>
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
        'endPrice': this.value[1]
      }
      this.$store.dispatch('itemStore/filterItem', filterQuery)
    },
    onRateClick: function () {
      this.value2 = null
    },
    resetPrice: function () {
      this.value = [0, this.maxPrice]
    }
  },
  computed: {
    ...mapState( 'itemStore', ['maxPrice'])
  },
}
</script>

<style>
#filter {
  font-weight: 900;
  font-size: 24px;
}
.category {
  font-size: 20px;
}
.hover {
  font-weight: bold;
}
</style>