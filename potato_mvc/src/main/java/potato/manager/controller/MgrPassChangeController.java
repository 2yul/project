package potato.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import potato.manager.service.MgrPassChangeService;
import potato.manager.vo.MgrPassChangeVO;

@Controller
public class MgrPassChangeController {
	
	@Autowired(required = false)
	private MgrPassChangeService pc;
	
	//비번 변경 화면 가져오기
	//forward로 변경하기
	@RequestMapping(value="/mgrPassChange.do",method={GET,POST})
	public String passChange(HttpSession session) {
		String url="manager/pass_change/jsp/manager_password_change";
		
		if(session.getAttribute("manager_id")==null) {
			url="forward:managerlogin_page.do"; 
		}
		
		return url;
	}		
	
	//비번 변경 처리
	@RequestMapping(value="/mgrPassChangeProcess.do",method={GET,POST})
	public String passChangeProcess(MgrPassChangeVO mpcVO, Model model) {
		
		
		int cnt=pc.modifyPass(mpcVO);
		
		model.addAttribute("cnt", cnt);
		
		return "forward:mgrPassChange.do";
	}
	
}
