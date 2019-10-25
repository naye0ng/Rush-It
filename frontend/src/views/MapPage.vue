<template>
  <div>
    <input type="text" v-model="search" placeholder="장소 검색..." style="border: 1px solid black;">
    <button @click="load">Search</button>
    <Map :searchPlace="searchPlace" style="margin-top:5%;"></Map>
    <Filter></Filter>
    <Detail></Detail>
  </div>
</template>

<script>
import Map from '@/components/map/Map'
import Search from '@/components/map/Search'
import Filter from '@/components/map/Filter'
import Detail from '@/components/map/Detail'

export default {
  name: 'MapPage',
  components: {
    Map,
    Search,
    Filter,
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
