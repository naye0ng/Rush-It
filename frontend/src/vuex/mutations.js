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

  console.log(state.map.user_marker_image)
  console.log(state.map.user_marker_image instanceof kakao.maps.MarkerImage)
  state.map.user_marker.setMap(state.map.draw_map);
};


export default {
    setCurrentPage(state, payload){
        state.currentPage = payload
    },
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
        console.log("현재위치 : ", state.map.user_loc)

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
      // 맵 생성

      // payload = document.getElementById('map');
      var mapOption = {
        center : new kakao.maps.LatLng(state.map.user_loc.x, state.map.user_loc.y),
        level : 3
      };

      state.map.draw_map = new kakao.maps.Map(payload, mapOption);

      // 지도가 움직일 때 Event Listener 달기
      kakao.maps.event.addListener(state.map.draw_map, 'center_changed', function() {
        // 지도의 중심좌표를 얻어옵니다 
        var latlng = state.map.draw_map.getCenter(); 

        // 영역 정보
        var bounds = state.map.draw_map.getBounds();

        // 남서쪽 정보
        var sw = bounds.getSouthWest();
        
        // 북동쪽 정보
        var ne = bounds.getNorthEast();
        
        // x : latlng.getLat()
        // y : latlng.getLng()
    
        console.log(latlng + bounds)

        // api 요청 보낸 후, list 받아오기
    });

    }
}