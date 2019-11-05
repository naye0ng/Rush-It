import axios from 'axios'

        const url = "http://13.125.1.123:8080"
        export default {
            asyncSignIn({ commit }, payload) {
                var data = JSON.stringify({
                    "user": {
                      "x": 37.50055141806106,
                      "y": 127.03794184626457
                    },
                    "map": {
                      "southWest": {
                        "x": 37.49739917613735,
                        "y": 127.03372215500326
                      },
                      "northEast": {
                        "x": 37.503703507363795,
                        "y": 127.04216189229597
                      }
                    },
                    "keyword": ""
                  });
                  
               
                axios.get(url + '/toilet/', {data:data}, {headers: {'Content-Type': 'multipart/form-data'}}).then(function (response) {
                        console.log(response);
                    }).catch(function (error) {
                        console.log("d")
                    })
                // axios. axios({
                //     method: "get",
                //     url: "http://13.125.1.123:8080/toilet/",
                //     params: {
                //     username: this.state.username,
                //     password: this.state.password
                //     }
                //     }).then(res => console.log(res.data));
                // axios.get(url + '/toilet/', {
                //     body:{
                //     user : {
                //         x : 37.50055141806106,
                //         y : 127.03794184626457
                //     },
                //     map : {
                //         southWest : {
                //             x : 37.49739917613735,
                //             y : 127.03372215500326
                //         },
                //         northEast : {
                //             x : 37.503703507363795,
                //             y : 127.04216189229597
                //         }
                //     },
                //     keyword : ""
                // }}, {headers: {'Content-Type': 'multipart/form-data'}}).then(function (response) {
                //         console.log(response);
                //     }).catch(function (error) {
                //         console.log(error)
                //     })
                
                //   var xhr = new XMLHttpRequest();
                //   xhr.withCredentials = true;
                  
                //   xhr.addEventListener("readystatechange", function () {
                //     if (this.readyState === 4) {
                //       console.log("sadfghvjbk",this);
                //     }
                //   });
                  
                //   xhr.open("GET", "http://13.125.1.123:8080/toilet/");
                //   xhr.setRequestHeader("Content-Type", "application/json");
                //   xhr.setRequestHeader("Access-Control-Allow-Origin", "* ");
                //   xhr.setRequestHeader("Access-Control-Allow-Credentials",true);
                //   xhr.setRequestHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
                //   xhr.setRequestHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

                //   xhr.setRequestHeader("Accept", "*/*");
                //   xhr.setRequestHeader("Cache-Control", "no-cache");
                //   xhr.setRequestHeader("Host", "http://13.125.1.123:8080");
                //   xhr.setRequestHeader("Accept-Encoding", "gzip, deflate");
                //   xhr.setRequestHeader("Content-Length", "349");
                //   xhr.setRequestHeader("Connection", "keep-alive");
                //   xhr.setRequestHeader("cache-control", "no-cache");
                //   xhr.withCredentials = true;
                //   xhr.send(data);

        // 자동로그인 처리      
        return false
        // if (payload.signIn_id && payload.signIn_pw){
        //     console.log("비어있지 않다")
        //     // auto login이 true이면 로컬 스토리지에 저장하자

        // }
    },
    asyncSignUp({ commit }, payload) {
        if (payload.signUp_id && payload.signUp_nick && payload.signUp_pw && payload.signUp_pw2) {
            if (payload.signUp_pw == payload.signUp_pw2) {
                console.log("비말번호가 같다")

            }
        }
    }
}




