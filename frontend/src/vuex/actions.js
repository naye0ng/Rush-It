import qs from 'qs';
import axios from 'axios'
              
const url = "http://localhost:8080"
export default {
    asyncSignIn({ commit }, payload) {
        if (payload.id && payload.pw) {
            // const data = {
            //     query : 'test'
            // };
            // const options = {
            // method: 'POST',
            // data: qs.stringify(data),
            // url: 'http://localhost:8080/user/test'
            // };


            axios.post('http://localhost:8080/user/test/', {'pw': "test"})
            .then(response => {
                console.log("dsfgb",response.data)
            }).catch(error=>{
                // console.log("dsfghj")
                console.log(error)
            })

            // axios.post('http://localhost:8080/user/test',{data}).then(response => {
            //     console.log('sdsddssdfv')
            //     console.log("dsfgb",response.data)
            //     // commit('setMapPlaceList', response);
            // }).catch(error=>{
            //     console.log("dsfghj")
            //     console.log(error)
            // })
            
            // axios.post(url + "/toilet/", params).then(response => {
            //     console.log('sdsddssdfv')
            //     console.log("dsfgb",response.data)
            //     // commit('setMapPlaceList', response);
            // }).catch(error=>{
            //     console.log("dsfghj")
            //     console.log(error)
            // })
            // axios.post(url + '/user/test/', {pw:'test'}).then(function (response) {
            //     console.log(response);
            // }).catch(function (error) {
            //     console.log("d")
            // })
        // axios. axios({
        //     method: "get",
        //  {headers: {'Content-Type': 'multipart/form-data'}}
        //     url: "http://13.125.1.123:8080/toilet/",
        //     params: {
        //     username: this.state.username,
        //     password: this.state.password
        //     }
        //     }).then(res => console.log(res.data));

            // 자동로그인 처리      
            return false
            // if (payload.signIn_id && payload.signIn_pw){
            //     console.log("비어있지 않다")
            //     // auto login이 true이면 로컬 스토리지에 저장하자

            // }
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

            axios.post(url + "/toilet/", params)
            .then(response => {
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




