<template>
  <div id="reviewList">
    <h2>리뷰관리</h2>
    <h3>작성한 리뷰 수 : {{ reviewList.length }}</h3>
    <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col" id="col_image"></th>
          <th scope="col" id="col_title">리뷰 제목</th>
          <th scope="col" id="col_edit">수정</th>
          <th scope="col" id="col_edit">삭제</th>
        </tr>
      </thead>
      <tbody v-for="(review, index) in reviewList" :key="`${index}_item`">
        <tr
          data-bs-toggle="collapse"
          :data-bs-target="'#reviewDetailCollapse_' + review.review_id"
          aria-expanded="false"
          :aria-controls="'#reviewDetailCollapse_' + review.review_id"
        >
          <td>
            <img
              :src="review.review_img"
              alt="IMG-REVIEW"
              width="100"
              height="100"
            />
          </td>
          <td>{{ review.review_title }}</td>
          <!-- 수정 아이콘 -->
          <td>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-pencil-square"
              viewBox="0 0 16 16"
              @click="modify_review(review)"
            >
              <path
                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"
              />
              <path
                fill-rule="evenodd"
                d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"
              />
            </svg>
          </td>
          <!-- 삭제 아이콘 -->
          <td>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-trash"
              viewBox="0 0 16 16"
              @click="delete_review(review.review_id)"
            >
              <path
                d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"
              />
              <path
                fill-rule="evenodd"
                d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"
              />
            </svg>
          </td>
        </tr>
        <div
          class="collapse"
          :id="'reviewDetailCollapse_' + review.review_id"
          style="width: auto"
        >
          <div class="card card-body">
            <p>
              <strong>{{ review.review_title }}</strong>
            </p>
            <p>{{ $filters.date(review.review_date) }}</p>
            <p>
              <star-rating
                :rating="Number(review.review_rating)"
                :read-only="true"
                :show-rating="false"
              ></star-rating>
            </p>
            <p>
              <img
                :src="review.review_img"
                alt="IMG-REVIEW"
                width="100"
                height="100"
              />
            </p>
            <p>
              {{ review.review_content }}
            </p>
            <p>
              {{ review.review_liked }}
            </p>
          </div>
        </div>
      </tbody>
    </table>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';
import http from '@/utils/http-common';

export default {
  name: 'productReview',
  components: {
    StarRating,
  },
  computed: {
    reviewList() {
      return this.$store.getters['productReview/reviewList'];
    },
  },
  created() {
    // 작성한 리뷰 목록을 받아온다.
    // this.$store.dispatch('productReview/getReviewList');
  },
  methods: {
    // 리뷰 수정
    modify_review(review) {
      this.$router.push({ name: 'reviewModify', params: review });
    },
    // 리뷰 삭제
    delete_review(review_id) {
      http
        .delete('/review/' + review_id)
        .then((res) => {
          if (res.status == 200) {
            alert('리뷰 삭제 성공');
          } else {
            alert('리뷰 삭제 실패!');
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style scoped>
#reviewList {
  padding: 50px;
}
#col_image {
  width: 20%;
}
#col_title {
  width: 60%;
}
#col_edit {
  width: 10%;
}
</style>
