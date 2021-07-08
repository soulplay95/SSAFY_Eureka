  <template>
  <div>
    <h2>비밀번호의 경우 암호화 저장되어 분실 시 찾아드릴 수 없는 정보 입니다.</h2>
    <h3>가입하실 때 사용하신 이메일로 임시 비밀번호를 발급해드립니다</h3>
    <el-form
      :model="credentials"
      :rules="rules"
      v-if="!isSubmitted"
      label-width="250px"
      ref='loginForm'
    >
      <el-form-item
        label="이름"
        prop="name"
      >
        <!-- 이름 -->
        <el-input v-model="credentials.name"></el-input>
      </el-form-item>
      <el-form-item
        label="아이디(이메일)"
        prop="userid"
      >
        <!-- 아이디 -->
        <el-input v-model="credentials.userid"></el-input>
      </el-form-item>
      <el-form-item
        label="전화번호(ex.010-1234-5678)"
        prop="phone"
      >
        <!-- 연락처 -->
        <el-input v-model="credentials.phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click.prevent="onSubmit('loginForm')">비밀번호 찾기</el-button>
      </el-form-item>
    </el-form>
    <div v-if="isSubmitted">
      <p>
        {{ credentials.userid }}으로 임시 비밀번호를 발급해드렸습니다.
        해당 정보로 로그인 후 '회원정보 수정'에서 비밀번호 변경을 진행해주세요.
        이메일을 받지 못하셨나요?😥
        스팸함을 확인해보시거나, 입력하신 이름과 아이디(이메일)가 Eureka 회원정보와 일치하는지 확인해주세요.
      </p>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http-common'

export default {
  name: 'SearchPassword',
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
    onSubmit(formName) {
      const data = {
          member_userid: this.credentials.userid,
          member_name: this.credentials.name,
          member_phone: this.credentials.phone
      }
      http
        .post('member/findpwd', data)
        .then((res) => {
          if (res.status === 204) {
            alert('다시 입력해주세요!')
            this.$refs[formName].resetFields()
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

<style>

</style>