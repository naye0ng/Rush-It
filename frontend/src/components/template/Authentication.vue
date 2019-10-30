<template>
  <b-row id="AuthenticationForm" class="show-up">    
    <div class="login-wrap">
	    <div class="login-html">
		    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		    <div class="login-form">
                <div class="sign-in-htm">
                    <div class="group">
                        <input id="user" type="text" class="input text" placeholder="아이디를 입력하세요.">
                    </div>
                    <div class="group">
                        <input id="pass" type="password" class="input text" data-type="password" placeholder="비밀벝호를 입력하세요.">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <input type="submit" class="button radius" value="Sign In">
                    </div>
                </div>
                <div class="sign-up-htm">
                    <div class="group">
                        <input id="user" type="text" class="input text" placeholder="아이디를 입력하세요.">
                    </div>
                    <div class="group">
                        <input id="user" type="text" class="input text" placeholder="닉네임을 입력하세요.">
                    </div>
                    <div class="group">
                        <input id="pass" type="password" class="input text" data-type="password" placeholder="비밀번호를 입력하세요.">
                    </div>
                    <div class="group">
                        <input id="pass" type="password" class="input text" data-type="password" placeholder="비밀번호 확인">
                    </div>
                    <div class="group">
                        <input type="submit" class="button radius" value="Sign Up">
                    </div>
                </div>
			</div>
	    </div>
    </div>

  </b-row>
</template>

<script>
export default {
  data() {
    return {
    }
  }
};
</script>
<style>
#AuthenticationForm{
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
    text-align:left;
    color: #214079;
    font-weight: 650;
    background-color: #ffffff;
}
.login-wrap{
	width:100%;
    position:relative;
    display: inline-block;
}
.login-html{
	width:100%;
    position:absolute;
    text-align:center;
}
.login-html .sign-in-htm,
.login-html .sign-up-htm{
	top:0;
	left:0;
	right:0;
	bottom:0;
	position:absolute;
	transform:rotateY(180deg);
	backface-visibility:hidden;
    transition:all .4s linear;
}
.login-html .sign-in,
.login-html .sign-up,
.login-form .group .check{
	display:none;
}
.login-html .tab,
.login-form .group .label,
.login-form .group .button{
	text-transform:uppercase;
}
.login-html .tab{
	font-size: 0.9rem;
	margin-right:20px;
	padding-bottom:5px;
	margin:0 15px 10px 0;
	display:inline-block;
	border-bottom:2px solid transparent;
}
.login-html .sign-in:checked + .tab,
.login-html .sign-up:checked + .tab{
	border-color:#214079;
}
.login-form{
	position:relative;
	perspective:1000px;
	transform-style:preserve-3d;
}
.login-form .group{
    margin-bottom:15px;
    text-align: left;
}
.login-form .group .input,
.login-form .group .button{
	width:100%;
	display:block;
}
.login-form .group .input,
.login-form .group .button{
	border:none;
    padding:8px 8px;
	border-bottom: 1.5px solid #214079;
}
#AuthenticationForm .input.text{
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
#AuthenticationForm .button.radius{
    border-radius: 25px;
    color: #ffffff;
    font-size: 0.9rem;
}
.login-form .group input[data-type="password"]{
	text-security:circle;
	-webkit-text-security:circle;
}
.login-form .group .label{
    font-size:11px;
    margin-left: 10px;
}
.login-form .group .button{
    background:#214079;
    font-weight: 650;
}
.login-form .group label .icon{
	width:15px;
	height:15px;
	border-radius:2px;
	position:relative;
	display:inline-block;
	background:rgba(255,255,255,.2);
}
.login-form .group label .icon:before,
.login-form .group label .icon:after{
	content:'';
	width:10px;
	height:2px;
	background:#fff;
	position:absolute;
	transition:all .2s ease-in-out 0s;
}
.login-form .group label .icon:before{
	left:3px;
	width:5px;
	bottom:6px;
	transform:scale(0) rotate(0);
}
.login-form .group label .icon:after{
	top:6px;
	right:0;
  transform:scale(0) rotate(0);
}
.login-form .group .check:checked + label{
  font-size: 0.7rem;
  font-weight: 500;
  color: #7a808c;
}
.login-form .group .check:checked + label .icon{
  background:#214079;
}
.login-form .group .check:checked + label .icon:before{
	transform:scale(1) rotate(45deg);
}
.login-form .group .check:checked + label .icon:after{
	transform:scale(1) rotate(-45deg);
}
.login-html .sign-in:checked + .tab + .sign-up + .tab + .login-form .sign-in-htm{
	transform:rotate(0);
}
.login-html .sign-up:checked + .tab + .login-form .sign-up-htm{
  transform:rotate(0);
}
</style>
