package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import potato.service.DetailedService;
import potato.vo.DetailedBookmarkVO;
import potato.vo.DetailedLikeVO;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;

@Controller
public class DetailedController {
	
	@Autowired(required = false)
	private DetailedService ds;

	//휴게소 상세창 접속
	@RequestMapping(value = "user_detailed.do", method={GET,POST})
	public String userDetailedMove(Integer restarea_idx, Model model, HttpSession session, HttpServletRequest request) {
		 
		model.addAttribute("rd", ds.getRestDetailed(restarea_idx));
		model.addAttribute("bt", ds.getBookmarkTotal(restarea_idx));
		model.addAttribute("rt", ds.getRateTotal(restarea_idx));
		model.addAttribute("fd", ds.getFoodDatailed(restarea_idx));
		model.addAttribute("ai", ds.getAmenityImg(restarea_idx));
		model.addAttribute("rt", ds.getReviewTotal(restarea_idx));
		model.addAttribute("lp", ds.getLastPageNum(ds.getReviewTotal(restarea_idx)));
		model.addAttribute("rs", ds.getReviewSum(restarea_idx));
		
		DetailedBookmarkVO dbVO=new DetailedBookmarkVO();
		
		/* session.setAttribute("id", "coffee"); */
		
		String id=(String) session.getAttribute("id");
		if(id!=null) {
			dbVO.setId(id);
			dbVO.setRestarea_idx(restarea_idx);
			model.addAttribute("bc", ds.getBookmarkChk(dbVO));
		}else {
			model.addAttribute("bc", 0);
		}
		
		return "detailed/jsp/user_detailed";
	}
	
	//휴게소 즐겨찾기 추가(비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_bookmarkAdd.do", method= {GET,POST})
	public String enterBookMark(HttpSession session, int restarea_idx) {
		DetailedBookmarkVO dbVO=new DetailedBookmarkVO();
		String id=(String) session.getAttribute("id");
		dbVO.setId(id);
		dbVO.setRestarea_idx(restarea_idx);
		String jsonObj=ds.setBookmarkAdd(dbVO);
		return jsonObj;
	}
	
	//휴게소 즐겨찾기 삭제(비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_bookmarkDel.do", method= {GET,POST})
	public String cancelBookMark(HttpSession session, int restarea_idx) {
		DetailedBookmarkVO dbVO=new DetailedBookmarkVO();
		String id=(String) session.getAttribute("id");
		dbVO.setId(id);
		dbVO.setRestarea_idx(restarea_idx);
		String jsonObj=ds.setBookmarkDel(dbVO);
		return jsonObj;
	}

	//리뷰작성창 접속
	@RequestMapping(value = "write.do", method=GET)
	public String writePageMove(HttpSession session, int restarea_idx, Model model) {
			String url="detailed/jsp/write";
		
		if(session.getAttribute("id")==null) {
			url="forward:user_mainhome.do"; 
			}
		model.addAttribute("mrw", ds.moveReviewWrite(restarea_idx));
		return url;
	}
	
	//리뷰수정창 접속
	@RequestMapping(value = "rewrite.do", method= {GET,POST})
	public String rewritePageMove(HttpSession session, DetailedReviewVO drVO, Model model) {
		String url="detailed/jsp/re_write";
		
		if(session.getAttribute("id")==null) {
			url="forward:user_mainhome.do"; 
			}
		
		model.addAttribute("mrw", ds.moveReReviewWrite(drVO));
		model.addAttribute("mri", ds.moveReReviewImg(drVO));
		return url;
	}
	
	//휴게소 리뷰 + 버튼 페이징 (비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_page.do", method= {GET,POST}, produces = "application/json;charset=UTF-8")
	public String reviewPageFilter(HttpServletRequest request, DetailedReviewVO drVO) {
		String jsonObj=ds.getReviewAll(drVO);
		return jsonObj;
	}
	
	//리뷰 좋아요 추가(비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_likeAdd.do", method= {GET,POST})
	public String enterLike(HttpSession session, DetailedLikeVO dlVO) {
		String jsonObj=ds.getLikeAdd(dlVO);
		return jsonObj;
	}

	//리뷰 좋아요 삭제(비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_likeDel.do", method= {GET,POST})
	public String cancelLike(HttpSession session, DetailedLikeVO dlVO) {
		String jsonObj=ds.getLikeDel(dlVO);
		return jsonObj;
	}
	
	//리뷰 신고창 오픈
	@RequestMapping(value = "report_review_popup.do", method= {GET,POST})
	public String reportPopup(HttpServletRequest request, DetailedReportVO drVO, Model model) {
		model.addAttribute("rp", ds.getReportPopup());
		
		drVO.setId_reporter(request.getParameter("id"));
		drVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		drVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
		
		model.addAttribute("rpc", ds.setReportPopupChk(drVO));
		return "detailed/jsp/report_review_popup";
	}
	
	//리뷰 신고 접수
	@RequestMapping(value = "detailed_report.do", method= {GET,POST})
	public String setReport(HttpServletRequest request, DetailedReportVO drVO, Model model) {
		ds.setReportPopup(drVO);
		
		drVO.setId_reporter(request.getParameter("id_reporter"));
		drVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		drVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
		
		model.addAttribute("rpc", ds.setReportPopupChk(drVO));
		
		return "detailed/jsp/report_review_popup";
	}
	
	////리뷰 삭제
	@ResponseBody
	@RequestMapping(value = "detailed_review_delete.do", method= {GET,POST})
	public String deleteReview(DetailedReviewVO drVO) {
		String jsonObj=ds.getReviewDel(drVO);
		return jsonObj;
	}
	
	
}
