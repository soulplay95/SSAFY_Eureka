<template>
  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
    <div>
      <h1>여기는 상품 관리 - 상품 리스트 페이지입니다!(관리자)</h1>
      <admin-item-table/>
    </div>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminItemTable from '@/components/Admin/adminItemTable'

export default {
  name: "AdminItemList",
  components: {
    adminSideBar,
    adminItemTable
  }
}
</script>

<style scoped>
</style>