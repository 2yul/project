package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.OtherReviewDomain;
import potato.vo.OtherReviewVO;

@Component
public class OtherReviewDAO {

	public String selOtherImg(OtherReviewVO orVO) {
		String otherImg = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		otherImg = ss.selectOne("potato.otherReview.selOtherImg", orVO);
		mbh.closeHandler(ss);
		return otherImg;
	}//selOtherImg
	
	public String selOtherNick(OtherReviewVO orVO) {
		String otherNick = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		otherNick = ss.selectOne("potato.otherReview.selOtherNick", orVO);
		mbh.closeHandler(ss);
		return otherNick;
	}//selOtherNick
	
	//ÃÑ ¸®ºä ¼ö
	public int selOtherRevCnt(OtherReviewVO orVO) {
		int otherRevCnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		otherRevCnt = ss.selectOne("potato.otherReview.selOtherRevCnt", orVO);
		mbh.closeHandler(ss);
		return otherRevCnt;
	}//selTotalRev
	
	//¸®ºäÁ¶È¸
	public List<OtherReviewDomain> selOtherRevAll(OtherReviewVO orVO){
		List<OtherReviewDomain> list= null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler(); 
		list = ss.selectList("potato.otherReview.selOtherRevAll", orVO);
		mbh.closeHandler(ss);
		return list;
	}//selOtherRevAll  


}//class
