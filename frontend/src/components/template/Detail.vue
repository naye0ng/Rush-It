<template>
  <div id="detail-card" >
    <b-container class="toilet-title">  
      <b-row class="title-txt">
        <b-col>{{toilet.name}}</b-col>
        <b-col class="text-right " >
          <span @click="goDirection()">
            <font-awesome-icon icon="directions"/>
          </span>
        </b-col>
      </b-row>
      <b-row class="title-desc" align-v="center">
        <b-col v-if="toilet.type == 2">카페</b-col>
        <b-col v-else-if="toilet.type == 3">패스트푸드</b-col>
        <b-col v-else>공공화장실</b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: toilet.handicapped == 0}"><font-awesome-icon icon="wheelchair"/></b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: toilet.bell == 0}"><font-awesome-icon icon="bell"/></b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: toilet.diaper == 0}"><font-awesome-icon icon="baby"/></b-col>
      </b-row>
      <b-row class="boder-top-bottom" align-v="center"> 
        <b-col class="toilet-score">
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet_detail.score>=1 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet_detail.score>=2 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet_detail.score>=3 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet_detail.score>=4 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet_detail.score==5 }"/>
          <span class="task-txt">( {{toilet_detail.score}}점 )</span>
          </b-col>
        <b-col cols="2" class="text-right default-btn">
          <font-awesome-icon icon="thumbs-up" v-bind:class="{active_like: isLike == 1}" @click="like(1)"/>
          {{ toilet_detail.like }}
        </b-col>
        <b-col cols="2" class="text-right default-btn">
          <font-awesome-icon icon="thumbs-down" v-bind:class="{active_dislike: isLike == -1}" @click="like(-1)"/>
          {{ toilet_detail.dislike }}
        </b-col>
      </b-row>
    </b-container>
    <div id="scroll-sec">
      <b-container class="toilet-info">  
        <b-row>
          <b-col class="into-title" cols="3">주소</b-col>
          <b-col class="into-txt">{{ toilet.address }}</b-col>
        </b-row>
        <b-row>
          <b-col class="into-title" cols="3">개방시간</b-col>
          <b-col>{{ toilet_detail.time }}</b-col>
        </b-row>
        <b-row>
          <b-col class="into-title" cols="3">전화번호</b-col>
          <b-col>{{ toilet_detail.telephone }}</b-col>
        </b-row>
      </b-container>
      <b-container class="toilet-review"> 
        <b-row class="review-cnt" >총 {{reviews.length}}개의 리뷰가 있어요.</b-row>
        <b-row class="review-sec" v-for="(review, index) in reviews" :key="index"> 
          <b-col cols="2">
            <div class="user-img">
              <img src="../../assets/user.png">
            </div>
          </b-col>        
          <b-col>
            <b-row class="review-time">{{ review.time }}</b-row>
            <b-row class="review-score toilet-score">
                <font-awesome-icon icon="star" v-bind:class="{ active: review.rating>=1 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.rating>=2 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.rating>=3 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.rating>=4 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.rating==5 }"/>
                <span class="score-txt"> {{review.rating}}점 </span>           
              </b-row>
            <b-row class="review-txt">{{ review.review }}</b-row>
            </b-col>
        </b-row>
      </b-container>
    </div>
  </div>
</template>

<script>
import qs from 'qs';
import axios from 'axios'
import { mapState } from "vuex";

