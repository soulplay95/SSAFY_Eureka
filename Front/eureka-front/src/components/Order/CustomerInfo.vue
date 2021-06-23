<template>
  <div>
    <!-- 구매자정보 -->
    <h2>구매자정보</h2>
    <table class="infoTable">
      <tr>
        <th>이름</th>
        <td>{{ user.name }}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>{{ user.userid }}</td>
      </tr>
      <tr>
        <th>번호</th>
        <td>{{ user.phone }}</td>
      </tr>
    </table>
    <!-- 받는사람정보 -->
    <h2>받는사람정보</h2>

    <table></table>
  </div>
</template>

<script>
export default {
  name: 'customerInfo',
  computed: {
    // 로그인된 유저 정보
    user() {
      return this.$store.state.userStore.user;
    },
    // 로그인된 유저의 배송 주소록
    addressBook() {
      return this.$store.state.order.addressBook;
    },
  },
  methods: {},
};
</script>

<style scoped>
.infoTable {
  width: 100%;
  border-top: 1px solid #333333;
  border-collapse: collapse;
  margin-bottom: 20px;
}
.infoTable > tr {
  border-bottom: 1px solid #333333;
}
</style>
