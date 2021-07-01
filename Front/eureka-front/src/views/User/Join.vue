<template>
  <div>
    <h1>회원가입 페이지!</h1>
    <form @submit.prevent="onSubmit()">
      <!-- 아이디 -->
      <fieldset>
        <!-- id camelCase? kebab-case? -->
        <input
          v-model="credentials.userid"
          :disabled="isIdChecked"
          type="email"
          placeholder="아이디(이메일)"
          autocomplete="email"
          pattern="^[^(\.)][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}"
          required
        />
        <button @click.prevent="onSubmitId()">{{ idCheckMessage }}</button>
      </fieldset>
      <!-- 비밀번호 -->
      <fieldset>
        <input
          v-model="credentials.userpwd"
          type="password"
          minlength="8"
          placeholder="비밀번호"
          autocomplete="new-password"
          required
        />
      </fieldset>
      <fieldset>
        <!-- 비밀번호 확인 -->
        <input
          v-model="userpwdconfirmation"
          type="password"
          minlength="8"
          placeholder="비밀번호 확인"
          autocomplete="new-password"
          required
        />
      </fieldset>
      <!-- 이름 -->
      <fieldset>
        <input 
          v-model="credentials.name" 
          type="text" 
          placeholder="이름"
          required
        />
      </fieldset>
      <!-- 연락처 -->
      <fieldset>
        <input
          v-model="credentials.phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"
          required
        />
      </fieldset>
      <!-- 주소 -->
      <addressForm class="addressForm"
      ref="addressForm"
      />
      <input
        type="submit" 
        value="회원가입"
      />
    </form>
  </div>
</template>

<script>
// useStore 훅을 사용하여 store에 접근합니다.
import addressForm from '@/components/User/Join/addressForm'
import http from '@/utils/http-common'

export default {
  name: "Join",
  components: {
    addressForm
  },
  data() {
    return {
      credentials: {
        userid: "",
        userpwd: "",
        name: "",
        phone: "",
        address: "",
        type: "일반"
      },
      userpwdconfirmation: "",
      isIdChecked: false
    }
  },
  methods: {
    // 회원가입 정보 Submit
    onSubmit() {
      if (!this.isIdChecked) {
        return alert('아이디 중복 검사를 진행해주세요!')
      }
      if (this.issamepassword) {
        this.updateAddress()
        this.$store.dispatch("userStore/register", this.credentials)
      } else {
        this.resetPassword()
        alert("입력하신 비밀번호가 다릅니다!")
      }
    },
    onSubmitId() {
      // 중복검사 받은 아이디 수정
      if (this.isIdChecked) {
        this.isIdChecked = false
      } else {
        // 아이디 중복검사
        http
          .get('member/isDuplicated/' + this.credentials.userid)
          .then((res) => {
            if (res.status == 200) {
              alert('사용가능합니다')
              this.isIdChecked = true
            } else if (res.status == 204) {
              alert('아이디가 사용중입니다')
              this.resetUserId()
            }
          })
          .catch((err) => {
            console.log(err)          
            alert('아이디를 다시 입력해주세요!')
          })
      }
    },
    // 패스워드 입력창 초기화
    resetPassword() {
        this.credentials.userpwd = ""
        this.userpwdconfirmation = ""
    },
    resetUserId() {
      this.userid = ""
    },
    // 주소 업데이트
    updateAddress() {
      let address = ""
      // 기본 주소
      address += this.$refs.addressForm.address
      // 상세주소
      if (this.$refs.addressForm.detailAddress) {
        address += ' ' + this.$refs.addressForm.detailAddress
      // 참고주소
      address += ' ' + this.$refs.addressForm.extraAddr
      // 우편번호
      address += ' ' + this.$refs.addressForm.postcode
      this.credentials.address = address
      }
    }
  },
  computed: {
    issamepassword() {
      return Boolean(this.credentials.userpwd === this.userpwdconfirmation)
    },
    idCheckMessage() {
      return this.isIdChecked ? '아이디 새로 입력' : '아이디 중복 검사'
    }
  }
}
</script>
<style scoped>
  fieldset {
    display: flex;
    flex-direction: column;
    text-align: center;
    border-radius: 1rem;
  }

  fieldset * {
    margin-top: 0.5rem;
    padding: 0.5rem;
  }

  fieldset input {
    border: 1px solid black;
    border-radius: 1rem;
    margin: 1rem 2rem;
  }

  fieldset input:focus {
    outline:none;
  }

  .addressForm {
    display: flex;
  }

  .beDisabled {
    position: dis;
  }

</style>
