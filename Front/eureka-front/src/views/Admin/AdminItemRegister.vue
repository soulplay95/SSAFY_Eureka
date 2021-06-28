<template>
  <div>
    <adminSideBar/>
    <h1>여기는 상품 등록 페이지입니다(관리자 페이지)</h1>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'

export default {
  name: "AdminItemRegister",
  components: {
    adminSideBar
  }
}
</script>

<style>

</style>