package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.MyReviewDomain;
import potato.vo.MyReviewVO;

@Component
public class UserReviewDAO {
///////////////////네비바////////////////////
	public String selMyImg(MyReviewVO mrVO) {
		String myImg = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		myImg = ss.selectOne("potato.userReview.selMyImg", mrVO);
		mbh.closeHandler(ss);
		return myImg;
	}//selMyImg
	public String selMyNick(MyReviewVO mrVO) {
		String myNick = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		myNick = ss.selectOne("potato.userReview.selMyNick", mrVO);
		mbh.closeHandler(ss);
		return myNick;
	}//selMyNick
	
///////////////////사용자리뷰조회////////////////////
	public List<MyReviewDomain> selMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> mlist=null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler(); 
		
		mlist = ss.selectList("potato.userReview.selMyRevAll", mrVO);
		mbh.closeHandler(ss);
		return mlist;		
	}//selMyRevAll
	
///////////////////좋아요한리뷰조회////////////////////	
	public List<MyReviewDomain> selLikeRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> llist=null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler(); 
		llist = ss.selectList("potato.userReview.selLikeRevAll", mrVO);
		mbh.closeHandler(ss);
		return llist;		
	}//selLikeRevAll
	
///////////////////페이징////////////////////		
	//총 리뷰 수
	public int selTotalReview(MyReviewVO mrVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.selectOne("potato.userReview.selTotalReview", mrVO);
		return cnt;
	}//selTotalReview
	
	//내가 좋아요한 총 리뷰수
	public int selTotalLikedReview(MyReviewVO mrVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.selectOne("potato.userReview.selTotalLikedReview", mrVO);
		return cnt;
	}

}//class
