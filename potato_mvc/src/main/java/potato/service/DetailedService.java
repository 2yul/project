package potato.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.DetailedDAO;
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
public class DetailedService {

	@Autowired(required = false)
	private DetailedDAO dDAO;
	
	//<휴게소 상세창>
	//휴게소 상세창 정보 불러오기
	public DetailedDomain getRestDetailed(Integer restarea_idx) {
		DetailedDomain dd=null;
		dd=dDAO.selectRestDetailed(restarea_idx);
		return dd;
	}
	
	//휴게소 북마크 total
	public int getBookmarkTotal(int restarea_idx) {
		int booktotal=0;
		booktotal=dDAO.selectBookmarkTotal(restarea_idx);
		return booktotal;
	}
	
	//휴게소 북마크 여부
	public int getBookmarkChk(DetailedBookmarkVO dbVO) {
		int bookChk=0;
		bookChk=dDAO.selectBookmarkChk(dbVO);
		return bookChk;
	}
	
	//휴게소 북마크 추가 (비동기)
	public String setBookmarkAdd(DetailedBookmarkVO dbVO) {
		String bookAdd=null;
		bookAdd=dDAO.insertBookmarkAdd(dbVO);
		return bookAdd;
	}
	
	//휴게소 북마크 해제 (비동기)
	public String setBookmarkDel(DetailedBookmarkVO dbVO) {
		String bookDel=null;
		bookDel=dDAO.deleteBookmarkDel(dbVO);
		return bookDel;
	}
	
	//휴게소 별점 total
	public int getRateTotal(int restarea_idx) {
		int startotal=0;
		startotal=dDAO.selectRateTotal(restarea_idx);
		return startotal;
	}
	
	//휴게소 음식 정보
	public List<DetailedFoodDomain> getFoodDatailed(int restarea_idx) {
		List<DetailedFoodDomain> dfd=null;
		dfd=dDAO.selectFoodDatailed(restarea_idx);
		return dfd;
	}
	
	//휴게소 편의시설아이콘
	public List<DetailedAmenityDomain> getAmenityImg(int restarea_idx) {
		List<DetailedAmenityDomain> dad=null;
		dad=dDAO.selectAmenityImg(restarea_idx);
		return dad;
	}
	
	//<휴게소 리뷰>
	//리뷰 작성창 이동
	public DetailedReviewDomain moveReviewWrite(int restarea_idx) {
		DetailedReviewDomain drd=null;
		drd=dDAO.selectReviewWrite(restarea_idx);
		return drd;
	}
	
	//리뷰 수정창 이동
	public DetailedReviewDomain moveReReviewWrite(DetailedReviewVO drVO) {
		DetailedReviewDomain drd=null;
		drd=dDAO.selectReReviewWrite(drVO);
		return drd;
	}
	
	//리뷰 이미지 불러오기
	public List<WriteReviewDomain> moveReReviewImg(DetailedReviewVO drVO) {
		List<WriteReviewDomain> wrd=null;
		wrd=dDAO.selectReReviewImg(drVO);
		return wrd;
	}
	
	//리뷰 총 total
	public int getReviewTotal(int restarea_idx) {
		int reviewtotal=0;
		reviewtotal=dDAO.selectReviewTotal(restarea_idx);
		return reviewtotal;
	}
	
	//리뷰 총 sum
	public int getReviewSum(int restarea_idx) {
		int reviewSum=0;
		reviewSum=dDAO.selectReviewSum(restarea_idx);
		return reviewSum;
	}
	
	//리뷰 조회(비동기)
	public String getReviewAll(DetailedReviewVO drVO) {
		List<DetailedReviewDomain> list=null;
		list=dDAO.selectReviewAll(drVO);
		JSONObject jsonObj=new JSONObject();
		JSONObject jo=null;
		JSONArray js=new JSONArray();

		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String date=null;
		
		for(DetailedReviewDomain dd: list) {
			jo=new JSONObject();
			jo.put("contents", dd.getContents());
			jo.put("foodimg", dd.getFoodimg());
			jo.put("id", dd.getId());
			jo.put("img", dd.getImg());
			jo.put("liked", dd.getLiked());
			jo.put("nick", dd.getNick());
			date=dateFormat.format(dd.getPost_date());
			jo.put("post_date", date);
			jo.put("rating", dd.getRating());
			jo.put("review_idx", dd.getReview_idx());
			jo.put("idclick", dd.getIdclick());
			js.add(jo);
		}//end for
		
		jsonObj.put("review", js);
		
		
		
		return jsonObj.toJSONString();
	}

	//페이징 마지막 페이지
	public int getLastPageNum(int total) {
		int lastPage = (int) Math.ceil((double) total / 5);
		return lastPage;
	}
	
	//리뷰 좋아요 추가
	public String getLikeAdd(DetailedLikeVO dlVO) {
		String likeAdd=null;
		likeAdd=dDAO.insertLikeAdd(dlVO);
		return likeAdd;
	}
	
	//리뷰 좋아요 삭제
	public String getLikeDel(DetailedLikeVO dlVO) {
		String likeDel=null;
		likeDel=dDAO.deleteLikeDel(dlVO);
		return likeDel;
	}
	
	//리뷰 삭제
	public String getReviewDel(DetailedReviewVO drVO) {
		String reviewDel=null;
		reviewDel=dDAO.deleteReviewDel(drVO);
		return reviewDel;
	}
	
	//<신고창>
	//신고창 접속
	public List<DetailedReportDomain> getReportPopup() {
		List<DetailedReportDomain> dd=null;
		dd=dDAO.selectReportPopup();
		return dd;
	}
	
	//신고 접수
	public Integer setReportPopup(DetailedReportVO drVO) {
		Integer setReport=0;
		setReport=dDAO.insertReportPopup(drVO);
		return setReport;
	}
	
	//신고 접수 유무
	public Integer setReportPopupChk(DetailedReportVO drVO) {
		Integer setReportChk=0;
		setReportChk=dDAO.selectReportPopupChk(drVO);
		return setReportChk;
	}
	
}
