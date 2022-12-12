package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.service.HomeServiece;

@Controller
public class HomeController {
	
	@Autowired(required = false)
	private HomeServiece hs;

	//메인화면 접속
	@RequestMapping(value = "user_mainhome.do", method={GET,POST})
	public String userHomeMove(HttpServletRequest request, Model model) {
		
		//방문자 ip 얻기
		String ip=request.getRemoteAddr();
		hs.getVisiter(ip);
		
		model.addAttribute("link1", hs.getLink1());
		model.addAttribute("link2", hs.getLink2());
		model.addAttribute("link3", hs.getLink3());
		model.addAttribute("link4", hs.getLink4());
		model.addAttribute("mapPin", hs.getMap());
		
		return "mainhome/jsp/user_mainhome";
	}
	
	//도움말 접속
	@RequestMapping(value = "help.do", method=GET)
	public String helpMove() {
		return "cs/jsp/help";
	}
	
}
