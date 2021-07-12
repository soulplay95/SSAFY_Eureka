<template>
  <el-menu
    default-active="2"
    class="my-page-sidebar"
    @open="handleOpen"
    @close="handleClose"
    background-color="rgba(255, 252, 252, 0.2)"
    text-color="black"
    active-text-color="gray"
  >
    <el-submenu index="1">
      <template #title>
        <i class="el-icon-user-solid"></i>
        <span>MY 정보</span>
      </template>
      <el-menu-item @click="onClick($event)" index="userModify">
        <i class="el-icon-s-tools"></i>
        회원정보 수정
      </el-menu-item>
      <el-menu-item @click="onClick($event)" index="manageAddress">
        <i class="el-icon-s-home"></i>
        배송지 관리
        </el-menu-item>
    </el-submenu>
    <el-submenu index="2">
      <template #title>
        <i class="el-icon-shopping-bag-1"></i>
        <span>MY 쇼핑</span>
      </template>
      <el-menu-item @click="onClick($event)" index="orderList">
        <i class="el-icon-shopping-cart-full"></i>
        주문목록
      </el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
  export default {
    name: "myPageSideBar",
    data() {
      return {
        currentMode: "",  
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      onClick(key) {
        const selectedMode = key.index
        this.$store.dispatch('myPageStore/changeMode', selectedMode)
      },
    }
  }
</script>

<style scoped>
.my-page-sidebar {
  min-height: 100vh;
}

</style>