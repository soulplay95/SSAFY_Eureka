<template>

  <div class="d-flex flex-row mt-5">
    <admin-side-bar/>
      <el-descriptions title="관리자 프로필" direction="vertical" :column="4" border>
        <el-descriptions-item label="Adminname">{{ user.member_name }}</el-descriptions-item>
        <el-descriptions-item label="Telephone">{{ user.member_phone }}</el-descriptions-item>
        <el-descriptions-item label="AdminID" :span="4">{{ user.member_userid }}</el-descriptions-item>
        <el-descriptions-item label="Join Date">
          <el-tag size="small">{{ user.member_joindate }} </el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="Address">{{ user.member_address }}</el-descriptions-item>
      </el-descriptions>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import adminSideBar from '@/components/Admin/adminSideBar'

export default {
  name: 'AdminProfile',
  components: {
    adminSideBar,
  },
  computed: {
    ...mapState('userStore', ['user']),
    ...mapGetters('userStore', ['isAdmin'])
  },
}
</script>

<style scoped>

</style>