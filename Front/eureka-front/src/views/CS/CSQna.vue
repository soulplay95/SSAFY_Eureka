<template>
  <div>
    <ul class="nav nav-tabs" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">문의 내역</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="faq-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">FAQ</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="form-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">질문하기</button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        <CSQnaHistory/>
      </div>
      <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="faq-tab">
        <CSQnaFAQ/>
      </div>
      <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="form-tab">
        <CSQnaForm/>
      </div>
    </div>
  </div>
</template>

<script>
import CSQnaFAQ from '@/components/CSQna/CSQnaFAQ'
import CSQnaForm from '@/components/CSQna/CSQnaForm'
import CSQnaHistory from '@/components/CSQna/CSQnaHistory'

export default {
  components: {
    CSQnaFAQ,
    CSQnaForm,
    CSQnaHistory
  },
  // created: function () {
  //   console.log(request.user.is_authenticated)
  // }
}
</script>

<style>

</style>