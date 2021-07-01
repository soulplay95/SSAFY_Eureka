<template>
  <adminSideBar/>
  <adminUserTable/>
</template>


<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminUserTable from '@/components/Admin/adminUserTable'

export default {
  name: "AdminUserList",
  components: {
    adminSideBar,
    adminUserTable
  }
}
</script>

<style>

</style>