<template>
  <div class="muck-up">
    <div class="reviews">
      <div class="title">
        <h3>Toilet</h3>
        <small>Your toilet reviews</small>
      </div>
      <div class="scroll_ok ul-wrap">
        <ul class="tasks">
          <li v-for="review in reviews" class="one red" if="reviews" >
            <div class="task-title">{{review.toilet_name }}</div>
            <div class="task-time">{{review.time.substring(0,10)}}</div>
            <div class="task-score">
                <font-awesome-icon icon="star" v-bind:class="{ active: review.score>=1 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.score>=2 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.score>=3 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.score>=4 }"/>
                <font-awesome-icon icon="star" v-bind:class="{ active: review.score==5 }"/>
                ( {{review.rating}} 점 )
              </div>
            <div class="task-txt">{{review.review }}</div>
          </li>
        </ul>
      </div>
    </div>
    <!-- <transition name="slide-up-and-down"> -->
      <!-- <Detail v-show="showPopup && index == detailId" v-bind:class="{top:swipe==1}" v-bind:toilet="toilet_rank[detailId]" v-hammer:swipe.vertical="swipeEvent"/> -->
    <!-- </transition> -->
  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from "vuex";

export default {
  data(){
    return {
      reviews:{},
      toilet:{},
    }
  },
  computed: {
    ...mapState({
      userID: state => state.authentication.userID,
    })
  },
  methods:{
    setReviews(){
       // 화장실 리뷰 조회
      const url = 'http://localhost:8080'
      axios.get(url+"/review",{params:{user_id:this.userID}})
      .then(response => {
        if(response.data.code == 200){
          this.reviews = response.data.reviews
          console.log(response.data)
        }
      }).catch(error=>{
          console.log(error)
      })
    }
  },
  mounted(){
    this.setReviews()
  }
}
</script>
<style>
.muck-up {
  width: 100%;
  height:100%;
  padding: 0 10px;
  overflow: hidden;
}

.muck-up .reviews {
  background-color: #fff;
  height:100%;
  z-index: 1;
  position: relative;
  color: #222;
  padding-right: 10px;
}
.muck-up .reviews .ul-wrap{
  padding-left: 35px;
  padding-right: 10px;

}
.muck-up .reviews .title {
  margin: 20px 0;
}

.muck-up .reviews .title h3 {
  font-size: 22px;
  margin-bottom: 5px;
}

.title small {
  font-size: 10px;
  color: #888;
  text-transform: uppercase;
  letter-spacing: 1px;
}
ul.tasks .task-title {
  font-size: 14px;
}
ul.tasks .task-time {
  margin-top:3px;
  font-size: 11px;
  color: #888;
}

ul.tasks .task-score {
  font-size: 10px;
  display: block;
  color: #888;
  margin-bottom: 10px;
}
ul.tasks .task-score .active {
  color: #fcb500;
}
ul.tasks .task-txt {
  font-size: 12.5px;
  display: block;
  color: #636363;
}

ul.tasks li {
  padding-bottom: 15px;
  position: relative;
  z-index: 8;
  text-align: left;
  margin-bottom: 10px;
}

ul.tasks li:after {
  content: '';
  position: absolute;
  left: -18px;
  top: 8px;
  height: 8px;
  width: 8px;
  border-radius: 50%;
}

ul.tasks li.red:after {
  background: #888;
}
ul.tasks li.red:hover:after {
  background:#FF3163;
}

ul.tasks::after {
  content: '';
  position: absolute;
  height: 100vh;
  width: 1px;
  background: #eee;
  left: 20px;
  top: -68px;
}

ul li.hang {
  margin-bottom: 48px;
}

ul li.hang img {
  float: left;
  height: 20ox;
  width: 20px;
  border-radius: 50%;
  margin-right: 8px;
}
</style>