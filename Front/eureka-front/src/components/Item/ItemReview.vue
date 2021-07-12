<template>
  <!-- <div>
    <div>
      <h2>평점 :</h2>
      <star-rating
        :rating="Number(average_rating)"
        :read-only="true"
        :show-rating="false"
        :increment="0.1"
        style="display: inline-block"
      ></star-rating>
      {{ $filters.price(reviews.length) }}
    </div>
  </div> -->
  <link
    rel="stylesheet"
    href="https://allyoucan.cloud/cdn/icofont/1.0.1/icofont.css"
    integrity="sha384-jbCTJB16Q17718YM9U22iJkhuGbS0Gd2LjaWb4YJEZToOPmnKDjySVa323U+W7Fv"
    crossorigin="anonymous"
  />
  <div class="container">
    <div class="col-md-12" v-if="reviews.length == 0">리뷰가 없습니다.</div>
    <div class="col-md-12" v-if="reviews.length != 0">
      <div class="offer-dedicated-body-left">
        <div class="tab-content" id="pills-tabContent">
          <div
            class="tab-pane fade active show"
            id="pills-reviews"
            role="tabpanel"
            aria-labelledby="pills-reviews-tab"
          >
            <div
              class="
                bg-white
                rounded
                shadow-sm
                p-4
                mb-4
                clearfix
                graph-star-rating
              "
            >
              <h3 class="mb-0 mb-4">만족도</h3>
              <!-- 총점 -->
              <div class="graph-star-rating-header">
                <p
                  class="text-black mb-4 mt-2"
                  style="
                    display: flex;
                    align-items: center;
                    justify-content: center;
                  "
                >
                  <star-rating
                    :rating="average_rating"
                    :read-only="true"
                    :increment="0.01"
                    :star-size="50"
                  ></star-rating>
                  <!-- <el-rate
                    v-model="average_rating"
                    disabled
                    show-score
                    text-color="#ff9900"
                    :score-template="average_rating"
                  >
                  </el-rate> -->
                </p>
                <p>{{ reviews.length }} 건</p>
              </div>
              <!-- 리뷰 통계 -->
              <div class="graph-star-rating-body">
                <div class="rating-list">
                  <div class="rating-list-left text-black">5점</div>
                  <div class="rating-list-center">
                    <div class="progress">
                      <div
                        style="width: 56%"
                        aria-valuemax="5"
                        aria-valuemin="0"
                        aria-valuenow="5"
                        role="progressbar"
                        class="progress-bar bg-primary"
                      >
                        <span class="sr-only">2,211</span>
                      </div>
                    </div>
                  </div>
                  <div class="rating-list-right text-black">56%</div>
                </div>
                <!-- 4점 -->
                <div class="rating-list">
                  <div class="rating-list-left text-black">4점</div>
                  <div class="rating-list-center">
                    <div class="progress">
                      <div
                        style="width: 23%"
                        aria-valuemax="5"
                        aria-valuemin="0"
                        aria-valuenow="5"
                        role="progressbar"
                        class="progress-bar bg-primary"
                      >
                        <span class="sr-only">1,120</span>
                      </div>
                    </div>
                  </div>
                  <div class="rating-list-right text-black">23%</div>
                </div>
                <!-- 3점 -->
                <div class="rating-list">
                  <div class="rating-list-left text-black">3점</div>
                  <div class="rating-list-center">
                    <div class="progress">
                      <div
                        style="width: 11%"
                        aria-valuemax="5"
                        aria-valuemin="0"
                        aria-valuenow="5"
                        role="progressbar"
                        class="progress-bar bg-primary"
                      >
                        <span class="sr-only">555</span>
                      </div>
                    </div>
                  </div>
                  <div class="rating-list-right text-black">11%</div>
                </div>
                <!-- 2점 -->
                <div class="rating-list">
                  <div class="rating-list-left text-black">2점</div>
                  <div class="rating-list-center">
                    <div class="progress">
                      <div
                        style="width: 2%"
                        aria-valuemax="5"
                        aria-valuemin="0"
                        aria-valuenow="5"
                        role="progressbar"
                        class="progress-bar bg-primary"
                      >
                        <span class="sr-only">298</span>
                      </div>
                    </div>
                  </div>
                  <div class="rating-list-right text-black">7%</div>
                </div>
                <!-- 1점 -->
                <div class="rating-list">
                  <div class="rating-list-left text-black">1점</div>
                  <div class="rating-list-center">
                    <div class="progress">
                      <div
                        style="width: 2%"
                        aria-valuemax="5"
                        aria-valuemin="0"
                        aria-valuenow="5"
                        role="progressbar"
                        class="progress-bar bg-primary"
                      >
                        <span class="sr-only">99</span>
                      </div>
                    </div>
                  </div>
                  <div class="rating-list-right text-black">3%</div>
                </div>
              </div>
            </div>
            <!-- 리뷰창 -->
            <div
              class="
                bg-white
                rounded
                shadow-sm
                p-4
                mb-4
                restaurant-detailed-ratings-and-reviews
              "
            >
              <i class="fas fa-crown"></i>
              <div
                class="reviews-members pt-4 pb-4"
                v-for="(review, index) in reviews"
                :key="`${index}_review`"
              >
                <div class="media">
                  <img
                    alt="Generic placeholder image"
                    src="https://img.icons8.com/windows/96/000000/user.png"
                    class="mr-3 rounded-pill"
                  />
                  <div class="media-body">
                    <div class="reviews-members-header">
                      <p
                        class="text-black mb-4 mt-2"
                        style="
                          display: flex;
                          align-items: center;
                          justify-content: center;
                        "
                      >
                        <star-rating
                          :rating="Number(review.review_rating)"
                          :read-only="true"
                          :star-size="20"
                          style="text-align: center"
                          :show-rating="false"
                        ></star-rating>
                      </p>

                      <!-- <el-rate
                        v-value="Number(review.review_rating)"
                        disabled
                        style="margin-bottom: 10px"
                      ></el-rate> -->
                      <h6 class="mb-1">
                        <a class="text-black" href="#">{{
                          review.member_userid
                        }}</a>
                      </h6>
                      <p class="text-gray">
                        {{ $filters.date(review.review_date) }}
                      </p>
                    </div>
                    <div class="reviews-members-body">
                      <h5>
                        {{ review.review_title }}
                      </h5>
                      <p>
                        {{ review.review_content }}
                      </p>
                    </div>
                    <div class="reviews-members-footer">
                      <div
                        class="placement"
                        @click="like(review.review_id)"
                        style="
                          display: flex;
                          align-items: center;
                          justify-content: center;
                        "
                      >
                        <div
                          class="heart"
                          :class="{ 'is-active': toggle }"
                        ></div>
                        {{ review.review_liked }}
                      </div>
                    </div>
                  </div>
                </div>
                <hr />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';
