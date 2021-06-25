export const getAccessToken = () => {
  return window.localStorage.getItem('accessJwt');
}

export const getRefreshToken = () => {
  return window.localStorage.getItem('refreshJwt');
}

export const saveTokens = tokens => {
  window.localStorage.setItem("accessJwt", tokens.accessJws)
  window.localStorage.setItem("refreshJwt", tokens.refreshJws)
}

export const destroyTokens = () => {
  window.localStorage.removeItem("accessJwt")
  window.localStorage.removeItem("refreshJwt")
}

export default { getAccessToken, getRefreshToken, saveTokens, destroyTokens };