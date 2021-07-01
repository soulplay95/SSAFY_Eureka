<template>
  <el-table
    :data="itemInfo.filter(data => !search || data.product_name.toLowerCase().includes(search.toLowerCase()))"
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
          placeholder="이름 검색"/>
      </template>
      <template #default="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
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
  computed: {
    ...mapGetters('adminStore', ['itemInfo'])
  },
  created() {
    this.$store.dispatch('adminStore/setItemInfo', 1)
  },
}
</script>

<style>

</style>