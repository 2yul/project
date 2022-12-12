package potato.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.MyPageDAO;
import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageMyInfoDomain;
import potato.domain.MyPageReportDomain;
import potato.domain.MyPageReviewDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageReportVO;

@Component
public class MyPageService {
	@Autowired(required = false)
	private MyPageDAO mDAO;
	
	//마이페이지 접속
	public String searchMyPageIn(String id) {
		String sl=null;
		sl=mDAO.selectLogin(id);
		return "";
	}//searchMyPageIn
	
	//내 정보 조회
	public List<MyPageMyInfoDomain>searchInfo(String id) {
		List<MyPageMyInfoDomain>mid=null;
		mid=mDAO.selectInfo(id);
		return mid;
	}//searchInfo
	
	//아이디,비밀번호 확인
	public boolean searchMember(LoginVO lVO) {
		
		return false;
	}//searchMember
	
	//내 정보 수정
	public int updateInfo(MyPageMyInfoEditVO mieVO) {
		int updateInfoCnt=0;
		updateInfoCnt=mDAO.updateInfo(mieVO);
		
		return updateInfoCnt; 
	}//updateInfo
	
	//비밀번호 수정 처리
	//정보 수정이기 때문에 forward보다는 redirect로 처리해주는 것이 좋다.
	
	public int modifyPw(MyPagePwEditVO peVO) {
		int updateCnt=0;
		updateCnt=mDAO.updatePw(peVO);
		return updateCnt;
	}//modifyPw
	
	//회원탈퇴
	public int updateQuit(MyPageQuitVO qVO) {
		int quitCount=0;
		quitCount=mDAO.updateQuit(qVO);
		return quitCount;
	}//updateQuit
	
	//회원탈퇴 처리
	//public String quitProcess(HttpSession session, MyPageQuitVO qVO) {
		//탈퇴 처리가 완료되면 메인으로 이동시키기
		//return null;
//	}//quitProcess
	
	
	//북마크한 휴게소 조회
	public List<MyPageBookmarkDomain>searchBookmark(String id){
		List<MyPageBookmarkDomain> mbd=null;
		mbd=mDAO.selectBookmark(id);
		return mbd;
	}//searchBookmark
	
	//북마크한 휴게소 삭제(아이디, 휴게소 인덱스-int)
	public int removeBookmark(HttpSession session, MyPageBookmarkVO bVO) {
		int cnt=mDAO.delBookmark(bVO);
		return cnt;
	}//removeBookmark
	
	
}//class
