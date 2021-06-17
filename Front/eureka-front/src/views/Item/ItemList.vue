<template>
  <div>
    <h1>{{ searchText }}</h1>
  </div>
</template>

<script>

export default {
  data: function() {
    return {
      searchText: this.$store.state.itemStore.searchText,
    }
  }
}
</script>

<style>

</style>