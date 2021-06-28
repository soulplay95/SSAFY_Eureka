<template>
  <div>
    <h1>나의 문의내역</h1>
    <div class="container" v-for="(history, idx) in historys" :key="idx">
      <div class="row">
        <div class="col">
          <span v-if="history.category === 1">
            (배송)
          </span>
          <span v-else-if="history.category === 2">
            (주문)
          </span>
          <span v-else-if="history.category === 3">
            (서비스 칭찬)
          </span>
          <span v-else>
            (시스템개선)
          </span>
        </div>
        <div class="col">
          {{ history.title }}
        </div>
        <div class="col-6">
          {{ history.content }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      historys: this.$store.state.CSQnaStore.myQnaHistory
    }
  }
}
</script>

<style>

</style>