package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.manager.domain.DeleteImgDomain;
import potato.manager.domain.DoDomain;
import potato.manager.domain.FoodDomain;
import potato.manager.domain.LineDomain;
import potato.manager.domain.RestDomain;
import potato.manager.vo.AmenityVO;
import potato.manager.vo.FoodVO;
import potato.manager.vo.RestVO;
import potato.manager.vo.SearchRestVO;

@Component
public class MgrRestDAO {
	
	/**
	 * 휴게소가져오기
	 * @param srVO
	 * @return
	 */
	public List<RestDomain> selectRest(SearchRestVO srVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<RestDomain> list = ss.selectList("potato.manager.rest.selectRestarea", srVO);
		mbh.closeHandler(ss);
		return list;
	}
	
	/**
	 * 노선가져오기
	 * @return
	 */
	public List<LineDomain> selectLine() {
		List<LineDomain> list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		list = ss.selectList("potato.manager.rest.getLine");
		mbh.closeHandler(ss);
		return list;
	}
	
	/**
	 * 휴게소 수 가져오기
	 * @param srVO
	 * @return
	 */
	public int selectTotalRest(SearchRestVO srVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int totalReview = ss.selectOne("potato.manager.rest.selectRestTotal", srVO);
		mbh.closeHandler(ss);
		return totalReview;
	}
	
	/**
	 * 휴게소 상세창
	 * @param restarea_idx
	 * @return
	 */
	public RestDomain selectRestDetail(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		RestDomain rd = ss.selectOne("potato.manager.rest.selectRestDetail", restarea_idx); 
		mbh.closeHandler(ss);
		return rd;
	}
	
	//휴게소상세창과 수정창동시사용
	public List<FoodDomain> selectRestFood(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<FoodDomain> list = ss.selectList("potato.manager.rest.selectFood", restarea_idx);
		mbh.closeHandler(ss);
		return list;
	}
	
	//도가져오기
	public List<DoDomain> selectDo() {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<DoDomain> list = ss.selectList("potato.manager.rest.getDo");
		mbh.closeHandler(ss);
		return list;
	}
	
	//휴게소 추가
	public int insertRest(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertRest", rVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//추가된 휴게소 인덱스 반환
	public int selectNewIdx(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int idx = ss.selectOne("potato.manager.rest.selectNewIdx", rVO);
		mbh.closeHandler(ss);
		return idx;
	}
	
	//휴게소음식 추가
	public int insertFood(List<FoodVO> list) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertFood",list);
		if(cnt == list.size()) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//휴게소 편의시설추가
	public int insertAmenity(AmenityVO amVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertAmt",amVO);
		ss.commit();
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//수정휴게소정보
	public RestDomain selectRestInfo(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		RestDomain rd = ss.selectOne("potato.manager.rest.selectModifyRest",restarea_idx );
		mbh.closeHandler(ss);
		return rd;
	}
		
	//휴게소수정
	public int updateRest(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.update("potato.manager.rest.updateRest", rVO);
		if( cnt > 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//휴게소 사진 수정 시 삭제할 과거 휴게소 이미지 불러오기
	public String selectOldImg(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		String img = ss.selectOne("potato.manager.rest.selectOldImg", restarea_idx);
		mbh.closeHandler(ss);
		return img;
	}
	
	
	//휴게소 수정시 기존 편의시설 삭제
	public int deleteOldAmt(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.delete("potato.manager.rest.deleteAmt", restarea_idx);
		if(cnt > 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//음식사진이미지 수정
	public int updateFoodImg(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.update("potato.manager.rest.updateFoodImg",fVO);
		if(cnt ==1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//음식인덱스 존재여부확인
	public int selectIsFoodIdx(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.selectOne("potato.manager.rest.selectIsFoodIdx", fVO);
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//휴게소 수정시 과거음식사진불러오기
	public String selectDelFoodImg(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		String img = ss.selectOne("potato.manager.rest.selectOldFoomImg", fVO);
		mbh.closeHandler(ss);
		return img;
	}
	
	//수정페이지 새로운 음식사진추가
	public int insertUpdatedFoodImg(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertNewFoodImg", fVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//수정페이지 새로운 음식정보수정
	public int updateFoodInfo(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.update("potato.manager.rest.updateFoodInfo", fVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//수정페이지 새로운 음식정보추가
	public int insertUpdatedFoodInfo(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertNewFoodInfo", fVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//수정페이지 음식테이블 레코드삭제
	public int deleteFood(FoodVO fVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.delete("potato.manager.rest.deleteFood", fVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//휴게소 삭제
	public int deleteRest(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.delete("potato.manager.rest.deleteRest", restarea_idx);
		if(cnt == 1) {
			ss.commit(); 
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//휴게소 삭제시 삭제할 이미지 호출
	public DeleteImgDomain selectDelImg(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		DeleteImgDomain did = ss.selectOne("potato.manager.rest.selectDeleteImg", restarea_idx);
		mbh.closeHandler(ss);
		return did;
	}
	
	
}
