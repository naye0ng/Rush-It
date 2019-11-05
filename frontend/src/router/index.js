import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/views/HomePage'
import MapPage from '@/views/MapPage'
import MyPage from '@/views/MyPage'
import RankPage from '@/views/RankPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/map',
      name: 'MapPage',
      component: MapPage
    },
    {
      path: '/user',
      name: 'MyPage',
      component: MyPage
    },
    {
      path: '/rank',
      name: 'RankPage',
      component: RankPage
    }
  ]
})
