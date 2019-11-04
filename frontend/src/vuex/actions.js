import axios from 'axios'

        // const url = "http://13.125.1.123:8080"
        export default {
            asyncSignIn({ commit }, payload) {
                let config ={
                    'Content-Type': 'multipart/form-data',
                    'Access-Control-Allow-Origin': '*',
                    "Access-Control-Allow-Methods" :"GET,PUT,POST,DELETE",
                    "Access-Control-Allow-Credentials": true,
                    "Access-Control-Allow-Headers":"Origin, X-Requested-With, Content-Type, Accept",

                };
                let data = { pw: "test" };

                axios({
                    method: "post",
                    url: "http://13.125.1.123:8080/user/test/",
                    data: data,
                    headers: config
                }).then(function (response) {
                    console.log(response);
                }).catch(function (error) {
                    console.log("d")
                    if (error.response) {
                    
                        console.log(1,error.response.data);
                        console.log(2,error.response.status);
                        console.log(3,error.response.headers);
                    } else if (error.request) {
                        console.log(4,error.request);
                        console.log(5,error)
                    } else {
                        console.log('Error', error.message);
                    }
                    console.log(error.config);
                });
        // console.log(payload)
        // axios.post(url + '/user/' + payload.id + '/', {
        //     'pw': payload.pw,
        // }, {
        //     headers: {
        //         'Content-Type': 'multipart/form-data',
        //         'crossdomain': true,
        //     }
        // })
        //     .then(function (response) {
        //         console.log(response);
        //     })
        //     .catch(function (error) {
        //         console.log("dfghgfdcx")
        //         console.log(error);
        //     });

        // axios.post(url+'/user/'+payload.id, data, {
        //     headers: {
        //         'Content-Type': 'application/json',
        //     }
        // }).then(function (response) {
        //     console.log(response);
        //   })
        //   .catch(function (error) {
        //     console.log(error);
        //   });
        //로그인처리할 것
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




