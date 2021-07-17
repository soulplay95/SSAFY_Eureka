import axios from "axios";
import JWTservice from '@/utils/JWT-common'

// axios 객체 생성
export default axios.create({
  // baseURL: 'http://localhost:80/eureka/api',
  baseURL: "http://localhost/",
  headers: {
    "Content-type": "application/json",
    "jwt-auth-access-token": `${JWTservice.getAccessToken()}`,
    "jwt-auth-refresh-token": `${JWTservice.getRefreshToken()}`
  },
});