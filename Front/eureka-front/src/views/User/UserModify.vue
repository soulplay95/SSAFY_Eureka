<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <form @submit.prevent="onSubmit()">
      <fieldset>
        <!-- 이름 -->
        <input 
          v-model="credentials.name" 
          type="text" 
          placeholder="이름"
        />
        <!-- 현재 비밀번호 -->
        <input
          v-model="credentials.originalpwd"
          type="password"
          minlength="8"
          placeholder="현재 비밀번호"
          autocomplete="new-password"
        />
        <!-- 비밀번호 -->
        <input
          v-model="credentials.userpwd"
          type="password"
          minlength="8"
          placeholder="신규 비밀번호"
          autocomplete="new-password"
        />
        <!-- 비밀번호 확인 -->
        <input
          v-model="userpwdconfirmation"
          type="password"
          minlength="8"
          placeholder="비밀번호 확인"
          autocomplete="new-password"
        />
        <!-- 연락처 -->
        <input
          v-model="credentials.phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"
          
        />
        <!-- 현재 주소 -->
        <div> 
          기존 주소: {{ credentials.address }}
          주소록 관리는 주문페이지에서 진행하시면 됩니다🍕
        </div> 
      </fieldset>
    </form>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  // vuex 불러오기
  name: "UserModify",
  data() {
    return {
      credentials: {
        userid: "",
        userpwd: "",
        originalpwd: "",
        name: "",
        phone: "",
      },
      userpwdconfirmation: "",
    }
  },
  // 비밀번호와 비밀번호 확인은 local에서 처리
  // 이후, 가입은 vuex에서 처리
  methods: {
    onSubmit() {
      if (this.issamepassword) {
        this.updateAddress()
        // 회원가입 진행
        this.store.dispatch("userStore/register", this.credentials)
      } else {
        this.resetPassword()
        alert("입력하신 비밀번호가 다릅니다!")
      }
    },
    // 패스워드 입력창 초기화
    resetPassword() {
        this.credentials.userpwd = ""
        this.userpwdconfirmation = ""
    },
  },
  computed: {
    issamepassword() {
      return Boolean(this.credentials.userpwd === this.userpwdconfirmation)
    }
  },
  created() {
    this.credentials.userid = user.userid
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

  .addressForm {
    display: flex;
  }

</style>
