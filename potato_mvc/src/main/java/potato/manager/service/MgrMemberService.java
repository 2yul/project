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
	
	//ȸ�� ��ȸ
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
	
	//ȸ�� ������â �ҷ�����
	public MgrMemberDomain searchMemberInfo(String id) {
		MgrMemberDomain mmd=null;
		mmd=mmDAO.selectDetailInfo(id);
		
		return mmd;
	}
	
	//���� ���� �ҷ�����
	public List<MgrBlockReasonDomain> searchReason(){
		List<MgrBlockReasonDomain> list=null;
		list=mmDAO.selectReason();
		
		return list;
	}
	
	//ȸ�� �����ϱ�(����ȸ�� ��Ͽ� �߰�)
	public String addBlock(ManagerBlockVO mbVO) {
		String blockFlag="N";	
		try {
			mmDAO.insertBlock(mbVO);
		}catch (PersistenceException se) {
			blockFlag="Y";	
		}

		return blockFlag;
	}
	
	//���� ����
	public int removeBlock(String id) {
		
		int cnt=mmDAO.deleteBlock(id);
		return cnt;
	}
	
	////////////////////////����¡////////////////////
	//��ü ��������
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
	
	//������ ������ ��ȣ
	public int lastPage(int totalPages) {
		int lastPage=(int)Math.ceil((double)totalPages/10); //10���� �����ֱ�

		return lastPage;
	}
	
	//������������ ���� ��ȣ
	public int startNum(int currentPage) {
		int startNum=currentPage-(currentPage-1) % 3; //3�������� ������
		
		return startNum;
	}
	
	// �� �������� ������ ������ ��, ������ ���������� ���ٸ� �ٽ� ���
	public int isLast( int lastPage,int startNum) {
		int isLast = 2; // 3������ �� 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		
		return isLast;
	}
}