# Eureka Project 🛒

> 기본적인 쇼핑기능을 제공하는 이커머스 웹사이트
>
> 어디서나 고객이 원하는 상품을 찾을 수 있도록 하는 Eureka의 핵심인 떠 다니는 카테고리
>
> 상품 검색, 주문, 리뷰, 판매자 상품등록, 관리자 페이지, 카트, 회원 관리 등의 기능을 지원하는 이커머스 웹사이트

<br>

# **결과물 Preview**


- 로그인
- 회원가입
- 장바구니
- 등등 여러 화면들 gif 생성해서 보여주기

<br>

# **개발 환경**


### **Front-end**

- **Framework** : Vue.js

<br>

### **Back-end**

- **Framework** : Spring boot
- **Database** : MySQL

<br>

### **Design**

- Framework 사용
  - Element UI Plus
  - Bootstrap5
  - Fontawesome
  - 눈누폰트

<br>

# **Used Library**

- 추후 추가 예정

<br>

# 폴더 구조

### Front

```
│  babel.config.js
│  package-lock.json
│  package.json
│  README.md
│  tree.txt
│  vue.config.js
│  
├─public
│      favicon.ico
│      index.html
│      
└─src
    │  App.vue
    │  main.js
    │  
    ├─assets
    │  │  eureka.png
    │  │  eureka2.png
    │  │  eureka3.png
    │  │  eureka4.png
    │  │  food.png
    │  │  item1.png
    │  │  item2.png
    │  │  item3.png
    │  │  logo.png
    │  │  logo.svg
    │  │  logo2.png
    │  │  main.png
    │  │  main2.png
    │  │  main3.png
    │  │  main4.png
    │  │  random.png
    │  │  star.png
    │  │  
    │  └─scss
    │          _common.scss
    │          
    ├─components
    │  ├─Admin
    │  │      adminItemForm.vue
    │  │      adminItemTable.vue
    │  │      adminSideBar.vue
    │  │      adminUserTable.vue
    │  │      backTop.vue
    │  │      
    │  ├─Bar
    │  │      CategoryBar.vue
    │  │      NavBar.vue
    │  │      
    │  ├─Carousel
    │  │      Slide.vue
    │  │      
    │  ├─Cart
    │  │      CartList.vue
    │  │      TotalOrder.vue
    │  │      
    │  ├─CSQna
    │  │      CSQnaFAQ.vue
    │  │      CSQnaForm.vue
    │  │      CSQnaHistory.vue
    │  │      CSQnaHistoryItem.vue
    │  │      
    │  ├─Item
    │  │      ItemDetailImage.vue
    │  │      ItemListCard.vue
    │  │      ItemListFilter.vue
    │  │      ItemQna.vue
    │  │      ItemReview.vue
    │  │      
    │  ├─Order
    │  │      CustomerInfo.vue
    │  │      PayInfo.vue
    │  │      ProductInfo.vue
    │  │      
    │  ├─productReview
    │  │      reviewModify.vue
    │  │      reviewRegister.vue
    │  │      
    │  └─User
    │      ├─Common
    │      │      logo.vue
    │      │      
    │      ├─Join
    │      │      addressForm.vue
    │      │      googleAuth.vue
    │      │      
    │      └─MyPage
    │              myPageSideBar.vue
    │              userModifyInfo.vue
    │              userModifyPassword.vue
    │              
    ├─plugins
    │      vuetify.js
    │      
    ├─router
    │      index.js
    │      
    ├─store
    │  │  index.js
    │  │  
    │  └─modules
    │      ├─Admin
    │      │      adminStore.js
    │      │      
    │      ├─Cart
    │      │      cart.js
    │      │      
    │      ├─CSQna
    │      │      CSQnaStore.js
    │      │      
    │      ├─Item
    │      │      itemDetail.js
    │      │      itemStore.js
    │      │      
    │      ├─MyPage
    │      │      myPageStore.js
    │      │      
    │      ├─Order
    │      │      order.js
    │      │      
    │      ├─productReview
    │      │      productReview.js
    │      │      
    │      └─User
    │              userStore.js
    │              
    ├─utils
    │      http-common.js
    │      JWT-common.js
    │      
    └─views
        │  Home.vue
        │  
        ├─Admin
        │      AdminItemList.vue
        │      AdminItemModify.vue
        │      AdminItemRegister.vue
        │      AdminProfile.vue
        │      AdminUserList.vue
        │      AdminView.vue
        │      
        ├─Cart
        │      CartView.vue
        │      
        ├─CS
        │      CSQna.vue
        │      
        ├─Direct
        │      DirectView.vue
        │      
        ├─Item
        │      CategoryItemList.vue
        │      ItemDetail.vue
        │      ItemList.vue
        │      ItemListByCategories.vue
        │      
        ├─Order
        │      OrderList.vue
        │      OrderView.vue
        │      ReceiverInfo.vue
        │      ShippingAddressList.vue
        │      
        ├─productReview
        │      ProductReview.vue
        │      
        └─User
                Join.vue
                Login.vue
                MyPage.vue
                SearchPassword.vue
                Temp.vue
```
<br>

