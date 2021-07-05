<template>
  <el-table
    :data="itemsInfo.filter(data => !search || data.product_name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label="상품id"
      prop="product_id">
    </el-table-column>
    <el-table-column
      label="상품명"
      prop="product_name">
    </el-table-column>
    <el-table-column
      label="판매자명"
      prop="seller_name">
    </el-table-column>
    <el-table-column
      label="상품 브랜드"
      prop="product_brand">
    </el-table-column>
    <el-table-column
      label="상품 카테고리"
      prop="product_category">
    </el-table-column>
    <el-table-column
      label="개수"
      prop="product_count">
    </el-table-column>
    <el-table-column
      label="가격"
      prop="product_price">
    </el-table-column>
    <el-table-column
      label="배송비"
      prop="product_deliveryprice">
    </el-table-column>
    <el-table-column
      label="할인율"
      prop="product_discount">
    </el-table-column>
    <el-table-column
      label="이미지"
      prop="product_img">
      <template v-slot="scope">
        <el-image
          style="width: 100%;"
          :src="scope.row.product_img"
          :fit="fill">
        </el-image>
      </template>
    </el-table-column>
    <el-table-column
      label="평점"
      prop="product_rating">
    </el-table-column>
    <el-table-column
      align="right">
      <template #header>
        <el-input
          v-model="search"
          size="mini"
          placeholder="상품명 검색"/>
      </template>
      <template #default="scope">
        <el-button
          size="mini"
          @click="editItem(scope.$index)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="deleteItemConfirmation(scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
    background
    layout="prev, pager, next"
    @current-change="updatePage($event)"
    :total="possiblePage">
  </el-pagination>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name:"adminItemTable",
  data() {
    return {
      search: '',
    }
  },
  methods: {
    updatePage(event) {
      this.$store.dispatch('adminStore/setItemsInfo', event)
    },
    editItem(idx) {
      this.$store.dispatch('adminStore/getItemInfo', idx)
    },
    deleteItemConfirmation(item) {
          this.$confirm('해당 상품을 삭제하시겠습니까?', 'Warning', {
            confirmButtonText: '네',
            cancelButtonText: '아니오',
            type: 'warning',
        })
        .then((res) => {
          console.log(res)
          const selectedItemId = item.product_id
          this.$store.dispatch('adminStore/deleteItem', selectedItemId)
        })
        .then((res) => {
          console.log(res)
          this.$message({
            type: 'success',
            message: '삭제 완료되었습니다😥'
          })
        })
        .catch((err) => {
          console.log(err)
          this.$message({
            type:'info',
            message: '삭제 취소되었습니다😚'
          })
        })
    }
  },
  computed: {
    ...mapGetters('adminStore', ['itemsInfo', 'possiblePage'])
  },
  created() {
    // 접속 시 1페이지 정보 출력
    this.$store.dispatch('adminStore/setItemsInfo', 1)
  },
}
</script>

<style>

</style>