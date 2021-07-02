<template>
  <div>
    <admin-side-bar/>
    <h1>여기는 상품 변경 페이지입니다.(관리자 페이지)</h1>
    <admin-item-form/>
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