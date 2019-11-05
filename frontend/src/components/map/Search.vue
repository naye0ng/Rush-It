<template>
  <div>
    <b-form id="map-search-form">
      <b-input-group>
        <b-form-input v-model="search" placeholder="Search by name..."></b-form-input>
        <b-input-group-append>
          <!-- search 를 store state 에 저장. -->
          <div @click="asyncSearchMap(search)" style="margin: auto 0.6rem;">
            <img src="../../assets/user.png" height="35px" />
          </div>
          <!-- map 을 현재 위치로 이동 -->
           <div @click="setMapPoint()" style="margin: auto 0.6rem;">
            <img src="../../assets/user.png" height="35px" />
          </div>
        </b-input-group-append>
      </b-input-group>
    </b-form>
  </div>
</template>

<script>
import { mapMutations, mapActions } from "vuex";
import store from "vuex";

export default {
  name: "Search",
  data() {
    return {
      search: ""
    };
  },
  methods: {
    ...mapMutations({
      setMapPoint: "setMapPoint"
    }),
    ...mapActions({
      asyncSearchMap: "asyncSearchMap"
    })
  }
};
</script>

<style>
#map-search-form {
  margin: 0px auto;
}
</style>