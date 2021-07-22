<template>
  <div>
    <!-- @@@@@@@@@@@@@@@@@@@ Contents @@@@@@@@@@@@@@@@@@@ -->
    <section class="cart bgwhite">
      <div class="container">
        <!-- @@@@@@@@@@@@@@@@@@@ 기간별 조회 @@@@@@@@@@@@@@@@@@@ -->
        <div id="calendar">
          <input type="date" v-model="start_date" /> ~
          <input type="date" v-model="end_date" />
          <el-button
            icon="el-icon-search"
            circle
            @click="inquiry(start_date, end_date)"
            style="margin-left: 15px"
          ></el-button>
        </div>

        <!-- @@@@@@@@@@@@@@@@@@@ 주문 목록 @@@@@@@@@@@@@@@@@@@ -->
        <!-- 한 주문 -->
        <div
          id="order"
          class="card"
          v-for="(order, index) in orderList"
          :key="`${index}_item`"
        >
          <div
            class="card-header"
            style="display: flex; align-items: center; justify-content: center"
          >
            <strong style="font-size: 20px"
              >{{ $filters.date(order.order.order_date) }} 주문</strong
            >
            <!-- 배송지정보 보기 버튼 -->
            <el-popover placement="right" :width="400" trigger="click">
              <template #reference>
                <el-button
                  type="warning"
                  icon="el-icon-house"
                  circle
                  @click="getShip(order.order.shipaddress_id)"
                ></el-button>
              </template>
              <el-table :data="addr">
                <el-table-column
                  width="100"
                  property="shipaddress_nickname"
                  label="이름"
                ></el-table-column>
                <el-table-column
                  width="100"
                  property="shipaddress_addr"
                  label="주소"
                ></el-table-column>
                <el-table-column
                  width="100"
                  property="shipaddress_phone"
                  label="번호"
                ></el-table-column>
                <el-table-column
                  width="100"
                  property="shipaddress_request"
                  label="요청사항"
                ></el-table-column>
              </el-table>
            </el-popover>
            <!-- 삭제버튼 -->
            <el-popconfirm
              confirmButtonText="OK"
              cancelButtonText="No, Thanks"
              icon="el-icon-info"
              iconColor="red"
              title="삭제하시겠습니까?"
              @confirm="delete_order(order.order.order_id)"
            >
              <template #reference>
                <el-button
                  type="danger"
                  icon="el-icon-delete"
                  circle
                ></el-button>
              </template>
            </el-popconfirm>

            <!-- <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-truck"
              viewBox="0 0 16 16"
              @click="viewReceiverInfo(order.order.shipaddress_id)"
            >
              <path
                d="M0 3.5A1.5 1.5 0 0 1 1.5 2h9A1.5 1.5 0 0 1 12 3.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-3.998-.085A1.5 1.5 0 0 1 0 10.5v-7zm1.294 7.456A1.999 1.999 0 0 1 4.732 11h5.536a2.01 2.01 0 0 1 .732-.732V3.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .294.456zM12 10a2 2 0 0 1 1.732 1h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12v4zm-9 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"
              /></svg
            >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
            <!-- 삭제버튼 -->
            <!-- <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-trash"
              viewBox="0 0 16 16"
              @click="delete_order(order.order.order_id)"
            >
              <path
                d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"
              />
              <path
                fill-rule="evenodd"
                d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"
              />
            </svg> -->
          </div>
          <el-table :data="order.orderdetail_list" style="width: 100%">
            <el-table-column type="expand">
              <template #default="props">
                <div @click="getProductInfo(props.row.product_id)">
                  <img
                    :src="productInfo.product_img"
                    class="img-fluid rounded-start"
                    alt="상품 메인 이미지"
                  />
                  <p>
                    <router-link
                      style="text-decoration: none"
                      :to="
                        '/item/item-detail?product_id=' + productInfo.product_id
                      "
                      >{{ productInfo.product_name }}</router-link
                    >
                  </p>
                  <p>
                    가격: {{ $filters.price(props.row.orderdetail_price) }}원
                  </p>
                  <p>
                    수량: {{ $filters.price(props.row.orderdetail_count) }}개
                  </p>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="상품번호" prop="product_id">
            </el-table-column>
            <el-table-column label="배송상태" prop="orderdetail_state">
            </el-table-column>
            <el-table-column align="right">
              <template #default="scope">
                <el-button
                  size="mini"
                  @click="write_review(scope.row.product_id)"
                  >리뷰 쓰기</el-button
                >
              </template>
            </el-table-column>
          </el-table>
          <!-- <div
            id="product"
            class="card-body"
            v-for="(item, i) in order.orderdetail_list"
            :key="`${i}_item`"
          > -->
          <!-- 주문당 상품 -->
          <!-- <div class="card">
              <div class="card-body">
                <h5 class="card-title">
                  <strong>{{ item.orderdetail_state }}</strong>
                </h5>
                <p class="card-text">
                  product_id : {{ item.product_id }}
                  <button
                    type="button"
                    class="btn btn-dark"
                    style="float: right"
                    @click="write_review(item.product_id)"
                  >
                    리뷰 작성하기
                  </button>
                </p>
                <p class="card-text">
                  {{ $filters.price(item.orderdetail_price) }}원 /
                  {{ $filters.price(item.orderdetail_count) }}개
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-cart-plus"
                    viewBox="0 0 16 16"
                    @click="addCart(item.product_id)"
                  >
                    <path
                      d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"
                    />
                    <path
                      d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"
                    />
                  </svg>
                </p>
              </div>
            </div>
          </div> -->
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import http from '@/utils/http-common';

