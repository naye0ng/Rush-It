import qs from 'qs';
import axios from 'axios'
              
const url = "http://localhost:8080"
export default {
    asyncSignIn({ commit }, payload) {
        let data = {
            'pw' : payload.pw
        };
        let options = {
            method: 'POST',
            data: qs.stringify(data),
            url: url+'/user/'+payload.id 
        };
        return axios(options).then(response => {
            if(response.data.code == 200){
                // TODO : 자동로그인 처리 
                // auto login이 true이면 로컬 스토리지에 저장하자
                
                commit('setAuthentication',{
                    isActive : false,
                    isLogin : true,
                    userID : response.data.id,
                    userNickName : response.data.nick,
                  })
                console.log(response.data)
                return true
            }
            return false
        }).catch(error=>{
            return false
        })
    },
    asyncSignUp({ commit }, payload) {
        let options = {
            method: 'POST',
            data: qs.stringify(payload),
            url: url+'/user'
        };
        return axios(options).then(response => {
            if(response.data.code == 200){
                console.log("회원가입 완료")
                return true
            }
            return false
        }).catch(error=>{
            return false
        })
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

            axios.post(url + "/toilet/", params)
            .then(response => {
                console.log(response.data)
                commit('setMapPlaceList', response.data.toiletList);
            })
        });

    },
    asyncSearchMap({commit, state}, payload) {
        commit('setMapSearch', payload)

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

        axios.post(url + "/toilet/", params)
        .then(response => {
            commit('setMapPlaceList', response.data.toiletList);
        })
    }
}




