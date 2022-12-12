package potato.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.UserDomain;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;

/**
 *	유저의 로그인, 회원가입 관련 DAO
 * @author user
 */
@Component
public class UserDAO {
	//mapper namespace 변수 선언
	public static final String UserMapper="potato.userMapper.";
	
	/**
	 * 유저 회원가입
	 * @param uiVO
	 */
	public int insertMember(UserInfoVO uiVO) {
		int cnt = 0;
		
		//1. Handler 얻기
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2. 쿼리실행
		cnt=ss.insert(UserMapper+"insertMember", uiVO);
		ss.commit();
		//3. 끊기
		mbh.closeHandler(ss);
		
		return cnt;
	}//insertMember
	
	/**
	 * 유저로그인
	 * @param lVO
	 * @return
	 */
	public int selectLogin(LoginVO lVO) {
		int cnt=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		cnt = ss.selectOne(UserMapper+"selectLogin", lVO);
		mbh.closeHandler(ss);
		return cnt;
	}//selectManager
	
	/**
	 * 유저 로그인
	 * @param lVO
	 * @return
	 */
	public UserDomain selectLoginInfo(LoginVO lVO) {
		UserDomain ud= null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		ud=ss.selectOne(UserMapper+"selectLoginInfo", lVO);
		mbh.closeHandler(ss);
		return ud;
	}//selectLogin
	
	/**
	 * 매니저 로그인
	 * @param mlVO
	 * @return
	 */
	public int selectManager(ManagerLoginVO mlVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		cnt = ss.selectOne(UserMapper+"selectManagerLogin", mlVO);
		
		mbh.closeHandler(ss);
		return cnt;
	}//selectManager
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return 
	 */
	public int selectMDuplChkId(String id) {
		int cnt =0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt = ss.selectOne(UserMapper+"selectDuplChkId", id);
		mbh.closeHandler(ss);
		return cnt;
	}//selectMDuplChkId
	
	/**
	 * 닉네임 중복 검사
	 * @param nick
	 * @return 
	 */
	public int selectMDuplChkNick(String nick) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt = ss.selectOne(UserMapper+"selectDuplChkNick", nick);
		mbh.closeHandler(ss);
		return cnt;
	}//selectMDuplChkNick
	
	
	/**
	 * 아이디 찾기
	 * @param fiVO
	 * @return
	 */
	public String selectId(ForgotIdVO fiVO) {
		String id="";
		MyBatisHandler mbh=MyBatisHandler.getInstance(); 
		SqlSession ss=mbh.getHandler();
		id= ss.selectOne(UserMapper+"selectForgotId", fiVO); 
		mbh.closeHandler(ss);
		return id; 
	}//selectId
	 
	/**
	 * 비밀번호 찾기
	 * @param fpVO
	 * @return
	 */
	public int selectPw(ForgotPwVO fpVO) {
		int cnt=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt= ss.selectOne(UserMapper+"selectForgotPw", fpVO);
		mbh.closeHandler(ss);
		
		return cnt;
	}//selectId
	
	/**
	 * 임시비밀번호 업데이트
	 * @param fpVO
	 * @return
	 */
	public void updatePw(ForgotPwVO fpVO) {
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		ss.update(UserMapper+"updatePw", fpVO);
		ss.commit();
		mbh.closeHandler(ss);
	}//updatePw
	
}//class