import http from '@/utils/http-common';

export default {
  name: 'itemReview',
  components: {
    StarRating,
  },
  data() {
    return {
      toggle: false,
    };
  },
  computed: {
    // 평점
    average_rating() {
      return Number(
        this.$store.getters['itemDetail/productInfo'].product.product_rating
      );
    },
    // 리뷰s
    reviews() {
      let original_reviews =
        this.$store.getters['itemDetail/productInfo'].review;

      return original_reviews.sort((a, b) => {
        return b.review_liked - a.review_liked;
      });
    },
  },
  methods: {
    like(review_id) {
      this.toggle = !this.toggle;
      http
        .put('/review/' + review_id)
        .then((res) => {
          if (res.status == 200) {
            // 성공
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
.heart {
  width: 100px;
  height: 100px;
  background: url('https://cssanimation.rocks/images/posts/steps/heart.png')
    no-repeat;
  background-position: 0 0;
  cursor: pointer;
  transition: background-position 1s steps(28);
  transition-duration: 0s;
  &.is-active {
    transition-duration: 1s;
    background-position: -2800px 0;
  }
}
.is-active {
  width: 100px;
  height: 100px;
  background: url('https://cssanimation.rocks/images/posts/steps/heart.png')
    no-repeat;
  background-position: 0 0;
  cursor: pointer;
  transition: background-position 1s steps(28);
  transition-duration: 0s;
  transition-duration: 1s;
  background-position: -2800px 0;
}

#likediv {
  height: 100px;
  margin: 0 auto;
  position: relative;
}
#likei {
  cursor: pointer;
  padding: 10px 12px 8px;
  background: blanchedalmond;
  border-radius: 50%;
  display: inline-block;
  margin: 0 0 15px;
  color: #aaa;
  transition: 0.2s;
}

#likei:hover {
  color: #f0f;
}

#likei:before {
  /* font-family: fontawesome; */
  font-family: 'Font Awesome 5 Free';
  font-weight: 400;
  content: '\f004';
  font-style: normal;
}

#likespan {
  position: absolute;
  bottom: 70px;
  left: 0;
  right: 0;
  visibility: visible;
  transition: 0.6s;
  z-index: -2;
  font-size: 2px;
  color: transparent;
  font-weight: 400;
}

#likei.press {
  animation: size 0.4s;
  color: #e23b3b;
}

