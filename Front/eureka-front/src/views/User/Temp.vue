<template>
  <button @click="postQna">실험</button>
</template>

<script>
import http from '@/utils/http-common'

export default {
  name: 'Temp',
  data() {
    return {
      qnaInfo: {
        qna_qtitle: 'axios가 안됩니다',
        qna_qcontent: 'axios header가 안담겨요',
        qna_category: '202',
        member_userid: 'abc@naver.com'
      }
    }
  },
  methods: {
    postQna() {
      http
        .post('qna', this.qnaInfo)
        .then((res) => {
          console.log('성공', res)
        })
        .catch((err) => {
          alert(err)
        })
      
    }
  }
}
</script>

<style>

</style>