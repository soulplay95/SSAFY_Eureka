<template>
  <div>
    <div class="col">
            <div class="card">
              <img :src="`https://placedog.net/300/200?random`"
              class="card-img-top" alt="..."
              @click="selectItem">
              <div class="card-body">
                <p>{{ itemId }}</p>
                <h5 class="card-title">Card title</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              </div>
            </div>
          </div>
  </div>
</template>

<script>
export default {
  props: {
    itemId: {
      type: Number,
    },
  },
  data: function() {
    return {
      searchText: '',
    }
  },
  methods: {
    selectItem: function () {
      this.$store.dispatch("itemStore/selectItem", this.searchText);
      this.$router.push({ name: "ItemDetail" });
    },
  },
};
</script>

<style></style>
