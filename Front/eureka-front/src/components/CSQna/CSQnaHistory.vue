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
import CSQnaHistoryItem from '@/components/CSQna/CSQnaHistoryItem'
export default {
  components: {
    CSQnaHistoryItem,
  },
  computed: {
    questions: function () {
      return this.$store.state.CSQnaStore.myQnaHistory
    }
  }
}
</script>

<style>

</style>