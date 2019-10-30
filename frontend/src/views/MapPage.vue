<template>
  <div id = "map-page">
    <Search></Search>
    <Filters style="padding-top:10px"></Filters>
    <!--<input type="text" v-model="search" placeholder="장소 검색..." style="border: 1px solid black;">
    <button @click="load">Search</button>-->
    <Map :searchPlace="searchPlace" style="margin-top:5%;"></Map>
    <Detail></Detail>
  </div>
</template>

<script>
import Map from '@/components/map/Map'
import Search from '@/components/map/Search'
import Filters from '@/components/map/Filters'
import Detail from '@/components/map/Detail'

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
      this.searchPlace = this.search
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