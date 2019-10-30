<template>
  <div>
    <b-form id="map-search-form">
      <b-input-group>
        <b-form-input v-model="search" placeholder="Search by name..."></b-form-input>
        <b-input-group-append>
          <b-button @click="setMapSearch(search)">
            pooh!
          </b-button>
          <b-button @click="setMapPoint()">
            현재위치
          </b-button>
        </b-input-group-append>
      </b-input-group>
    </b-form>
  </div>
</template>

<script>
import { mapMutations, mapActions } from 'vuex'

export default {
  name: 'Search',
  data() {
    return {
      search : ''
    }
  },
  methods : {
    ...mapMutations({
      setMapSearch : 'setMapSearch'
    }),
    ...mapActions({
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