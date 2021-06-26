<template>
  <div>
    <adminSideBar/>
    <h1>여기는 상품 관리 - 상품 리스트 페이지입니다!</h1>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'

export default {
  name: "AdminItemList",
  components: {
    adminSideBar
  }
}
</script>

<style>

</style>