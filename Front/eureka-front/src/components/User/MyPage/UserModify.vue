<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <!-- 기본정보 수정 -->
    <form @submit.prevent="onSubmitInfo()">
      <!-- 아이디(이메일) -->
      <fieldset>
        <input 
          :value="credentials.userid"
          type="text"
          disabled
        />
      </fieldset>
      <!-- 이름 -->
      <fieldset>
        <input 
          v-model="currentUser.member_name" 
          type="text"
          placeholder="이름"
          required
        />
      </fieldset>
      <!-- 연락처 -->
      <fieldset>
        <input
          v-model="currentUser.member_phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"
          required
        />
      </fieldset>
      <fieldset>
        <input
          type="submit"
          value="수정"
        />
      </fieldset>
    </form>
    <!-- 비밀번호 수정 -->
    <form @submit.prevent="onSubmitPwd()">
      <!-- 현재 비밀번호 -->
      <fieldset>
        <input
          v-model="credentials.userpwd"
          type="password"
          minlength="8"
          placeholder="현재 비밀번호"
          autocomplete="password"
          required
        />
      </fieldset>
      <!-- 비밀번호 -->
      <fieldset>
        <input
          v-model="credentials.newpwd"
          type="password"
          minlength="8"
          placeholder="신규 비밀번호"
          autocomplete="new-password"
          required
        />
      </fieldset>
      <!-- 비밀번호 확인 -->
      <fieldset>
        <input
          v-model="newpwdconfirmation"
          type="password"
          minlength="8"
          placeholder="비밀번호 확인"
          autocomplete="new-password"
          required
        />
      </fieldset>
      <fieldset>
        <input
          type="submit"
          value="비밀번호 변경하기"
        />
      </fieldset>
    </form>
    <!-- 현재 주소 -->
    <div> 
      <p>기존 주소 -  {{ currentUser.member_address }}</p>
      주소록 관리는 주문페이지에서 진행하시면 됩니다🍕
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  // vuex 불러오기
  name: "UserModify",
  data() {
    return {
      credentials: {
        userid: "",
        userpwd: "",
        newpwd: "",
      },
      newpwdconfirmation: "",
    }
  },
  // 비밀번호와 비밀번호 확인은 local에서 처리
  // 이후, 가입은 vuex에서 처리
  methods: {
    onSubmitInfo() {
      this.$store.dispatch('userStore/modifyuserinfo', this.currentUser)
      console.log('회원정보수정 vuex로 보냄')
    },
    onSubmitPwd() {
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
    ...mapGetters('userStore', ['currentUser']),
    issamepassword() {
      return Boolean(this.credentials.newpwd === this.newpwdconfirmation)
    }
  },
  created() {
    this.credentials.userid = this.currentUser.member_userid
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
