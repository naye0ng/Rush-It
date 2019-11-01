import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import actions from './actions'
import mutations from './mutations'

Vue.use(Vuex)

const state = {
  currentPage : 0,
  authentication : {
    isActive : false,
    isLogin : false,
    // 자동로그인의 경우 로컬스토리지 체크
    userID : '',
    userNickName : '',
  },
  map : { // map
    search : '',
    accessAuth : false,
    user_loc : { x : 37.5546788388674, y : 126.970606917394},
    draw_map : null,
    place_list : [],
    markers : []
  }
}

export default new Vuex.Store({
  state,
  getters,
  actions,
  mutations
})
