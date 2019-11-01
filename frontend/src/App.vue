<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
    <transition name="slide-up-and-down">
      <Authentication v-show="isActive"/>
    </transition>
    <Navigation />
  </div>
</template>

<script>
import Authentication from '../src/components/template/Authentication'
import Navigation from '../src/components/template/Navigation'
import {mapState} from 'vuex';
import store from 'vuex';

export default {
  name: 'App',
  components : {
    Authentication,
    Navigation
  },
  computed: {
    ...mapState({
      isActive: state => state.authentication.isActive
    }),
  },
  created() { // test change to updated()
    this.$store.commit('setUserPoint')
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50!important;
}
/* 1초 동안 위로 올라오는 애니메이션 */
.slide-up-and-down-enter-active{
  animation: slide-move 1s;
}
.slide-up-and-down-leave-active{
  animation: slide-move 1s reverse;
}
@keyframes slide-move{
  0%{
    opacity: 0;
    transform: translateY(100%);
  }
  40%{
    opacity: 1;
  }
  100%{
    transform: translateY(0%)
  }
} 
</style>
