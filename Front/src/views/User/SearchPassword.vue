<template>
  <div class="search-password-container">
    <logo/>
    <el-form
      :model="credentials"
      :rules="rules"
      v-if="!isSubmitted"
      ref='searchPasswordForm'
      label-position="top"
      class="search-password-form"
    >
      <p class="description">
        비밀번호의 경우 암호화 저장되어 분실 시 찾아드릴 수 없는 정보 입니다.<br>
        가입하실 때 사용하신 이메일로 임시 비밀번호를 발급해드립니다.
      </p>
      <el-form-item
        label="이름"
        prop="name"
        class="search-password-item"
      >
        <!-- 이름 -->
        <el-input v-model="credentials.name" @keyup.enter="onSubmit()"></el-input>
      </el-form-item>
      <el-form-item
        label="아이디(이메일)"
        prop="userid"
        class="search-password-item"
      >
        <!-- 아이디 -->
        <el-input v-model="credentials.userid" @keyup.enter="onSubmit()"></el-input>
      </el-form-item>
      <el-form-item
        label="전화번호(ex.010-1234-5678)"
        prop="phone"
        class="search-password-item"
      >
        <!-- 연락처 -->
        <el-input v-model="credentials.phone" @keyup.enter="onSubmit()"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" size="small" round @click.prevent="onSubmit()">비밀번호 찾기</el-button>
      </el-form-item>
    </el-form>
    <p v-if="isSubmitted" class="success-password">
      {{ credentials.userid }}으로 임시 비밀번호를 발급해드렸습니다.  
      해당 정보로 로그인 후 '회원정보 수정'에서 비밀번호 변경을 진행해주세요. 
      이메일을 받지 못하셨나요?😥 
      스팸함을 확인해보시거나, 입력하신 이름과 아이디(이메일)가 Eureka 회원정보와 일치하는지 확인해주세요.  
    </p>
  </div>
</template>

<script>
import http from '@/utils/http-common'
import logo from '@/components/User/Common/logo'
import Swal from 'sweetalert2'

export default {
  name: 'SearchPassword',
  components: {
    logo
  },
  data() {
    return {
      credentials: {
        name: '',
        userid: '',
        phone: '',
      },
      rules: {
        name: [
          {
            required: true,
            message: '이름을 입력해주세요!'
          }
        ],
        userid: [
          {
            required: true,
            pattern: /^[^\s@]+@[^\s@]+$/,
            trigger: 'blur',
            message: '아이디를 형식에 맞게 입력해주세요!'
          }
        ],
        phone: [
          {
            required: true,
            pattern: /[0-9]{3}-[0-9]{4}-[0-9]{4}/,
            trigger: 'blur',
            message: '전화번호 형식에 맞게 입력해주세요!'
          }
        ]
      },
      isSubmitted: false,
    }
  },
  methods: {
    onSubmit() {
      const data = {
          member_userid: this.credentials.userid,
          member_name: this.credentials.name,
          member_phone: this.credentials.phone
      }
      http
        .post('member/findpwd', data)
        .then((res) => {
          if (res.status === 204) {
            Swal.fire({
            icon: 'error',
            title: '잘못된 정보',
            text: '입력하신 정보를 한 번 더 확인해주세요😀',
            })
          } else {
            this.isSubmitted = true
            console.log(res)
          }
        })
        .catch((err) => {
        console.log(err)
        })
    }
  }

}
</script>

<style scoped>
.search-password-container {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 35px;
}

.search-password-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 40px;
}

.search-password-item {
  min-width: 660px;
}

.success-password {
  width: 60%;
  display: flex;
  flex-direction: column;
  word-break: keep-all;
  white-space: pre-wrap;
  text-align: center;
  line-height: 2;
  font-size: 19px;
  font-weight: 700;
}

.description {
  font-size: 19px;
}

</style>