<template>
  <div class="d-flex flex-row mt-5">
    <adminSideBar/>
    <div class="admin-user-table">
      <adminUserTable/>
      <back-top/>
    </div>
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

<style scoped>
.admin-user-table {
  width: 80%;
  margin-bottom: 50px;
}

</style>