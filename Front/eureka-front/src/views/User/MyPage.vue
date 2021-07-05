<template>
  <navBar/>
  <div class="d-flex">
    <el-aside width="200px">
      <my-page-side-bar/>
    </el-aside>
    <div>
      <user-modify v-if="currentMode==='userModify'"/>
      <!-- 주문목록 -->
      <!-- 배송지관리 -->
    </div>
  </div>
</template>

<script>
import myPageSideBar from '@/components/User/MyPage/myPageSideBar'
import navBar from "@/components/Bar/NavBar"
import UserModify from "@/components/User/MyPage/UserModify"
import { mapGetters } from 'vuex'

export default {
  name: "MyPage",
  components: {
    myPageSideBar,
    navBar,
    UserModify
  },
  computed: {
    ...mapGetters('myPageStore', ['currentMode'])
  }
}
</script>

<style scoped>

</style>