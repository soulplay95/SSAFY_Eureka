<template>
  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
    <div>
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