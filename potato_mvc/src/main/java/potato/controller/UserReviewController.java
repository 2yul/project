package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.domain.MyReviewDomain;
import potato.service.UserReviewService;
import potato.vo.MyReviewVO;

@Controller
public class UserReviewController {
	
	@Autowired(required = false)
	private UserReviewService urs;
	
///////////////////사용자리뷰조회////////////////////
	
	//사용자리뷰조회
	@RequestMapping(value = "my_review.do", method = {GET,POST})
	public String myReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		////네비바////
		model.addAttribute("img",urs.searchMyImg(mrVO));
		model.addAttribute("nick",urs.searchMyNick(mrVO));
		
		
		//session id에 paramter가 이상한게 들어가서 set 해주는 부분
		mrVO.setId((String)session.getAttribute("id"));//id 넣어주기
		
		
		List<MyReviewDomain> list=urs.searchMyRevAll(mrVO);
		System.out.println("-----리스트----"+list);//리스트조회
		model.addAttribute("mAll",list);
		
		//페이징변수
		int totalData = urs.searchTotalReview(mrVO);
		int lastPage = urs.lastPage(totalData);
		int curPage = mrVO.getPageFlag();
		int startNum = urs.startNum(curPage);
		int isLast = urs.isLast(lastPage, startNum);
		
		//view로 전송
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", urs.searchMyRevAll(mrVO));
		
		return "mypages/jsp/my_review";
	}//myReviewMove
	
	
///////////////////좋아요한리뷰조회////////////////////	
	@RequestMapping(value = "like_review.do", method = {GET,POST})
	public String likeReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		
		mrVO.setId((String)session.getAttribute("id"));//id 넣어주기
		model.addAttribute("lAll",urs.searchLikeRevAll(mrVO));
		
		
		//페이징변수
		int totalData = urs.searchTotalLikedReview(mrVO);
		int lastPage = urs.lastPage(totalData);
		int curPage = mrVO.getPageFlag();
		int startNum = urs.startNum(curPage);
		int isLast = urs.isLast(lastPage, startNum);
				
		//view로 전송
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", urs.searchLikeRevAll(mrVO));
		//model.addAttribute("rIdx",mrVO.getRestarea_idx());
		
		return "mypages/jsp/like_review";
	}//likeReviewMove
	
}//class
