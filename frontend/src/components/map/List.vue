<template>
  <div id="map-list">
      <b-container v-for="place in place_list" :key="place.id" class="py-2" @click="showDetail(place)">
        <b-row class="text-left" id="map-list-title">{{place.name}}</b-row>
        <b-row class="title-desc" align-v="center" id="map-list-body">
          <b-col class="text-left">{{place.address}}</b-col>
          <b-col cols="1" class="service text-center" v-bind:class="{notService: place.handicapped == 0}"><font-awesome-icon icon="wheelchair"/></b-col>
          <b-col cols="1" class="service text-center" v-bind:class="{notService: place.bell == 0}"><font-awesome-icon icon="bell"/></b-col>
          <b-col cols="1" class="service text-center" v-bind:class="{notService: place.diaper == 0}"><font-awesome-icon icon="baby"/></b-col>
        </b-row>
      </b-container>
      <transition name="slide-up-and-down">
        <Detail v-if="showPopup" v-bind:toilet="toilet" />
      </transition>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import store from "vuex";
import Detail from '@/components/template/Detail'

export default {
  name: "List",
  components:{
    Detail
  },
  computed: {
    ...mapGetters({
      place_list: "get_place_list"
    })
  },
  data() {
    return {
      showPopup: false,
      toilet : { "address": "", "handicapped": "", "name": "", "location_x": "", "location_y": "", "id": "", "diaper": "0", "type": "0", "bell": "0" }
    };
  },
  methods : {
    showDetail(toilet){
      this.showPopup = true;
      this.toilet = toilet;
    }
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

#map-list-body .service{
  height:20px;
  font-size: 0.85rem;
  color:#888;
}
#map-list-body .notService{
  position:relative;
  color:rgb(44, 62, 80, 0.2);
}
</style>
