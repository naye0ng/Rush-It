<template>
  <div>
    <b-form id="map-search-form">
      <b-input-group>
        <b-form-input v-model="search" placeholder="Search by name..."></b-form-input>
        <b-input-group-append>
          <b-button>
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
export default {
  name: 'Search',
  data(){
    return {
      search : ''
    }
  }
}
</script>

<style>
#map-search-form {
  width : 90vw;
  margin : 0px auto;
}
</style>