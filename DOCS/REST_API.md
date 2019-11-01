# RUSH-IT : 서두르다 %%.

> #### REST API 정의




## I. 화장실

### 1. GPS 화장실 조회, 키워드 화장실 조회

| Method | URL      | Params                                                       | Role                                   |
| :----: | -------- | ------------------------------------------------------------ | -------------------------------------- |
|  GET   | /toilet/ | user : {x, y}<br />map: { <br />    southWest : {x, y},<br />    northEast : {x,y}<br />} <br/>keyword : 키워드(예. 강남구) | map범위 내에 있는 전체 화장실 목록조회 |

|     Key     | Value                                                        |
| :---------: | ------------------------------------------------------------ |
|     id      | 아이디                                                       |
|    name     | 이름                                                         |
|    type     | 0 : 공공화장실<br />1 : 지하철<br />2 : 프랜차이즈 카페<br />3 : 페스트푸드 |
|   address   | 주소                                                         |
|  location   | 좌표<br />{x : location_x, y : location_y}                   |
| handicapped | 장애인 화장실 유무 (1 : true / 0 : false)                    |
|   diaper    | 기저귀 교환대 유무                                           |
|    bell     | 비상벨 설치 유무                                             |



### 2. 화장실 상세 정보 조회 - 1

- `toilet_id` : 화장실 아이디

| Method | URL                  | Role                  |
| :----: | -------------------- | --------------------- |
|  GET   | /toilet/{toilet_id}/ | 화장실 상세 정보 조회 |

|    Key    | Value     |
| :-------: | --------- |
|    id     | 아이디    |
|   like    | 좋아요 수 |
|  dislike  | 싫어요 수 |
|   score   | 전체 평점 |
| telephone | 전화번호  |
|   time    | 개방 시간 |
|   state   | 지역구    |

>```json
>// reviews 구성
>reviews : [
>  {
>    score : 4,
>    review : "최고의 화장실!"
>  },
>  {
>    score : 3,
>    review : "보통"
>  }]
>```



### 3. 화장실 상세 정보 조회 - 2

- `toilet_id` : 화장실 아이디
- `user_id` : 유저 아이디

| Method | URL                  |Params| Role                  |
| :----: | -------------------- |------| --------------------- |
|  GET   | /toilet/{toilet_id}/ |user_id| 화장실 상세 정보 조회 |

|   Key   | Value                                                        |
| :-----: | ------------------------------------------------------------ |
| isLike  | 해당 유저가 좋아요 했는지 여부<br />0 : 유저가 없거나, 평가를 안했을 경우<br />1 : 유저가 이전에 좋아요한 경우<br />-1 : 유저가 싫어요한 경우 |





## II. 회원정보

### 1. 회원가입 / 로그인

- 회원가입 완료 시, 자동로그인

| Method | URL    | Params               | Role     |
| :----: | ------ | -------------------- | -------- |
|  POST  | /user/ | id, nick, pw, gender | 회원가입 |

| Key  | Value  |
| :--: | ------ |
|  id  | 아이디 |
| nick | 닉네임 |



### 2. 로그인


| Method | URL          | Params                  | Role      |
| :----: | ------------ | ----------------------- | --------- |
|  POST  | /user/{id}/ | pw                  | 로그인      |

| Key  | Value  |
| :--: | ------ |
|  id  | 아이디 |
| nick | 닉네임 |



### 3. 회원정보 수정

- 닉네임 수정

| Method | URL         | Params              | Role      |
| :----: | ----------- | ------------------- | --------- |
|  PUT   | /user/{id}/ | nick(변경할 닉네임) | 정보 수정 |

| Key  | Value  |
| :--: | ------ |
|  id  | 아이디 |
| nick | 닉네임 |



## III. 평점

### 1. 평점 CRUD

| Method | URL      | Params                                                       | Role      |
| :----: | -------- | ------------------------------------------------------------ | --------- |
|  POST  | /review/ | score : 평점<br />review : 리뷰<br />user_id : 유저 아이디<br />toilet_id : 화장실 아이디 | 평점 등록 |
|  PUT   | /review/ | score : 평점<br />review : 리뷰<br />user_id : 유저 아이디<br />toilet_id : 화장실 아이디 | 평점 수정 |
| DELETE | /review/ | user_id : 유저 아이디<br />toilet_id : 화장실 아이디         | 평점 삭제 |



### 2. 리뷰 조회 - User Detail

> time을 기준으로 최신 순으로 정렬 후 반환

| Method | URL      | Params                    | Role                 |
| :----: | -------- | ------------------------- | -------------------- |
|  GET   | /review/ | user_id : 유저 아이디     | 사용자ID로 평점 조회 |

| Key  | Value  |
| :--: | ------ |
|  toilet_id  | 화장실 ID |
| toilet_name | 화장실 이름|
| score | 평점 |
| review| 리뷰|
|time| 리뷰 작성 시간|

```json
{ "reviews" : [
	{
		"toilet_id" : "화장실 ID",
		"toilet_name" : "화장실 이름",
		"score" : "평점",
		"review" : "리뷰",
		"time" : "리뷰 작성 시간"
	}, 
    {
		"toilet_id" : "화장실 ID",
		"score" : "평점",
		"review" : "리뷰",
		"time" : "리뷰 작성 시간"
	}, 
]}
```



### 3. 리뷰 조회 - Toilet Detail

> time을 기준으로 최신 순으로 정렬 후 반환

| Method | URL      | Params                    | Role                 |
| :----: | -------- | ------------------------- | -------------------- |
|  GET   | /review/ | toilet_id : 화장실 아이디 | 화장실ID로 평점 조회 |

| Key  | Value  |
| :--: | ------ |
|  toilet_id  | 화장실 ID |
| toilet_name | 화장실 이름|
| score | 평점 |
| review| 리뷰|
|time| 리뷰 작성 시간|

```json
{ "reviews" : [
	{
		"toilet_id" : "화장실 ID",
		"toilet_name" : "화장실 이름",
		"score" : "평점",
		"review" : "리뷰",
		"time" : "리뷰 작성 시간"
	}, 
    {
		"toilet_id" : "화장실 ID",
		"score" : "평점",
		"review" : "리뷰",
		"time" : "리뷰 작성 시간"
	}, 
]}
```



## IV. 좋아요/싫어요

| Method | URL    | Params                                                       | Role                |
| :----: | ------ | ------------------------------------------------------------ | ------------------- |
|  POST  | /like/ | user_id : 유저 아이디<br />toilet_id : 화장실 아이디<br />state : 1(좋아요) \|\| -1(싫어요) | 좋아요/싫어요       |
| DELETE | /like/ | user_id : 유저 아이디<br />toilet_id : 화장실 아이디         | 좋아요, 싫어요 삭제 |





# Response Code

> 응답 코드

| Code      | Value                                 |
| --------- | ------------------------------------- |
| **200~** | **성공**                              |
| 200       | Good Response                         |
| **300~** | **DB 관련 Response**                  |
| 300       | DB에 이미 존재할 때                   |
| 301       | DB에 없을 때                          |
| **400~** | **요청 관련 Response**                |
| 400       | 파라메터 개수가 많을 때               |
| 401       | 파라메터 개수가 적을 때               |
| 402       | 정의되지 않은 파라메터 가 들어왔을 때 |

```json
{ "code" : 200 }
```

