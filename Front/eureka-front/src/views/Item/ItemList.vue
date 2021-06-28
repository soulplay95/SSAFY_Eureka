<template>
  <div>
    <NavBar/>
    <p><span class="search">‘{{ searchText }}’</span>에 대한 결과</p>
    <div class="row g-0">
      <div class="col-6 col-md-2" style="border:2px solid grey; padding:10px; height:1000px; margin: 10px 10px 10px 10px;">
        <span class="filter">필터
        </span>
        <hr>
        <span class="category">카테고리</span>
        <hr style="0.5px;">
      </div>
      <div class="col-sm-6 col-md-8">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <!-- <ItemListCard v-for="card in 15" :key="card"/> -->
          <ItemListCard v-for="(item, idx) in searchItems"
          :key=idx
          :itemId="id"
          @click="onClick"
          />
        </div>
      </div>
    </div>
    <!-- <Pagination 
    v-model="page" 
    :records="500" 
    :per-page="25" 
    @paginate="myCallback"
    /> -->
  </div>
</template>

<script>
// import axios from 'axios'
import NavBar from '@/components/Bar/NavBar'
import ItemListCard from '@/components/Item/ItemListCard'
// import Pagination from 'v-pagination-3';

export default {
  components: {
    NavBar,
    ItemListCard,
    // Pagination,
  },
  data: function() {
    return {
      searchItems: this.$store.state.itemStore.searchItems,
      searchText: this.$store.state.itemStore.searchText,
      page: 1
    }
  },
  methods: {
    onClick: function () {
      this.$router.push({ name: 'ItemDetail' });
    }
  },

  created() {
    // axios({
    //     method: 'get',
    //     url: `http://127.0.0.1:8000/movies/${this.movie.movie_id}/likes/`,
    //     headers: this.token,
    //   })
    //   .then(res => {
    //     this.liked = res.data.liked
    //   })
    //   .catch(err => {
    //     console.log(err)
    //   })
  }
}
</script>

<style>
.search {
  font-weight: 900;
}
.filter {
  font-weight: 900;
  font-size: 24px;
}
.category {
  font-size: 20px;
}
</style>