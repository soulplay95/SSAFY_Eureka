import { createRouter, createWebHistory } from 'vue-router';

// Views imports
// Home
import Home from '@/views/Home.vue';
// 회원
import Login from '@/views/User/Login.vue';
import Join from '@/views/User/Join.vue';
import MyPage from '@/views/User/MyPage.vue';
import UserModify from '@/views/User/UserModify.vue';
import SearchId from '@/views/User/SearchId.vue';
import SearchPassword from '@/views/User/SearchPassword.vue';

// 장바구니
import CartView from '@/views/Cart/CartView.vue';

// 관리자
import AdminProfile from '@/views/Admin/AdminProfile.vue';
import AdminUserList from '@/views/Admin/AdminUserList.vue';
import AdminItemList from '@/views/Admin/AdminItemList.vue';
// 고객센터
import CSQnaHistory from '@/views/CS/CSQnaHistory.vue';
import CSFAQ from '@/views/CS/CSFAQ.vue';
import CSQuestionForm from '@/views/CS/CSQuestionForm.vue';
// 상품
import ItemList from '@/views/Item/ItemList.vue';

const routes = [
  // Home
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  /* ------------------------ 회원 ------------------------ */
  // 로그인
  {
    path: '/user/login',
    name: 'Login',
    component: Login,
  },
  // 회원가입
  {
    path: '/user/join',
    name: 'Join',
    component: Join,
  },
  // MyPage
  {
    path: '/user/mypage',
    name: 'MyPage',
    component: MyPage,
  },
  // 회원 정보 수정
  {
    path: '/user/modify',
    name: 'UserModify',
    component: UserModify,
  },
  // 아이디 찾기
  {
    path: '/user/search-id',
    name: 'SearchId',
    component: SearchId,
  },
  // 비밀번호 찾기
  {
    path: '/user/search-password',
    name: 'SearchPassword',
    component: SearchPassword,
  },
  /* ------------------------ @도명 ------------------------ */
  // 장바구니
  {
    path: '/cart',
    name: 'CartView',
    component: CartView,
  },
  /* ------------------------ 관리자 ------------------------ */
  // 관리자 화면 Home - 관리자 정보
  {
    path: '/admin/profile',
    name: 'AdminProfile',
    component: AdminProfile,
  },
  // 회원 관리
  {
    path: '/admin/user-list',
    name: 'AdminUserList',
    component: AdminUserList,
  },
  // 상품 관리
  {
    path: '/admin/item-list',
    name: 'AdminItemList',
    component: AdminItemList,
  },
  /* ------------------------ 고객센터 ------------------------ */
  // Home - 나의 문의 내역
  {
    path: '/cs/qna-history',
    name: 'CSQnaHistory',
    component: CSQnaHistory,
  },
  // 자주묻는 질문
  {
    path: '/cs/faq',
    name: 'CSFAQ',
    component: CSFAQ,
  },
  // 질문하기 - form
  {
    path: '/cs/questionForm',
    name: 'CSQuestionForm',
    component: CSQuestionForm,
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

export default router;
