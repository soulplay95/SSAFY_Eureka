<template>
  <div>
    <p class="result"><span class="searchResult">‘{{ searchText }}’</span>에 대한 결과</p>
    <h3 class="detail">HOT ITEMS</h3>
    <div class="row g-0">
      <div class="col-6 col-md-2" style="border:2px solid #b0eacd; padding:10px; height:1000px; margin: 10px 10px 10px 10px;">
        <ItemListFilter/>
      </div>
      <div class="col-sm-6 col-md-9">
        <div class="row row-cols-1 row-cols-md-5 g-4">
          <ItemListCard 
          v-for="(item, idx) in categoryHotItems"
          :key="idx"
          :item="item"
          />
        </div>
        <br><br>
        <h3 class="detail">NORMAL ITEMS</h3>
          <div class="row row-cols-1 row-cols-md-5 g-4">
          <ItemListCard 
          v-for="(item, idx) in categoryItems"
          :key="idx"
          :item="item"
          />
        </div>
      </div>
    </div>
    <div class="block">
      <el-pagination
        :page-size="30"
        layout="prev, pager, next"
        :total="pageCount"
        @current-change="setPageChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex' 
import ItemListCard from '@/components/Item/ItemListCard'
import ItemListFilter from '@/components/Item/ItemListFilter'

export default {
  components: {
    ItemListCard,
    ItemListFilter,
  },
  data: function () {
    return {
    }
  },
  methods: {
    setPageChange(val) {
      const searchText = this.searchText
      const categoryNum = this.categoryIndex
      this.$store.dispatch("itemStore/clickCategory", { searchText, categoryNum, val })
      }
  },
  computed: {
    ...mapState( 'itemStore', ['searchText', 'categoryHotItems', 'categoryItems', 'pageCount', 'categoryIndex'])
  },
};
</script>

<style>
/* .search {
  color: #21bf73;
} */
.detail {
  color: #21bf73;
}
.searchResult {
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
