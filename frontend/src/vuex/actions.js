import axios from 'axios'

const url = "http://localhost:8080"
export default {
    asyncSignIn({ commit }, payload) {
        if (payload.signIn_id && payload.signIn_pw) {
            console.log("비어있지 않다")
            // auto login이 true이면 로컬 스토리지에 저장하자

        }
    },
    asyncSignUp({ commit }, payload) {
        if (payload.signUp_id && payload.signUp_nick && payload.signUp_pw && payload.signUp_pw2) {
            if (payload.signUp_pw == payload.signUp_pw2) {
                console.log("비말번호가 같다")

            }
        }
    },
    asyncMakeMap({ commit, getters, state }, payload) {
        var mapOption = {
            center: new kakao.maps.LatLng(getters.user_loc.x, getters.user_loc.y),
            level: 3
        }

        commit('setMap', new kakao.maps.Map(payload, mapOption))

        // 지도가 움직일 때 Event Listener 달기
        kakao.maps.event.addListener(state.map.draw_map, 'center_changed', function () {
            // 지도의 중심좌표를 얻어옵니다 
            var latlng = state.map.draw_map.getCenter();
            // 영역 정보
            var bounds = state.map.draw_map.getBounds();
            // 남서쪽 정보
            var sw = bounds.getSouthWest();
            // 북동쪽 정보
            var ne = bounds.getNorthEast();

            var params = {
                'user' : { 'x' : latlng.getLat(), 'y' : latlng.getLng() },
                'map' : {
                    'southWest' : { 'x' : sw.getLat(), 'y' : sw.getLng() },
                    'northEast' : { 'x' : ne.getLat(), 'y' : ne.getLng() }
                },
                'keyword' : state.map.search
            };

            // axios.get(url + "/toilet/", {
            //     body : params,  
            //     headers : { 'Content-Type' : 'application/'}
            // }).then(response => {
            //     console.log(response)
            //     commit('setMapPlaceList', response);
            // })
            // x : latlng.getLat()
            // y : latlng.getLng()

            // console.log(latlng + bounds)

            // api 요청 보낸 후, list 받아오기
        });

    }
}
