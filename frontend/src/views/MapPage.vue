<template>
  <div id = "map-page">
    <Search></Search>
    <Filters style="padding-top:10px"></Filters>
    <Map :searchPlace="searchPlace" style="margin-top:5%;"></Map>
    <Detail></Detail>
  </div>
</template>

<script>
import Map from '@/components/map/Map'
import Search from '@/components/map/Search'
import Filters from '@/components/map/Filters'
import Detail from '@/components/map/Detail'
import store from 'vuex'

export default {
  name: 'MapPage',
  components: {
    Map,
    Search,
    Filters,
    Detail
  },
  data(){
    return {
      search:'',
      searchPlace:'',
    }
  },
  methods:{
    load(){
      //this.searchPlace = this.search
      console.log(this.$store.state.map.draw_map.getCenter())
    }
  }
}
</script>

<style>
#map-page {
  width : 90vw;
  margin : 0px auto;
  padding-top : 10px;
}
</style>