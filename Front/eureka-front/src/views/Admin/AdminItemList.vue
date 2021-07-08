<template>
  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
    <div>
      <admin-item-table/>
      <back-top/>
    </div>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminItemTable from '@/components/Admin/adminItemTable'
import BackTop from '@/components/Admin/backTop.vue'

export default {
  name: "AdminItemList",
  components: {
    adminSideBar,
    adminItemTable,
    BackTop
  }
}
</script>

<style scoped>
</style>