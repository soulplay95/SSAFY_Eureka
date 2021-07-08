<template>
  <div class="d-flex">
    <side-bar-npm/>
    <!-- <el-aside width="200px">
      <my-page-side-bar/>
    </el-aside> -->
    <div>
      <user-modify v-if="currentMode==='userModify'"/>
      <!-- 주문목록 -->
      <!-- 배송지관리 -->
    </div>
  </div>
</template>

<script>
// import myPageSideBar from '@/components/User/MyPage/myPageSideBar'
import UserModify from "@/components/User/MyPage/UserModify"
import { mapGetters } from 'vuex'
import SideBarNpm from '@/components/Admin/sideBarNpm.vue'

export default {
  name: "MyPage",
  components: {
    UserModify,
    SideBarNpm,
  },
  computed: {
    ...mapGetters('myPageStore', ['currentMode'])
  }
}
</script>

<style scoped>

</style>