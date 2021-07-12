<template>
  <div>
    <div class="col">
            <div class="card">
              <router-link :to="'/item/item-detail?product_id=' + item.product_id">
                <img :src=item.product_img
                class="card-img-top" alt="...">
              </router-link>
                <div class="card text-end">
                    <div class="card-body">
                      <h5 class="card-title">{{ item.product_name }}</h5>
                      <el-rate
                        v-model="value"
                        disabled
                        show-score>
                      </el-rate>
                      <div><span class="price">{{ $filters.price(item.product_price) }}</span>원</div>
                    </div>      
                </div>
            </div>
          </div>
  </div>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
    },
  },
  data: function() {
    return {
      value: Number(this.item.product_rating),
    }
  },
}
</script>

<style>
@font-face {
    font-family: 'SEBANG_Gothic_Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SEBANG_Gothic_Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
     font-family: 'S-CoreDream-6Bold';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-6Bold.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}
.card-title {
  font-family: S-CoreDream-6Bold
}
.price {
  font-family: SEBANG_Gothic_Bold;
  font-size: 28px;
}
.card-title {
  font-size: 16px;
}
</style>
