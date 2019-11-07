import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import actions from './actions'
import mutations from './mutations'

Vue.use(Vuex)

function make_marker_image(src) {
  var imageSrc = src; // 마커이미지의 주소입니다    
  var imageSize = new kakao.maps.Size(45); // 마커이미지의 크기입니다
  var imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
  
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

  return markerImage;
}


const state = {
  currentPage : "HomePage",
  authentication : {
    isActive : false,
    isLogin : false,
    userID : '',
    userNickName : '',
  },
  map : { // map
    search : '',
    accessAuth : false,
    user_loc : { x : 37.5546788388674, y : 126.970606917394},
    user_marker : null,
    user_marker_image : make_marker_image('https://i.ibb.co/Yys2M26/marker-user.png'),
    draw_map : null,
    place_list : [],
    place_list_markers : [],
    markers : [],
    marker_images : {
       user_image : make_marker_image('https://i.ibb.co/Yys2M26/marker-user.png'),
       type0_image : make_marker_image('https://i.ibb.co/6rxnC3v/marker-type0.png')
    },
    infowindow_flag : [],
    infowindow_list : []
  }
}
export default new Vuex.Store({
  state,
  getters,
  actions,
  mutations
})
