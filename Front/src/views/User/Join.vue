<template>
  <el-row class="signup-container" type="flex" align="middle">
    <el-col :span="8" :offset="7" class="signup-form">
      <logo/>
      <el-form 
        :model="credentials"
        :rules="rules"
        :label-position="labelPosition"
        ref="signUpForm"
        label-width="150px"
      >
        <!-- 아이디 -->
        <el-form-item label="아이디(이메일)" prop="userid" style="font-size: 5rem;">
          <div class="input-userid">
            <el-input v-model="credentials.userid"  :disabled="isIdChecked"></el-input>
            <el-button type="info" size="small" @click.prevent="onSubmitId()">{{ idCheckMessage }}</el-button>
          </div>
        </el-form-item>
        <!-- 비밀번호 -->
        <el-form-item label="비밀번호" prop="userpwd">
          <el-input v-model="credentials.userpwd" show-password></el-input>
        </el-form-item>
        <el-form-item label="비밀번호 확인" prop="userpwdconfirmation">
          <!-- 비밀번호 확인 -->
          <el-input v-model="credentials.userpwdconfirmation" show-password></el-input>
        </el-form-item>
        <!-- 이름 -->
        <el-form-item label="이름" prop="name">
          <el-input v-model="credentials.name"></el-input>
        </el-form-item>
        <!-- 연락처 -->
        <el-form-item label="연락처 (ex.010-1234-5678)" prop="phone">
          <el-input v-model="credentials.phone"></el-input>
        </el-form-item>
        <!-- 주소 -->
        <el-form-item ref="addressForm" label="주소">
          <addressForm prop="address" class="addressForm"/>
        </el-form-item>
        <!-- 제출, 리셋 버튼 -->
        <el-form-item>
          <el-button type="primary" round @click.prevent="onSubmit('signUpForm')">회원가입</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<script>
// useStore 훅을 사용하여 store에 접근합니다.
import addressForm from '@/components/User/Join/addressForm'
import http from '@/utils/http-common'
import logo from '@/components/User/Common/logo'
import Swal from 'sweetalert2'

export default {
  name: "Join",
  components: {
    addressForm,
    logo
  },
  data() {
    const validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('비밀번호를 입력해주세요'))
      } else if (value !== this.credentials.userpwd) {
        callback(new Error('비밀번호가 일치하지 않습니다.'))
      } else {
          callback()
      }
    }
    return {
      credentials: {
        userid: "",
        userpwd: "",
        name: "",
        phone: "",
        address: "",
        type: "일반",
        userpwdconfirmation: "",
      },
      rules: {
          userid: [
            { 
              pattern: /^[^\s@]+@[^\s@]+$/,
              trigger: 'blur',
              message: '아이디를 형식에 맞게 입력해주세요!',
              required: true
            }
          ],
          userpwd: [
            {
              required: true,
              message: '비밀번호를 입력해주세요!',
              trigger: 'blur'
            },
            {
              min: 8,
              message: '최소 8자 이상 입력해주세요!',
              trigger: 'blur',
            }
          ],
          userpwdconfirmation: [
            {
              required: true,
              message: "비밀번호를 한번 더 입력해주세요!",
              trigger: 'blur',
            },
            {
              validator: validatePass,
              trigger: 'blur',
              message: '비밀번호와 동일하게 입력해주세요!',
            }
          ],
          name: [
            {
              trigger: 'blur',
              message: '이름을 입력해주세요!',
              required: true
            }
          ],
          phone: [
            {
              pattern: /[0-9]{3}-[0-9]{4}-[0-9]{4}/,
              trigger: 'blur',
              message: '전화번호 형식에 맞게 입력해주세요!',
              required: true
            }
          ],
          address: [
            {
              required: true,
              trigger: 'change',
              message: '주소를 입력해주세요!'
            }
          ]
        },
      userpwdconfirmation: "",
      isIdChecked: false,
      labelPosition: "top"
    }
  },
  methods: {
    // 회원가입 정보 Submit
    onSubmit(formName) {
      if (!this.isIdChecked) {
        return Swal.fire({
            icon: 'error',
            text: '아이디 중복검사를 진행해주세요😀',
          })
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.updateAddress()
          console.log('회원가입진행')
          this.$store.dispatch("userStore/register", this.credentials)
        } else {
          Swal.fire({
            icon: 'error',
            title: '잘못된 정보',
            text: '입력하신 정보를 한 번 더 확인해주세요😀',
          })
        }
      })
    },
    onSubmitId() {
      const idPattern =  /^[^\s@]+@[^\s@]+$/
      // 중복검사 받은 아이디 수정
      if (this.isIdChecked) {
        this.isIdChecked = false
      } else if (idPattern.test(this.credentials.userid)) {
        // 아이디 중복검사
        http
          .get('member/isDuplicated/' + this.credentials.userid)
          .then((res) => {
            if (res.status == 200) {
              Swal.fire({
                icon: 'success',
                text: '사용가능한 아이디입니다😀',
              })
              this.isIdChecked = true
            } else if (res.status == 204) {
              Swal.fire({
                icon: 'error',
                text: '사용중인 아이디입니다😥',
              })
              this.resetUserId()
            }
          })
          .catch((err) => {
            console.log(err)          
          })
      }
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
    },
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
.addressForm {
  display: flex;
}
.signup-container {
  min-height: 80vh;
}

.signup-form {
  min-width:660px;
  padding: 35px;
  border-radius: 10px solid black;
}

.signup-form > logo {
  margin-top: 40px;
}

.input-userid {
  display: flex !important;
  flex-direction: row;
}

#text {
  font-size: 5rem !important;
}
</style>
