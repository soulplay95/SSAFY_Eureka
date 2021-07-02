<template>
  <div>
    <span class="filter">필터
    </span>
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
      <button type="button" class="btn btn-outline-success" @click="onPriceClick">가격 전체</button>
      <br>
      <el-slider
        v-model="value"
        range
        :step="5000"
        show-stops
        :max="100000">
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
      // const filterQuery = {
      //   'minprice': this.value[0],
      //   'maxprice': this.value[1],
      //   'rate': this.value2,
      // }
      // this.$store.dispatch('itemStore/filterItem', filterQuery);
      this.$router.push({ name: 'ItemList' });
    },
    onRateClick: function () {
      this.value2 = null
    },
    onPriceClick: function () {
      this.value = [0, 0]
    }
  }
}
</script>

<style>
.filter {
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