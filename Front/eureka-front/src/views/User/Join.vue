<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <form @submit.prevent="onSubmit">
      <fieldset>
        <!-- 아이디 -->
        <label for="userId">아이디(이메일)</label>
        <input v-model="userid" type="email" id="userId" placeholder="ex) abcdefg@naver.com" >
        <!-- 비밀번호 -->
        <label for="userPassword">비밀번호(최소 8자 이상)</label>
        <input v-model="userpwd" type="password" id="userPassword" minlength="8">
        <!-- 비밀번호 -->
        <label for="userPasswordConfirmation">비밀번호 확인</label>
        <input v-model="userpwdconfirmation" type="password" id="userPasswordConfirmation" minlength="8">
        <!-- 이름 -->
        <label for="username">이름</label>
        <input v-model="username" type="text" id="username">
        <!-- 연락처 -->
        <label for="userPhoneNumber">연락처</label>
        <input v-model="phone" type="tel" id="userPhoneNumber" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="ex) 010-0000-0000" required>
        <!-- 주소 -->
        <label for="userId">주소</label>
        <input v-model="address" type="email" id="userId" placeholder="ex) abcdefg@naver.com">
        <input type="submit" value="회원가입">
      </fieldset>
    </form>
  </div>
</template>

<script>
// import { mapActions } from 'vuex'

export default {
  name: 'Join',
  data() {
    return {
      // 명칭 재정의 필요
      userid: '',
      userpwd: '',
      userpwdconfirmation: '',
      username: '',
      phone: '',
      address: '',
    }
  },
  // 비밀번호와 비밀번호 확인은 local에서 처리
  // 이후, 가입은 vuex에서 처리
  methods: {
    onSubmit: function () {
      if (!this.checkPassword()) {
          // 회원가입 진행
          console.log('a')
        }
      }
    },
    checkPassword: function() {
      if (this.userpwd !== this.userpwdconfirmation) {
        this.resetPassword()
        alert('입력하신 비밀번호가 다릅니다!')
      }
    },
    resetPassword: function() {
      this.userpwd = ''
      this.userpwdconfirmation = ''
    }
}
</script>
<style>
  fieldset {
    display: flex;
    flex-direction: column;
    text-align: center;
    border-radius: 1rem;
  }

  fieldset * {
    margin-top: 0.5rem;
    padding: 0.5rem;
  }

  fieldset input {
    border: 1px solid black;
    border-radius: 1rem;
    
  }
</style>