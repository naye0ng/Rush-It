<template>
  <div id = "map-page">
    <Search style="padding-top:3vh"></Search>
    <!-- <Filters style="padding-top:10px"></Filters> -->
    <Map style="margin-top:5%;"></Map>
    <List></List>
  </div>
</template>

<script>
import Map from '@/components/map/Map'
import Search from '@/components/map/Search'
import Filters from '@/components/map/Filters'
import List from '@/components/map/List'
import store from 'vuex'

export default {
  name: 'MapPage',
  components: {
    Map,
    Search,
    Filters,
    List
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