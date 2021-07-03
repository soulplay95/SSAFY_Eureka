<template>
  <div>
    <el-aside width="200px" style="position: absolute;">
      <my-page-side-bar/>
    </el-aside>
    <h1>여기가 마이페이지입니다!</h1>  
  </div>
</template>

<script>
import myPageSideBar from '@/components/User/MyPage/myPageSideBar'

export default {
  name: "MyPage",
  components: {
    myPageSideBar
  }
}
</script>

<style scoped>

</style>