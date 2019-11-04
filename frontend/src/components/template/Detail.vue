<template>
  <div id="detail-card">
    <b-container class="toilet-title">  
      <b-row class="title-txt">{{toilet.name}}</b-row>
      <b-row class="title-desc" align-v="center">
        <b-col v-if="toilet.type == 2">카페</b-col>
        <b-col v-else-if="toilet.type == 3">패스트푸드</b-col>
        <b-col v-else>공공화장실</b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: !toilet.handicapped}"><font-awesome-icon icon="wheelchair"/></b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: !toilet.bell}"><font-awesome-icon icon="bell"/></b-col>
        <b-col cols="1" class="service text-center" v-bind:class="{notService: !toilet.diaper}"><font-awesome-icon icon="baby"/></b-col>
      </b-row>
    </b-container>
    <b-container class="toilet-info">  
      <b-row class="boder-bottom"> 
        <b-col class="toilet-score">
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet.score>=1 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet.score>=2 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet.score>=3 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet.score>=4 }"/>
          <font-awesome-icon icon="star" v-bind:class="{ active: toilet.score==5 }"/>
          <span class="task-txt">( {{toilet.score}}점 )</span>
          </b-col>
        <b-col cols="2" class="text-right default-btn">
          <font-awesome-icon icon="thumbs-up"/>
          {{ like }}
        </b-col>
        <b-col cols="2" class="text-right default-btn">
          <font-awesome-icon icon="thumbs-down"/>
          {{ dislike }}
        </b-col>
      </b-row>
      <b-row>
        <b-col class="into-title" cols="3">주소</b-col>
        <b-col class="into-txt">{{ toilet.address }}</b-col>
      </b-row>
      <b-row>
        <b-col class="into-title" cols="3">개방시간</b-col>
        <b-col>{{ time }}</b-col>
      </b-row>
      <b-row>
        <b-col class="into-title" cols="3">전화번호</b-col>
        <b-col>{{ telephone }}</b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  props:{
    toilet: {type:Object}
  },
  data(){
    return {
      time:'오전 12시부터 24시',
      telephone: '010-123-1234',
      dislike: 2,
      like:10,
      //여긴 다른 API임
      userStatus:1,
    }
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
  min-height: 65%;
  border-radius: 30px 30px 0 0;
  -webkit-box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  padding: 1.5rem 1rem;
  margin: 0;
  text-align: left;
  background: rgb(233,236,241);
}
.toilet-title{
  margin: 1rem 0 1.5rem;
  padding: 0 10px;
  font-weight:600;
}
.toilet-title .title-txt{
  font-size: 1.3rem;
}
.toilet-title .title-desc{
  margin-top: 5px;
  font-size: 0.9rem;
  color:rgb(44, 62, 80, 0.8);
}
.title-desc .service{
  height:20px;
  font-size: 1rem;
  color: #2c3e50;
}
.title-desc .notService{
  position:relative;
  color:rgb(44, 62, 80, 0.2);
}
/* .title-desc .notService::after{
  content: "";
  position: absolute;
  width:20px;
  top: 0;
  bottom: 0;
  left: 0.7rem;
  background-image: url("../../assets/notService.png");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
} */

#detail-card .toilet-info{
  padding: 0.5rem;
  background: #ffffff;
  border-radius: 5px;
  font-size: 0.8rem;
}
#detail-card .toilet-info .row{
  padding: 5px 0;
}
#detail-card .toilet-info .into-title{
  padding:0;
  text-align: left;
}
#detail-card .toilet-info .into-txt{
  overflow: hidden;
}
.row.boder-bottom{
  border-bottom: 1px solid #ddd;
  margin-bottom: 0.5rem;
}
.row.boder-bottom .col{
  margin-bottom: 0.3rem;
}
.default-btn{
  font-weight: 600;
  color: #888;
}
.toilet-score {
  font-size: 10px;
  display: block;
  color: #888;
}
.toilet-score .active {
  color: #fcb500;
}
.toilet-score .task-txt {
  font-size: 0.75rem;
  font-weight: 600;
  color: #888;
}
</style>
