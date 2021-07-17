<template>
  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
    <div>
      <admin-item-form/>
    </div>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminItemForm from '@/components/Admin/adminItemForm.vue'

export default {
	name: "AdminItemModify",
	components: {
		adminSideBar,
		adminItemForm
	},
	created() {
		this.$store.dispatch('adminStore/changeMode', 'modify')
	}
}
</script>

<style>

</style>