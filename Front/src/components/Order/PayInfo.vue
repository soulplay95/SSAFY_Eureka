<template>
  <div>
    <h2>결제 정보</h2>
    <div class="orderInfo">
      <ul class="info1">
        <li style="margin-left: 100px">
          <dl>
            <dt style="float: left">상품금액</dt>
            <dd style="text-align: right; margin-right: 100px">
              {{ $filters.price(totalProductPrice) }}원
            </dd>
          </dl>
        </li>
        <li style="margin-left: 100px">
          <dl>
            <dt style="float: left">할인금액</dt>
            <dd style="text-align: right; margin-right: 100px">
              - {{ $filters.price(totalDiscountPrice) }}원
            </dd>
          </dl>
        </li>
        <li style="margin-left: 100px">
          <dl>
            <dt style="float: left">배송비</dt>
            <dd style="text-align: right; margin-right: 100px">
              + {{ $filters.price(totalDeliveryPrice) }}원
            </dd>
          </dl>
        </li>
        <hr style="margin: 0 0" />
        <li style="margin-left: 100px; margin-top: 30px">
          <dl>
            <dt style="float: left">결제금액</dt>
            <dd style="text-align: right; margin-right: 100px">
              <strong>{{ $filters.price(totalPrice) }}원</strong>
            </dd>
          </dl>
        </li>
      </ul>
    </div>
    <!-- 결제 버튼 -->
    <button
      type="button"
      class="btn btn-primary"
      style="font-size: 25px; padding: 10px 10px"
      @click="pay(selectedProducts)"
    >
      결제하기
    </button>
  </div>
</template>

<script>
import http from '@/utils/http-common';

export default {
  name: 'payInfo',
  computed: {
    totalProductPrice() {
      return this.$store.getters['cart/totalProductPrice'];
    },
    totalDiscountPrice() {
      return this.$store.getters['cart/totalDiscountPrice'];
    },
    totalDeliveryPrice() {
      return this.$store.getters['cart/totalDeliveryPrice'];
    },
    totalPrice() {
      return this.$store.getters['cart/totalPrice'];
    },
    // 결제 예정 상품 리스트
    selectedProducts() {
      return this.$store.getters['cart/selectedProducts'];
    },
    // 배송지
    shipaddress_id() {
      return this.$store.getters['order/receiverInfo'].shipaddress_id;
    },
  },
  methods: {
    // 결제하기
    pay(list) {
      let map = {};
      let order = {};
      order.member_userid =
        this.$store.getters['userStore/currentUser'].member_userid; // user id

      // orderdetails 속성 만들기
      let array = [];
      list.forEach((element) => {
        let item = {};
        item.orderdetail_count = element.quantity;
        item.product_id = element.product_id;
        item.orderdetail_state = '배송준비중';
        let price = Number(element.product_price);
        let discount = Number(element.product_discount);
        let delivery = Number(element.product_deliveryprice);
        let tprice =
          Math.floor(
            (element.quantity * (price * (1 - discount / 100)) + delivery) / 10
          ) * 10;
        item.orderdetail_price = String(tprice);

        array.push(item);
      });

      map.orderdetails = array;

      order.shipaddress_id = this.shipaddress_id;
      order.order_totalprice = this.totalPrice;

      map.order = order;

      http
        .post('/order', map)
        .then((res) => {
          if (res.status == 200) {
            alert('결제 성공!');
            this.$router.push('/');
          } else {
            alert('결제 실패!');
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
.orderInfo {
  width: 100%;
  margin-bottom: 20px;
  border: 4px solid #333333;
}
.info1 {
  padding: 15px 0px 15px 15px;
}
</style>
