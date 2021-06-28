import { createRouter, createWebHistory } from 'vue-router';

// Views imports
// Home
import Home from "@/views/Home.vue";
// 회원
import Login from '@/views/User/Login.vue';
import Join from '@/views/User/Join.vue';
import MyPage from '@/views/User/MyPage.vue';
import UserModify from '@/views/User/UserModify.vue';
import SearchId from '@/views/User/SearchId.vue';
import SearchPassword from '@/views/User/SearchPassword.vue';
// 장바구니
import CartView from '@/views/Cart/CartView.vue';
// 주문결제
import OrderView from '@/views/Order/OrderView.vue';

// 관리자
import AdminProfile from "@/views/Admin/AdminProfile.vue";
import AdminUserRegisterDetail from '@/views/Admin/AdminUserRegisterDetail.vue'
import AdminUserList from "@/views/Admin/AdminUserList.vue";
import AdminItemList from "@/views/Admin/AdminItemList.vue";
import AdminItemRegister from '@/views/Admin/AdminItemRegister.vue'

// 고객센터
import CSQnaHistory from '@/views/CS/CSQnaHistory.vue';
import CSFAQ from '@/views/CS/CSFAQ.vue';
import CSQuestionForm from '@/views/CS/CSQuestionForm.vue';
// 상품
import ItemList from '@/views/Item/ItemList.vue';

// JWT-common import
import JWTcommon from '@/utils/JWT-common'

// import mapGetters (admin) 
// import store from '@/store'

const routes = [
  // Home
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  /* ------------------------ 회원 ------------------------ */
  // 로그인
  {
    path: "/user/login",
    name: "Login",
    component: Login,
  },
  // 회원가입
  {
    path: "/user/join",
    name: "Join",
    component: Join,
  },
  // MyPage
  {
    path: "/user/mypage",
    name: "MyPage",
    component: MyPage,
    meta: {
      requiresAuth: true,
    },
  },
  // 회원 정보 수정
  {
    path: "/user/modify",
    name: "UserModify",
    component: UserModify,
    meta: {
      requiresAuth: true,
    },
  },
  // 아이디 찾기
  {
    path: "/user/search-id",
    name: "SearchId",
    component: SearchId,
  },
  // 비밀번호 찾기
  {
    path: "/user/search-password",
    name: "SearchPassword",
    component: SearchPassword,
  },
  /* ------------------------ @도명 ------------------------ */
  // 장바구니
  {
    path: '/cart',
    name: 'CartView',
    component: CartView,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: '/order',
    name: 'OrderView',
    component: OrderView,
    meta: {
      requiresAuth: true,
    },
  },
  /* ------------------------ 관리자 ------------------------ */
  // 관리자 화면 Home - 관리자 정보
  {
    path: "/admin/profile",
    name: "AdminProfile",
    component: AdminProfile,
    meta: {
      requiresAuth: true,
      requiersAdmin: true,
    },
  },
  // 회원 가입 현황
  {
    path: "/admin/user-register-detail",
    name: "AdminUserRegisterDetail",
    component: AdminUserRegisterDetail,
    meta: {
      requiresAuth: true,
      requiersAdmin: true,
    },
  },
  // 회원 리스트
  {
    path: "/admin/user-list",
    name: "AdminUserList",
    component: AdminUserList,
    meta: {
      requiresAuth: true,
      requiersAdmin: true,
    },
  },
  // 상품 리스트
  {
    path: "/admin/item-list",
    name: "AdminItemList",
    component: AdminItemList,
    meta: {
      requiresAuth: true,
      requiersAdmin: true,
    },
  },
  // 상품 등록
  {
    path: "/admin/item-register",
    name: "AdminItemRegister",
    component: AdminItemRegister,
    meta: {
      requiresAuth: true,
      requiersAdmin: true,
    },
  },
  /* ------------------------ 고객센터 ------------------------ */
  // Home - 나의 문의 내역
  {
    path: "/cs/qna-history",
    name: "CSQnaHistory",
    component: CSQnaHistory,
    meta: {
      requiresAuth: true,
    },
  },
  // 자주묻는 질문
  {
    path: "/cs/faq",
    name: "CSFAQ",
    component: CSFAQ,
  },
  // 질문하기 - form
  {
    path: "/cs/questionForm",
    name: "CSQnaForm",
    component: CSQuestionForm,
    meta: {
      requiresAuth: true,
    },
  },
  // 상품 검색
  {
    path: '/item/item-list',
    name: 'ItemList',
    component: ItemList,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});



// navigation guard
// 1. 로그인 해야 갈 수 있는 페이지 설정
// 2. admin이여만 갈 수 있는 페이지에 일반 유저가 가는 것 방지

router.beforeEach((to, from, next) => {
  // Access Token이 있는 지 검사하고 없으면 로그인
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!JWTcommon.getAccessToken()) {
      next({name: 'Login'})
    }
    else {
      next()
    }
  }
  next()
})



export default router;
