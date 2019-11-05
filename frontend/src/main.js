// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './vuex/store'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { VueHammer } from 'vue2-hammer'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faSearch, faHome, faTrophy, faChild, faPoo, faCog, faStar, faBell, faWheelchair, faBaby, faThumbsDown, faThumbsUp, faMapMarkerAlt, faSearchLocation } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

Vue.use(BootstrapVue)
Vue.use(VueHammer)
VueHammer.config.swipe = {
  threshold: 0
};

library.add(faSearch, faHome, faTrophy, faChild, faPoo, faCog, faStar, faBell, faWheelchair, faBaby, faThumbsDown, faThumbsUp, faMapMarkerAlt, faSearchLocation )
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

/* eslint-disable */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