#likespan.press {
  bottom: 120px;
  font-size: 14px;
  visibility: visible;
  animation: fade 1s;
}

@keyframes fade {
  0% {
    color: transparent;
  }
  50% {
    color: #e23b3b;
  }
  100% {
    color: transparent;
  }
}

@keyframes size {
  0% {
    padding: 10px 12px 8px;
  }
  50% {
    padding: 14px 16px 12px;
    margin-top: -4px;
  }
  100% {
    padding: 10px 12px 8px;
  }
}
a {
  text-decoration: none;
}
body {
  background: #dcdcdc;
}
.total-like-user-main a {
  display: inline-block;
  margin: 0 -17px 0 0;
}
.total-like {
  border: 1px solid;
  border-radius: 50px;
  display: inline-block;
  font-weight: 500;
  height: 34px;
  line-height: 33px;
  padding: 0 13px;
  vertical-align: top;
}
.restaurant-detailed-ratings-and-reviews hr {
  margin: 0 -24px;
}
.graph-star-rating-header .star-rating {
  font-size: 17px;
}
.progress {
  background: #f2f4f8 none repeat scroll 0 0;
  border-radius: 0;
  height: 30px;
}
.rating-list {
  display: inline-flex;
  margin-bottom: 15px;
  width: 100%;
}
.rating-list-left {
  height: 16px;
  line-height: 29px;
  width: 10%;
}
.rating-list-center {
  width: 80%;
}
.rating-list-right {
  line-height: 29px;
  text-align: right;
  width: 10%;
}
.restaurant-slider-pics {
  bottom: 0;
  font-size: 12px;
  left: 0;
  z-index: 999;
  padding: 0 10px;
}
.restaurant-slider-view-all {
  bottom: 15px;
  right: 15px;
  z-index: 999;
}
.offer-dedicated-nav .nav-link.active,
.offer-dedicated-nav .nav-link:hover,
.offer-dedicated-nav .nav-link:focus {
  border-color: #3868fb;
  color: #3868fb;
}
.offer-dedicated-nav .nav-link {
  border-bottom: 2px solid #fff;
  color: #000000;
  padding: 16px 0;
  font-weight: 600;
}
.offer-dedicated-nav .nav-item {
  margin: 0 37px 0 0;
}
.restaurant-detailed-action-btn {
  margin-top: 12px;
}
.restaurant-detailed-header-right .btn-success {
  border-radius: 3px;
  height: 45px;
  margin: -18px 0 18px;
  min-width: 130px;
  padding: 7px;
}
.text-black {
  color: #000000;
}
.icon-overlap {
  bottom: -23px;
  font-size: 74px;
  opacity: 0.23;
  position: absolute;
  right: -32px;
}
.menu-list img {
  width: 41px;
  height: 41px;
  object-fit: cover;
}
.restaurant-detailed-header-left img {
  width: 88px;
  height: 88px;
  border-radius: 3px;
  object-fit: cover;
  box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075) !important;
}
.reviews-members .media .mr-3 {
  width: 56px;
  height: 56px;
  object-fit: cover;
}
.rounded-pill {
  border-radius: 50rem !important;
}
.total-like-user {
  border: 2px solid #fff;
  height: 34px;
  box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075) !important;
  width: 34px;
}
.total-like-user-main a {
  display: inline-block;
  margin: 0 -17px 0 0;
}
.total-like {
  border: 1px solid;
  border-radius: 50px;
  display: inline-block;
  font-weight: 500;
  height: 34px;
  line-height: 33px;
  padding: 0 13px;
  vertical-align: top;
}
.restaurant-detailed-ratings-and-reviews hr {
  margin: 0 -24px;
}
.graph-star-rating-header .star-rating {
  font-size: 17px;
}
.progress {
  background: #f2f4f8 none repeat scroll 0 0;
  border-radius: 0;
  height: 30px;
}
.rating-list {
  display: inline-flex;
  margin-bottom: 15px;
  width: 100%;
}
.rating-list-left {
  height: 16px;
  line-height: 29px;
  width: 10%;
}
.rating-list-center {
  width: 80%;
}
.rating-list-right {
  line-height: 29px;
  text-align: right;
  width: 10%;
}
.restaurant-slider-pics {
  bottom: 0;
  font-size: 12px;
  left: 0;
  z-index: 999;
  padding: 0 10px;
}
.restaurant-slider-view-all {
  bottom: 15px;
  right: 15px;
  z-index: 999;
}

.progress {
  background: #f2f4f8 none repeat scroll 0 0;
  border-radius: 0;
  height: 30px;
}
</style>
