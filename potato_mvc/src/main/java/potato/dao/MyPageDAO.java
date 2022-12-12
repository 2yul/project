package potato.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageMyInfoDomain;
import potato.domain.MyPageReportDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;
@Component
public class MyPageDAO {
	
	//마이페이지 접속
	public String selectLogin(String id) {
		String sl=null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. 쿼리문 실행
		sl=ss.selectOne("potato.mypageMapper.selectMyLogin");
		//3. MyBatis Handler 끊기
		mbh.closeHandler(ss);
		return sl;
	}//selectLogin
	
	//내 정보 조회
	public List<MyPageMyInfoDomain> selectInfo(String id) {
		List<MyPageMyInfoDomain> mid=null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. 쿼리문 실행
		mid=ss.selectList("potato.mypageMapper.selectMypageInfo", id);
		//3. MyBatis Handler 끊기
		mbh.closeHandler(ss);
		
		return mid;
	}//selectInfo
	
	//내 정보 수정
	public int updateInfo(MyPageMyInfoEditVO mieVO) {
		int updateInfoCnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		updateInfoCnt=ss.update("potato.mypageMapper.updateMypageInfo",mieVO);
		
		if(updateInfoCnt == 1 ) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return updateInfoCnt;
	}//updateInfo
	
	//비밀번호 수정
	public int updatePw(MyPagePwEditVO peVO) {
		int updateCnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		updateCnt=session.update("potato.mypageMapper.updatePw",peVO);
		
		if(updateCnt==1) { //수정사항이 있으면 커밋
			session.commit();
		}else { //수정사항이 없으면
			session.rollback();
			
		}
		
		
		mbh.closeHandler(session);
		
		return updateCnt;
	}//updatePw
	
	//회원 탈퇴
	public int updateQuit(MyPageQuitVO qVO) {
		int quitCount=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		quitCount=session.update("potato.mypageMapper.updateQuit",qVO);
		
		if(quitCount ==1) {
			session.commit();
			session.close();
		}
		mbh.closeHandler(session);
		return quitCount;
	}//updateQuit
	
	
	//북마크한 휴게소 조회
	public List<MyPageBookmarkDomain> selectBookmark(String id){
		List<MyPageBookmarkDomain> mbd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		mbd=ss.selectList("potato.mypageMapper.selectBookmark", id);
		
		mbh.closeHandler(ss);
		
		return mbd;
	}//selectBookmark
	
	//북마크한 휴게소 삭제(아이디, 휴게소 인덱스)(String id랑 restrea_idx가 bookmarkVO네..)
	public int delBookmark(MyPageBookmarkVO bVO) {
		int cnt=0;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. 쿼리문 실행
		cnt=ss.delete("potato.mypageMapper.updateBookmark",bVO);
		ss.commit();
		//3. MyBatis Handler 끊기
		mbh.closeHandler(ss);
		return cnt;
	}//delBookmark
	
}//class
