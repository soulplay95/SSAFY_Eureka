export const getAccessToken = () => {
  return window.localStorage.getItem('accessJwt');
}

export const getRefreshToken = () => {
  return window.localStorage.getItem('refreshJwt');
}

export const saveTokens = tokens => {
  window.localStorage.setItem("accessJwt", tokens.accessJws)
  // access Token이 만료되어서 saveToken할 때는 refreshToken이 업데이트 되지 않음
  if (tokens.refreshJws) {
    window.localStorage.setItem("refreshJwt", tokens.refreshJws)
  } 
}

export const destroyTokens = () => {
  window.localStorage.removeItem("accessJwt")
  window.localStorage.removeItem("refreshJwt")
}

export default { getAccessToken, getRefreshToken, saveTokens, destroyTokens };