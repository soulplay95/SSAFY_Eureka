<template>
  <div>
    <h1>비밀번호 찾기 페이지입니다!</h1>
    <form @submit.prevent="onSubmit()">
      <fieldset>
        <input>아이디</input>
        이름
        연락처
        <button></button>
      </fieldset>
    </form>
  </div>
</template>

<script>
export default {
  name: SearchPassword,
  data() {
    return {
      member_userid: "",
      member_name: "",
      member_phone: "",
    }
  },
  methods: {
    onSubmit() {
      // 
      axios({
        methods:,
        url:
        data: {
          return {
            member_userid,
            member_name,
            member_phone
          }
        }
      })
      .then((res) => {
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