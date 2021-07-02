<template>
  <div>
    <div class="col">
            <div class="card">
              <img :src="`https://placedog.net/300/200?random`"
              class="card-img-top" alt="..."
              @click="selectItem">
                <div class="card text-end">
                  <div class="card-body" @click="selectItem">
                    <h5 class="card-title">{{ item.name }}</h5>
                    <el-rate
                      v-model="value"
                      disabled
                      show-score
                      text-color="#ff9900"
                      score-template="{value} points">
                    </el-rate>
                    <h3>{{ item.price }}</h3>
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
      searchText: '',
      value: this.item.rating,
    }
  },
  methods: {
    selectItem: function () {
      // this.$store.dispatch('itemStore/selectItem', this.searchText);
      this.$router.push({ name: 'ItemDetail' });
    },
  },
}
</script>

<style>

</style>