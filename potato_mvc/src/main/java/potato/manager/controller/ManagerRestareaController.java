package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.manager.domain.DeleteImgDomain;
import potato.manager.service.ManagerRestService;
import potato.manager.vo.AmenityVO;
import potato.manager.vo.FoodVO;
import potato.manager.vo.RestVO;
import potato.manager.vo.SearchRestVO;

@Controller
public class ManagerRestareaController {
	
	@Autowired(required = false)
	private ManagerRestService mrs;
	
	/**
	 * 관리자 휴게소를 보여주는 컨트롤러
	 * @param srVO
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="manager_restarea.do",method= {GET, POST})
	public String restMain(SearchRestVO srVO, Model model, HttpSession session) {
		String url="manager/rest_management/jsp/manager_rest_management";
		
		
		if(session.getAttribute("manager_id")==null) {
			url="forward:managerlogin_page.do";
		}
		
		
		//페이징
		int totalReview = mrs.searchTotalRest(srVO);
		int lastPage = mrs.lastPage(totalReview);
		int curPage = srVO.getPageFlag();
		int startNum = mrs.startNum(curPage);
		int isLast = mrs.isLast(lastPage, startNum);
		
		//view전송
		model.addAttribute("restList", mrs.searchRest(srVO));
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("lineList", mrs.searchLine());
		return url;
	}
	
	
	/**
	 * 휴게소의 상세창을 보여주는 컨트롤러
	 * @param restarea_idx
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manager_restdetailPopup.do",method=POST)
	public String restDetailPopup(int restarea_idx, Model model) {
		model.addAttribute("detail", mrs.searchRestDetail(restarea_idx));
		model.addAttribute("foodList", mrs.searchRestFood(restarea_idx));
		return "manager/rest_management/jsp/rest_popup";
	}
	
	/**
	 * 휴게소 추가창을 보여주는 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manager_writePopup.do", method=GET)
	public String openWriteRest(Model model) {
		model.addAttribute("lineList", mrs.searchLine());
		model.addAttribute("doList", mrs.searchDo());
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	/**
	 * 휴게소를 추가하는 컨트롤러
	 * @param request
	 * @return
	 */
	@RequestMapping(value="manager_rest_add.do", method=POST)
	public String newRest(HttpServletRequest request) {
		//이미지저장공간과 크기 설정
		File saveDir = new File("/home/ubuntu/potato_mvc/css/images/");
		int maxSize=1024*1024*20;
		try {
			//이미지파일 추가
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			RestVO rVO = new RestVO();
			
			//휴게소 테이블 입력 파라메터 처리
			rVO.setName(mr.getParameter("restName"));
			rVO.setImg(mr.getFilesystemName("upFile"));
			rVO.setLat(parseDouble(mr.getParameter("lat")));
			rVO.setLng(parseDouble(mr.getParameter("lng")));
			rVO.setDo_idx(parseInt(mr.getParameter("doIdx")));
			rVO.setLine_idx(parseInt(mr.getParameter("lineIdx")));
			rVO.setTel(mr.getParameter("tel"));
			rVO.setCarwash_chk(mr.getParameter("washChk"));
			if(mr.getParameter("washChk") == null) {
				rVO.setCarwash_chk("N");
			}
			rVO.setRepair_chk(mr.getParameter("repairChk"));
			if(mr.getParameter("repairChk") == null) {
				rVO.setRepair_chk("N");
			}
			rVO.setCargolounge_chk(mr.getParameter("cargoChk"));
			if(mr.getParameter("cargoChk") == null) {
				rVO.setCargolounge_chk("N");
			}
			
			//휴게소 테이블 성공여부확인, 1이 나와야 성공
			int restResultCnt = mrs.addRest(rVO);
			
			//휴게소테이블에 추가성공시 음식, 시설테이블에 추가
			if(restResultCnt == 1) {
				int idx = mrs.searchNewIdx(rVO); // 추가된 휴게소 인덱스반환를 반환하여 사용
				
				//음식 테이블용 파라메터
				List<FoodVO> foodList = new ArrayList<FoodVO>();
				FoodVO fVO = null;
				for(int i =0; i<mr.getParameterValues("foodName").length; i++) {
					fVO = new FoodVO();
					fVO.setRestarea_idx(idx);
					fVO.setFood_idx(i+1);
					fVO.setImg(mr.getFilesystemName("foodFile"+i));
					fVO.setName(mr.getParameterValues("foodName")[i]);
					fVO.setPrice(parseInt(mr.getParameterValues("foodPrice")[i]));
					fVO.setContents(mr.getParameterValues("foodConts")[i]);
					fVO.setIngredient(mr.getParameterValues("foodIng")[i]);
					if(mr.getParameter("radio"+i).equals("main")) {
						fVO.setMain_chk("Y");
						fVO.setRec_chk("N");
					} else if(mr.getParameter("radio"+i).equals("good")) {
						fVO.setMain_chk("N");
						fVO.setRec_chk("Y");
					} else {
						fVO.setMain_chk("N");
						fVO.setRec_chk("N");
					}
					foodList.add(fVO);
				}//end for
				
				//음식추가
				mrs.addFood(foodList);
				
				
				//휴게소 편의시설 테이블용 파라메터
				AmenityVO amVO = new AmenityVO();
				amVO.setRestarea_idx(idx);
				
				//체크박스가 선택되지않았을 경우에 대한 유효성검증
				if(mr.getParameterValues("restIcons") != null) {
					amVO.setRestIcons(mr.getParameterValues("restIcons"));
				}
				
				if(mr.getParameterValues("gasIcons") != null) {
					amVO.setGasIcons(mr.getParameterValues("gasIcons"));
				}
				
				//두개 모두 하나도 체크되지 않았다면 insert할 필요가 없다.
				if(mr.getParameterValues("restIcons") != null || mr.getParameterValues("gasIcons") != null) {
					mrs.addAmenity(amVO);
				}
				
				//성공 시 view로 값을 전달해 창닫기
				request.setAttribute("result", "success");
			}
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	
	/**
	 * 수정창을 보여주는 컨트롤러
	 * @param restarea_idx
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manager_rest_modifyPopup.do",method=POST)
	public String restModifyPopup(int restarea_idx, Model model) {
		
		//기존정보 불러오기
		model.addAttribute("lineList", mrs.searchLine());
		model.addAttribute("doList", mrs.searchDo());
		model.addAttribute("rest", mrs.searchRestInfo(restarea_idx));
		model.addAttribute("food", mrs.searchRestFood(restarea_idx));
		
		return "manager/rest_management/jsp/manager_rest_modify_popup";
	}
	
	
	/**
	 * 수정하는 컨트롤러
	 * @param request
	 * @return
	 */
	@RequestMapping(value="manager_rest_modify.do", method= {POST,GET})
	public String restModify(HttpServletRequest request) {
		//이미지저장공간과 크기 설정
		File saveDir = new File("/home/ubuntu/potato_mvc/css/images/");
		int maxSize=1024*1024*20;
		try {
			//이미지파일 추가
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			RestVO rVO = new RestVO();
			
			//수정정보 입력 파라메터
			rVO.setRestarea_idx(parseInt(mr.getParameter("restarea_idx")));
			rVO.setName(mr.getParameter("restName"));
			rVO.setImg(mr.getFilesystemName("upFile"));
			rVO.setLat(parseDouble(mr.getParameter("lat")));
			rVO.setLng(parseDouble(mr.getParameter("lng")));
			rVO.setDo_idx(parseInt(mr.getParameter("doIdx")));
			rVO.setLine_idx(parseInt(mr.getParameter("lineIdx")));
			rVO.setTel(mr.getParameter("tel"));
			rVO.setCarwash_chk(mr.getParameter("washChk"));
			if(mr.getParameter("washChk") == null) {
				rVO.setCarwash_chk("N");
			}
			rVO.setRepair_chk(mr.getParameter("repairChk"));
			if(mr.getParameter("repairChk") == null) {
				rVO.setRepair_chk("N");
			}
			rVO.setCargolounge_chk(mr.getParameter("cargoChk"));
			if(mr.getParameter("cargoChk") == null) {
				rVO.setCargolounge_chk("N");
			}
			
			//휴게소인덱스 저장
			int idx = rVO.getRestarea_idx();
			
			//수정되기전 이미지 미리저장
			String img = mrs.searchOldImg(idx);
			
			//휴게소 테이블 업데이트 수행
			int cnt = mrs.modifyRest(rVO);
			
			//휴게소 테이블이 업데이트 되었다면
			if(cnt == 1) {
				if(rVO.getImg() != null) { //이미지변동이 있다면 
					mrs.removeOldImg(img); //과거 이미지삭제
				}
				
				//편의시설관련
				mrs.removeOldAnt(idx); // 기존 편의시설삭제
				AmenityVO amVO = new AmenityVO(); // 변경 편의시설삽입을 위한 VO
				amVO.setRestarea_idx(idx);
				
				//체크박스가 선택되지않았을 경우에 대한 유효성검증
				if(mr.getParameterValues("restIcons") != null) {
					amVO.setRestIcons(mr.getParameterValues("restIcons"));
				}
				
				if(mr.getParameterValues("gasIcons") != null) {
					amVO.setGasIcons(mr.getParameterValues("gasIcons"));
				}
				
				//두개 모두 하나도 체크되지 않았다면 insert할 필요가 없다.
				if(mr.getParameterValues("restIcons") != null || mr.getParameterValues("gasIcons") != null) {
					mrs.addAmenity(amVO);//편의시설 테이블 업데이트
				}
				request.setAttribute("result", "success");
			}
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		return "manager/rest_management/jsp/manager_restUpdateReust";
	}
	
	/**
	 * 음식이미지수정에 대한 ajax처리
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="ajax_foodImg_update.do", method= {POST,GET})
	public String updateFoodImgAJAX(HttpServletRequest request) {
		mrs.modifyFoodImgAJAX(request);
		return "";
	}
	
	/**
	 * 휴게소 음식삭제에 대한 ajax처리
	 * @param fVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="ajax_food_delete.do", method= {POST,GET})
	public String deleteFoodAJAX(FoodVO fVO) {
		mrs.removeFoodAJAX(fVO);
		return "";
	}
	
	
	/**
	 * 휴게소음식정보수정에 대한 ajax처리
	 * @param fVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="ajax_foodInfo_update.do", method=POST)
	public String updateFoodAJAX(FoodVO fVO,String radioChk) {
		if(radioChk.equals("main")) {
			fVO.setMain_chk("Y");
			fVO.setRec_chk("N");
		} else if(radioChk.equals("good")) {
			fVO.setMain_chk("N");
			fVO.setRec_chk("Y");
		} else {
			fVO.setMain_chk("N");
			fVO.setRec_chk("N");
		}
		
		mrs.modifyFoodInfoAJAX(fVO);
		return "";
	}
	
	
	
	/**
	 * 휴게소삭제에 대한 처리
	 * @param restarea_idx
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manager_removeRest.do",method=POST)
	public String delRest(int restarea_idx, Model model) {
		DeleteImgDomain did = mrs.searchImg(restarea_idx);//이미지 먼저 불러놓고 도메인을 생성하고
		int cnt = mrs.removeRest(restarea_idx);//테이블날리고 
		if(cnt == 1) {//테이블이 날아갔다면
			mrs.removeImg(did);//이미지파일도 날린다.
		}
		model.addAttribute("success",cnt);
		return "manager/rest_management/jsp/manager_restDelResult";
	}

}