export default {
  name: 'orderList',
  data() {
    return {
      // 끝 날짜(현재 날짜)
      end_date: '',
      // 시작 날짜(현재 날짜 기준 1개월 전)
      start_date: '',
      addr: [],
      productInfo: {},
    };
  },
  mounted() {
    this.end_date = new Date().toISOString().substring(0, 10); // end_date : 현재 날짜로 초기화

    let date = new Date();
    date.setMonth(date.getMonth() - 1);
    this.start_date = date.toISOString().substring(0, 10); // start_date : 1개월 전 날짜로 초기화
  },
  computed: {
    // 기간 내 주문 목록 (주문일 기준 내림차순)
    orderList() {
      let list = this.$store.getters['order/orderList']; // 원본

      let ordered_list = list.sort((a, b) => {
        let dateA = new Date(a['order_date']).getTime();
        let dateB = new Date(b['order_date']).getTime();

        return dateA < dateB ? 1 : -1;
      });

      return ordered_list;
    },
    // 상품 디테일 정보
    // product_detail(id) {
    //   let products = this.$store.getters['order/product_details']; // 원본
    //   return products.$filter((product) => product.product_id == id);
    // },
  },
  created() {
    let userid = this.$store.getters['userStore/currentUser'].member_userid; // 로그인된 유저 아이디

    // user_id에 해당하는 전체 주문 목록을 받아온다.
    this.$store.dispatch('order/getOrderList', userid);

    // let list = this.orderList.orderdetail_list;
    // console.log(list);
    // list.forEach((element) => {
    //   let id = element.orderdetail_id;
    //   this.$store.dispatch('order/getProductDetails', id);
    // });
    // console.log(this.product_detail(20));
  },
  methods: {
    getShip(id) {
      let addressBook = this.$store.getters['order/addressBook'];

      this.addr = addressBook.filter((addr) => {
        return addr.shipaddress_id == id;
      });
    },
    // 기간별 조회
    inquiry(s, e) {
      this.orderList = this.orderList(s, e);
    },
    // 배송지(받는사람정보) 조회
    viewReceiverInfo(shipaddress_id) {
      this.$router.push('/receiverinfo?sid=' + shipaddress_id);
    },
    // 장바구니 담기 (수량 1개로)
    addCart(product_id) {
      let data = {
        product_id: product_id,
        member_userid: this.$store.getters['userStore/user'].member_userid,
        quantity: 1,
      };

      http
        .post('/cart', data)
        .then((response) => {
          if (response.status == 200) {
            alert('장바구니에 상품이 담겼습니다.');
          } else {
            alert('장바구니 담기 실패!');
          }
        })
        .catch((err) => {
          // console.error(err.response.status);
          if (err.response.status == 409) {
            alert('이미 해당 상품이 장바구니에 있습니다.');
          }
        });
    },
    // 주문 목록 삭제
    delete_order(order_id) {
      http
        .delete('order?order_id=' + order_id)
        .then((res) => {
          if (res.status == 200) {
            alert('해당 주문 목록이 삭제되었습니다.');
          } else {
            alert('삭제 실패');
          }
        })
        .catch((err) => {
          console.err(err);
        });
    },
    // 리뷰 작성
    write_review(product_id) {
      this.$router.push('/productreview/register?product_id=' + product_id);
    },
    // 상품 정보 가져오기
    async getProductInfo(product_id) {
      await http
        .get('product/detailview/' + product_id)
        .then((res) => {
          if (res.status == 200) {
            this.productInfo = res.data.product;
          } else {
            alert('상품 조회 실패!');
          }
        })
        .catch((err) => {
          console.err(err);
        });
    },
  },
};
</script>

<style lang="scss">
#inquiry_button {
  margin-left: 10px;
}
#order {
  margin-bottom: 20px;
}
#calendar {
  margin-bottom: 50px;
}
#product {
  margin-bottom: 10px;
}
@import '@/assets/scss/_common.scss';
</style>
