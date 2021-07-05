<template>
  <div>
    <h1>나의 문의내역</h1>
    <CSQnaHistoryItem 
      v-for="(question, idx) in questions" 
      :key="idx"
      :question="question"
    />
  </div>
</template>

<script>
import axios from 'axios'
import { mapState, mapActions } from 'vuex' 
import CSQnaHistoryItem from '@/components/CSQna/CSQnaHistoryItem'
export default {
  components: {
    CSQnaHistoryItem,
  },
  computed: {
    ...mapState( 'CSQnaStore', ['myQnaHistory', 'setToken']),
    ...mapActions(
      'CSQnaStore', 
      [
        // 'getArticleDetail', 'addComment', 
        // 'likeArticle', 'deleteArticle', 'getUpdateData'

      ]
    ),
  }, 
  created: function () {
    axios({
      method: 'get',
      url: `http://localhost/qna`,
      headers: this.setToken
    })
    .then(res =>{
      console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style>

</style>