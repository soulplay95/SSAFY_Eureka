<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    background-color="#e0e085"
    text-color="black"
    active-text-color="gray"
  >
    <el-submenu index="1">
      <template #title>
        <i class="el-icon-location"></i>
        <span>MY 정보</span>
      </template>
      <el-menu-item @click="onClick($event)" index="userModify">회원정보 수정</el-menu-item>
      <el-menu-item @click="onClick($event)" index="manageAddress">배송지 관리</el-menu-item>
    </el-submenu>
    <el-submenu index="2">
      <template #title>
        <i class="el-icon-location"></i>
        <span>MY 쇼핑</span>
      </template>
      <el-menu-item @click="onClick($event)" index="orderList">주문목록</el-menu-item>
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