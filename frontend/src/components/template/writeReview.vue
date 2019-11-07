<template>
  <b-row id="writeReview">
    <div class="login-wrap">
      <div class="login-html">
        <label for="tab-1" class="tab">Review</label>
        <b-row class="justify-content-md-center">
          <b-col cols="3" align-self="center">평점</b-col>
          <b-col cols="3" align-self="center">
            <input
              id="number"
              type="number"
              class="score_input"
              placeholder="평점"
              v-model="review_score"
            />
          </b-col>
        </b-row>
        <b-row class="review-form">
          <textarea
            id="review"
            type="text"
            class="review_txt"
            placeholder="리뷰를 작성하세요."
            v-model="review_txt"
          />
        </b-row>
        <b-row>
          <b-col>
            <input
              align-self="center"
              type="submit"
              class="review_submit"
              value="작성"
              @click="writeReview"
            />
          </b-col>
        </b-row>
      </div>
    </div>
  </b-row>
</template>

<script>
import qs from "qs";
import axios from "axios";
import { mapState } from "vuex";

export default {
  props: {
    toilet_id: { type: String }
  },
  data() {
    return {
      review_txt: "",
      review_score: ""
    };
  },
  computed: {
    ...mapState({
      userID: state => state.authentication.userID,
    })
  },
  methods: {
    writeReview() {
      if (this.review_txt && this.review_score) {
        const url = "http://localhost:8080";
        let data = {
          score : this.review_score,
          review : this.review_txt,
          user_id : this.userID,
          toilet_id : this.toilet_id
        };
        let options = {
          method: "POST",
          data: qs.stringify(data),
          url: url + "/review/"
        };
        axios(options)
          .then(response => {
            console.log(response.data)
            //작성완료
            this.$store.commit("setIsReview", false);
          })
          .catch(error => {
            console.log(error)
          });
      }
    }
  }
};
</script>
<style>
#writeReview {
  z-index: 90;
  position: fixed;
  bottom: 2rem;
  left: 0;
  width: 100%;
  min-height: 250px;
  border-radius: 30px 30px 0 0;
  box-shadow: 0 1px 15px rgba(0, 0, 0, 0.1);
  padding: 1.5rem 1.5rem;
  margin: 0;
  text-align: left;
  color: #ffffff;
  font-weight: 650;
  background-color: #214079;
}
#writeReview .review_txt {
  width: 100%;
  border-radius: 10px;
  padding: 10px;
  margin-top: 10px;
}
#writeReview .score_input {
  width: 100%;
  border-radius: 3px;
  border: 0;
  padding: 1px 3px;
  text-align: center;
}
#writeReview .review_submit {
  width: 30%;
  margin: 20px 0;
  padding: 3px;
  border: 2px solid #ffffff;
  background-color: #214079;
  border-radius: 20px;
  color: #ffffff;
  font-weight: 600;
  text-align: center;
}
#writeReview .review_submit:hover {
  background-color: #ffffff;
  color: #214079;
}
</style>
