<template>
  <div>
    <section
      class="bg-title-page flex-col-c-m"
      style="background-image: url(https://picsum.photos/seed/picsum/1920/239)"
    >
      <h2 class="l-text2 t-center">Review Modify</h2>
    </section>
    <section class="cart bgwhite">
      <div class="container">
        <!-- form -->
        <label for="rating" class="form-label">평점</label>
        <div
          class="mb-3"
          style="display: flex; align-items: center; justify-content: center"
        >
          <star-rating id="rating" v-model:rating="rate"></star-rating>
        </div>
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" v-model="title" />
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea
            class="form-control"
            id="content"
            rows="3"
            v-model="content"
          ></textarea>
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
            <img :src="image" /><br />
            <button
              type="button"
              class="btn btn-secondary"
              @click="removeImage"
            >
              사진 다시 선택하기
            </button>
          </div>
        </div>
        <!-- 수정 버튼 -->
        <button type="button" class="btn btn-primary" @click="modify()">
          수정하기
        </button>
      </div>
    </section>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';
import http from '@/utils/http-common';

export default {
  name: 'reviewModify',
  components: {
    StarRating,
  },
  created() {
    this.rate = Number(this.$route.params.review_rating);
    this.title = this.$route.params.review_title;
    this.content = this.$route.params.review_content;
    this.image = this.$route.params.review_img;
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
    // 리뷰 수정
    modify() {
      http
        .put('/review', {
          member_userid:
            this.$store.getters['userStore/currentUser'].member_userid,
          product_id: this.$route.params.product_id,
          review_content: this.content,
          review_img: this.image,
          review_rating: this.rate,
          review_title: this.title,
          review_id: this.$route.params.review_id,
          review_liked: this.$route.params.review_liked,
        })
        .then((response) => {
          console.log(response.status);
          if (response.status == 200) {
            alert('수정 성공!');
            this.$router.push('/productreview');
          } else {
            alert('수정 실패!');
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
