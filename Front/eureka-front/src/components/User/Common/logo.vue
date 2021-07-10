<template>
  <el-image 
    :src="logoImage"
    style="width: 300px;"
  ></el-image>
</template>

<script>
import logoImage from '@/assets/eureka3.png'

export default {
  name: "logo",
  data() {
    return {
      logoImage
    }
  }
}
</script>

<style>

</style>