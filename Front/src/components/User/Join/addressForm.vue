<template>
  <div class="address-form">
    <!-- 주소 -->
    <el-form-item>
      <el-input  
        :value="address" placeholder="기본주소"
        size="small"
      >
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input      
        :value="extraAddr" placeholder="(동)"
        size="small"
      >
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input
        v-model="detailAddress"
        ref="detailAddress"
        placeholder="상세주소"
        size="small"
      >
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input 
        :value="postcode" placeholder="우편번호"
        size="small"
      >
      </el-input>
    </el-form-item>
    <el-button type="info" @click="getAddress()">우편번호 찾기</el-button>
  </div>
</template>

<script>
export default {
  name: 'addressForm',
  data() {
    return {
      address: '',
      extraAddr: '',
      postcode: '',
      detailAddress: ''
    }
  },
  methods: {
    getAddress() {
      new window.daum.Postcode({
        oncomplete: (userData) => {
          this.extraAddr = ''
          this.detailAddress = ''
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
          this.$refs.detailAddress.focus();
        },
      }).open();
    },
  },
};
</script>

<style scoped>
.address-form {
  display: flex;
  flex-direction: column;
}

template {
  font-size: 5rem;
}
</style>
