<template>
  <el-form :label-position="labelPosition" label-width="100px" :model="credentials">
    <el-form-item label="Name">
      <el-input v-model="credentials.name"></el-input>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'Temp',
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
      isIdChecked: false,
      labelPosition: 'top'
    }
  },

}
</script>

<style>

</style>