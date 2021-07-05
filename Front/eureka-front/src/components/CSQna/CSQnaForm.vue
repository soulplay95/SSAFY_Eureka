<template>
  <div>
    <h1>질문하기</h1>
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
        <button class="btn btn-primary me-md-2" type="button" @click="submitQna">보내기</button>
      </div>
    </div>
    
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      title: '',
      content: '',
      category: null,
    }
  },
  methods: {
    submitQna: function () {
      const query = {
        qna_qtitle: this.title,
        qna_qcontent: this.content,
        qna_category: String(this.category),
      }
      this.$store.dispatch('CSQnaStore/submitQna', query);
    },
  }

}
</script>

<style>

</style>