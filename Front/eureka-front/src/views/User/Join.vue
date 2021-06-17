<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <form @submit.prevent="onSubmit">
      <fieldset>
        <!-- id camelCase? kebab-case? -->
        <!-- 아이디 -->
        <input
          v-model="credentials.userid"
          type="email"
          placeholder="아이디(이메일)"
          autocomplete="email"
          required
        />
        <!-- 비밀번호 -->
        <input
          v-model="credentials.userpwd"
          type="password"
          minlength="8"
          placeholder="비밀번호"
          autocomplete="new-password"
          required
        />
        <!-- 비밀번호 확인 -->
        <input
          v-model="credentials.userpwdconfirmation"
          type="password"
          minlength="8"
          placeholder="비밀번호 확인"
          autocomplete="new-password"
          required
        />
        <!-- 이름 -->
        <input 
          v-model="credentials.username" 
          type="text" 
          placeholder="이름"
          required
        />
        <!-- 연락처 -->
        <input
          v-model="credentials.phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"

        />
        <!-- 주소 -->
        <input
          v-model="credentials.address"
          type="email"
          id="userId"
          placeholder="주소"
          required
        />
        <input type="submit" value="회원가입" />
      </fieldset>
    </form>
  </div>
</template>

<script>
// useStore 훅을 사용하여 store에 접근합니다.
import { useStore } from "vuex";
// import { mapActions } from 'vuex'

export default {
  // vuex 불러오기
  setup () {
      const store = useStore();
      return { store }
  },
  name: "Join",
  data() {
    return {
      credentials: {
        // 명칭 재정의 필요
        userid: "",
        userpwd: "",
        userpwdconfirmation: "",
        username: "",
        phone: "",
        address: "",
      },
      issamepassword: false
    }
  },
  // 비밀번호와 비밀번호 확인은 local에서 처리
  // 이후, 가입은 vuex에서 처리
  methods: {
    onSubmit: function () {
      this.checkPassword()
        // 회원가입 진행
        // this.store.dispatch("userStore/register", this.credentials)
    },
    checkPassword: function () {
      if (this.credentials.userpwd !== this.credentials.userpwdconfirmation) {
        this.resetPassword()
        alert("입력하신 비밀번호가 다릅니다!")
      } else {
        issamepassword == true
      }
    },
    resetPassword: function () {
        this.credentials.userpwd = ""
        this.credentials.userpwdconfirmation = ""
    }
  },
  created() {
    this.issamepassword == false
  }
}
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
