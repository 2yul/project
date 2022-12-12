package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Component
public class WriteDAO {

	//리뷰 등록
	public int insertReview(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.insert("potato.writeMapper.insReview",wrVO);
		if(cnt == 1) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//추가된 휴게소 인덱스 반환
	public int selectNewReview(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int idx = ss.selectOne("potato.writeMapper.selNewReview", restarea_idx);
		mbh.closeHandler(ss);
		return idx;
	}
	
	//리뷰 이미지 등록
	public int insertReviewImg(WriteReviewImgVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.insert("potato.writeMapper.upReReviewImg",wrVO);
		if(cnt == 1) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//수정 리뷰 등록
	public int updateReReview(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.update("potato.writeMapper.upReReview",wrVO);
		if(cnt != 0) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//이미지 삭제 
	public int deleteReReviewImg(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.delete("potato.writeMapper.delReReviewImg",wrVO);
		if(cnt != 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}

}
