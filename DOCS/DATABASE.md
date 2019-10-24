## Database 구조

#### user

> 사용자 정보를 담은 테이블

| Field  | Type        | Null | Key  | Default | Comment                          |
| ------ | ----------- | ---- | ---- | ------- | -------------------------------- |
| id     | VARCHAR(45) | No   | PRI  |         | 아이디                           |
| pw     | VARCHAR(45) | No   |      |         | 비밀번호                         |
| nick   | VARCHAR(45) | No   |      |         | 닉네임                           |
| gender | VARCHAR(2)  | No   |      | F       | 성별<br/>F - Female<br/>M - Male |



#### toilet

> 화장실 정보를 담은 테이블

| Field       | Type         | Null | Key  | Default | Comment                                                      |
| ----------- | ------------ | ---- | ---- | ------- | ------------------------------------------------------------ |
| id          | VARCHAR(45)  | No   | PRI  |         | ID                                                           |
| name        | VARCHAR(45)  | No   |      |         | 콘텐츠명                                                     |
| location_x  | DOUBLE       | No   |      |         | 좌표(X)                                                      |
| location_y  | DOUBLE       | No   |      |         | 좌표(Y)                                                      |
| state       | VARCHAR(20)  | No   |      |         | 지역구                                                       |
| address     | VARCHAR(100) | No   |      |         | 도로명 주소                                                  |
| type        | INT          | No   |      |         | 화장실 타입 <br/>0 : 공공화장실 <br/>1 : 지하철<br/>2 : 프랜차이즈 카페<br/>3 : 패스트푸드점 |
| telephone   | VARCHAR(45)  |      |      |         | 전화번호                                                     |
| time        | VARCHAR(45)  |      |      |         | 개방 시간                                                    |
| handicapped | TINYINT      |      |      | 0       | 장애인 화장실 유무 (T/F)                                     |
| diaper      | TINYINT      |      |      | 0       | 기저귀교환대 유무 (T/F)                                      |
| bell        | TINYINT      |      |      | 0       | 비상벨 유무 (T/F)                                            |



#### like

> 사용자가 화장실에 대해서 좋아요, 싫어요 한 정보를 담은 테이블

| Field     | Type        | Null | Key  | Default | Comment                   |
| --------- | ----------- | ---- | ---- | ------- | ------------------------- |
| toilet_id | VARCHAR(45) | No   | PRI  |         | FOREIGN KEY (TOILET)      |
| user_id   | VARCHAR(45) | No   | PRI  |         | FOREIGN KEY (USER)        |
| like      | TINYINT     | No   |      | 1       | 0 : 싫어요<br/>1 : 좋아요 |



#### review

> 사용자가 화장실 사용 후, 리뷰를 남기는 테이블
>
> ※ 한 명의 사용자가 여러 개의 리뷰를 남기는 것이 가능하다.

| Field     | Type         | Null | Key  | Default | Comment                        |
| --------- | ------------ | ---- | ---- | ------- | ------------------------------ |
| id        | INT          | No   | PRI  |         | Auto-increment                 |
| toilet_id | VARCHAR(45)  | No   |      |         | FOREIGN KEY (TOILET)           |
| user_id   | VARCHAR(45)  | No   |      |         | FOREIGN KEY (USER)             |
| review    | VARCHAR(200) | No   |      |         | 리뷰                           |
| rating    | DOUBLE       | No   |      | 0       | 평점 (0 ~ 5) <br/>[단위 : 0.5] |
| timestamp | DATE         | No   |      |         | 작성 시간                      |



### EER Diagram

<p align="center">
<img src = "https://i.ibb.co/wgMfLYF/rushit-diagram.png">
</p>

