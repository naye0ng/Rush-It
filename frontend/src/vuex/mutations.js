export default {
    setCurrentPage(state, payload){
        state.currentPage = payload
    },
    setAuthentication(state, payload){
        for(var key in payload){
            state.authentication[key] = payload[key]
        }
    }
}