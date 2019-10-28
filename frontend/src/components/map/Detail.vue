<template>
  <div>
    <b-card :title="placeDetail.place_name" :sub-title="placeDetail.address_name">
      <b-card-text>
        {{placeDetail.phone}}
      </b-card-text>
      <a :href="placeDetail.place_url" class="card-link" v-if="placeDetail.place_url">바로가기</a>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  props:{
    placeDetail: {type:Object}
  },
  data(){
    return {
    }
  }
}
</script>
