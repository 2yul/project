package potato.manager.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrMemberDAO;
import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

@Component
public class MgrMemberService {

	@Autowired(required = false)
	private MgrMemberDAO mmDAO;
	
	//회원 조회
	public List<MgrMemberDomain> searchMember(MgrMemberVO mmVO,String memberCat,HttpSession session){
		List<MgrMemberDomain> list=null;
		
		if(memberCat == null || "1".equals(memberCat)) {
			list=mmDAO.selectMember(mmVO);
		}else if("2".equals(memberCat)) {
			list=mmDAO.selectQuitMember(mmVO);
		}else if("3".equals(memberCat)) {
			list=mmDAO.selectBlockMember(mmVO);
		}//end else 
		return list;
	}
	
	//회원 상세정보창 불러오기
	public MgrMemberDomain searchMemberInfo(String id) {
		MgrMemberDomain mmd=null;
		mmd=mmDAO.selectDetailInfo(id);
		
		return mmd;
	}
	
	//차단 사유 불러오기
	public List<MgrBlockReasonDomain> searchReason(){
		List<MgrBlockReasonDomain> list=null;
		list=mmDAO.selectReason();
		
		return list;
	}
	
	//회원 차단하기(차단회원 목록에 추가)
	public String addBlock(ManagerBlockVO mbVO) {
		String blockFlag="N";	
		try {
			mmDAO.insertBlock(mbVO);
		}catch (PersistenceException se) {
			blockFlag="Y";	
		}

		return blockFlag;
	}
	
	//차단 해제
	public int removeBlock(String id) {
		
		int cnt=mmDAO.deleteBlock(id);
		return cnt;
	}
	
	////////////////////////페이징////////////////////
	//전체 페이지수
	public int searchTotalPages(String memberCat,MgrMemberVO mmVO) {
		int cnt=0;
		if("1".equals(memberCat)) {
			cnt=mmDAO.selectTotalPages1(mmVO);
		}else if("2".equals(memberCat)) {
			cnt=mmDAO.selectTotalPages2(mmVO);
		}else if("3".equals(memberCat)) {
			cnt=mmDAO.selectTotalPages3(mmVO);
		}
		
		return cnt;
	}
	
	//마지막 페이지 번호
	public int lastPage(int totalPages) {
		int lastPage=(int)Math.ceil((double)totalPages/10); //10개씩 보여주기

		return lastPage;
	}
	
	//현재페이지의 시작 번호
	public int startNum(int currentPage) {
		int startNum=currentPage-(currentPage-1) % 3; //3페이지씩 보여줌
		
		return startNum;
	}
	
	// 한 페이지당 보여줄 페이지 수, 마지막 페이지보다 적다면 다시 계산
	public int isLast( int lastPage,int startNum) {
		int isLast = 2; // 3페이직 씩 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		
		return isLast;
	}
}
