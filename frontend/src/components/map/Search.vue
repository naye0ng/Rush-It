<template>
  <div>
    <b-form id="map-search-form">
      <b-input-group>
        <b-form-input v-model="search" placeholder="Search by name..."></b-form-input>
        <b-input-group-append>
          <b-button >
            pooh!
          </b-button>
          <b-button>
            현재위치
          </b-button>
        </b-input-group-append>
      </b-input-group>
    </b-form>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: 'Search',
  computed: {
    ...mapState({
      search : state => state.map.search
    })
  },
  mounted() {
    console.log(this.search);
  }
}
</script>

<style>
#map-search-form {
  width : 90vw;
  margin : 0px auto;
}
</style>