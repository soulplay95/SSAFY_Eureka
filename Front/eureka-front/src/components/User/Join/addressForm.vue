<template>
  <div>
  <!-- 주소 -->
    <input 
      type="text"
      :value="postcode"
      placeholder="우편번호"
    />
    <input 
      type="button"
      @click="getAddress"
      value="우편번호 찾기"
     />
    <input
      type="text"
      :value="address"
      placeholder="주소"
    />
    <input
      type="text"
      ref="detailAddress"
      placeholder="상세주소"
    />
    <input
      type="text"
      :value="extraAddr"
      placeholder="참고항목"
    />
    </div>
</template>

<script>
export default {
  name: "addressForm",
  data() {
    return {
      address: '',
      extraAddr: '',
      postcode: '',
    }
  },
  methods: {
    getAddress() {
      console.log(this.address)
      new window.daum.Postcode({
        oncomplete: (userData) => {
          console.log(userData.zonecode)
          if (userData.userSelectedType === 'R') {
            this.address = userData.roadAddress
          } else {
            this.address = userData.jibunAddress
          }
          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (userData.userSelectedType === 'R') {
            if(userData.bname !== '' && /[동|로|가]$/g.test(userData.bname)){
              this.extraAddr += userData.bname
            }
            if (userData.buildingName !== '' && userData.apartment === 'Y'){
              this.extraAddr += (this.extraAddr !== '' ? ' , ' + userData.buildingName : userData.buildingName)
            }
            if (this.extraAddr !== ''){
              this.extraAddr = ' (' + this.extraAddr + ')'
            }
          }
          this.postcode = userData.zonecode
          this.$refs.detailAddress.focus()
        }
      }).open()
    }
  }
}
</script>

<style>

</style>
