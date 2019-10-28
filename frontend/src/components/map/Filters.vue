<template>
  <div>
      <b-form-group>
        <!-- Label -->
        <b-form-checkbox-group
          v-model="selected"
          :options = "options"
          inline
        ></b-form-checkbox-group>
      </b-form-group>
  </div>
</template>

<script>
export default {
  name: 'Filters',
  data(){
    return {
      selected : [],
      options: [
        {text : '장애인화장실', value : 'handicapped'},
        {text : '기저귀교환대', value : 'diaper'},
        {text : '비상벨', value : 'bell'}
      ]
    }
  }
}
</script>
