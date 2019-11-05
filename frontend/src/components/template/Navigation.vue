<template>
  <b-row id="navigation">
    <b-col>
      <div
        class="menu-list"
        v-bind:class="{active: currentMenu == 'HomePage' }"
        @click="changeCurrentMenu('HomePage')"
      >
        <font-awesome-icon icon="home" />
      </div>
    </b-col>
    <b-col>
      <div
        class="menu-list"
        v-bind:class="{active: currentMenu == 'MapPage' }"
        @click="changeCurrentMenu('MapPage')"
      >
        <font-awesome-icon icon="search" />
      </div>
    </b-col>
    <b-col>
      <div
        class="menu-list"
        v-bind:class="{active: currentMenu == 'MyPage' }"
        @click="changeCurrentMenu('MyPage')"
      >
        <font-awesome-icon icon="child" />
      </div>
    </b-col>
    <b-col>
      <div
        class="menu-list"
        v-bind:class="{active: currentMenu == 'RankPage' }"
        @click="changeCurrentMenu('RankPage')"
      >
        <font-awesome-icon icon="trophy" />
      </div>
    </b-col>
  </b-row>
</template>
<script>
import { mapState } from "vuex";

export default {
  name: "Navigation",
  data() {
    return {};
  },
  methods: {
    changeCurrentMenu(target) {
      if(target === "HomePage"  && target !== this.currentMenu){
        this.$router.push({ name: "HomePage" });
        if(this.isActive){
          this.$store.commit("setAuthentication", { isActive: false });
        }
      }else if(target === "MapPage" && target !== this.currentMenu){
        this.$router.push({ name: "MapPage" });
        if(this.isActive){
          this.$store.commit("setAuthentication", { isActive: false });
        }
      }else if(target === "MyPage"){
        if (this.isLogin) {
          this.$router.push({ name: "MyPage" });
        }else if(target === this.currentMenu){
          if(this.isActive){
            this.$store.commit("setAuthentication", { isActive: false });
          }else{
            this.$store.commit("setAuthentication", { isActive: true });
          }
        }else{
          this.$store.commit("setAuthentication", { isActive: true });
        }
      }else if(target === "RankPage"){
        if (this.isLogin) {
          this.$router.push({ name: "RankPage" });
        }else if(target === this.currentMenu){
          if(this.isActive){
            this.$store.commit("setAuthentication", { isActive: false });
          }else{
            this.$store.commit("setAuthentication", { isActive: true });
          }
        }else{
          this.$store.commit("setAuthentication", { isActive: true });
        }
      }
      this.$store.commit("setCurrentPage", target);
    }
  },
  computed: {
    ...mapState({
      currentMenu: state => state.currentPage,
      isActive: state => state.authentication.isActive,
      isLogin: state => state.authentication.isLogin,
    })
  }
};
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
  font-size: 18px;
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
