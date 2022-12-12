package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.ListDAO;
import potato.domain.DetailedDomain;
import potato.domain.ListMapPinDomain;
import potato.domain.RestAreaListDomain;
import potato.vo.DoSearchVO;
import potato.vo.SearchFlagVO;

@Component
public class ListService {
	
	@Autowired(required = false)
	private ListDAO lDAO;
	
	//전체 휴게소 목록 조회
	public List<RestAreaListDomain> searchAllList(SearchFlagVO sfVO){
		List<RestAreaListDomain> list=null;
		list=lDAO.selectAllRestAreaList(sfVO);
		
		return list;
	}//searchAllList
	
	//고속도로 핀 불러오기
	//경부고속도로
	public List<ListMapPinDomain> searchPin1(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin1();
		return list;
	}//searchPin1
	
	//남해고속도로
	public List<ListMapPinDomain> searchPin2(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin2();
		return list;
	}//searchPin2
	
	//서해안고속도로
	public List<ListMapPinDomain> searchPin3(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin3();
		return list;
	}//searchPin3
	
	//영동고속도로
	public List<ListMapPinDomain> searchPin4(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin4();
		return list;
	}//searchPin4
	
	//중부내륙고속도로
	public List<ListMapPinDomain> searchPin5(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin5();
		return list;
	}//searchPin5
	
	//도 클릭시 휴게소 목록 조회
	public List<RestAreaListDomain> searchDoList(DoSearchVO dsVO){
		List<RestAreaListDomain> list = null;
		list=lDAO.selectDoList(dsVO);
		return list;
	}//searchDoList
	
	//도 이름 가져오기
	public String searchDoName(int do_idx) {
		String name=lDAO.selectDoName(do_idx);
		
		return name;
	}
	
	//도 휴게소 목록에서 검색, 정렬
	public List<RestAreaListDomain> searchArrangeDo(SearchFlagVO sfVO) {
		
		return null;
	}//searchArrangeDo
	
	//////////////////////페이징/////////////////////
	//전체 페이지수(전체 리스트)
	public int searchTotalPages(SearchFlagVO sfVO) {
		int cnt=lDAO.selectTotalPages(sfVO);
		
		return cnt;
	}
	
	public int searchDoTotalPages(DoSearchVO dsVO) {
		int cnt=lDAO.selectDoTotalPages(dsVO);
		
		return cnt;
	}
	
	//마지막 페이지 번호
	public int lastPage(int totalPages) {
		int lastPage=(int)Math.ceil((double)totalPages/6); //6개씩 보여준다.
		return lastPage;
	}
	
	//현재페이지의 시작 번호
	public int startNum(int currentPage) {
		int startNum=currentPage-(currentPage-1) % 3;//3페이지씩 보여준다.
		return startNum;
	}
	
	// 한 페이지당 보여줄 페이지 수, 마지막 페이지보다 적다면 다시 계산
	public int isLast(int startNum, int lastPage) {
		int isLast = 2; // 3페이직 씩 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
	
	
	
	//연관검색어(ajax)
	public String searchKeywordList(String keyword) {
		
		return "";
	}
}
