<template>
  <div class="flex-shrink-0 p-3 bg-white position-relative" style="width: 280px;">
    <router-link to="/admin/profile" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
      <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
      <span class="fs-5 fw-semibold">관리자 페이지</span>
    </router-link>
    <ul class="list-unstyled ps-0">
      <li class="mb-1">
        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="false">
          회원관리
        </button>
        <div class="collapse" id="home-collapse" style="">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
            <li><router-link to="/admin/user-list" class="link-dark rounded">회원 리스트</router-link></li>
          </ul>
        </div>
      </li>
      <li class="mb-1">
        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
          상품관리
        </button>
        <div class="collapse" id="dashboard-collapse" style="">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
            <li><router-link  to="/admin/item-list" class="link-dark rounded">상품 리스트</router-link></li>
            <li><router-link  to="/admin/item-register" class="link-dark rounded">상품 등록</router-link></li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "adminSideBar"
}
</script>

<style scoped>

</style>