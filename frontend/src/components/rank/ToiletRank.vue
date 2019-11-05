<template>
  <div id="toilet-rank">
    <!-- v-bind:class="{ no1: index == 0 }" -->
    <b-row
      align-v="center"
      class="rank-list"
      v-if="toilet_rank"
      v-for="(toilet, index) in toilet_rank"
      @click="showDetail(index)"
    >
      <b-col>{{index + 1}}위</b-col>
      <b-col cols="6">{{toilet.name}}</b-col>
      <b-col>{{toilet.ratings}} 점</b-col>
      <b-col>
        <font-awesome-icon icon="trophy" v-if="index == 0"/>
        <font-awesome-icon icon="star" v-else/>
        <p class="review-cnt">{{toilet.reviews}}</p>
      </b-col>
      <transition name="slide-up-and-down">
        <Detail v-show="showPopup" v-bind:toilet="toilet_rank[detailId]" />
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
  font-size: 0.8rem;
  margin: 15px;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  animation: rank-list 0.5s;
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