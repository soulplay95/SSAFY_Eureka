<template>
  <div>
    <br><br><br>
    <div class="row g-2" style="margin: 30px 300px 10px 300px;">
      <div class="col-md-3">
        <div class="form-floating">
          <select class="form-select" id="floatingSelectGrid" aria-label="Floating label select example" v-model="category">
            <option selected></option>
            <option value="1">배송</option>
            <option value="2">주문</option>
            <option value="3">서비스 칭찬</option>
            <option value="4">시스템 개선</option>
          </select>
          <label for="floatingSelectGrid">문의 카테고리</label>
        </div>
      </div>
      <div class="col-md">
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInputGrid" v-model.trim="title">
          <label for="floatingInputGrid">제목</label>
        </div>
      </div>
    </div>
    <div class="mb-3" style="margin: 30px 300px 10px 300px;">
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model.trim="content"></textarea>
      <br><br>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <el-button icon="el-icon" @click="submitQna" style="background-color:#b0eacd; color:white;">
          <FontAwesomeIcon class="fa-2x" :icon="['fas', 'plane-departure']" />
        </el-button>
      </div>
    </div>
    <br><br><br><br>
  </div>
</template>

<script>
import axios from "axios"
// import http from '@/utils/http-common'
import { mapGetters } from 'vuex'
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

import JWTservice from '@/utils/JWT-common'

export default {
  data: function() {
    return {
      title: '',
      content: '',
      category: null,
      userid: '',
    }
  },
  components: {
    FontAwesomeIcon,
  },
  methods: {
    submitQna: function () {
      let category = ''
      switch (this.category) {
        case '1':
          category = '배송'
          break
        case '2':
          category = '주문'
          break
        case '3':
          category = '서비스 칭찬'
          break
        case '4':
          category = '시스템 개선'
      }
      console.log(category)
      const data = {
        qna_qtitle: this.title,
        qna_qcontent: this.content,
        qna_category: category,
        member_userid: this.currentUser.member_userid
      }
      console.log(this.currentUser.member_userid)
      console.log(JWTservice.getAccessToken())
      axios({
        method: 'post',
        url: `http://localhost/qna`,
        data: data,
        headers: {
          'jwt-auth-refresh-token': JWTservice.getAccessToken()
          // "Content-type": "application/json",
          // "Authorization": 'Bearer ' + JWTservice.getAccessToken()
        },
      }).
        then(res =>{
          console.log(res)
          console.log(res.config.data)
          // console.log(res.data['products'])
          // const products = res.data['products']
          // const pageCount = res.data['count']
          this.$store.dispatch('CSQnaStore/postQna', res.config.data)
        })
        .catch(err => {
          console.log(err)
        })
      // this.$store.dispatch('CSQnaStore/submitQna', query);
    },
  },
  computed: {
    ...mapGetters('userStore', ['currentUser']),
    // ...mapState('CSQnaStore', ['setToken']),
  },
}
</script>

<style>

</style>