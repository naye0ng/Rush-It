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
      <b-col>{{toilet.score}} 점</b-col>
      <b-col>
        <font-awesome-icon icon="trophy" v-if="index == 0"/>
        <font-awesome-icon icon="star" v-else/>
        <p class="review-cnt">{{toilet.review_cnt}}</p>
      </b-col>
    </b-row>
    <transition name="slide-up-and-down">
      <Detail v-show="showPopup" v-bind:toilet="toilet_rank[detailId]" />
    </transition>
  </div>
</template>

<script>
import { mapState } from "vuex";
import Detail from '../template/Detail'
export default {
  name: "ToiletRank",
  components:{
    Detail,
  },
  data() {
    return {
      toilet_rank: [
        {
          id:1,
          name: "강남역 삼성건물 지하1층",
          type: 1,
          address: '서울시 강남구 어쩌구 어쩌구 놔놔놔놔dfghjfdrewqefdghrtewgfhvftrdfhgtrfghftyrdhfg노',
          handicapped: 1,
          diaper: true,
          bell: true,
          review_cnt: 30,
          score: 5,
        },
        {
          id:5,
          name: "강남역 삼성건물 5층",
          type: 0,
          address: '서울시 강남구 어쩌구 어쩌구 놔놔놔놔노',
          handicapped: 1,
          diaper: true,
          bell: true,
          review_cnt: 30,
          score: 4,
        },
        {
          id:3,
          name: "강남역 삼성건물 지하2층",
          type: 3,
          address: '서울시 강남구 어쩌구 어쩌구 놔놔놔놔노',
          handicapped: 1,
          diaper: true,
          bell: true,
          review_cnt: 30,
          score: 5,
          review_cnt: 32,
          score: 3.5,
        },
        {
          id:12,
          name: "강남역 삼성건물 지상1층",
          type: 1,
          address: '서울시 강남구 어쩌구 어쩌구 놔놔놔놔dfghjfdrewqefdghrtewgfhvftrdfhgtrfghftyrdhfg노',
          handicapped: false,
          diaper: true,
          bell: true,
          review_cnt: 50,
          score: 3,
        }
      ],
    showPopup: false,
    detailId: 0,
    };
  },
  methods:{
    showDetail(target){
      this.detailId = target
      this.showPopup = true
    }
  },
  computed: {
    ...mapState({
      userNickName: state => state.authentication.userNickName
    })
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