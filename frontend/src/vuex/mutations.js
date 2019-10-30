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
    setMapPoint({commit}, payload) {
        if(navigator.geolocation) {
          // 날씨정보를 가져와 vuex에 저장하는 부분.
          navigator.geolocation.watchPosition(position => {
            // 위치 정보 허용한 경우.
            // 위도와 경도값을 받아온다.
            state.map.x = position.coords.latitude;
            state.map.y = position.coords.longitude;
          }, error => {
            // 위치 정보 허용 안함. - 기본값[역삼]
            state.map.x = 37.5108295
            state.map.y = 127.02928809999999
          })
        }
        else {
          // navigator.geolocation 사용 불가 브라우져
          state.map.x = 37.5108295
          state.map.y = 127.02928809999999
        }
    
      }
}