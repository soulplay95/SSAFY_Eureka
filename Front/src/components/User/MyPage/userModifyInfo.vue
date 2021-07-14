<template>
  <el-form
    :model="currentUser"
    :rules="rules"
    ref="modifyInfoForm"
  >
    <!-- 아이디(이메일) -->
    <el-form-item prop="userid">
      <el-input
        v-model="currentUser.member_userid"
        disabled
      ></el-input>
    </el-form-item>
    <!-- 이름 -->
    <el-form-item prop="name">
      <el-input 
        v-model="currentUser.member_name"
        placeholder="이름"
      ></el-input>
    </el-form-item>
    <!-- 연락처 -->
    <el-form-item prop="phone">
      <el-input
        v-model="currentUser.member_phone"
      ></el-input>
    </el-form-item>
    <el-form-item>
    <div> 
      주소록 관리는 주문페이지에서 진행하시면 됩니다🍕
    </div>
    <el-form-item>
      <el-button type="primary" size="medium" round @click.prevent="onSubmit('modifyInfoForm')">수정하기</el-button>
    </el-form-item>
    </el-form-item>
    <!-- 현재 주소 -->
  </el-form>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: "userModifyInfo",
  data() {
    return {
      rules: {
        name: [
          {
            required: true,
            trigger: 'blur',
            message: '이름을 입력해주세요',
            placeholder: '이름'
          }
        ],
        phone: [
          {
            required: true,
            pattern: /[0-9]{3}-[0-9]{4}-[0-9]{4}/,
            trigger: 'blur',
            message: '전화번호 형식에 맞게 입력해주세요!',
            placeholder: "연락처"
          }
        ]
      }
    }
  },
  methods: {
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$store.dispatch('userStore/modifyuserinfo', this.currentUser)
          console.log('회원정보수정 vuex로 보냄')
        } else {
          console.log('통과못함')
        }
      })
    },
  },
  computed: {
    ...mapGetters('userStore', ['currentUser']),
  },
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

</style>
