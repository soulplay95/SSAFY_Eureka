<template>
  <div>
    <!-- <section
      class="bg-title-page flex-col-c-m"
      style="background-image: url(https://picsum.photos/1920/239/?image=233)"
    >
      <h2 class="l-text2 t-center">Review Register</h2>
    </section> -->

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
          member_userid:
            this.$store.getters['userStore/currentUser'].member_userid,
          product_id: this.$route.query.product_id,
          review_content: this.content,
          review_img: this.image,
          review_rating: this.rate,
          review_title: this.title,
        })
        .then((response) => {
          if (response.status == 200) {
            // 상품 rating 수정
            this.updateRating();
            this.$router.push('/productreview');
          } else {
            alert('등록 실패!');
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    // 상품 rating 수정
    async updateRating() {
      let product_id = this.$route.query.product_id;
      let addRate = this.rate; // 추가할 rate
      let product_info; // 상품 정보

      await http
        .get('product/detailview/' + product_id)
        .then((res) => {
          if (res.status == 200) {
            product_info = res.data;
          }
        })
        .catch((err) => {
          console.error(err);
        });

      // 평균 rating 계산하여 다시 업데이트
      let totalRate = product_info.product.review_rating;
      let totalReviewCounts = product_info.review.length;
      let newRate = (totalRate + addRate) / (totalReviewCounts + 1);

      let result = product_info.product;
      result.product_rating = newRate;

      http
        .put('/product/modify', result)
        .then((res) => {
          if (res.status == 200) {
            alert('등록 완료!');
          } else {
            alert('등록 실패');
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style></style>
