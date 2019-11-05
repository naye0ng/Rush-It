package com.rushit.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rushit.model.service.FavService;
import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.Review;
import com.rushit.model.vo.Toilet;

@CrossOrigin(origins= {"*"})
@RestController
public class ToiletController {
	private ToiletService ts;
	private ReviewService rs;
	private UserService us;
	private FavService fs;

	@Autowired
	public void setTs(ToiletService ts) {
		this.ts = ts;
	}
	
	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}

	@Autowired
	public void setLs(FavService fs) {
		this.fs = fs;
	}


	
	@PostMapping("/toilet")
	public ResponseEntity<HashMap<String, Object>> findToilets(@RequestBody String json) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map= new HashMap<String, Object>();
		map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		Set<String> set= map.keySet();
		
		Map<String, Object> user = (Map<String, Object>) map.get("user");
		Double user_x=(Double) user.get("x");
		Double user_y=(Double) user.get("y");

		Map<String, Object> maps = (Map<String, Object>) map.get("map");
		System.out.println(maps.get("southWest"));
		System.out.println(maps.get("northEast"));
		Map<String, Object> southWest = (Map<String, Object>) maps.get("southWest");
		Map<String, Object> northEast = (Map<String, Object>) maps.get("northEast");
		Double sw_x= (Double) southWest.get("x");
		System.out.println(sw_x);
		Double sw_y= (Double) southWest.get("y");
		System.out.println(sw_y);
		Double ne_x=(Double) northEast.get("x");
		System.out.println(ne_x);
		Double ne_y=(Double) northEast.get("y");
		System.out.println(ne_y);
		
		String keyword = (String) map.get("keyword");
		System.out.println(keyword);
		

	
		//input을 hash로 변환해서 넣어준다.
		HashMap<String, Object> input = new HashMap<>();
		input.put("sw_x", sw_x);
		input.put("sw_y", sw_y);
		input.put("ne_x", ne_x);
		input.put("ne_y", ne_y);
		input.put("keyword", keyword);
		List<Toilet> list=ts.selectToiletList(input);
		System.out.println(list.toString());
		//return 해주기 위한 hash
		HashMap<String, Object> hash= new HashMap<>();
		//toilet들의 정보를 담는 list
		ArrayList<HashMap<String, String>> value= new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			//toilet 하나의 정보에 대한 hashmap
			HashMap<String, String> ret= new HashMap<>();
			Toilet t=list.get(i);
			ret.put("id", t.getId());
			ret.put("name", t.getName());
			ret.put("type", t.getType()+"");
			ret.put("address", t.getAddress());
			ret.put("location_x", t.getLocation_x());
			ret.put("location_y", t.getLocation_y());
			if(t.isHandicapped())ret.put("handicapped", "1");
			else ret.put("handicapped", "0");
			if(t.isDiaper())ret.put("diaper", "1");
			else ret.put("diaper", "0");
			if(t.isBell())ret.put("bell", "1");
			else ret.put("bell", "0");
			value.add(ret);
		}
		hash.put("toiletList", value);
		hash.put("code", 200);
		return new ResponseEntity<HashMap<String, Object>>(hash, HttpStatus.OK);
	}
	
	
	@GetMapping("/toilet/{toilet_id}")
	public HashMap<String, Object> toiletDetail(@PathVariable String toilet_id){
		HashMap<String, Object> ret= new HashMap<>();
		if(ts.selectToilet(toilet_id)==null) {
			ret.put("code", "301");
			return ret;
		}
		List<Review> reviewList=(ArrayList<Review>)rs.selectReviewListByToilet(toilet_id);
		double reviewTotal=0;
		for(int i=0; i<reviewList.size(); i++) {
			reviewTotal+=reviewList.get(i).getRating();
		}
		reviewTotal/=reviewList.size();
		reviewTotal=Math.round((reviewTotal*10))/10.0;
		
		Toilet t=ts.selectToilet(toilet_id);
		int likeCount=fs.toiletFavCnt(toilet_id);
		int dislikeCount=fs.toiletNotFavCnt(toilet_id);
		ret.put("id", t.getId());
		ret.put("like", likeCount+"");
		ret.put("dislike", dislikeCount+"");
		ret.put("score", reviewTotal+"");
		ret.put("telephone", t.getTelephone());
		ret.put("time", t.getTime());
		ret.put("state", t.getState());
		ret.put("code", "200");
		ArrayList<HashMap<String, String>> input= new ArrayList<>();
		HashMap<String, String> h;
		for(int i=0; i<reviewList.size(); i++) {
			h= new HashMap<>();
			h.put("score", reviewList.get(i).getRating()+"");
			h.put("review", reviewList.get(i).getRating()+"");
			input.add(h);
		}
		ret.put("reviews", input);
		return ret;
	}
	
	
	
	@GetMapping("toilet/{toilet_id}/{user_id}")
	public HashMap<String, Object> toiletDetail(@PathVariable String toilet_id, @PathVariable String user_id) {
		HashMap<String, Object> ret= new HashMap<String,Object>();
		//map 형태로 loveService의 인자값에 넘겨준다.
		if(ts.selectToilet(toilet_id)==null || us.checkUser(user_id)==null) {
			ret.put("code", "301");
			return ret;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("toilet_id", toilet_id);
		map.put("user_id", user_id);
		//해당 유저가 좋아요 했는지 여부
		int userLove=0;
		//review를  먼저 갔다와서 평가 했는지 안했는지 여부를 먼저 확인한다.
		if(fs.selectFav(map)==null) userLove=0; 
		else if(fs.selectIsFav(map))userLove=1;
		else if(!fs.selectIsFav(map))userLove=-1;
		//전체 좋아요 갯수
		int likeCount=fs.toiletFavCnt(toilet_id);
		//전체 싫어요 갯수
		int dislikeCount=fs.toiletNotFavCnt(toilet_id);
		//리뷰 리스트
		ArrayList<Review> reviewList= (ArrayList<Review>) rs.selectReviewListByToilet(toilet_id);
		double reviewTotal=0;
		for(int i=0; i<reviewList.size(); i++) {
			reviewTotal+=reviewList.get(i).getRating();
		}
		reviewTotal/=reviewList.size();
		reviewTotal=Math.round((reviewTotal*10))/10.0;
		//telephone, handicapped, state, time을 toilet_id로 조회
		Toilet t=ts.selectToilet(toilet_id);
		
		//hashmap을 사용하여 key,value로 값으로 front에 전달한다.
		ret.put("toilet_id", toilet_id);
		ret.put("likeCount", likeCount);
		ret.put("dislikeCount", dislikeCount);
		ret.put("reviewList", reviewList);
		ret.put("reviewTotal", reviewTotal);
		ret.put("userLove", userLove);
		ret.put("telephone", t.getTelephone());
		ret.put("handicapped", t.isHandicapped());
		ret.put("state", t.getState());
		ret.put("time", t.getTime());
		ret.put("code", "200");
		return ret;
	}
		
}

