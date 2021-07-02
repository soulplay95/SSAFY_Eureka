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
              <form class="d-flex">
                <input
                  class="form-control me-2"
                  type="search"
                  placeholder="Search"
                  aria-label="Search"
                  v-model.trim="searchText"
                  @keyup.enter="searchItem"
                />
                <button
                  class="btn btn-outline-success"
                  type="submit"
                  @click="searchItem"
                >
                  Search
                </button>
              </form>
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
                <li><a class="dropdown-item" href="#">주문목록</a></li>
                <li><a class="dropdown-item" href="#">취소/반품</a></li>
                <li><hr class="dropdown-divider" /></li>
                <li><a class="dropdown-item" href="#">찜리스트</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <router-link to="/cart" class="nav-link">장바구니</router-link>
            </li>
            <li v-if="!isAuthenticated" class="nav-item">
                <router-link to="/user/login" class="nav-link">로그인</router-link>
            </li>
            <li v-if="isAuthenticated" class="nav-item">
                <button @click="logout" class="nav-link">로그아웃</button>
            </li>
            <li class="nav-item">
                <router-link to="/user/join" class="nav-link">회원가입</router-link>
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
      this.$store.dispatch('itemStore/searchItem', this.searchText);
      // this.$router.push({ name: 'ItemList' });
    },
    logout() {
      this.$store.dispatch('userStore/logout')
    }
  },
  computed: {
    // ...mapGetters ("userStore", ["isAuthenticated"])
  },
};
</script>

<style>
nav{
  height: 75px;
  padding: 1rem;
  color: white;
  background: #b0eacd;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>