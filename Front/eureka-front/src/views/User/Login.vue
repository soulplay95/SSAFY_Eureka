<template>
  <div>
    <logo/>
    <el-form
      :model="credentials"
      :rules="rules"
      ref="loginForm"
    >
      <!-- 아이디 -->
      <el-form-item prop="userid">
        <el-input v-model="credentials.userid" placeholder="아이디(이메일) " @keyup.enter="onSubmit('loginForm')"></el-input>
      </el-form-item>
      <el-form-item prop="userpwd">
        <el-input v-model="credentials.userpwd" @keyup.enter="onSubmit('loginForm')" placeholder="비밀번호"></el-input>
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
import logo from '@/components/User/Common/logo'

export default {
  // vuex 불러오기
  name: "Login",
  components: {
    logo
  },
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
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$store.dispatch('userStore/login', this.credentials)
        } else {
          return false
        }
      })
    }
  },
};
</script>

<style scoped>
</style>
