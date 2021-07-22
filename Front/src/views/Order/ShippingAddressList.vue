<template>
  <div>
    <!-- Contents START -->
    <section class="cart bgwhite">
      <div class="container">
        <!-- 배송 주소록 리스트 테이블 START -->
        <el-table
          ref="multipleTable"
          :data="addressBook"
          style="width: 100%"
          @selection-change="handleSelectionChange"
        >
          <!-- 체크박스 -->
          <el-table-column type="selection" width="55"> </el-table-column>
          <!-- 별칭 -->
          <el-table-column label="별칭" width="120" show-overflow-tooltip>
            <template #default="scope">{{
              scope.row.shipaddress_nickname
            }}</template>
          </el-table-column>
          <!-- 주소 -->
          <el-table-column
            property="shipaddress_addr"
            label="주소"
            width="400"
            show-overflow-tooltip
          >
          </el-table-column>
          <!-- 연락처 -->
          <el-table-column
            property="shipaddress_phone"
            label="연락처"
            width="200"
            show-overflow-tooltip
          >
          </el-table-column>
          <!-- 요청사항 -->
          <el-table-column
            property="shipaddress_request"
            label="요청사항"
            width="150"
            show-overflow-tooltip
          >
          </el-table-column>
          <!-- 태그 -->
          <el-table-column
            prop="shipaddress_type"
            label="유형"
            width="150"
            :filters="[
              { text: '기본배송지', value: 1 },
              { text: '일반배송지', value: 2 },
            ]"
            :filter-method="filterTag"
            filter-placement="bottom-end"
          >
            <template #default="scope">
              <el-tag
                :type="scope.row.shipaddress_type === 1 ? 'primary' : 'success'"
                disable-transitions
                >{{ $filters.addressType(scope.row.shipaddress_type) }}</el-tag
              >
            </template>
          </el-table-column>
          <!-- 수정/삭제 -->
          <el-table-column label="Operations">
            <template #default="scope">
              <el-button
                size="mini"
                type="primary"
                @click="handleEdit(scope.row)"
                >수정</el-button
              >
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.row)"
                >삭제</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <!-- 배송 주소록 리스트 테이블 END -->

        <!-- 배송지 추가 버튼 -->
        <el-button style="margin-top: 20px" @click="handleAdd()"
          >배송지 추가</el-button
        >
      </div>
    </section>
    <!-- Contents END -->

    <!-- Dialog START -->
    <!-- 수정 Dialog -->
    <el-dialog title="배송지 수정" v-model="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="별칭" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_nickname"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="주소" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_addr"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="연락처" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_phone"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="요청사항" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_request"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="" :label-width="formLabelWidth">
          <el-checkbox v-model="form.shipaddress_type"
            >기본배송지로 저장</el-checkbox
          >
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <!-- <el-button @click="dialogFormVisible = false">Cancel</el-button> -->
          <el-button type="primary" @click="modifyAddress()">수정</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- 추가 Dialog -->
    <el-dialog title="배송지 추가" v-model="dialogFormVisibleAdd">
      <el-form :model="form">
        <el-form-item label="별칭" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_nickname"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="주소" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_addr"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="연락처" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_phone"
            autocomplete="on"
          ></el-input>
        </el-form-item>
        <el-form-item label="요청사항" :label-width="formLabelWidth">
          <el-input
            v-model="form.shipaddress_request"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="" :label-width="formLabelWidth">
          <el-checkbox v-model="form.shipaddress_type"
            >기본배송지로 저장</el-checkbox
          >
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <!-- <el-button @click="dialogFormVisibleAdd = false">Cancel</el-button> -->
          <el-button type="primary" @click="addAddress()">추가</el-button>
        </span>
      </template>
    </el-dialog>
    <!-- Dialog END -->
  </div>
</template>

<script>
export default {
  name: 'ShippingAddressList',
  data() {
    return {
      multipleSelection: [], // 선택된 row
      dialogFormVisible: false, // 배송지 수정 dialog
      dialogFormVisibleAdd: false, // 배송지 추가 dialog
      // 수정 form
      form: {
        shipaddress_id: '',
        shipaddress_nickname: '',
        shipaddress_addr: '',
        shipaddress_phone: '',
        shipaddress_request: '',
        shipaddress_type: false,
        member_userid: '',
      },
      formLabelWidth: '100px',
    };
  },
  computed: {
    // 로그인된 유저의 정보
    user() {
      return this.$store.getters['userStore/currentUser'];
    },
    // 배송 주소록
    addressBook() {
      return this.$store.getters['order/addressBook'];
    },
  },
  created() {
    // 로그인된 유저 아이디로 배송 주소록 리스트를 가져온다.
    this.$store.dispatch('order/getAddressBook', this.user.member_userid);
  },
  methods: {
    // 선택된 row를 관리해주는 메소드
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 타입 필터 관리 메소드
    filterTag(value, row) {
      return row.tag === value;
    },
    // 배송지 수정
    handleEdit(row) {
      // data setting
      this.form.shipaddress_id = row.shipaddress_id;
      this.form.shipaddress_nickname = row.shipaddress_nickname;
      this.form.shipaddress_addr = row.shipaddress_addr;
      this.form.shipaddress_phone = row.shipaddress_phone;
      this.form.shipaddress_request = row.shipaddress_request;
      this.form.shipaddress_type = row.shipaddress_type == 1 ? true : false; // true : 기본배송지
      this.form.member_userid = row.member_userid;

      this.dialogFormVisible = true; // 배송지 수정 dialog 띄우기
    },
    // 배송지 리얼 수정
    async modifyAddress() {
      if (this.form.shipaddress_type) {
        this.form.shipaddress_type = 1;
      } else {
        this.form.shipaddress_type = 2;
      }

      await this.$store.dispatch('order/modifyAddress', this.form);

      this.dialogFormVisible = false; // 창 닫기
    },
    // 배송지 삭제
    handleDelete(row) {
      this.$store.dispatch('order/deleteAddress', row.shipaddress_id);
    },
    // 배송지 추가
    handleAdd() {
      // data setting
      this.form.shipaddress_id = '';
      this.form.shipaddress_nickname = '';
      this.form.shipaddress_addr = '';
      this.form.shipaddress_phone = '';
      this.form.shipaddress_request = '';
      this.form.shipaddress_type = false; // true : 기본배송지
      this.form.member_userid = this.user.member_userid;

      this.dialogFormVisibleAdd = true; // 배송지 추가 dialog 띄우기
    },
    // 배송지 리얼 추가
    addAddress() {
      if (this.form.shipaddress_type) {
        this.form.shipaddress_type = 1;
      } else {
        this.form.shipaddress_type = 2;
      }

      this.$store.dispatch('order/addAddress', this.form);

      this.dialogFormVisibleAdd = false; // 창 닫기
    },
  },
};
</script>

<style></style>
