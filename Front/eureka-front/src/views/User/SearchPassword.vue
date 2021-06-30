  <template>
  <div>
    <h1>비밀번호 찾기 페이지입니다!</h1>
    <form v-if="!isSubmitted" @submit.prevent="onSubmit()">
      <span>비밀번호의 경우 암호화 저장되어 분실 시 찾아드릴 수 없는 정보 입니다.</span>
      <span>가입하실 때 사용하신 이메일로 임시 비밀번호를 발급해드립니다</span>
      <fieldset>
        <!-- 이름 -->
        <input 
          v-model="name" 
          type="text" 
          placeholder="이름"
          required
        />
        <!-- 아이디 -->
        <input
          v-model="userid"
          type="email"
          placeholder="아이디(이메일)"
          autocomplete="email"
          pattern="^[^(\.)][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}"
          required
        />
        <!-- 연락처 -->
        <input
          v-model="credentials.phone"
          type="tel"
          pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          placeholder="연락처"
          required
        />
        <input
          type="submit" 
          value="비밀번호 찾기"
        />
      </fieldset>
    </form>
    <div v-if="isSubmitted">
      <p>
        {{ userid }}으로 임시 비밀번호를 발급해드렸습니다.
        해당 정보로 로그인 후 '회원정보 수정'에서 비밀번호 변경을 진행해주세요.
        이메일을 받지 못하셨나요?😥
        스팸함을 확인해보시거나, 입력하신 이름과 아이디(이메일)가 Eureka 회원정보와 일치하는지 확인해주세요.
      </p>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SearchPassword',
  data() {
    return {
      name: '',
      userid: '',
      phone: '',
      isSubmitted: false,
    }
  },
  methods: {
    onSubmit() {
      axios({
        methods: 'POST',
        url: 'http://localhost/member/findpwd',
        data: {
            member_userid: this.userid,
            member_name: this.name,
            // 임시
            member_phone: this.phone
        }
      })
      .then((res) => {
        this.isSubmitted = true
        console.log(res)
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