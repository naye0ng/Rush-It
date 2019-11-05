<template>
  <div id = "rank-page">
    <b-row class="rank-header" align-v="center">
      <b-col>RANKING <font-awesome-icon icon="trophy"/></b-col>
    </b-row>
    <b-row align-h="center" class="rank-toggle">
      <b-col v-bind:class="{ active: currentMenu == 0}" @click="toggle(0)">TOILET</b-col>
      <b-col v-bind:class="{ active: currentMenu == 1}" @click="toggle(1)">USER</b-col>
    </b-row>
    <ToiletRank v-if="currentMenu==0"></ToiletRank>
    <UserRank v-else></UserRank>

  </div>
</template>

<script>
import ToiletRank from '@/components/rank/ToiletRank'
import UserRank from '@/components/rank/UserRank'

export default {
  name: 'RankPage',
  components: {
    ToiletRank,
    UserRank,
  },
  data(){
    return {
      currentMenu: 0, 
    }
  },
  methods: {
    toggle(select){
      this.currentMenu = select
    }
  }
}
</script>
<style>
.rank-header{
  width: 100%;
  height: 80px;
  background: #214079;
  margin: 0;
  overflow: hidden;
  font-size: 1.1rem;
  color: #ffffff;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  letter-spacing: 0.05rem;
}
.rank-header .col{
  font-weight: 550;
}
.rank-toggle{
  background: rgb(33, 64, 121, 0.1);
  font-size: 0.8rem;
  font-weight: 550;
  letter-spacing: 0.08rem;
  margin: 20px 20% 35px;
  border-radius: 30px;
}
.rank-toggle .col{
  margin: 5px;
  padding: 5px;
  cursor: pointer;
}
.rank-toggle .col.active{
  background: #214079;
  color: #ffffff;
  border-radius: 30px;
}
</style>