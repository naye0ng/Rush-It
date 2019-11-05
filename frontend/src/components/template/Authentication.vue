<template>
  <b-row id="AuthenticationForm">
    <div class="login-wrap">
      <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked />
        <label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up" />
        <label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
          <div class="sign-in-htm">
            <div class="group">
              <input
                id="user"
                type="text"
                class="input text"
                placeholder="아이디를 입력하세요."
                v-model="signIn_id"
              />
            </div>
            <div class="group">
              <input
                id="pass"
                type="password"
                class="input text"
                data-type="password"
                placeholder="비밀벝호를 입력하세요."
                v-model="signIn_pw"
              />
            </div>
            <div class="group">
              <input id="check" type="checkbox" class="check" v-model="signIn_auto" />
              <label for="check">
                <span class="icon"></span> Keep me Signed in
              </label>
            </div>
            <div class="group form-err">{{signIn_msg }}</div>
            <div class="group">
              <input type="submit" class="button radius" value="Sign In" @click="signIn()" />
            </div>
          </div>
          <div class="sign-up-htm">
            <div class="group sec2">
              <input
                id="user"
                type="text"
                class="input text"
                placeholder="아이디를 입력하세요."
                v-model="signUp_id"
              />
            </div>
            <div class="group sec2">
              <input
                id="user"
                type="text"
                class="input text"
                placeholder="닉네임을 입력하세요."
                v-model="signUp_nick"
              />
            </div>
            <div class="group sec2">
              <input
                id="pass"
                type="password"
                class="input text"
                data-type="password"
                placeholder="비밀번호를 입력하세요."
                v-model="signUp_pw"
              />
            </div>
            <div class="group sec2">
              <input
                id="pass"
                type="password"
                class="input text"
                data-type="password"
                placeholder="비밀번호 확인"
                v-model="signUp_pw2"
              />
            </div>
            <div class="group">
              <input id="female" type="radio" v-model="signUp_gender" value="F">
              <label for="female">Female</label>
              <input id="male" type="radio" v-model="signUp_gender" value="M">
              <label for="male">Male</label>
            </div>
            <div class="group form-err">{{signUp_msg }}</div>
            <div class="group">
              <input type="submit" class="button radius" value="Sign Up" @click="signUp()" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </b-row>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  data() {
    return {
      signIn_id: "",
      signIn_pw: "",
      signIn_auto: true,
      signIn_msg: "",

      signUp_id: "",
      signUp_nick: "",
      signUp_gender: "F",
      signUp_pw: "",
      signUp_pw2: "",
      signUp_msg: ""
    };
  },
  methods: {
    ...mapActions(["asyncSignIn", "asyncSignUp"]),
    signIn: function() {
      if (this.signIn_id && this.signIn_pw) {
        this.asyncSignIn({
          'id':this.signIn_id,
          'pw':this.signIn_pw,
          'auto':this.signIn_auto,
        }).then((isSuccess) => {
          if(isSuccess){
            this.$router.push({ name: "MyPage" });
          }else{
            this.signIn_msg = "회원정보와 일치하지 않습니다.";
          }
        })
        
        
      } else {
        this.signIn_msg = "아이디와 비밀번호를 입력하세요!";
      }
    },
    signUp() {
      if (
        this.signUp_id &&
        this.signUp_nick &&
        this.signUp_pw &&
        this.signUp_pw2
      ) {
        if (this.signUp_pw == this.signUp_pw2) {
          this.asyncSignUp({
            'id':signUp_id,
            'nick':signUp_nick,
            'pw':signUp_pw,
            'gender':signUp_gender,
          })
        } else {
          this.signUp_msg = "비밀번호가 일치하지 않습니다.";
        }
      } else {
        this.signUp_msg = "모든 칸을 빠짐없이 적어주세요.";
      }
    }
  }
};
</script>
<style>
#AuthenticationForm {
  z-index: 99;
  position: fixed;
  bottom: 2rem;
  left: 0;
  width: 100%;
  min-height: 360px;
  border-radius: 30px 30px 0 0;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  padding: 1.5rem 1.5rem;
  margin: 0;
  text-align: left;
  color: #214079;
  font-weight: 650;
  background-color: #ffffff;
}
.login-wrap {
  width: 100%;
  position: relative;
  display: inline-block;
}
.login-html {
  width: 100%;
  position: absolute;
  text-align: center;
}
.login-html .sign-in-htm,
.login-html .sign-up-htm {
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  position: absolute;
  transform: rotateY(180deg);
  backface-visibility: hidden;
  transition: all 0.4s linear;
}
.login-html .sign-in,
.login-html .sign-up,
.login-form .group .check {
  display: none;
}
.login-html .tab,
.login-form .group .label,
.login-form .group .button {
  text-transform: uppercase;
}
.login-html .tab {
  font-size: 0.9rem;
  margin-right: 20px;
  padding-bottom: 5px;
  margin: 0 15px 10px 0;
  display: inline-block;
  border-bottom: 2px solid transparent;
}
.login-html .sign-in:checked + .tab,
.login-html .sign-up:checked + .tab {
  border-color: #214079;
}
.login-form {
  position: relative;
  perspective: 1000px;
  transform-style: preserve-3d;
}
.login-form .group {
  margin-bottom: 15px;
  text-align: left;
}
.login-form .group.sec2 {
  width: 45%;
  margin: auto 1%;
  margin-bottom: 15px;
  display: inline-block;
}
.login-form .group .input,
.login-form .group .button {
  width: 100%;
  display: block;
}
.login-form .group .input,
.login-form .group .button {
  border: none;
  padding: 8px 8px;
  border-bottom: 1.5px solid #214079;
}
#AuthenticationForm .input.text {
  color: #7a808c;
  font-weight: 550;
  font-size: 0.8rem;
}
#AuthenticationForm .input.text::placeholder {
  font-size: 0.65rem;
  color: #7a808c;
  letter-spacing: 0.07rem;
  font-style: italic;
}
#AuthenticationForm .button.radius {
  border-radius: 25px;
  color: #ffffff;
  font-size: 0.9rem;
}
.login-form .group input[data-type="password"] {
  text-security: circle;
  -webkit-text-security: circle;
}
.login-form .group .label {
  font-size: 11px;
  margin-left: 10px;
}
.login-form .group .button {
  background: #214079;
  font-weight: 650;
}
.login-form .group label .icon {
  width: 15px;
  height: 15px;
  border-radius: 2px;
  position: relative;
  display: inline-block;
  background: rgba(255, 255, 255, 0.2);
}
.login-form .group label .icon:before,
.login-form .group label .icon:after {
  content: "";
  width: 10px;
  height: 2px;
  background: #fff;
  position: absolute;
  transition: all 0.2s ease-in-out 0s;
}
.login-form .group label .icon:before {
  left: 3px;
  width: 5px;
  bottom: 6px;
  transform: scale(0) rotate(0);
}
.login-form .group label .icon:after {
  top: 6px;
  right: 0;
  transform: scale(0) rotate(0);
}
.login-form .group .check + label {
  font-size: 0.7rem;
  font-weight: 500;
  color: #7a808c;
}
.login-form .group .check + label .icon {
  border: 1px solid #7a808c;
}
.login-form .group .check:checked + label .icon {
  background: #214079;
  border: none;
}
.login-form .group .check:checked + label .icon:before {
  transform: scale(1) rotate(45deg);
}
.login-form .group .check:checked + label .icon:after {
  transform: scale(1) rotate(-45deg);
}
.login-html
  .sign-in:checked
  + .tab
  + .sign-up
  + .tab
  + .login-form
  .sign-in-htm {
  transform: rotate(0);
}
.login-html .sign-up:checked + .tab + .login-form .sign-up-htm {
  transform: rotate(0);
}
.form-err {
  font-size: 10px;
  color: #ff3163;
  text-align: center !important;
}
</style>
