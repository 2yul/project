package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.DetailedDomain;
import potato.domain.ListMapPinDomain;
import potato.domain.RestAreaListDomain;
import potato.vo.DoSearchVO;
import potato.vo.SearchFlagVO;

@Component
public class ListDAO {
	
	//전체휴게소 목록 보여주기
	public List<RestAreaListDomain> selectAllRestAreaList(SearchFlagVO sfVO){
		List<RestAreaListDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.allRestAreaList",sfVO);
		
		mbh.closeHandler(ss);
		
		return list;
	}//selectAllRestAreaList
	
	//고속도로 버튼 클릭시 핀 불러오기
	//경부고속도로
	public List<ListMapPinDomain> selectPin1(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin1");
				
		return list;
	}
	//남해고속도로
	public List<ListMapPinDomain> selectPin2(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin2");
		
		return list;
	}
	//서해안고속도로
	public List<ListMapPinDomain> selectPin3(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin3");
		
		return list;
	}
	//영동고속도로
	public List<ListMapPinDomain> selectPin4(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin4");
		
		return list;
	}
	//중부내륙고속도로
	public List<ListMapPinDomain> selectPin5(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin5");
		
		return list;
	}
	
	//도 클릭시 휴게소 목록 보여주기
	public List<RestAreaListDomain> selectDoList(DoSearchVO dsVO){
		List<RestAreaListDomain> list = null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.doList",dsVO);
		
		return list;
	}//selectDoList
	
	//도 이름 가져오기
	public String selectDoName(int do_idx) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		String doName=ss.selectOne("potato.listMapper.doName",do_idx);
		
		return doName;
	}
	
	//도 휴게소 목록에서 검색, 정렬
	public List<RestAreaListDomain> selectSearchArrangeDo(SearchFlagVO sfVO){
		
		return null;
	}
	
	//휴게소 목록에서 상세창으로 이동
	public DetailedDomain selectDetailPage(int restarea_idx) {
		
		return null;
	}
	
	//페이징
	public int selectTotalPages(SearchFlagVO sfVO) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		int cnt=session.selectOne("potato.listMapper.listPage",sfVO);
		
		return cnt;
	}
	//페이징(도 휴게소 목록)
	public int selectDoTotalPages(DoSearchVO dsVO) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		int cnt=session.selectOne("potato.listMapper.doListPage",dsVO);
		
		return cnt;
	}
	
	//연관검색어(ajax)
	public String searchKeywordList(String keyword) {
		
		return null;
	}
}