### Back

<br>

```
│  mvnw
│  mvnw.cmd
│  pom.xml
│  README.md
│  tree_back.txt
│  
├─.mvn
│  └─wrapper
│          maven-wrapper.jar
│          maven-wrapper.properties
│          MavenWrapperDownloader.java
│          
├─bin
│  │  .gitignore
│  │  mvnw
│  │  mvnw.cmd
│  │  pom.xml
│  │  
│  ├─.mvn
│  │  └─wrapper
│  │          maven-wrapper.jar
│  │          maven-wrapper.properties
│  │          MavenWrapperDownloader.class
│  │          
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─ssafy
│      │  │          └─eureka
│      │  │                  EurekaApplication.class
│      │  │                  ServletInitializer.class
│      │  │                  
│      │  └─resources
│      │          application.properties
│      │          
│      └─test
│          └─java
│              └─com
│                  └─ssafy
│                      └─eureka
│                              EurekaApplicationTests.class
│                              
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─ssafy
    │  │          └─eureka
    │  │              │  EurekaApplication.java
    │  │              │  ServletInitializer.java
    │  │              │  SwaggerConfiguration.java
    │  │              │  
    │  │              ├─controller
    │  │              │      AdminController.java
    │  │              │      HomeController.java
    │  │              │      MemberController.java
    │  │              │      OrderController.java
    │  │              │      ProductController.java
    │  │              │      ProductQnAController.java
    │  │              │      QnAController.java
    │  │              │      ReviewController.java
    │  │              │      RootController.java
    │  │              │      
    │  │              ├─dao
    │  │              │      AdminDao.java
    │  │              │      HomeDao.java
    │  │              │      MemberDao.java
    │  │              │      OrderDao.java
    │  │              │      ProductDao.java
    │  │              │      ProductQnADao.java
    │  │              │      QnADao.java
    │  │              │      ReviewDao.java
    │  │              │      
    │  │              ├─dto
    │  │              │      Cart.java
    │  │              │      Comment.java
    │  │              │      Member.java
    │  │              │      Order.java
    │  │              │      OrderDetail.java
    │  │              │      Product.java
    │  │              │      Productqna.java
    │  │              │      QnA.java
    │  │              │      Review.java
    │  │              │      ShipAddress.java
    │  │              │      Token.java
    │  │              │      Wish.java
    │  │              │      
    │  │              ├─interceptor
    │  │              │      ConfirmInterceptor.java
    │  │              │      JWTInterceptor.java
    │  │              │      
    │  │              └─service
    │  │                      AdminService.java
    │  │                      AdminServiceImpl.java
    │  │                      HomeService.java
    │  │                      HomeServiceImpl.java
    │  │                      JWTService.java
    │  │                      MemberService.java
    │  │                      MemberServiceImpl.java
    │  │                      OrderService.java
    │  │                      OrderServiceImpl.java
    │  │                      ProductQnAService.java
    │  │                      ProductQnAServiceImpl.java
    │  │                      ProductService.java
    │  │                      ProductServiceImpl.java
    │  │                      QnAService.java
    │  │                      QnAServiceImpl.java
    │  │                      ReviewService.java
    │  │                      ReviewServiceImpl.java
    │  │                      
    │  └─resources
    │      │  application.properties
    │      │  
    │      ├─config
    │      │      mybatis-config.xml
    │      │      
    │      ├─mappers
    │      │      admin.xml
    │      │      home.xml
    │      │      member.xml
    │      │      order.xml
    │      │      product.xml
    │      │      productqna.xml
    │      │      qna.xml
    │      │      review.xml
    │      │      
    │      └─static
    │          │  favicon.ico
    │          │  index.html
    │          │  
    │          ├─css
    │          │      app.e02a3953.css
    │          │      chunk-vendors.8dd7dea4.css
    │          │      
    │          ├─img
    │          │      food.8872b051.png
    │          │      
    │          └─js
    │                  app.49fa99d1.js
    │                  app.49fa99d1.js.map
    │                  chunk-vendors.41ede9e1.js
    │                  chunk-vendors.41ede9e1.js.map
    │                  
    └─test
        └─java
            └─com
                └─ssafy
                    └─eureka
                            EurekaApplicationTests.java
```
