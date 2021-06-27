<template>
  <div>
    <adminSideBar/>
    <h1>여기는 회원관리 - 회원리스트입니다!(관리자)</h1>
    <adminTable/>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminTable from '@/components/Admin/adminTable'

export default {
  name: "AdminUserList",
  components: {
    adminSideBar,
    adminTable
  }
}
</script>

<style>

</style>