export default {
  name: 'Detail',
  props:{
    toilet: {type:Object}
  },
  data(){
    return {
      msg: 'Welcome to Your Vue.js App',
      toilet_detail:{},
      reviews:[],
      // 이건 로그인 처리 이후에 사용자가 존재할 떄 가능
      isLike:0,
    }
  },
  computed: {
    ...mapState({
      userNickName: state => state.authentication.userNickName,
      userID: state => state.authentication.userID
    })
  },
  methods: {
    getMoreInfomation(){
      // 화장실 상세정보 조회
      const url = "http://localhost:8080"
      axios.get(url+"/toilet/"+this.toilet.id)
      .then(response => {
          this.toilet_detail = response.data
      }).catch(error=>{
          console.log(error)
      })
      // 화장실 리뷰 조회
      axios.get(url+"/review",{params:{toilet_id:this.toilet.id}})
      .then(response => {
        if(response.data.code == 200){
          this.reviews = response.data.reviews
        }
      }).catch(error=>{
          console.log(error)
      })
      // 로그인된 유저가 존재한다면?
      if(this.userID){
        axios.get(url+"/toilet/"+this.toilet.id+'/'+this.userID)
        .then(response => {
          // 이거 수정 필요
          this.isLike = response.data.userLove
        }).catch(error=>{
            console.log(error)
        })
      }
    },
    setStatus(){
      const url = "http://localhost:8080"
      axios.get(url+"/toilet/"+this.toilet.id)
      .then(response => {
          this.toilet_detail = response.data
      }).catch(error=>{
          console.log(error)
      })
      // 로그인된 유저가 존재한다면?
      if(this.userID){
        axios.get(url+"/toilet/"+this.toilet.id+'/'+this.userID)
        .then(response => {
          // 이거 수정 필요
          this.isLike = response.data.userLove
        }).catch(error=>{
            console.log(error)
        })
      }
    },
    like(state){
      const url = "http://localhost:8080"
      // console.log(this.isLike,state)
      // 같은 요청이 다시 들어오는건 취소

      console.log(this.toilet_detail)
      if(this.isLike == state){
        let data = {
          'user_id' : this.userID,
          'toilet_id' : this.toilet.id,
        };
        let options = {
            method: 'DELETE',
            data: qs.stringify(data),
            url: url+'/like'
        };
        axios(options).then(response => {
          this.setStatus()
          this.isLike = 0
          console.log(response.data)
        }).catch(error=>{
            console.log(error)
        })
      }else{
        let data = {
          'user_id' : this.userID,
          'toilet_id' : this.toilet.id,
          'state': state
        };
        let options = {
            method: 'POST',
            data: qs.stringify(data),
            url: url+'/like'
        };
        axios(options).then(response => {
          this.setStatus()
          this.isLike = state
        }).catch(error=>{
            console.log(error)
        })
      }

    },
    goDirection() {
      var url = "https://map.kakao.com/link/to/" + this.toilet.name + "," + this.toilet.location_x + "," + this.toilet.location_y;
      window.open(url)
    }
  },
  mounted(){
    this.getMoreInfomation()
  },
  updated(){
    this.setStatus()
  }
}
</script>
<style>
#detail-card{
  z-index: 90;
  position: fixed;
  bottom: 2rem;
  left: 0;
  width: 100%;
  min-height: 50vh;
  max-height:100vh;
  border-radius: 30px 30px 0 0;
  -webkit-box-shadow: 0 12px 15px 5px rgba(0, 0, 0, 0.1)!important;
  box-shadow: 0 12px 15px 5px rgba(0, 0, 0, 0.1)!important;
  padding: 1.5rem 1rem;
  margin: 0;
  text-align: left;
  background: #ffffff;
}
.toilet-title{
  margin-top: 1rem;
  padding: 0 10px;
  font-weight:600;
}
.toilet-title .title-txt{
  font-size: 1.3rem;
}
.toilet-title .title-desc{
  margin-top: 5px;
  font-size: 0.9rem;
  color:#888;
}
.title-desc .service{
  height:20px;
  font-size: 0.85rem;
  color:#888;
}
.title-desc .notService{
  position:relative;
  color:rgb(44, 62, 80, 0.2);
}

#detail-card .toilet-title .row.boder-top-bottom{
  border-bottom: 1px solid #ddd;
  border-top: 1px solid #ddd;
  margin-top: 1.5rem;
  font-size: 0.7rem;
  padding: 5px 0.5rem
}
#detail-card .toilet-title .row.boder-top-bottom .col{
  margin: 0.3rem 0;
}
.default-btn{
  font-weight: 600;
  color: #888;
}
.toilet-score {
  font-size: 0.65rem;
  display: block;
  color: #888;
}
.toilet-score .active {
  color: #fcb500;
}
.toilet-score .task-txt {
  font-weight: 600;
  color: #888;
}


/* 좋아요, 싫어요 */
.active_like{
  color: blue;
}

.active_dislike{
  color: blueviolet;
}

/* 여기서부터 상세정보 */
#detail-card .toilet-info{
  padding: 1.2rem 0.5rem 0;
  background: #ffffff;
  font-size: 0.8rem;
}
#detail-card .toilet-review{
  padding: 0 0.5rem;
  background: #ffffff;
  font-size: 0.8rem;
}
#detail-card .toilet-info .row{
  padding: 5px 0.5rem;
}
#detail-card .toilet-info .into-title{
  padding:0;
  text-align: left;
}
#detail-card .toilet-info .into-txt{
  overflow: hidden;
}

/* 여기부턴 리뷰 */
.toilet-review .row.review-cnt{
  border-top: 1px solid #ddd;
  padding: 15px 0.5rem 0;
  margin: 30px 0 15px;
  font-size: 0.8rem;
}
.toilet-review .row.review-sec{
  padding: 15px 0.5rem;
  font-size: 0.8rem;
}
.toilet-review .user-img{
  width: 35px;
  height: 35px; 
  background : rgb(33, 64, 121, 0.1);
  border-radius: 50%;
}
.toilet-review img{
  width:100%;
  padding: 15%;
}
.review-score{
  margin-bottom: 8px;
}
.review-score.toilet-score{
  font-size: 0.6rem;
}
.review-score .score-txt{
  font-size: 0.7rem;
  color: #2c3e50;
}
#scroll-sec{
  height: 40vh;
  overflow: scroll;
  padding-bottom: 3rem;
}

#detail-card.top{
  top:100px;
  animation: slide-up 1s;
}
#detail-card.top #scroll-sec{
  height: 80vh;
}

@keyframes slide-up{
  0%{
    transform: translateY(10%);
  }
  100%{
    transform: translateY(0%)
  }
}
</style>
