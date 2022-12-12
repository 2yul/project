package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;

@Component
public class MgrHomeDAO {

	/**
	 * 오늘 신고 수
	 * @return
	 */
	public int selectReportCnt() {
		 int reportCnt=0;
		 
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행
	reportCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectReportCnt");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);
	 
		 return reportCnt;
	}//selectReportCnt
	 
	/**
	 * 인기 휴게소(별점+리뷰)
	 * @return
	 */
	public String selectPopOne() {
		 String popOne=null;
	 
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행
	popOne=ss.selectOne("potato.manager.mgrHomeMapper.selectPopOne");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);
	 
		 return popOne;
	 }//selectPopOne
	
	/**
	 * 관심 휴게소(북마크)
	 * @return
	 */
	public String selectBookmark() {
		String bookmark=null;
		  
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
	bookmark=ss.selectOne("potato.manager.mgrHomeMapper.selectBookmark");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);
	  
		 return bookmark;
	}//selectBookmark
	  
	/**
	 * 방문자현황(일주일 날짜)
	 * @param DateFlag
	 * @return
	 */
	public String selectVisitDate(int DateFlag) { 
		String visitDate=null;
		
		//1. MyBatis Handler(SqlSession) 얻기
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
		visitDate=ss.selectOne("potato.manager.mgrHomeMapper.selectVisitDate",DateFlag);
		//3. MyBatis Handler 끊기
		mbh.closeHandler(ss);	 
		
		return visitDate;
	}//selectVisitorCnt
	
	/**
	 * 방문자 현황(어제,오늘,총,주간)
	 * @param visitFlag
	 * @return
	 */
	public int selectVisitorCnt(int visitFlag) { 
		int visitorCnt=0;
		
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
	visitorCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectVisitorCnt",visitFlag);
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);	 
		
		return visitorCnt;
	 }//selectVisitorCnt
	 
	/**
	 * 회원 현황(전체)
	 * @return
	 */
	public int selectAllMem() {
		 int allMemCnt=0;
	
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
	allMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectAllMem");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);	 
		 
	 	return allMemCnt;
	 }//selectAllMem
	
	/**
	 * 회원 현황(신규)
	 * @return
	 */
	public int selectNewMemCnt() {
		 int newMemCnt=0;
	 
	 //1. MyBatis Handler(SqlSession) 얻기
	 MyBatisHandler mbh=MyBatisHandler.getInstance();
	 SqlSession ss=mbh.getHandler();
	 //2.쿼리문 실행 
	 newMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectNewMemCnt");
	 //3. MyBatis Handler 끊기
	 mbh.closeHandler(ss);
	 
	 	return newMemCnt; 
	 }//selectNewMemCnt
	
	/**
	 * 회원 현황(탈퇴)
	 * @return
	 */
	public int selectQuitMem() {
		int quitMemCnt=0;
		
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
	quitMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectQuitMem");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);	 
		
		return quitMemCnt;
	}//selectQuitMem
	 
	/**
	 * 인기 휴게소 랭킹
	 * @return
	 */
	public List<String> selectPopAll(){ 
		List<String> list=null;
	 
	//1. MyBatis Handler(SqlSession) 얻기
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.쿼리문 실행 : 입력값 없이 총 레코드의 수를 얻자
	list=ss.selectList("potato.manager.mgrHomeMapper.selectPopAll");
	//3. MyBatis Handler 끊기
	mbh.closeHandler(ss);	 	
		
		return list;
	}//selectPopAll
	
}//class
