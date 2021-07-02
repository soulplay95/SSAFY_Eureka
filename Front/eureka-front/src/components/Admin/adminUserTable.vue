<template>
  <el-table
    :data="userInfo.filter(data => !search || data.member_name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label="아이디(이메일)"
      prop="member_userid">
    </el-table-column>
    <el-table-column
      label="이름"
      prop="member_name">
    </el-table-column>
    <el-table-column
      label="전화번호"
      prop="member_phone">
    </el-table-column>
    <el-table-column
      label="주소"
      prop="member_address">
    </el-table-column>
    <el-table-column
      label="멤버 타입"
      prop="member_type">
    </el-table-column>
    <el-table-column
      label="가입일"
      prop="member_joindate">
    </el-table-column>
    <el-table-column
      label="마지막 로그인일"
      prop="member_lastlogindate">
    </el-table-column>
    <el-table-column
      align="right">
      <template #header>
        <el-input
          v-model="search"
          size="mini"
          placeholder="이름 검색"/>
      </template>
      <template #default="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: "adminTable",
  data() {
      return {
        search: '',
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
    },
    mounted() {
      // 유저 정보 가져오기
      this.$store.dispatch('adminStore/setUserInfo')
    },
    computed: {
      ...mapGetters('adminStore', ['userInfo'])
    }
}
</script>

<style>

</style>