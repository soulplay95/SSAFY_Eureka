<template>
  <div class="d-flex">
    <el-aside width="200px">
      <my-page-side-bar/>
    </el-aside>
    <!-- 회원관리 -->
    <el-tabs 
      type="border-card"
      v-model="activeName"
      v-if="currentMode==='userModify'"
      class="tabs"
    >
      <el-tab-pane label="기본 정보 수정" name="first" class="user-modify-tab">
        <user-modify-info class="user-modify-info"/>
      </el-tab-pane>
      <el-tab-pane label="비밀번호 수정" name="second" class="user-modify-tab">
        <user-modify-password class="user-modify-password"/>
      </el-tab-pane>
    </el-tabs>
    <!-- 배송지관리 -->
    <div v-if="currentMode==='manageAddress'">
      여기가 배송지관리 페이지입니다
      😀😀여기에 배송지관리 컴포넌트 추가해주시면 됩니다😀😀
    </div>
    <!-- 주문목록 -->
    <div v-if="currentMode==='orderList'">
      여기가 주문목록 페이지입니다
      😀😀여기에 주문목록 컴포넌트 추가해주시면 됩니다😀😀
    </div>
  </div>
</template>

<script>
// import myPageSideBar from '@/components/User/MyPage/myPageSideBar'
import userModifyInfo from "@/components/User/MyPage/userModifyInfo"
import userModifyPassword from "@/components/User/MyPage/userModifyPassword"
import { mapGetters } from 'vuex'
import myPageSideBar from '@/components/User/MyPage/myPageSideBar'

export default {
  name: "MyPage",
  components: {
    userModifyInfo,
    userModifyPassword,
    myPageSideBar,
  },
  data() {
    return {
      activeName: "first"
    }
  },
  computed: {
    ...mapGetters('myPageStore', ['currentMode'])
  }
}
</script>

<style scoped>
.tabs {
  width: 100%;
}
.user-modify-tab {
  min-height: 500px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.user-modify-info {
  width: 40%;
  min-width: 480px;
}

.user-modify-password {
  min-width: 40%;
  min-width: 480px;
}
</style>