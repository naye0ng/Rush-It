<template>
  <b-row id="navigation">
    <b-col>
      <div class="menu-list" v-bind:class="{active: currentMenu == 0 }" @click="changeCurrentMenu(0)">
        <font-awesome-icon icon="home"/>
      </div>
    </b-col>
    <b-col>
      <div class="menu-list" v-bind:class="{active: currentMenu == 1 }" @click="changeCurrentMenu(1)">
      <font-awesome-icon icon="search" />
      </div>
    </b-col>
    <b-col>
      <div class="menu-list" v-bind:class="{active: currentMenu == 2 }" @click="changeCurrentMenu(2)">
        <font-awesome-icon icon="child"/>
      </div>
    </b-col>
    <b-col>
      <div class="menu-list" v-bind:class="{active: currentMenu == 3 }" @click="changeCurrentMenu(3)">
        <font-awesome-icon icon="trophy" />
      </div>
    </b-col>
  </b-row>
</template>
<script>
import {mapState} from 'vuex';

export default {
  name: "Navigation",
  data() {
    return {
    }
  },
  methods: {
    changeCurrentMenu(target) { 
      this.$store.commit('setCurrentPage', target);
      if (target == 0){
            // home 화면으로 변경
        }
        else if (target == 1){
            // 검색 화면으로 변경
            router.push({ path: 'home' })
        }
        else{
            if(this.isLogin){
                if(payload == 2){
                    // 마이페이지로 이동
                }else{
                    // 랭킹페이지러로 이동
                }
            }else{
              //로그인창 활성화
              this.$store.commit('setAuthentication',{'isActive':true});
            }

        
            
        }
    }
  },
  computed: {
    ...mapState({
      currentMenu: state => state.currentPage,
      isLogin: state => state.authentication.isLogin,
    }),
  },

}
</script>
<style>
#navigation {
  z-index: 100;
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 68px;
  border-radius: 30px 30px 0 0;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  background: #ffffff;
  padding: 1.5rem 1.5rem;
  margin: 0;
}
#navigation .col {
  margin: 0;
  height: 34px;
  font-size:18px;
  color: #262626;
  position: relative;  
}
#navigation .col .menu-list::before {
  content: "";
  position: absolute;
  width: 46px;
  height: 46px;
  top: calc(35% - 23px);
  left: calc(50% - 23px);
  border-radius: 50%;
}
#navigation .col .menu-list.active::before {
  background: rgb(33, 64, 121, 0.1);
}
</style>
