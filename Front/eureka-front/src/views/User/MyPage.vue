<template>
  <navBar/>
  <div class="d-flex">
    <el-aside width="200px">
      <my-page-side-bar/>
    </el-aside>
    <div>
      <h1>여기가 마이페이지입니다!</h1>
      <user-modify/> 
    </div>
  </div>
</template>

<script>
import myPageSideBar from '@/components/User/MyPage/myPageSideBar'
import navBar from "@/components/Bar/NavBar"
import UserModify from "@/components/User/MyPage/UserModify"


export default {
  name: "MyPage",
  components: {
    myPageSideBar,
    navBar,
    UserModify
  },
  data() {
    return {
      currentMode: '',
    }
  }
}
</script>

<style scoped>

</style>