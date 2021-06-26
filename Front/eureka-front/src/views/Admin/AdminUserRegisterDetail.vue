<template>
  <div>
    <adminSideBar/>
    <h1> 여기는 회원 가입현황 페이지입니다!(관리자)</h1>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'

export default {
  name: 'AdminUserRegisterDetail',
  components: {
    adminSideBar
  }
}
</script>

<style>

</style>