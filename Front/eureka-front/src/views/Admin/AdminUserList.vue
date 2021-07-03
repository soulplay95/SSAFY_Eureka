<template>
  <div class="d-flex flex-row mt-5">
    <adminSideBar/>
    <adminUserTable/>
  </div>
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