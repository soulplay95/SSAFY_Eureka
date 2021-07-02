<template>
  <div>
    <admin-side-bar/>
    <h1>여기는 상품 관리 - 상품 리스트 페이지입니다!(관리자)</h1>
    <admin-item-table/>
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

<style>

</style>