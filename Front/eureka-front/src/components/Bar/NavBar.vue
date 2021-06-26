<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <!--fluid에서 그냥 container로 바꿈 -->
        <router-link to="/" class="navbar-brand">Navbar</router-link>
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
                <!-- <input class="form-control me-2" type="search" v-model.trim="searchText" @keyup.enter="searchItem"> -->
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
                카테고리
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#">주문목록</a></li>
                <li><a class="dropdown-item" href="#">취소/반품</a></li>
                <li><hr class="dropdown-divider" /></li>
                <li><a class="dropdown-item" href="#">찜리스트</a></li>
              </ul>
            </li>
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
              <a class="dropdown-item" href="#">
                <router-link to="/cart">장바구니</router-link>
              </a>
            </li>
            <li v-if="!isAuthenticated" class="nav-item">
              <a class="dropdown-item" href="#">
                <router-link to="/user/login">로그인</router-link>
              </a>
            </li>
            <li v-if="isAuthenticated" class="nav-item">
              <a class="dropdown-item" href="#">
                <button @click="logout">로그아웃</button>
              </a>
            </li>
            <li class="nav-item">
              <a class="dropdown-item" href="#">
                <router-link to="/user/join">회원가입</router-link>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  methods: {
    searchItem: function () {
      this.$store.dispatch('itemStore/searchItem', this.searchText);
      this.$router.push({ name: 'ItemList' });
    },
    logout() {
      this.$store.dispatch('userStore/logout')
    }
  },
  computed: {
    ...mapGetters ("userStore", ["isAuthenticated"])
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

<style></style>
