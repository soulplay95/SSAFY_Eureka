<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-red">
      <div class="d-flex">
      <!-- <div class="container"> -->
        <!--fluid에서 그냥 container로 바꿈 -->
        <router-link to="/" class="navbar-brand" style="margin: 0px 20px 0px 100px;">
          <img :src="pic" alt="EUREKA" class="good">
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

                <div class="wrap">
                  <div class="search">
                      <input 
                      v-model.trim="searchText" 
                      type="text" 
                      class="searchTerm" 
                      placeholder="What are you looking for?"
                      @keyup.enter="searchItem"
                      >
                      <button 
                      type="submit" 
                      class="searchButton"
                      @click="searchItem"
                      >
                      <FontAwesomeIcon class="fa-lg" :icon="['fas', 'lightbulb']" />
                        <!-- <FontAwesomeIcon class="fa-lg" :icon="['fa', 'search']" /> -->
                    </button>
                  </div>
                </div>


                <!-- <input
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
                </button> -->


              </div>
            </div>
            <div class="d-flex" style="margin: -60px 0 10px 230px;">
              <li class="nav-item dropdown" >
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  style="color:#21bf73;"
                >
                <FontAwesomeIcon class="fa-2x" :icon="['fas', 'user-lock']" style="color:#21bf73;"/>
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><router-link to="/user/mypage" class="dropdown-item">마이 페이지</router-link></li>
                  <li><router-link to="/cart" class="dropdown-item">장바구니</router-link></li>
                  <li><router-link to="/cs/cs-qna" class="dropdown-item">MY QNA</router-link></li>
                </ul>
              </li>
              <li v-if="!isAuthenticated" class="nav-item">
                  <router-link to="/user/login" class="nav-link">
                    <FontAwesomeIcon class="fa-2x" :icon="['fas', 'sign-in-alt']" style="color:#21bf73;" />
                  </router-link>
              </li>
              <li v-if="!isAuthenticated" class="nav-item">
                  <router-link to="/user/join" class="nav-link">
                    <FontAwesomeIcon class="fa-2x" :icon="['fas', 'user-plus']" style="color:#21bf73;" />
                  </router-link>
              </li>
              <li v-if="isAuthenticated" class="nav-item">
                  <a @click="logout" class="nav-link">
                    <FontAwesomeIcon class="fa-2x" :icon="['fas', 'sign-out-alt']" style="color:#21bf73;" />
                  </a>
              </li>
              <li v-if="isAuthenticated" class="nav-item">
                  <router-link to="/admin/profile" v-if="isAdmin" class="nav-link">
                    <FontAwesomeIcon class="fa-2x" :icon="['fas', 'tasks']" style="color:#21bf73;" />
                  </router-link>
              </li>
              <li class="nav-item">
                <router-link to="/cs/cs-qna" class="nav-link">
                  <FontAwesomeIcon class="fa-2x" :icon="['fas', 'headset']" style="color:#21bf73;" />
                </router-link>
              </li>
            </div>

          </ul>
        </div>
      </div>


      <CategoryBar/>
    </nav>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import pic from '@/assets/eureka3.png'
import CategoryBar from '@/components/Bar/CategoryBar'
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
export default {
  data: function () {
    return {
      searchText: null,
      pic:pic,
    }
  },
  components: {
    CategoryBar,
    FontAwesomeIcon,
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
};
</script>

<style>
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.good {
  /* width: 70px; eureka2*/
  /* width: 100px; eureka3 */
  width: 150px;
  height: auto;
  background-size: contain;
  padding: 0;
  margin: -90px 70px 20px 80px;
  /* margin: 20px 70px 20px 80px; */

  
  transform: scale(1);
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transition: all 0.3s ease-in-out;   /* 부드러운 모션을 위해 추가*/
}

.good:hover {
  transform: scale(1.2);
  -webkit-transform: scale(1.2);
  -moz-transform: scale(1.2);
  -ms-transform: scale(1.2);
  -o-transform: scale(1.2);
}
.img {width:325px; height:280px; overflow:hidden }

nav {
  font-family: GmarketSansMedium;
  height: 185px;
  padding: 1rem;
  color: white;
  background: #fff;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 2% auto;
}

.nav-item {
  cursor: pointer;
}

@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
  
}

.search {
  width: 100%;
  position: relative;
  display: flex;
  
}

.searchTerm {
  width: 400%; 
  /* width: 100%;  */
  border: 3px solid #21bf73;
  border-right: none;
  padding: 5px;
  height: 36px;
  border-radius: 25px 0 0 25px;
  outline: none;
  color: #9DBFAF;
  margin: 0% auto;
}

.searchTerm:focus{
  color: #21bf73;
  
}

.searchButton {
  width: 340px;
  height: 36px;
  border: 1px solid #21bf73;
  background: #21bf73;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
  /* margin: 0px 200px 110px 0; */
}

/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 130%;
  /* position: relative; */
  position: static;
  top: 50%;
  left: 150%;
  transform: translate(20%, -140%);
  /* transform: translate(-150%, 10%); */
}
</style>