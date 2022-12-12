package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.UserReviewDAO;
import potato.domain.MyReviewDomain;
import potato.vo.MyReviewVO;

@Component
public class UserReviewService {
	
	@Autowired(required = false)
	private UserReviewDAO urDAO;
	
///////////////////네비바////////////////////	
	//사용자이미지
	public String searchMyImg(MyReviewVO mrVO){
		String  img = urDAO.selMyImg(mrVO);
		return img;
	}
	//사용자닉
	public String searchMyNick(MyReviewVO mrVO){
		String  nick = urDAO.selMyNick(mrVO);
		return nick;
	}
///////////////////사용자리뷰조회////////////////////	
	//My리뷰조회
	public List<MyReviewDomain> searchMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> mlist = urDAO.selMyRevAll(mrVO);
		return mlist;
	}

///////////////////좋아요한리뷰조회////////////////////
	//Like리뷰조회
	public List<MyReviewDomain> searchLikeRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> llist = urDAO.selLikeRevAll(mrVO);
		return llist;
	}

///////////////////페이징////////////////////		
	
	//내가쓴 리뷰 전체 게시물수
	public int searchTotalReview(MyReviewVO mrVO) {
		int cnt = urDAO.selTotalReview(mrVO);
		return cnt;
	}
	
	//내가 좋아요한 리뷰 전체 게시물수
	public int searchTotalLikedReview(MyReviewVO mrVO) {
		int cnt = urDAO.selTotalLikedReview(mrVO);
		return cnt;
	}
	

	// 마지막페이지수
	public int lastPage(int totalReview) {
		int lastPage = (int) Math.ceil((double) totalReview / 5);
		return lastPage;
	}

	// 현재페이지의 시작번호
	public int startNum(int curPage) {
		int startNum = curPage - (curPage - 1) % 3; // 3페이지씩보여준다
		return startNum;
	}

	// 한 페이지당 보여줄 페이지 수, 마지막 페이지보다 적다면 다시 계산
	public int isLast(int lastPage, int startNum) {
		int isLast = 2; // 3페이직 씩 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		
		return isLast;
	}
}//class
