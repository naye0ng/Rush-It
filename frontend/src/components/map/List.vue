<template>
  <div id="map-list">
      <b-container v-for="place in place_list" :key="place.name" class="py-2">
        <b-row class="text-left" id="map-list-title">{{place.name}}</b-row>
        <b-row id="map-list-body">
          <span>{{place.address}}</span>
          <b-col class="text-right">
            <span>{{place.handicapped}}</span>
            <span>{{place.diaper}}</span>
            <span>{{place.bell}}</span>
          </b-col>
        </b-row>
      </b-container>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import store from "vuex";

export default {
  name: "List",
  computed: {
    ...mapGetters({
      place_list: "get_place_list"
    })
  },
  data() {
    return {};
  }
};
</script>

<style>

#map-list {
  margin-top: 0.5rem;
  padding-bottom: 1.5rem;
  height: 30vh;
  overflow: scroll;
}

#map-list-title {
  font-size: 1rem;
  font-weight: bold;
}

#map-list-body {
  font-size: 0.85rem;
  color:darkgray;
}
</style>
