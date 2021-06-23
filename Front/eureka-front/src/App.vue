<template>
  <div id="nav">
    <!-- @상민 로그인, 회원가입 실험용 nav -->
    <!-- <router-link to="/">Home</router-link> |
    <router-link to="/user/join">Join</router-link>
    |
    <router-link to="/user/login">Login</router-link> -->
    <!-- --------------------------------------------------------------------- -->
    <!-- @도명 추가 - 테스트용 장바구니 nav -->
    <!-- TODO: PathVariable로 로그인된 id 넘겨주기 or 비로그인 시 장바구니 구현? -->
    <!-- <router-link to="/cart"> | 장바구니</router-link> -->
    <!-- --------------------------------------------------------------------- -->
    <!-- <router-link to="/">Home</router-link> |
    <router-link to="/user/join">Join</router-link> -->
  </div>
  <router-view />
</template>

<script>
import { defineComponent } from '@vue/composition-api'
export default defineComponent({
  setup() {
    
  },
})
</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
