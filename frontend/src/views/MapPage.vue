<template>
  <div>
    <input type="text" v-model="search" placeholder="장소 검색..." style="border: 1px solid black;">
    <button @click="load">Search</button>
    <Map :searchPlace="searchPlace" style="margin-top:5%;"></Map>
  </div>
</template>

<script>
import Map from '@/components/map/Map'
import Search from '@/components/map/Search'

export default {
  name: 'MapPage',
  components: {
    Map,
    Search
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
