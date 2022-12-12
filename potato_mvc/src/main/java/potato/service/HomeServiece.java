package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.HomeDAO;
import potato.domain.UserHomeMapDomain;
import potato.domain.UserHomeSliderDomain;

@Component
public class HomeServiece {
	
	@Autowired(required = false)
	private HomeDAO hDAO;
	
	//슬라이드 휴게소 링크
	//전라남도
	public List<UserHomeSliderDomain> getLink1() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx1();
		return list;
	}//getLink1
	
	//수도권
	public List<UserHomeSliderDomain> getLink2() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx2();
		return list;
	}
	
	//강원도
	public List<UserHomeSliderDomain> getLink3() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx3();
		return list;
	}
	
	//충청북도
	public List<UserHomeSliderDomain> getLink4() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx4();
		return list;
	}
	
	//지도 핀 설정
	public List<UserHomeMapDomain> getMap() {
		List<UserHomeMapDomain> list=null;
		list=hDAO.selectMapPin();
		return list;
	}
	
	//방문자수 집계
	public String getVisiter(String ip) {
		String visitorCnt="";
		if(ip.equals("0:0:0:0:0:0:0:1")) { //localhost ip주소 변환
			ip="127.0.0.1";
		}
		visitorCnt=hDAO.insertVisitor(ip);
		return visitorCnt;
	}
	
}
