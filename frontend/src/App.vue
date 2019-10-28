<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
    <Authentication />
    <Navigation />
  </div>
</template>

<script>
import Authentication from '../src/components/template/Authentication'
import Navigation from '../src/components/template/Navigation'

export default {
  name: 'App',
  components : {
    Authentication,
    Navigation
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
<<<<<<< HEAD
=======
  margin-top: 6%;
>>>>>>> 66094eb8599957fa9fa9a25d23e99c90d90bf72e
}
</style>
