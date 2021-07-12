import App from './App.vue';
import store from './store';
import router from './router';
import { createApp } from 'vue';
// import bootstrap5
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

// import Element UI Plus
import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';

// import vue-sidebar
import VueSidebarMenu from 'vue-sidebar-menu'
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'

// import moment => 날짜 형식 출력을 위한
import moment from 'moment';
import axios from 'axios';
import VueAxios from 'vue-axios';

//font-awesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

import { faUserLock } from "@fortawesome/free-solid-svg-icons";
import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { faSignInAlt } from "@fortawesome/free-solid-svg-icons";
import { faSignOutAlt } from "@fortawesome/free-solid-svg-icons";
import { faUserPlus } from "@fortawesome/free-solid-svg-icons";
import { faHeadset } from "@fortawesome/free-solid-svg-icons";
import { faLightbulb } from "@fortawesome/free-solid-svg-icons";
import { faTasks } from "@fortawesome/free-solid-svg-icons";
import { faPlaneDeparture } from "@fortawesome/free-solid-svg-icons";
import { faThList } from "@fortawesome/free-solid-svg-icons";

library.add(faUserLock);  
library.add(faSearch);  
library.add(faSignInAlt);  
library.add(faSignOutAlt);  
library.add(faUserPlus);  
library.add(faHeadset);  
library.add(faUserSecret)
library.add(faLightbulb)
library.add(faTasks)
library.add(faPlaneDeparture)
library.add(faThList)

const app = createApp(App);

// 전역 filter 설정
// 사용법 : {{ $filters.필터이름(데이터) }}
app.config.globalProperties.$filters = {
  // 금액, 수량 필터 : 천단위마다 , 찍음
  price(value) {
    if (!value) return value;
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  },
  // 번호 필터 ex) 010-1234-5678
  mobile(value) {
    // 0, null, undefined, 빈문자 이거나 10, 11자리가 아니면 그대로 리턴
    if (!value || !(value.length === 10 || value.length === 11)) return value;
    return value.replace(/^(\d{3})(\d{3,4})(\d{4})/g, '$1-$2-$3');
  },

  // 날짜 필터 ex) YYYY.MM.DD
  date(value) {
    return moment(new Date(value)).format('YYYY.MM.DD');
  },
};

app.component('font-awesome-icon', FontAwesomeIcon)
app.use(store)
  .use(router)
  .use(VueAxios, axios)
  .use(ElementPlus)
  .use(VueSidebarMenu)
  .mount('#app');
