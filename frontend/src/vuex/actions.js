import axios from 'axios'

const url = "http://13.125.1.123:8080"
export default {
    asyncSignIn({commit}, payload){
        if (payload.signIn_id && payload.signIn_pw){
            console.log("비어있지 않다")
            // auto login이 true이면 로컬 스토리지에 저장하자
            
        }
    },
    asyncSignUp({commit}, payload){
        if (payload.signUp_id && payload.signUp_nick && payload.signUp_pw && payload.signUp_pw2){
            if(payload.signUp_pw == payload.signUp_pw2){
                console.log("비말번호가 같다")

            }
        }
    }
}
