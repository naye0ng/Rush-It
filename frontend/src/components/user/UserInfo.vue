<template>
  <b-row id="userInfo">
    <b-col cols="7" align-self="center" style="text-align:left;">
      <b-row>
        <b-col align-self="center">
          <div class="user-img">
            <img src="../../assets/user.png">
          </div>
        </b-col>
        <b-col cols="8" align-self="center" class="user-nick">
          {{userNickName}}
        </b-col>
      </b-row>
    </b-col>
    <b-col align-self="center" style="text-align:right;">
      <font-awesome-icon icon="cog"/>
    </b-col>
  </b-row>
</template>

<script>
import { mapState } from "vuex";

export default {
  data(){
    return {
    }
  },
  computed: {
    ...mapState({
      userID: state => state.authentication.userID,
      userNickName: state => state.authentication.userNickName,
    })
  }
}
</script>
<style>
#userInfo{
  width: 100%;
  height: 80px;
  background:#214079;
  margin:0;
  overflow: hidden;
  font-size: 1rem;
  color: #ffffff;
}
#userInfo .col{
  overflow: hidden;
  margin: 0;
}
#userInfo .user-img{
  background: #fff;
  border-radius: 50%;
  width: 50px;
  height: 50px;
  overflow: hidden;
  display: inline-block;
}
#userInfo .user-img img{
  width:100%;
  padding: 10%;
}
#userInfo .user-nick{
  letter-spacing: 0.8px;
  font-weight: 600;
}

</style>