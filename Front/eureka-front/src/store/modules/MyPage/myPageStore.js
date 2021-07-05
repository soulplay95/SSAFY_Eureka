export const myPageStore = {
    namespaced: true,
    state: {
        mode: 'orderList',
    },
    mutations: {
      CHANGE_MODE(state, selectedMode) {
        state.mode = selectedMode
      }
    },
    actions: {
      changeMode({commit}, selectedMode) {
        commit('CHANGE_MODE', selectedMode)
      }  
    },
    getters: {
        currentMode(state) {
            return state.mode
        }
    }
}