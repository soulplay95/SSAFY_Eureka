<template>
  <div>
    <div class="row">
      <div class="col">
        <span>{{ question.qna_category }}</span>
      </div>
      <div class="col">
        {{ question.qna_qtitle }}
      </div>
      <div class="col-6">
        {{ question.qna_qcontent }}
      </div>
      <button class="col" @click="deleteQuestion(question)">Delete</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    question: {
      type: Object,
    }
  },
  methods: {
    deleteTodo: function () {
      console.log('문의 삭제')
      // this.$store.dispatch('deleteTodo', this.todo)
    },
    // updateTodo: function () {
    //   // console.log('수정!')
    //   this.$store.dispatch('updateTodo', this.todo)
    // }
    // ...mapActions([
    //   'deleteQuestion',
    //   'updateQuestion',
    // ])
  }
}
</script>

<style>

</style>