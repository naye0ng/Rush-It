<template>
  <div id="home">
    <div class="gps-btn">
      <div class="description">화장실 찾기</div>
      <div class="pin bounce"></div>
      <div class="pulse"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods :{
  }
}
</script>
<style>
#home{
  width:100%;
  height:100vh;
}
#home::before{
  content: "";
  position: absolute;
  width:100%;
  height:100vh;
  top: 0;
  left: 0;
  background-image: url('../assets/background-map.png');
  background-size: 130vw;
  /* opacity: 0.2; */
  /* background-color: #000000; */
  filter:blur(2px);
  animation: map-focus 1s;
}
.gps-btn{
  width: 100%;
  height: 50px;
  top:40%;
  position: relative;
}
.gps-btn .description{
  position:absolute;
  top: 10%;
  left: 60%;
  display: inline-block;
  padding: 0.5% 2%;
  border-bottom: 4px dotted #ed3336;
  color: #262626;
  font-size: 0.8rem;
  font-weight: 800;
  letter-spacing: 0.08rem;
  animation: description-focus 1s;
}
.gps-btn .description::before{
  content: "";
  position:absolute;
  width: 50%;
  height: 100%;
  bottom: -60%;
  left: -49%;
  transform: rotate(-25deg);
  border-bottom: 4px dotted #ed3336;
}
.gps-btn .pin{
  width: 40px;
  height: 40px;
  border-radius: 50% 50% 50% 0;
  background: #ed3336;
  position: relative;
  transform: rotate(-45deg);
  left: 50%;
  margin: -20px 0 0 -20px;
  z-index: 1;
}
.gps-btn .pin::after{
  content: '';
  width: 14px;
  height: 14px;
  left: 30%;
  top: 33%;
  margin: 0;
  background: #ffffff;
  position: absolute;
  border-radius: 50%;
}
.gps-btn .bounce{
  animation-name: bounce;
  animation-fill-mode: both;
  animation-duration: 1s;
}
.gps-btn .pulse{
  content: "";
  height: 14px;
  width: 14px;
  position: relative;
  left: 48%;
  bottom: -10%;
  background: rgba(1,1,1,0.2);
  margin: 0;
  transform: rotateX(55deg);
  border-radius: 50%;
}
.gps-btn .pulse:after{
  content: "";
  border-radius: 50%;
  height: 40px;
  width: 40px;
  left: -13px;
  top: -12px;
  position: absolute;
  margin: 0;
  animation: pulsate 1s ease-out;
  animation-iteration-count: infinite;
  opacity: 0.0;
  box-shadow: 0 0 1px 5px #ed33364f;
  animation-delay: 1.1s;
}
@keyframes map-focus{
  0%{
    filter:blur(0px);
  }
  50%{
    filter:blur(1px);
  }
  100%{
    filter:blur(2px);
  }
}
@keyframes description-focus{
  0%{
    transform: translateX(-10px);
    opacity: 0.0;
  }
  50%{
    opacity: 0.5;
  }
  100%{
    opacity: 1;
  }
}
@keyframes pulsate{
  0%{
    transform: scale(0.1, 0.1);
    opacity: 0.0;
  }
  50%{
    opacity: 1.0;
  }
  100%{
    transform: scale(1.2, 1.2);
    opacity: 0.0;
  }
}
@keyframes bounce{
  0%{
    opacity: 0;
    transform: translateY(-2000px) rotate(-45deg);
  }
  60%{
    opacity: 1;
    transform: translateY(30px) rotate(-45deg);
  }
  80%{
    transform: translateY(-10px) rotate(-45deg);
  }
  100%{
    transform: translateY(0) rotate(-45deg);
  }
} 
</style>