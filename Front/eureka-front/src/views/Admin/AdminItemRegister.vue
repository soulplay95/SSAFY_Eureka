<template>
  <div>
    <admin-side-bar/>
    <h1>여기는 상품 등록 페이지입니다(관리자 페이지)</h1>
    <admin-item-form/>
  </div>
</template>

<script>
import adminSideBar from '@/components/Admin/adminSideBar'
import adminItemForm from '@/components/Admin/adminItemForm.vue'


// <보낼 것>
// product_brand    string
// product_category    string
// product_deliveryprice    string
// product_img    string
// product_name    string
// product_price    string
// seller_name    string
// product_count    string

// <보내지 않을 것>
// product_detailimg    string
// product_id    integer($int32)
// product_rating    string


export default {
  name: "AdminItemRegister",
  components: {
    adminSideBar,
    adminItemForm,
  },
  created() {
    this.$store.dispatch('adminStore/changeMode', 'register')
  }
}
</script>

<style scoped>

</style>