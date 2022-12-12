package potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import potato.domain.ListMapPinDomain;
import potato.domain.RestAreaListDomain;
import potato.service.ListService;
import potato.vo.SearchFlagVO;
import potato.vo.DoSearchVO;

@Controller
public class ListController {
	
	@Autowired(required = false)
	private ListService ls;
	
	
	
	//전체 휴게소 목록
	@RequestMapping(value={"/allList.do","/header.do"}, method={GET,POST})
	public String allRestAreaList(SearchFlagVO sfVO, Model model) {
		
		List<RestAreaListDomain> list=ls.searchAllList(sfVO);
		model.addAttribute("allList",list);
		
		//페이징 변수
		int totalPages = ls.searchTotalPages(sfVO);
		int lastPage = ls.lastPage(totalPages);
		int currentPage = sfVO.getPageFlag();
		int startNum = ls.startNum(currentPage);
		int isLast = ls.isLast(startNum,lastPage);
		
		//view로 전송
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("currentPage", currentPage);
		
		return "list/jsp/list_view_all";
	}//allRestAreaList
	
	//고속도로별) 버튼 클릭시 해당 도로 핀 불러오기
	@RequestMapping(value="/mapPin.do",method={GET,POST})
	public String highwayMapPin(Model model) {
		model.addAttribute("pin1",ls.searchPin1());
		model.addAttribute("pin2",ls.searchPin2());
		model.addAttribute("pin3",ls.searchPin3());
		model.addAttribute("pin4",ls.searchPin4());
		model.addAttribute("pin5",ls.searchPin5());
		
		return "list/jsp/highway_list";
	}
	
	//도별 휴게소(지도)
	@RequestMapping(value="doMap.do",method={GET,POST})
	public String doMap() {
		
		return "list/jsp/do_list";
	}
	
	//클릭한 도 휴게소 목록으로 이동
	@RequestMapping(value="doList.do",method={GET,POST})
	public String doRestAreaList(DoSearchVO dsVO, Model model) {
		List<RestAreaListDomain> list = ls.searchDoList(dsVO);
		model.addAttribute("doRestList",list);
		
		String doName = ls.searchDoName(dsVO.getDo_idx());
		model.addAttribute("doName",doName);
		

		//페이징 변수
		int totalPages = ls.searchDoTotalPages(dsVO);
		int lastPage = ls.lastPage(totalPages);
		int currentPage = dsVO.getPageFlag();
		int startNum = ls.startNum(currentPage);
		int isLast = ls.isLast(startNum,lastPage);
		
		//view로 전송
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("currentPage", currentPage);
		
		return "list/jsp/do_list_details";
	}

	//도 휴게소에서 검색, 정렬
	@RequestMapping(value="searchArrange.do",method={GET,POST})
	public String doSearchArrange(SearchFlagVO sfVO, Model model) {
		
		return "list/jsp/list_view_all";
	}
	
	//휴게소 목록에서 또는 고속도로 지도에서 핀 클릭해서 상세창 이동
	//매개변수 int restarea_idx, Model model
	@RequestMapping(value="listToDetail.do",method={GET,POST})
	public String detailPage() {
		
		return "detailed/jsp/user_detailed";
	}
	
	//ex-FOOD //매개변수 : int restarea_idx
	@RequestMapping(value="exFood.do",method={GET,POST})
	public String exFoodList() {
		
		return "list/jsp/exfood_list";
	}//exFoodList
	
	//연관 검색어(ajax)
	@RequestMapping(value="relatedKeyword.do",method = {GET,POST})
	public String keywordList(String keyword) {
		
		return "list/jsp/list_view_all";
	}
	
}
