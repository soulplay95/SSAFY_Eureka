<template>
  <div>
    <section class="cart bgwhite">
      <div class="container">
        <!-- 카테고리 Dropdown -->
        <!-- <div id="category_dropdown">
          <div class="dropdown" style="display: inline-block">
            <button
              class="btn btn-secondary dropdown-toggle"
              type="button"
              id="dropdownMenu2"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Dropdown
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
              <li>
                <button class="dropdown-item" type="button">Action</button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Another action
                </button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Something else here
                </button>
              </li>
            </ul>
          </div>
          >
          <div class="dropdown" style="display: inline-block">
            <button
              class="btn btn-secondary dropdown-toggle"
              type="button"
              id="dropdownMenu2"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Dropdown
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
              <li>
                <button class="dropdown-item" type="button">Action</button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Another action
                </button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Something else here
                </button>
              </li>
            </ul>
          </div>
          >
          <div class="dropdown" style="display: inline-block">
            <button
              class="btn btn-secondary dropdown-toggle"
              type="button"
              id="dropdownMenu2"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Dropdown
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
              <li>
                <button class="dropdown-item" type="button">Action</button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Another action
                </button>
              </li>
              <li>
                <button class="dropdown-item" type="button">
                  Something else here
                </button>
              </li>
            </ul>
          </div>
        </div> -->

        <!-- 상품 정보 -->
        <div id="product_info">
          <div id="product_img">
            <div class="scale">
              <img :src="product.product.product_img" alt="IMG-PRODUCT" />
            </div>
          </div>
          <div id="product_detail">
            <div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-house"
                viewBox="0 0 16 16"
              >
                <path
                  fill-rule="evenodd"
                  d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"
                />
                <path
                  fill-rule="evenodd"
                  d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"
                />
              </svg>
              {{ product.product.seller_name }}
              <hr />
            </div>
            <h3>
              {{ product.product.product_name }}
            </h3>
            <div>
              <star-rating
                :rating="Number(product.product.product_rating)"
                :read-only="true"
                :show-rating="false"
                :increment="0.1"
                style="display: inline-block"
              ></star-rating>
              {{ $filters.price(product.review.length) }}개의 리뷰
            </div>
            <div
              style="
                display: flex;
                align-items: center;
                justify-content: center;
              "
            >
              <div style="display: inline-block; color: red; font-size: 40px">
                {{ product.product.product_discount }}%
              </div>
              &nbsp;&nbsp;&nbsp;
              <div style="display: inline-block">
                <del v-if="product.product.product_discount > 0">
                  {{ $filters.price(product.product.product_price) }}원
                  <br />
                </del>
                <h1 v-if="product.product.product_discount > 0">
                  {{
                    $filters.price(
                      Math.floor(
                        (product.product.product_price *
                          (1 - product.product.product_discount / 100)) /
                          10
                      ) * 10
                    )
                  }}원
                </h1>
                <b v-else>
                  {{ $filters.price(product.product.product_price) }}원
                </b>
              </div>
            </div>
            <hr />
            <div>
              <h5 v-if="product.product.product_deliveryprice > 0">
                배송비 : {{ $filters.price(product.product.deliveryprice) }}원
              </h5>
              <h5 v-else style="color: blue">무료배송</h5>
            </div>
            <div
              style="
                display: flex;
                align-items: center;
                justify-content: center;
              "
            >
              <el-button
                type="primary"
                @click="goCart(product.product.product_id)"
                >장바구니</el-button
              >&nbsp;&nbsp;&nbsp;
              <el-button type="success" @click="goOrder()">바로구매</el-button>
            </div>
          </div>
        </div>

        <!-- contents -->
        <div
          class="btn-group"
          role="group"
          aria-label="Basic radio toggle button group"
          style="margin-top: 100px; width: 100%"
        >
          <input
            type="radio"
            class="btn-check"
            name="btnradio"
            id="btnradio1"
            autocomplete="off"
            checked
          />
          <label
            class="btn btn-outline-primary"
            for="btnradio1"
            @click="setMode('detail')"
          >
            상품상세
          </label>

          <input
            type="radio"
            class="btn-check"
            name="btnradio"
            id="btnradio2"
            autocomplete="off"
          />
          <label
            class="btn btn-outline-primary"
            for="btnradio2"
            @click="setMode('review')"
          >
            상품리뷰
            <!-- <router-link
              to="/item/item-review"
              style="text-decoration: none"
            ></router-link
          > -->
          </label>

          <input
            type="radio"
            class="btn-check"
            name="btnradio"
            id="btnradio3"
            autocomplete="off"
          />
          <label
            class="btn btn-outline-primary"
            for="btnradio3"
            @click="setMode('qna')"
          >
            상품문의
          </label>
        </div>
        <div v-if="mode == 'detail'">
          <item-detail-image></item-detail-image>
        </div>
        <div v-if="mode == 'review'">
          <item-review></item-review>
        </div>
        <div v-if="mode == 'qna'">
          <item-qna></item-qna>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import http from '@/utils/http-common';

import StarRating from 'vue-star-rating';
import itemDetailImage from '@/components/Item/ItemDetailImage';
import itemReview from '@/components/Item/ItemReview';
import itemQna from '@/components/Item/ItemQna';

export default {
  name: 'itemDetail',
  components: {
    StarRating,
    itemDetailImage,
    itemReview,
    itemQna,
  },
  data() {
    return {
      mode: 'detail',
    };
  },
  async created() {
    await this.$store.dispatch(
      'itemDetail/getProductInfo',
      this.$route.query.product_id
    );
  },
  computed: {
    product() {
      return this.$store.getters['itemDetail/productInfo'];
    },
  },
  methods: {
    setMode(key) {
      this.mode = key;
    },
    goCart(product_id) {
      // 장바구니에 수량 1개로 추가
      http
        .post('/cart', {
          product_id,
          member_userid:
            this.$store.getters['userStore/currentUser'].member_userid,
          quantity: 1,
        })
        .then((res) => {
          if (res.status == 200) {
            alert('장바구니 담기 성공!');
          } else {
            alert('실패!');
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
#category_dropdown {
  width: 100%;
  height: 50px;
  text-align: left;
}
#product_info {
  display: flex;
}
#product_img {
  /* width: 30%; */
  display: inline-block;
  width: 325px;
  height: 280px;
  overflow: hidden;
}
#product_detail {
  width: 70%;
  display: inline-block;
}
.scale {
  display: inline-block;
  transform: scale(1);
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transition: all 0.3s ease-in-out; /* 부드러운 모션을 위해 추가*/
}
.scale:hover {
  transform: scale(1.2);
  -webkit-transform: scale(1.2);
  -moz-transform: scale(1.2);
  -ms-transform: scale(1.2);
  -o-transform: scale(1.2);
}
</style>
