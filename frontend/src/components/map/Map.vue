<template>
  <div>
    <div id="map" style="width:100%;height:40vh;"></div>
  </div>
</template>

<script>
import Detail from '@/components/map/Detail'
import { mapGetters } from 'vuex';
import store from 'vuex';

export default {
  name: 'Map',
  components:{
    Detail
  },
  data: function () {
    return {
      placelist : [],
      placeDetail:{},
    }
  },
  computed : {
    ...mapGetters({
      map : 'draw_map'
    })
  },
  mounted: function () {
    var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
    
    // 사용자의 위치를 기반으로 map을 그린다.
    this.$store.dispatch('asyncMakeMap', mapContainer);
  },
  watch:{
    
  },
  methods:{
    
  }
  
};
</script>
