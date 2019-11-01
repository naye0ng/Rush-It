import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import actions from './actions'
import mutations from './mutations'

Vue.use(Vuex)

// const state = {
//   currentPage : 0,
//   authentication : {
//     isActive : false,
//     isLogin : true,
//     // 자동로그인의 경우 로컬스토리지 체크
//     userID : '1일1똥',
//     userNickName : '나는야똥쟁이',
//   },
//   map : {}
// }

const state = {
  currentPage : 0,
  authentication : {
    isActive : false,
    isLogin : false,
    // 자동로그인의 경우 로컬스토리지 체크
    userID : '',
    userNickName : '',
  },
  map : {}
}
export default new Vuex.Store({
  state,
  getters,
  actions,
  mutations
})
