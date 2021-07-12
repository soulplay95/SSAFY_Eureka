<template>
  <div>
    <div class="col">
      <div class="card">
        <img
          :src="item.product_img"
          class="card-img-top"
          alt="..."
          @click="selectItem(item.product_name)"
        />
        <div class="card text-end">
          <div class="card-body" @click="selectItem(item.product_name)">
            <h5 class="card-title">{{ item.product_name }}</h5>
            <el-rate v-model="value" disabled show-score> </el-rate>
            <h3>{{ item.product_price }}</h3>
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
  data: function () {
    return {
      value: Number(this.item.product_rating),
    };
  },
  methods: {
    selectItem: function (id) {
      // this.$store.dispatch('itemStore/selectItem', this.searchText);
      this.$router.push('/item/item-detail?product_id=' + id);
    },
  },
};
</script>

<style></style>
