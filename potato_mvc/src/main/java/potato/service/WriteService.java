package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.WriteDAO;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Component
public class WriteService {
	
	@Autowired(required = false)
	private WriteDAO wDAO;

	//리뷰 등록
	public int setReview(WriteReviewVO wrVO) {
		int idx = wDAO.insertReview(wrVO);
		return idx;
	}
	
	//추가된휴게소의 인덱스가져오기
	public int searchNewIdx(int restarea_idx) {
		int idx = wDAO.selectNewReview(restarea_idx);
		return idx;
	}
	
	//리뷰 이미지 등록
	public int setReviewImg(WriteReviewImgVO wrVO) {
		int cnt = wDAO.insertReviewImg(wrVO);
		return cnt;
	}
	
	//수정 리뷰 등록
	public int setReReview(WriteReviewVO wrVO) {
		int idx = wDAO.updateReReview(wrVO);
		return idx;
	}
	
	//이미지 삭제 
	public int delReReviewImg(WriteReviewVO wrVO) {
		int cnt = wDAO.deleteReReviewImg(wrVO);
		return cnt;
	}
	
}
