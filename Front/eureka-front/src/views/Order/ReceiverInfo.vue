<template>
  <div>
    <table class="infoTable">
      <tr>
        <th>이름(별칭)</th>
        <td>
          {{ receiverInfo.shipaddress_nickname }}
          <span v-if="receiverInfo.shipaddress_type == 1">* 기본배송지</span>
        </td>
      </tr>
      <tr>
        <th>배송주소</th>
        <td>
          {{ receiverInfo.shipaddress_addr }}
        </td>
      </tr>
      <tr>
        <th>연락처</th>
        <td>{{ receiverInfo.shipaddress_phone }}</td>
      </tr>
      <tr>
        <th>배송 요청사항</th>
        <td>{{ receiverInfo.shipaddress_request }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import http from '@/utils/http-common';

export default {
  name: 'receiverInfo',
  data() {
    return {
      receiverInfo: {},
    };
  },
  async created() {
    let sid = this.$route.query.sid;
    let addressBook = [];

    await http
      .get(
        '/shipping/list/' + this.$store.getters['userStore/user'].member_userid
      )
      .then((res) => {
        if (res.status == 200) {
          addressBook = res.data;
        } else {
          alert('실패');
        }
      })
      .catch((err) => {
        console.error(err);
      });

    let ret = addressBook.filter((address) => {
      return address.shipaddress_id == sid;
    });

    this.receiverInfo = ret[0];
  },
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
