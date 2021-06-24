export const getAccessToken = () => {
  return window.localStorage.getItem('accessJws');
}

export const getRefreshToken = () => {
  return window.localStorage.getItem('refreshJws');
}

export const saveTokens = tokens => {
  window.localStorage.setItem("accessJws", tokens.accessJws)
  window.localStorage.setItem("refreshJws", tokens.refreshJws)
}

export const destroyTokens = () => {
  window.localStorage.removeItem("accessJws")
  window.localStorage.removeItem("refreshJws")
}

export default { getAccessToken, getRefreshToken, saveTokens, destroyTokens };