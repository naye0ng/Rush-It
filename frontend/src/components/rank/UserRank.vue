<template>
  <div id="user-rank">  
    <!-- 1 ~ 3위 -->
    <b-row align-v="end" class="rank-card">
      <b-col align-self="center">
        <div class="user-img">
          <img src="../../assets/user.png">
        </div>
        <p>{{ user_rank[1].nick }}</p>
        <p>{{ user_rank[1].reviewCount }}P</p>
      </b-col>
      <b-col cols="5">
        <div class="user-img">
          <img src="../../assets/user.png">
        </div>
        <p>{{ user_rank[0].nick }}</p>
        <p>{{ user_rank[0].reviewCount}}P</p>
      </b-col>
      <b-col align-self="center">
        <div class="user-img">
          <img src="../../assets/user.png">
        </div>
        <p>{{ user_rank[2].nick }}</p>
        <p>{{ user_rank[2].reviewCount }}P</p>
      </b-col>
    </b-row>
    <!-- 나머지 -->
    <b-container class="rank-table">
      <b-row align-v="center" v-for="(user, index) in user_rank" v-if="index>=3" :key="index">
        <b-col align-self="center" cols="2" class="no">{{ index+1 }}위</b-col>
        <b-col align-self="center" cols="2">
          <div class="user-img">
            <img src="../../assets/user.png">
        </div>
        </b-col>
        <b-col>{{ user.nick }}</b-col>
        <b-col cols="2">{{ user.reviewCount }}P</b-col>
      </b-row>
    </b-container>

  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from "vuex";
export default {
  name: "ToiletRank",
  data() {
    return {
      user_rank: [],
      my_rank:{}
    };
  },
  computed: {
    ...mapState({
      userNickName: state => state.authentication.userNickName,
      userID: state => state.authentication.userID
    })
  },
  methods:{
    getUserRank(){
      const url = "http://localhost:8080"

      axios.get(url+"/rank/user",{params:{user_id:this.userID}})
      .then(response => {
        this.user_rank = response.data.rank
        this.my_rank = response.data.myrank
      }).catch(error=>{
          console.log(error)
      })
    }
  },
  mounted(){
    this.getUserRank()
  }
};
</script>
<style>
#user-rank .rank-card{
  margin: 15px 12%;
  height: 120px;
}
#user-rank .rank-card p {
  margin: 0;
  padding: 0;
}

#user-rank .rank-card .col, 
#user-rank .rank-card .col-5{
  border-radius: 5px;
  height: 120px;
  background: rgb(255, 49, 99);
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
}
#user-rank .rank-card .col:nth-child(1){
  border-top-right-radius: 0;
  border-bottom-right-radius: 0;
  background: rgb(255, 49, 99, 0.65);
  height: 100px;
  animation: card-left 0.5s;
}
#user-rank .rank-card .col:nth-child(3){
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
  background: rgb(255, 49, 99, 0.5);
  height: 100px;
  animation: card-right 0.5s;

}
#user-rank .rank-card{
  font-size: 0.7rem;
  font-weight: 600;
  color: #fff;
}
#user-rank .rank-card .user-img{
  margin:10px 0 3px;
  background: #fff;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  overflow: hidden;
  display: inline-block;
}
#user-rank .col-5 .user-img{
  width: 50px;
  height: 50px; 
}
#user-rank .rank-card .col-5{
  font-size: 0.8rem;
  }
#user-rank .user-img img{
  width:100%;
  padding: 15%;
}
#user-rank .user-nick{
  letter-spacing: 0.8px;
  font-weight: 600;
}
/* 여기서부턴 테이블 */
.rank-table{
  padding: 15px;
  font-size: 0.8rem;
  font-weight: 500;
}
#user-rank .rank-table .user-img{
  margin: 5px 0 0 0;
  background: rgb(33, 64, 121, 0.07);
  border-radius: 50%;
  width: 30px;
  height: 30px;
  overflow: hidden;
  display: inline-block;
}
.rank-table .row{
  padding: 10px 0;
  border-bottom: 1px solid rgb(33, 64, 121, 0.1);
}
.rank-table .no{
  font-weight: 600;
}

@keyframes card-left{
  0%{
    transform: translateX(10%);
  }
  100%{
    transform: translateY(0%)
  }
}
@keyframes card-right{
  0%{
    transform: translateX(-10%);
  }
  100%{
    transform: translateY(0%)
  }
}

</style>