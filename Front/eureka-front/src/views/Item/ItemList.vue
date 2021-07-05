<template>
  <div>
    <p><span class="search">‘{{ searchText }}’</span>에 대한 결과</p>
    <div class="row g-0">
      <div class="col-6 col-md-2" style="border:2px solid grey; padding:10px; height:1000px; margin: 10px 10px 10px 10px;">
        <ItemListFilter/>
      </div>
      <div class="col-sm-6 col-md-8">
        <div class="row row-cols-1 row-cols-md-5 g-4">
          <ItemListCard 
          v-for="(item, idx) in searchItems"
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
      page: Math.ceil(this.pageCount / 100),
    }
  },
  methods: {
    setPageChange(val) {
      const searchText = this.searchText
      this.$store.dispatch("itemStore/searchItem", { searchText, val })
      }
  },
  computed: {
    ...mapState( 'itemStore', ['searchText', 'searchItems', 'pageCount'])
  },
};
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