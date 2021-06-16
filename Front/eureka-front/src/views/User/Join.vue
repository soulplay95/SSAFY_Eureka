<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <form @submit.prevent="onSubmit">
      <fieldset>
        <!-- id camelCase? kebab-case? -->
        <!-- 아이디 -->
        <input
          v-model="userid"
          type="email"
          placeholder="아이디(이메일)"
        />
        <!-- 비밀번호 -->
        <input
          v-model="userpwd"
          type="password"
          minlength="8"
          placeholder="비밀번호"
        />
        <!-- 비밀번호 -->
        <input
          v-model="userpwdconfirmation"
          type="password"
          minlength="8"
          placeholder="비밀번호 확인"
        />
        <!-- 이름 -->
        <input 
          v-model="username" 
          type="text" 
          placeholder="이름"
        />
        <!-- 연락처 -->
        <input
          v-model="phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"
          required
        />
        <!-- 주소 -->
        <input
          v-model="address"
          type="email"
          id="userId"
          placeholder="주소"
        />
        <input type="submit" value="회원가입" />
      </fieldset>
    </form>
  </div>
</template>

<script>
// import { mapActions } from 'vuex'

export default {
  name: "Join",
  data() {
    return {
      // 명칭 재정의 필요
      userid: "",
      userpwd: "",
      userpwdconfirmation: "",
      username: "",
      phone: "",
      address: "",
    };
  },
  // 비밀번호와 비밀번호 확인은 local에서 처리
  // 이후, 가입은 vuex에서 처리
  methods: {
    onSubmit: function () {
      if (!this.checkPassword()) {
        // 회원가입 진행
        console.log("a");
      }
    },
  },
  checkPassword: function () {
    if (this.userpwd !== this.userpwdconfirmation) {
      this.resetPassword();
      alert("입력하신 비밀번호가 다릅니다!");
    }
  },
  resetPassword: function () {
    this.userpwd = "";
    this.userpwdconfirmation = "";
  },
};
</script>
<style scoped>
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
  margin: 1rem 2rem;
}

fieldset input:focus {
  outline:none;
}

</style>
