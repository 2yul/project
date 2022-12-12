package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import potato.manager.service.ManagerReviewService;
import potato.manager.vo.ReviewVO;
import potato.manager.vo.SearchReviewVO;

@Controller
public class ManagerReviewController {

	@Autowired(required = false)
	private ManagerReviewService mrs;

	/**
	 * 관리자 리뷰관리 페이지 컨트롤러
	 * @param srVO
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "manager_review.do", method = {POST,GET})//최초요청은 get이고 이후 요청은 post로 받기위한 처리
	public String reviewMain(SearchReviewVO srVO, Model model, HttpSession session) {
		String url = "manager/review_management/jsp/manager_review_management";
	
		if(session.getAttribute("manager_id")==null) {
			url="forward:managerlogin_page.do"; 
		}
		 
		
		//검색옵션에 따라 컬럼명을 동적으로 만들기 위한 설정 
		if (srVO.getSearchType() != null && !"".equals(srVO.getSearchType())) {
			if (srVO.getSearchType().equals("1")) {
				srVO.setSearchType("ra.name");
			} else if (srVO.getSearchType().equals("2")) {
				srVO.setSearchType("re.contents");
			} else {
				srVO.setSearchType("re.id");
			}
		}
		
		//페이징변수
		int totalData = mrs.searchTotalReview(srVO);
		int lastPage = mrs.lastPage(totalData);
		int curPage = srVO.getPageFlag();
		int startNum = mrs.startNum(curPage);
		int isLast = mrs.isLast(lastPage, startNum);
		
		//view로 전송
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", mrs.searchReview(srVO));
		
		return url;
	}

	/**
	 * 검색어 검색시 포함단어가있는 리스트를 불러주는 AJAX요청컨트롤러
	 * @param keyword
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "manager_review_ajax.do", method = GET, produces = "application/json;charset=UTF-8")
	public String keywordList(String keyword) {
		String json = "";
		
		json = mrs.searchKeywordList(keyword);
			
		return json;
	}

	/**
	 * 리뷰일괄삭제를 위한 컨트롤러
	 * @param reviewChk
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manager_multipleReviews_delete.do", method = POST)
	public String delReviews(String[] reviewChk, Model model) {
		int cnt = mrs.removeReviews(reviewChk);
		model.addAttribute("mulDelCnt", cnt);
		return "forward:manager_review.do";
	}

	/**
	 * 리뷰상세창을 열기 위한 컨트롤러
	 * @param rVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manager_open_reviewPopup.do", method = POST)
	public String openPopup(ReviewVO rVO, Model model) {
		model.addAttribute("reviewDetail", mrs.searchReviewDetail(rVO));
		model.addAttribute("reviewData", rVO);
		return "manager/review_management/jsp/my_review_popup";
	}

	/**
	 * 단일리뷰삭제를 위한 컨트롤러
	 * @param rVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manager_singleReview_delete.do", method = POST)
	public String delReview(ReviewVO rVO, Model model) {
		int cnt =mrs.removeReview(rVO);
		model.addAttribute("oneDelCnt", cnt);
		return "forward:manager_review.do";
	}
}
