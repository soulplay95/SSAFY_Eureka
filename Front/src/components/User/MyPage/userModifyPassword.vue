<template>
  <el-form 
    :model="credentials"
    :rules="rules"
    ref="modifyPasswordForm"
  >
    <!-- 현재 비밀번호 -->
    <el-form-item label="기존 비밀번호" prop="userpwd">
      <el-input v-model="credentials.userpwd"></el-input>
    </el-form-item>
    <!-- 비밀번호 -->
    <el-form-item label="신규 비밀번호" prop="newpwd">
      <el-input v-model="credentials.newpwd"></el-input>
    </el-form-item>
    <!-- 비밀번호 확인 -->
    <el-form-item label="비밀번호 확인" prop="newpwd">
      <el-input v-model="newpwdconfirmation"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="medium" round @click.prevent="onSubmitPwd('modifyPasswordForm')">수정하기</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "userModifyPassword",
  data() {
    return {
      credentials: {
        userid: "",
        userpwd: "",
        newpwd: "",
      },
      rules: {
        userpwd: [
          {
            required: true,
            trigger: 'blur',
            message: '기존의 비밀번호를 입력해주세요!',
            placeholder: '기존 비밀번호'
          }
        ],
        newpwd: [
          {
            required: true,
            trigger: 'blur',
            message: '새로운 비밀번호를 입력해주세요!',
            placeholder:'신규 비밀번호'
          },
          {
            min: '8',
            trigger: 'blur',
            message: '최소 8자이상 입력해주세요!'
          }
        ]
      },
      newpwdconfirmation: "",
    }
  },
  methods: {
    onSubmitPwd(formName) {
      console.log(formName)
      if (this.issamepassword) {
        this.$store.dispatch('userStore/modifyuserpwd', this.credentials)
        console.log('비밀번호수정 vuex로 보냄')
      } else {
        this.resetPassword()
        alert("입력하신 비밀번호가 같아야합니다!")
      }
    },
        // 패스워드 입력창 초기화
    resetPassword() {
        this.credentials.newpwd = ""
        this.newpwdconfirmation = ""
    },
  },
  computed: {
    issamepassword() {
      return Boolean(this.credentials.newpwd === this.newpwdconfirmation)
    }
  }
}
</script>

<style>

</style>