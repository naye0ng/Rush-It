function setUserMarker(state) {
  if(state.map.user_marker != null) {
    state.map.user_marker.setMap(null);
  }
  console.log(state.map.user_loc)
  var userPosition = new kakao.maps.LatLng(state.map.user_loc.x, state.map.user_loc.y);  
  state.map.user_marker = new kakao.maps.Marker({
    position : userPosition,
    image : state.map.marker_images.user_image
  });

  state.map.user_marker.setMap(state.map.draw_map);
};

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeClickListener(map, marker, infowindow, isOpened) {
  return function() {
      if(isOpened) {
        infowindow.close();
      }
      else {
        infowindow.open(map, marker);
      }
      isOpened = !isOpened;
  };
}



export default {
    setCurrentPage(state, payload){
        state.currentPage = payload
    },
    // 로그인한 사용자 저장
    setAuthentication(state, payload){
        for(var key in payload){
            state.authentication[key] = payload[key]
        }
    },
    setMapSearch(state, payload) {
        state.map.search = payload
    },
    setMapPoint(state,payload) {
        var moveLatLon = new kakao.maps.LatLng(state.map.user_loc.x, state.map.user_loc.y);
        // setUserMarker(state);
        state.map.draw_map.panTo(moveLatLon); 
    },
    setUserPoint(state, payload) {
        if(navigator.geolocation) {
          // 날씨정보를 가져와 vuex에 저장하는 부분.
          navigator.geolocation.watchPosition(position => {
            // 위치 정보 허용한 경우.
            // 위도와 경도값을 받아온다.
            state.map.user_loc.x = position.coords.latitude;
            state.map.user_loc.y = position.coords.longitude;

            setUserMarker(state);
          }, error => {
            // 위치 정보 허용 안함. - 기본값 [서울역]
          })
        }
        else {
          // navigator.geolocation 사용 불가 브라우져
        }
    },
    setMap(state, payload) {
      state.map.draw_map = payload;
    },
    setMapPlaceList(state, payload) {
      for(var i=0; i<state.map.place_list_markers.length; i++) {
        state.map.place_list_markers[i].setMap(null);
        state.map.infowindow_list[i].close();
      }
      state.map.place_list_markers = []

      state.map.place_list = payload;

      state.map.infowindow_flag = [];
      state.map.infowindow_list = [];
      for(var i=0; i<state.map.place_list.length; i++) {
        var position = new kakao.maps.LatLng(state.map.place_list[i].location_x, state.map.place_list[i].location_y);
        var marker = new kakao.maps.Marker({
          map : state.map.draw_map,
          position : position,
          image : state.map.marker_images.type0_image
        })

        var marker_name = '<div>' + state.map.place_list[i].name + '</div>';

        // 마커에 표시할 인포윈도우를 생성합니다 
        var infowindow = new kakao.maps.InfoWindow({
          content: marker_name // 인포윈도우에 표시할 내용
        });

        state.map.infowindow_flag.push(false);
        kakao.maps.event.addListener(marker, 'click', makeClickListener(state.map.draw_map, marker, infowindow, state.map.infowindow_flag[i]));

        state.map.infowindow_list.push(infowindow);
        state.map.place_list_markers.push(marker);
      }
    }
}