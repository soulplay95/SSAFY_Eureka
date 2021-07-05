<template>
  <div>
    <section class="cart bgwhite">
      <div class="container">
        <!-- form -->
        <div class="mb-3">
          <label for="rating" class="form-label">평점</label>
          <star-rating id="rating" v-model:rating="rate"></star-rating>
        </div>
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" />
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea class="form-control" id="content" rows="3"></textarea>
        </div>
        <div class="mb-3">
          <label for="img" class="form-label">사진첨부</label>
          <input
            class="form-control"
            type="file"
            id="formFile"
            v-if="!image"
            @change="onFileChange"
          />
          <div v-else>
            <img :src="image" />
            <button
              type="button"
              class="btn btn-secondary"
              @click="removeImage"
            >
              사진 다시 선택하기
            </button>
          </div>
        </div>
        <!-- 등록 버튼 -->
        <button type="button" class="btn btn-primary" @click="register()">
          등록하기
        </button>
      </div>
    </section>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';
import http from '@/utils/http-common';

export default {
  name: 'reviewRegister',
  components: {
    StarRating,
  },
  data() {
    return {
      rate: 0,
      title: '',
      content: '',
      image: '',
    };
  },
  methods: {
    onFileChange(e) {
      var files = e.target.files || e.dataTransfer.files;
      if (!files.length) return;
      this.createImage(files[0]);
    },
    // 이미지 생성
    createImage(file) {
      // var image = new Image();
      var reader = new FileReader();
      var vm = this;

      reader.onload = (e) => {
        vm.image = e.target.result;
      };
      reader.readAsDataURL(file);
    },
    // 이미지 삭제
    removeImage() {
      this.image = '';
    },
    // 리뷰 등록
    register() {
      http
        .post('/review', {
          member_userid: this.$store.getters['userStore/user'].member_userid,
          product_id: this.$route.query.product_id,
          review_content: this.content,
          review_img: this.image,
          review_rating: this.rate,
          review_title: this.title,
        })
        .then((response) => {
          if (response.status == 200) {
            alert('등록 성공!');
            this.$router.push('/productreview');
          } else {
            alert('등록 실패!');
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
};
</script>

<style></style>
