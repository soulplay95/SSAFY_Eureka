<template>
  <div>
    <admin-side-bar/>
    <h1>여기는 관리자 페이지 Main입니다!</h1>
    {{ isAdmin }}
    이름: {{ user.member_name }}
    연락처: {{ user.member_phone }}
    주소: {{ user.member_address }}
    
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import adminSideBar from '@/components/Admin/adminSideBar'

export default {
  name: 'AdminProfile',
  components: {
    adminSideBar
  },
  data() {
    return {

    }
  },
  computed: {
    ...mapState('userStore', ['user']),
    ...mapGetters('userStore', ['isAdmin'])
  },
}
</script>

<style scoped>

</style>