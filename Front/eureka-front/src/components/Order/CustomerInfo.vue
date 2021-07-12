<template>
  <div>
    <!-- ======================== 구매자정보 ======================== -->
    <h2>구매자 정보</h2>
    <table class="infoTable">
      <tr>
        <th>이름</th>
        <td>{{ user.member_name }}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>{{ user.member_userid }}</td>
      </tr>
      <tr>
        <th>번호</th>
        <td>{{ user.member_phone }}</td>
      </tr>
    </table>
    <!-- ======================== 받는사람정보 ======================== -->
    <h2>받는사람 정보</h2>
    <!-- 배송지 추가 모달창 trigger 버튼 -->
    <button
      type="button"
      class="btn btn-info"
      data-bs-toggle="modal"
      data-bs-target="#add"
      style="margin-bottom: 20px"
      v-if="addressBook.length == 0"
    >
      배송지 추가
    </button>
    <!-- 배송 주소록(배송지 선택) 모달창 trigger 버튼 -->
    <button
      type="button"
      class="btn btn-info"
      data-bs-toggle="modal"
      data-bs-target="#select"
      style="margin-bottom: 20px"
      v-if="addressBook.length != 0"
    >
      배송지 변경
    </button>
    <!-- 받는사람정보 테이블 -->
    <p v-if="addressBook.length == 0">
      저장된 배송지가 없습니다. 배송지를 추가해주세요
    </p>
    <table class="infoTable" v-if="addressBook.length != 0">
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

    <!-- ======================== Modal창 ======================== -->
    <!-- ======================== Modal창 - 배송지 선택 ======================== -->
    <div
      class="modal fade"
      id="select"
      aria-hidden="true"
      aria-labelledby="exampleModalToggleLabel"
      tabindex="-1"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalToggleLabel">
              배송지 선택
            </h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <table
              class="modalTable"
              :class="{
                selected: receiverInfo.shipaddress_id == addr.shipaddress_id,
              }"
              v-for="(addr, index) in addressBook"
              :key="`${index}_item`"
            >
              <tr>
                <th>{{ addr.shipaddress_nickname }}</th>
              </tr>
              <tr v-if="addr.shipaddress_type === 1" style="color: blue">
                기본배송지
              </tr>
              <tr>
                <td>{{ addr.shipaddress_addr }}</td>
              </tr>
              <tr>
                <td>{{ addr.shipaddress_phone }}</td>
              </tr>
              <tr>
                <td>{{ addr.shipaddress_request }}</td>
              </tr>
              <tr>
                <td>
                  <button
                    type="button"
                    class="btn btn-success"
                    style="margin-right: 5px"
                    data-bs-target="#edit"
                    data-bs-toggle="modal"
                    data-bs-dismiss="modal"
                    @click="edit(addr)"
                  >
                    수정
                  </button>
                  <button
                    type="button"
                    class="btn btn-primary"
                    @click="updateReceiver(addr)"
                    data-bs-dismiss="modal"
                  >
                    선택
                  </button>
                </td>
              </tr>
            </table>
          </div>
          <div class="modal-footer">
            <button
              class="btn btn-primary"
              data-bs-target="#add"
              data-bs-toggle="modal"
              data-bs-dismiss="modal"
            >
              배송지추가
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- ======================== Modal창 - 배송지 추가 ======================== -->
    <div
      class="modal fade"
      id="add"
      aria-hidden="true"
      aria-labelledby="exampleModalToggleLabel"
      tabindex="-1"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalToggleLabel">
              배송지 추가
            </h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <!-- 추가폼 -->
            <form>
              <fieldset>
                <!-- 이름 -->
                <input
                  v-model="input.shipaddress_nickname"
                  type="text"
                  placeholder="받는 사람"
                  style="width: 100%"
                />
                <!-- 주소 -->
                <div style="width: 100%; margin-bottom: 10px">
                  <input
                    type="text"
                    v-model="postcode"
                    placeholder="우편번호"
                  />
                  <input
                    type="button"
                    @click="execDaumPostcode()"
                    value="우편번호 찾기"
                  /><br />
                  <input
                    type="text"
                    v-model="address"
                    placeholder="주소"
                    style="width: 100%"
                  /><br />
                  <input
                    type="text"
                    v-model="detailAddress"
                    placeholder="상세주소"
                    style="width: 50%"
                  />
                  <input
                    type="text"
                    v-model="extraAddr"
                    placeholder="참고항목"
                    style="width: 50%"
                  />
                </div>
                <!-- 연락처 -->
                <input
                  v-model="input.shipaddress_phone"
                  type="tel"
                  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                  placeholder="연락처"
                  style="width: 100%"
                />
                <!-- 배송요청사항 -->
                <input
                  v-model="input.shipaddress_request"
                  type="text"
                  placeholder="배송 요청사항"
                  style="width: 100%"
                />
                <div>
                  <label for="saveAsDefault">
                    <input
                      id="saveAsDefault"
                      type="checkbox"
                      v-model="input.isBasic"
                    />
                    <span>기본배송지로 저장</span>
                  </label>
                </div>
              </fieldset>
            </form>
          </div>
          <div class="modal-footer">
            <button
              class="btn btn-primary"
              data-bs-target="#select"
              data-bs-toggle="modal"
              data-bs-dismiss="modal"
              @click="save(user.member_userid)"
            >
              저장
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- ======================== Modal창 - 배송지 수정 ======================== -->
    <div
      class="modal fade"
      id="edit"
      aria-hidden="true"
      aria-labelledby="exampleModalToggleLabel"
      tabindex="-1"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalToggleLabel">
              배송지 수정
            </h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <!-- 추가폼 -->
            <form>
              <fieldset>
                <!-- 이름 -->
                <input
                  v-model="addressInEdit.shipaddress_nickname"
                  type="text"
                  placeholder="받는 사람"
                  style="width: 100%"
                />
                <!-- 주소 -->
                <div style="width: 100%; margin-bottom: 10px">
                  <input
                    type="text"
                    v-model="postcode"
                    placeholder="우편번호"
                  />
                  <input
                    type="button"
                    @click="execDaumPostcode()"
                    value="우편번호 찾기"
                  /><br />
                  <input
                    type="text"
                    v-model="address"
                    placeholder="주소"
                    style="width: 100%"
                  /><br />
                  <input
                    type="text"
                    v-model="detailAddress"
                    placeholder="상세주소"
                    style="width: 50%"
                  />
                  <input
                    type="text"
                    v-model="extraAddr"
                    placeholder="참고항목"
                    style="width: 50%"
                  />
                </div>
                <!-- 연락처 -->
                <input
                  v-model="addressInEdit.shipaddress_phone"
                  type="tel"
                  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                  placeholder="연락처"
                  style="width: 100%"
                />
                <!-- 배송요청사항 -->
                <input
                  v-model="addressInEdit.shipaddress_request"
                  type="text"
                  placeholder="배송 요청사항"
                  style="width: 100%"
                />
                <div>
                  <label for="saveAsDefault">
                    <input
                      id="saveAsDefault"
                      type="checkbox"
                      v-model="checked"
                    />
                    <span>기본배송지로 저장</span>
                  </label>
                </div>
              </fieldset>
            </form>
          </div>
          <div class="modal-footer">
            <button
              class="btn btn-primary"
              data-bs-target="#select"
              data-bs-toggle="modal"
              data-bs-dismiss="modal"
              @click="modify(addressInEdit.shipaddress_id)"
            >
              수정
            </button>
            <button
              class="btn btn-danger"
              data-bs-target="#select"
              data-bs-toggle="modal"
              data-bs-dismiss="modal"
              @click="deleteAddr(addressInEdit.shipaddress_id)"
            >
              삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'customerInfo',
  data() {
    return {
      input: {
        shipaddress_nickname: '',
        shipaddress_phone: '',
        shipaddress_request: '',
        isBasic: false,
      },
      address: '',
      extraAddr: '',
      postcode: '',
      detailAddress: '',
      addressInEdit: {}, // 수정 대상
    };
  },
  computed: {
    // 로그인된 유저 정보
    user() {
      return this.$store.getters['userStore/currentUser'];
    },
    // 로그인된 유저의 배송 주소록
    addressBook() {
      return this.$store.getters['order/addressBook'];
    },
    // 받는사람정보
    receiverInfo: {
      get() {
        return this.$store.getters['order/receiverInfo'];
      },
      set(value) {
        this.$store.state.order.receiverInfo = value;
      },
    },
    // 기본배송지인지
    checked: {
      get() {
        return this.addressInEdit.shipaddress_type == 1;
      },
      set(value) {
        this.addressInEdit.shipaddress_type = value ? 1 : 2;
      },
    },
  },
  methods: {
    // 리시버 정보를 변경한다.
    updateReceiver(addr) {
      this.$store.dispatch('order/updateReceiver', addr);
    },
    // 우편번호찾기
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (userData) => {
          this.extraAddr = '';
          if (userData.userSelectedType === 'R') {
            this.address = userData.roadAddress;
          } else {
            this.address = userData.jibunAddress;
          }
          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (userData.userSelectedType === 'R') {
            if (userData.bname !== '' && /[동|로|가]$/g.test(userData.bname)) {
              this.extraAddr += userData.bname;
            }
            if (userData.buildingName !== '' && userData.apartment === 'Y') {
              this.extraAddr +=
                this.extraAddr !== ''
                  ? ' , ' + userData.buildingName
                  : userData.buildingName;
            }
            if (this.extraAddr !== '') {
              this.extraAddr = '(' + this.extraAddr + ')';
            }
          }
          this.postcode = userData.zonecode;
        },
      }).open();
    },
    // 배송지 추가
    save(id) {
      // 전처리 - 데이터 다듬기
      var newAddr = {};
      newAddr.shipaddress_nickname = this.input.shipaddress_nickname;
      var fullAddr =
        this.address +
        ' ' +
        this.detailAddress +
        ' ' +
        this.extraAddr +
        ' ' +
        this.postcode;
      newAddr.shipaddress_addr = fullAddr;
      newAddr.shipaddress_phone = this.input.shipaddress_phone;
      newAddr.shipaddress_request = this.input.shipaddress_request;
      newAddr.shipaddress_type = this.input.isBasic ? 1 : 2;
      newAddr.member_userid = id;

      // addressBook에 추가
      this.$store.dispatch('order/addAddress', newAddr);

      // 초기화
      this.input.shipaddress_nickname = '';
      this.input.shipaddress_phone = '';
      this.input.shipaddress_request = '';
      this.input.isBasic = false;
      this.address = '';
      this.extraAddr = '';
      this.postcode = '';
      this.detailAddress = '';
    },
    // 수정 대상으로 설정
    edit(addr) {
      this.addressInEdit = addr;
    },
    // 배송지 수정
    modify(addrID) {
      var addr = {};
      addr.shipaddress_id = addrID;
      addr.shipaddress_nickname = this.addressInEdit.shipaddress_nickname;
      addr.shipaddress_phone = this.addressInEdit.shipaddress_phone;
      addr.shipaddress_request = this.addressInEdit.shipaddress_nickname;
      // 기본배송지로 수정
      if (this.checked) {
        addr.shipaddress_type = 1;
      } else {
        addr.shipaddress_type = 2;
      }
      addr.member_userid = this.addressInEdit.member_userid;
      // 주소 전처리
      var fullAddr =
        this.address +
        ' ' +
        this.detailAddress +
        ' ' +
        this.extraAddr +
        ' ' +
        this.postcode;
      addr.shipaddress_addr = fullAddr;
      // 수정
      this.$store.dispatch('order/modifyAddress', addr);

      this.addressInEdit = {};
    },
    // 배송지 삭제
    deleteAddr(addrID) {
      this.$store.dispatch('order/deleteAddress', addrID);
    },
  },
  created() {
    // 배송 주소록 받아오기
    this.$store.dispatch('order/getAddressBook', this.user.member_userid);
    // 받는사람정보 기본배송지로 초기화
    this.$store.dispatch('order/initReceiverInfo');
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
.modalTable {
  width: 100%;
  border: 2px solid #333333;
}
.selected {
  width: 100%;
  border: 2px solid blue;
}
fieldset > input {
  margin-bottom: 10px;
}
</style>
