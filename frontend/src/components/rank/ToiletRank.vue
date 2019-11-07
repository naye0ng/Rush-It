<template>
  <div id="toilet-rank" class="scroll_ok">
    <b-row
      align-v="center"
      class="rank-list"
      v-if="toilet_rank"
      v-for="(toilet, index) in toilet_rank"
      @click="showDetail(index)"
      :key="index"
      v-bind:class="{ rank01: index==0, rank02: index==1, rank03 : index==2 }"
    >
      <b-col v-if="index >= 3">{{index + 1}}위</b-col>
      <b-col v-else>&nbsp;</b-col>
      <b-col cols="6">{{toilet.name}}</b-col>
      <b-col>{{toilet.ratings}} 점</b-col>
      <b-col>
        <font-awesome-icon icon="trophy" v-if="index == 0"/>
        <font-awesome-icon icon="star" v-else/>
        <p class="review-cnt">{{toilet.reviews}}</p>
      </b-col>
      <transition name="slide-up-and-down">
        <Detail v-show="showPopup && index == detailId" v-bind:class="{top:swipe==1}" v-bind:toilet="toilet_rank[detailId]" v-hammer:swipe.vertical="swipeEvent"/>
      </transition>
    </b-row>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from "vuex";
import Detail from '../template/Detail'
export default {
  name: "ToiletRank",
  components:{
    Detail,
  },
  data() {
    return {
      toilet_rank: [],
      showPopup: false,
      detailId: 0,
      swipe: 0,
    };
  },
  methods:{
    showDetail(target){
      this.detailId = target
      this.showPopup = true
    },
    getToiletRank(){
      // 화장실 랭킹 조회
      const url = "http://localhost:8080"
      axios.get(url+"/rank/toilet")
      .then(response => {
          this.toilet_rank = response.data ||[]
      }).catch(error=>{
          console.log(error)
      })
    },
    swipeEvent(e){
      if(e.type == 'swipeup'){
        this.swipe = 1
      }else{
        this.swipe = 0
        this.showPopup = false
      }
    }
  },
  computed: {
    ...mapState({
      userNickName: state => state.authentication.userNickName
    })
  },
  mounted(){
    this.getToiletRank()
  }
};
</script>
<style>

#toilet-rank .rank-list {
  position:relative;
  font-size: 0.8rem;
  margin: 15px;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  animation: rank-list 0.5s;
}
.rank01::before, .rank02::before, .rank03::before{
  position: absolute;
  top:-11%;
  left: 5%;
  font-size:3rem;
}
.rank01::before{
  content:"🥇"
}
.rank02::before{
  content:"🥈"
}
.rank03::before{
  content:"🥉"
}

#toilet-rank .rank-list.no1 {
  font-size: 0.9rem;
  font-weight: 550;
  padding: 25px 15px;
  background: #FF3163;
  color: #fff;
}
.rank-list .review-cnt{
  font-size: 0.65rem;
  margin:0;
}

@keyframes rank-list{
  0%{
    transform: translateY(-10%);
  }
  100%{
    transform: translateY(0%)
  }
}
</style>