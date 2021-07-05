<template>
  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
    <div>
      <admin-item-modify/>
      <admin-item-register/>
      <admin-item-table/>
      <admin-profile/>
      <admin-item-list/>
    </div>
  </div>
</template>

<script>
import adminItemForm from '../../components/Admin/adminItemForm.vue'
import AdminItemList from './AdminItemList.vue'
import AdminItemModify from './AdminItemModify.vue'
import AdminItemRegister from './AdminItemRegister.vue'
import AdminProfile from './AdminProfile.vue'
export default {
  components: { adminItemForm, AdminItemList, AdminItemModify, AdminItemRegister, AdminProfile },

}
</script>

<style>

</style>