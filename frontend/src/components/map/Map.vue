<template>
  <div>
    <div id="map" style="width:100%;height:350px;">
    </div>
  </div>
</template>

<script>
export default {
  name: 'Map',
  props:{
    searchPlace: {type: String},
  },
  data: function () {
    return {
      map:'',
    }
  },
  mounted: function () {
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

    // 지도를 생성합니다    
    this.map = new kakao.maps.Map(mapContainer, mapOption);
  },
  watch:{
    searchPlace(){
      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places();

      // 키워드로 장소를 검색합니다
      ps.keywordSearch(this.searchPlace, this.placeSearchCB);
    }
  },
  methods:{
    placeSearchCB (data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {
        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            this.displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        this.map.setBounds(bounds);
      } 
    },
    displayMarker(place){
      // 마커를 생성하고 지도에 표시합니다
      var marker = new kakao.maps.Marker({
          map: this.map,
          position: new kakao.maps.LatLng(place.y, place.x) 
      });
    },
  }
  
};
</script>
