package potato.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrReviewDAO;
import potato.manager.domain.ReviewDomain;
import potato.manager.vo.ReviewVO;
import potato.manager.vo.SearchReviewVO;

@Component
public class ManagerReviewService {

	@Autowired(required = false)
	private MgrReviewDAO mrDAO;

	//게시물 불러오기
	public List<ReviewDomain> searchReview(SearchReviewVO srVO) {
		List<ReviewDomain> list = mrDAO.selectReview(srVO);
		return list;
	}

	//전체 게시물수
	public int searchTotalReview(SearchReviewVO srVO) {
		int cnt = mrDAO.selectTotalReview(srVO);
		return cnt;
	}

	// 마지막페이지수
	public int lastPage(int totalReview) {
		int lastPage = (int) Math.ceil((double) totalReview / 10);
		return lastPage;
	}

	// 현재페이지의 시작번호
	public int startNum(int curPage) {
		int startNum = curPage - (curPage - 1) % 3; // 3페이지씩보여준다
		return startNum;
	}

	// 한 페이지당 보여줄 페이지수, 만약 마지막페이보다 적다면 다시계산
	public int isLast(int lastPage, int startNum) {
		int isLast = 2; // 3페이직 씩 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}

	//ajax 검색어
	public String searchKeywordList(String keyword) {
		if(keyword == null) {
			keyword ="";
		}
		List<String> list = mrDAO.selectKeywordList(keyword);
		JSONObject jobj = new JSONObject();
		JSONArray jArr = new JSONArray();
		
		jobj.put("isData", !list.isEmpty());
		
		JSONObject temp = null;
		for(String name : list) {
			temp = new JSONObject();
			temp.put("keyword", name);
			jArr.add(temp);
		}
		jobj.put("data", jArr);
		return jobj.toJSONString();
	}
	
	//리뷰일괄삭제
	public int removeReviews(String[] reviewChk) {
		int cnt = 0;
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		ReviewVO rVO = null;
		String[] param = new String[3];
		for (String temp : reviewChk) {
			param = temp.split(",");
			rVO = new ReviewVO();
			rVO.setReview_idx(Integer.parseInt(param[0]));
			rVO.setId(param[1]);
			rVO.setRestarea_idx(Integer.parseInt(param[2]));
			list.add(rVO);
		}
		cnt = mrDAO.deleteMultipleReview(list);
		return cnt;
	}
	
	//리뷰상세창
	public ReviewDomain searchReviewDetail(ReviewVO rVO) {
		ReviewDomain rd = mrDAO.selectReviewDetail(rVO);
		return rd;
	}
	
	//리뷰단일삭제
	public int removeReview(ReviewVO rVO) {
		int cnt = mrDAO.deleteReview(rVO);
		return cnt;
	}

}
