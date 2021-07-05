<template>
  <div>
    <div class="row">
      <div class="col">
        <span v-if="question.category === 1">
          (배송)
        </span>
        <span v-else-if="question.category === 2">
          (주문)
        </span>
        <span v-else-if="question.category === 3">
          (서비스 칭찬)
        </span>
        <span v-else>
          (시스템개선)
        </span>
      </div>
      <div class="col">
        {{ question.title }}
      </div>
      <div class="col-6">
        {{ question.content }}
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