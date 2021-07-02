<template>
  <div>
    <p><span class="search">‘{{ searchText }}’</span>에 대한 결과</p>
    <div class="row g-0">
      <div class="col-6 col-md-2" style="border:2px solid grey; padding:10px; height:1000px; margin: 10px 10px 10px 10px;">
        <ItemListFilter/>
      </div>
      <div class="col-sm-6 col-md-8">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <!-- <ItemListCard v-for="card in 15" :key="card"/> -->
          <ItemListCard v-for="(item, idx) in searchItems"
          :key=idx
          :item="item"
          @click="onClick"
          />
        </div>
      </div>
    </div>
    
    <div class="block">
      <el-pagination
        layout="prev, pager, next"
        :total="1">
      </el-pagination>
    </div>
  </div>
</template>

<script>
// import axios from 'axios'
import { mapGetters } from 'vuex'
import ItemListCard from '@/components/Item/ItemListCard'
import ItemListFilter from '@/components/Item/ItemListFilter'

export default {
  components: {
    ItemListCard,
    ItemListFilter,
  },
  data: function () {
    return {
      page: 5000,
    }
  },
  computed: {
    ...mapGetters( 'itemStore', ['searchText', 'searchItems'])
  },
<<<<<<< HEAD
=======
  methods: {},

>>>>>>> 3a577c899985dd8c9a4744cb996489e2d9ad94f1
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
  },
};
</script>

<style>
.search {
  font-weight: 900;
}
<<<<<<< HEAD

</style>
=======
.filter {
  font-weight: 900;
  font-size: 24px;
}
.category {
  font-size: 20px;
}
</style>
>>>>>>> 3a577c899985dd8c9a4744cb996489e2d9ad94f1
