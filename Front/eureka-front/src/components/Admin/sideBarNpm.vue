<template>
  <sidebar-menu :menu="menu" />
</template>

<script>
  export default {
    data() {
      return {
        menu: [
          {
            header: '마이페이지',
            hiddenOnCollapse: false
          },
          {
            href: '',
            title: '회원정보 수정',
            icon: 'fa'
          },
          {
            href: '',
            title: '배송지 관리',
            icon: 'fa'
          },
          {
            href: '',
            title: '주문 목록',
            icon: 'fa',
          }
        ]
      }
    }
  }
</script>
