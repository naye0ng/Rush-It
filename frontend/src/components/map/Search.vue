<template>
  <div>
    <b-form id="map-search-form">
      <b-input-group>
        <b-form-input v-model="search" placeholder="Search by name..."></b-form-input>
        <b-input-group-append>
          <!-- search 를 store state 에 저장. -->
          <b-button @click="setMapSearch(search)">
            pooh!
          </b-button>
          <!-- map 을 현재 위치로 이동 -->
          <b-button @click="setMapPoint()">
            현재위치
          </b-button>
        </b-input-group-append>
      </b-input-group>
    </b-form>
  </div>
</template>

<script>
import { mapMutations, mapActions} from 'vuex'
import store from 'vuex'

export default {
  name: 'Search',
  data() {
    return {
      search : ''
    }
  },
  methods : {
    ...mapMutations({
      setMapSearch : 'setMapSearch',
      setMapPoint : 'setMapPoint'
    })
  }
}
</script>

<style>
#map-search-form {
  margin : 0px auto;
}
</style>