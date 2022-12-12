package potato.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrHomeDAO;

@Component
public class MgrHomeService {
	
	//의존성주입
	@Autowired(required = false)
	private MgrHomeDAO mhDAO;
	
	/**
	 * 오늘 신규가입 수
	 * @return
	 */
	public int searchNewMemCnt() {
		int NewMemCnt=0;
		
		NewMemCnt=mhDAO.selectNewMemCnt();
		
		return NewMemCnt;
	}//searchNewMemCnt
	
	/**
	 * 오늘 신고 수
	 * @return
	 */
	public int searchReportCnt() {	
		int reportCnt=0;
		
		reportCnt=mhDAO.selectReportCnt();
		
		return reportCnt;
	}//searchReportCnt
	
	//인기 휴게소(별점+리뷰)
	public String searchPopOne() {	
		String popOne=null;
		
		popOne=mhDAO.selectPopOne();
		
		return popOne;
	}//searchPopOne
	
	//관심 휴게소(북마크)
	public String searchBookmark() {	
		String bookmark=null;
		
		bookmark=mhDAO.selectBookmark();
		
		return bookmark;
	}//searchBookmark
	
	//방문자현황(일주일 날짜)
	public String searchVisitDate(int DateFlag) {	
		String visitDate=null;
		
		visitDate=mhDAO.selectVisitDate(DateFlag);
		
		return visitDate;
	}//searchVisitDate
	
	//방문자 현황(어제,오늘,총)
	public int searchVisitorCnt(int visitFlag) {	
		int visitorCnt=0;
		
		visitorCnt=mhDAO.selectVisitorCnt(visitFlag);
		
		return visitorCnt;
	}//searchVisitorCnt
	
	//회원 현황(전체)
	public int searchAllMem() {
		int allMemCnt=0;
		
		allMemCnt=mhDAO.selectAllMem();
		
		return allMemCnt;
	}//searchAllMem
	
	//회원 현황(탈퇴)
	public int searchQuitMem() {
		int quitMemCnt=0;
		
		quitMemCnt=mhDAO.selectQuitMem();
		
		return quitMemCnt;
	}//searchQuitMem
	
	//인기 휴게소 랭킹
	public List<String> searchPopAll() {
		List<String> list=null;
		
		list = mhDAO.selectPopAll();
		
		return list;
	}//searchQuitMem
}
