<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-submenu index="1">
      <template #title>
        <i class="el-icon-location"></i>
        <span>MY 정보</span>
      </template>
      <el-menu-item index="1-1">회원정보 수정</el-menu-item>
      <el-menu-item index="1-2">배송지 관리</el-menu-item>
    </el-submenu>
    <el-submenu index="2">
      <template #title>
        <i class="el-icon-location"></i>
        <span>MY 쇼핑</span>
      </template>
      <el-menu-item index="2-1">주문목록</el-menu-item>
      <el-menu-item index="2-2">장바구니</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
  export default {
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>