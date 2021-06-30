<template>
  <div>
    <h1>여기는 로그인 페이지!</h1>
    <img src="https://picsum.photos/id/239/500/150" alt="Logo image" />
    <form @submit.prevent="onSubmit()">
      <fieldset>
        <input
          v-model="credentials.userid"
          type="email"
          placeholder="아이디(이메일)"
          autocomplete="email"
          pattern="^[^(\.)][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}"
          required
        >
        <input
          v-model="credentials.password"
          type="password" placeholder="비밀번호"
          autocomplete="password"  
          required
        >
        <input type="submit" value="로그인">

      </fieldset>
    <router-link to="/user/join">회원가입</router-link>
    <router-link to="/user/search-id">아이디 찾기</router-link>
    <router-link to="/user/search-password">비밀번호 찾기</router-link>
    </form>
    <!-- <googleAuth/> -->
  </div>


</template>

<script>
// import googleAuth from '@/components/User/Join/googleAuth'

export default {
  // vuex 불러오기
  name: "Login",
  components: {
    // googleAuth
  },
  data() {
    return {
      credentials: {
        userid: '',
        userpwd: ''
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
div, fieldset {
  display: flex;
  flex-direction: column;
  align-items: center;
}

fieldset > * {
  margin-top: 1rem;
}
</style>
