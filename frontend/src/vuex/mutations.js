function setUserMarker(state) {
  if(state.map.user_marker != null) {
    state.map.user_marker.setMap(null);
  }
  console.log(state.map.user_loc)
  var userPosition = new kakao.maps.LatLng(state.map.user_loc.x, state.map.user_loc.y);  
  state.map.user_marker = new kakao.maps.Marker({
    position : userPosition,
    image : state.map.user_marker_image
  });

  state.map.user_marker.setMap(state.map.draw_map);
};


export default {
    setCurrentPage(state, payload){
        state.currentPage = payload
    },
    setAuthentication(state, payload){
        console.log(payload)
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
      state.map.place_list = payload;
    }
}