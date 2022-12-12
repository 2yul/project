package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.DetailedAmenityDomain;
import potato.domain.DetailedDomain;
import potato.domain.DetailedFoodDomain;
import potato.domain.DetailedReportDomain;
import potato.domain.DetailedReviewDomain;
import potato.domain.WriteReviewDomain;
import potato.vo.DetailedBookmarkVO;
import potato.vo.DetailedLikeVO;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;
import potato.vo.WriteReviewImgVO;

@Component
public class DetailedDAO {
	
	//<휴게소 상세창>
	//휴게소 상세창 정보 불러오기
	public DetailedDomain selectRestDetailed(Integer restarea_idx) {
		DetailedDomain dd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dd=ss.selectOne("potato.detailedMapper.selRestDetailed",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dd;
	}
	
	//휴게소 북마크 total
	public int selectBookmarkTotal(int restarea_idx) {
		int booktotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		booktotal=ss.selectOne("potato.detailedMapper.selBookmarkToTal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return booktotal;
	}
	
	//휴게소 북마크 여부
	public int selectBookmarkChk(DetailedBookmarkVO dbVO) {
		int bookmarkChk=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		bookmarkChk=ss.selectOne("potato.detailedMapper.selBookmarkChk",dbVO);
		
		mbh.closeHandler(ss);
		
		return bookmarkChk;
	}
	
	//휴게소 북마크 추가
	public String insertBookmarkAdd(DetailedBookmarkVO dbVO) {
		String bookmarkAdd="";
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		bookmarkAdd=ss.selectOne("potato.detailedMapper.insBookmarkAdd",dbVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return bookmarkAdd;
	}
	
	//휴게소 북마크 해제
	public String deleteBookmarkDel(DetailedBookmarkVO dbVO) {
		String bookmarkDel=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		bookmarkDel=ss.selectOne("potato.detailedMapper.delBookmarkDel",dbVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return bookmarkDel;
	}
	
	//휴게소 별점 total
	public int selectRateTotal(int restarea_idx) {
		int startotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		startotal=ss.selectOne("potato.detailedMapper.selRateTotal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return startotal;
	}
	
	//휴게소 음식 정보
	public List<DetailedFoodDomain> selectFoodDatailed(int restarea_idx) {
		List<DetailedFoodDomain> dfd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dfd=ss.selectList("potato.detailedMapper.selFoodDatailed",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dfd;
	}
	
	//휴게소 편의시설아이콘
	public List<DetailedAmenityDomain> selectAmenityImg(int restarea_idx) {
		List<DetailedAmenityDomain> dad=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dad=ss.selectList("potato.detailedMapper.selAmenityImg",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dad;
	}
	
	//<휴게소 리뷰>
	//리뷰 작성창 이동
	public DetailedReviewDomain selectReviewWrite(int restarea_idx) {
		DetailedReviewDomain drd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		drd=ss.selectOne("potato.detailedMapper.selReviewWrite",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return drd;
	}
	
	//리뷰 수정창 이동
	public DetailedReviewDomain selectReReviewWrite(DetailedReviewVO drVO) {
		DetailedReviewDomain drd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		drd=ss.selectOne("potato.detailedMapper.selReReviewWrite",drVO);
		
		mbh.closeHandler(ss);
		
		return drd;
	}
	
	//리뷰 수정 이미지 불러오기
	public List<WriteReviewDomain> selectReReviewImg(DetailedReviewVO drVO) {
		List<WriteReviewDomain> wrd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		wrd=ss.selectList("potato.detailedMapper.selReReviewImg",drVO);
		
		mbh.closeHandler(ss);
		
		return wrd;
	}
	
	//리뷰 총 total
	public int selectReviewTotal(int restarea_idx) {
		int reviewtotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		reviewtotal=ss.selectOne("potato.detailedMapper.selReviewTotal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return reviewtotal;
	}
	
	//리뷰 총 total
	public int selectReviewSum(int restarea_idx) {
		int reviewSum=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		reviewSum=ss.selectOne("potato.detailedMapper.selReviewSum",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return reviewSum;
	}
	
	//리뷰 조회
	public List<DetailedReviewDomain> selectReviewAll(DetailedReviewVO drVO) {
		List<DetailedReviewDomain> drd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		drd=ss.selectList("potato.detailedMapper.selReviewAll",drVO);
		
		mbh.closeHandler(ss);
		
		return drd;
	}
	
	//리뷰 좋아요 여부
	public int selectLikeChk(DetailedBookmarkVO dbVO) {
		int LikeChk=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		LikeChk=ss.selectOne("potato.detailedMapper.selBookmarkChk",dbVO);
		
		mbh.closeHandler(ss);
		
		return LikeChk;
	}
	
	//리뷰 좋아요 추가
	public String insertLikeAdd(DetailedLikeVO dlVO) {
		String likeAdd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		likeAdd=ss.selectOne("potato.detailedMapper.insLikeAdd",dlVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return likeAdd;
	}
	
	//리뷰 좋아요 삭제
	public String deleteLikeDel(DetailedLikeVO dlVO) {
		String likeDel=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		likeDel=ss.selectOne("potato.detailedMapper.delLikeDel",dlVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return likeDel;
	}
	
	//리뷰 삭제
	public String deleteReviewDel(DetailedReviewVO drVO) {
		String reviewDel=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		reviewDel=ss.selectOne("potato.detailedMapper.delReviewDel",drVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return reviewDel;
	}
	
	//<신고창>
	//신고창 접속
	public List<DetailedReportDomain> selectReportPopup() {
		List<DetailedReportDomain> drd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		drd=ss.selectList("potato.detailedMapper.selReportPopup");
		
		mbh.closeHandler(ss);
		
		return drd;
	}
	
	//신고 접수
	public Integer insertReportPopup(DetailedReportVO drVO) {
		Integer insertPeport=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		insertPeport=ss.selectOne("potato.detailedMapper.insReportPopup",drVO);
		ss.commit();
		
		mbh.closeHandler(ss);
		
		return insertPeport;
	}
	
	//신고 접수 유무
	public Integer selectReportPopupChk(DetailedReportVO drVO) {
		Integer selectPeportChk=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		selectPeportChk=ss.selectOne("potato.detailedMapper.selReportPopupChk",drVO);
		
		mbh.closeHandler(ss);
		
		return selectPeportChk;
	}
}
