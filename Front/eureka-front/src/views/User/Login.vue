<template>
  <div>
    
    <el-form
      :model="credentials"
      :rules="rules"
    >
      <!-- 아이디 -->
      <el-form-item>
        <el-input v-model="credentials.userid" placeholder="아이디(이메일)"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="credentials.userpwd" placeholder="비밀번호"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click.prevent="onSubmit('loginForm')">로그인</el-button>
        <el-button type="info" @click="$router.push('join')">회원가입</el-button>
        <el-button type="info" @click="$router.push('search-password')">비밀번호 찾기</el-button>
      </el-form-item>
    </el-form>
  </div>


</template>

<script>

export default {
  // vuex 불러오기
  name: "Login",
  data() {
    return {
      credentials: {
        userid: '',
        userpwd: ''
      },
      rules: {
        userid: [
          {
            required: true,
            type:"email",
            message: '아이디를 입력해주세요',
            trigger: 'blur'
          }
        ],
        userpwd: [
          {
            required: true,
            message: '비밀번호를 입력해주세요',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    onSubmit() {
      this.$store.dispatch('userStore/login', this.credentials)
    }
  },
};
</script>

<style scoped>
</style>
