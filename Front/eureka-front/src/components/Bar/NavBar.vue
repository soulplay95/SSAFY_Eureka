<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-red">
      <div class="container">
        <!--fluid에서 그냥 container로 바꿈 -->
        <router-link to="/" class="navbar-brand" style="margin: 0px 20px 0px 100px;">
          <img :src="pic" alt="EUREKA">
        </router-link>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <div style="float: none">
              <div class="d-flex">
                <input
                  v-model.trim="searchText"
                  class="form-control me-2"
                  type="text"
                  placeholder="Search"
                  @keyup.enter="searchItem"
                >
                <button
                  class="btn btn-outline-success"
                  type="text"
                  placeholder="Search"
                  @click="searchItem"
                >
                  Search
                </button>
              </div>
            </div>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                마이유레카
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><router-link to="/user/mypage" class="dropdown-item">마이 페이지</router-link></li>
                <li><router-link to="/cart" class="dropdown-item">장바구니</router-link></li>
                <li><router-link to="/cs/cs-qna" class="dropdown-item">MY QNA</router-link></li>
              </ul>
            </li>
            <li v-if="!isAuthenticated" class="nav-item">
                <router-link to="/user/login" class="nav-link">로그인</router-link>
            </li>
            <li v-if="!isAuthenticated" class="nav-item">
                <router-link to="/user/join" class="nav-link">회원가입</router-link>
            </li>
            <li v-if="isAuthenticated" class="nav-item">
                <a @click="logout" class="nav-link">로그아웃</a>
            </li>
            <li v-if="isAuthenticated" class="nav-item">
                <router-link to="/admin/profile" v-if="isAdmin" class="nav-link">관리자 메뉴</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/cs/cs-qna" class="nav-link">고객센터</router-link>
            </li>
          </ul>
        </div>
      </div>
      <CategoryBar/>
    </nav>
  </div>
</template>

<script>

import pic from '@/assets/eureka.png'
// import { mapGetters } from 'vuex'
import CategoryBar from '@/components/Bar/CategoryBar'
export default {
  data: function () {
    return {
      searchText: null,
      pic:pic,
    }
  },
  components: {
    CategoryBar,
  },
  methods: {
    searchItem: function () {
      console.log(this.searchText)
      const searchText = this.searchText
      const val = 1
      this.$store.dispatch("itemStore/searchItem", { searchText, val})
      this.$router.push({ name: "ItemList" })
      this.searchText=""
    },
    logout() {
      this.$store.dispatch('userStore/logout')
    }
  },
  computed: {
    ...mapGetters ("userStore", ["isAuthenticated", "isAdmin"])
  },
  created() {
    // 카테고리 url이 정해지면 axios에 넣을 것.
    // axios({
    //   method: 'get',
    //   url: TMDB_URL,
    // })
    //   .then(res => {
    //     console.log(res)
    //   })
    //   .catch(err => {
    //     console.log(err)
    //   })
  },
};
</script>

<style>
nav {
  height: 75px;
  padding: 1rem;
  color: white;
  background: #b0eacd;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-item {
  cursor: pointer;
}
</style>