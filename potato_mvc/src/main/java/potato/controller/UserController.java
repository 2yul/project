package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.domain.UserDomain;
import potato.service.UserService;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;

//@SessionAttributes({"id","nick", "img"})
@Controller
@Component
public class UserController {
	
	@Autowired(required = false)
	private UserService us;
	

	/**
	 * 로그인 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login_page.do", method = GET)
	public String loginPage(HttpSession session) {
		session.invalidate();
		return "login/jsp/login";
	}//loginPage
	
	/**
	 * 매니저 로그인 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/managerlogin_page.do", method = GET)
	public String managerloginPage() {
		return "manager/home/jsp/manager_login";
	}//loginPage
	
	/**
	 * 회원 로그인
	 * @param lVO
	 * @param session
	 * @param id
	 * @param pass
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = POST)
	public String login(LoginVO lVO, HttpSession session, String id, String pass) {
		
		lVO.setId(id);
		lVO.setPass(pass);
		
		JSONObject jsonObj=new JSONObject();
		UserDomain ud=null;
		jsonObj.put("flag", false);
		int cnt=us.searchMember(lVO);
		if( cnt == 1 ) {
			ud=us.searchMemberInfo(lVO);
			if( "N".equals(ud.getQuit()) ) {
				session.setAttribute("id", ud.getId());
				session.setAttribute("nick", ud.getNick());
				session.setAttribute("img", ud.getImg());
			}//end if
			jsonObj.put("id", ud.getId());
			jsonObj.put("nick", ud.getNick());
			jsonObj.put("quit", ud.getQuit());
			jsonObj.put("img", ud.getImg());
			jsonObj.put("flag", true);
		}//end if
		return jsonObj.toJSONString();
	}//login
	

	/**
	 * 매니저 로그인
	 * @param mlVO
	 * @param ss
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/managerlogin.do", method = POST)
	public String managerlogin(ManagerLoginVO mlVO, String manager_id, String pass, HttpSession session) {
		mlVO.setManager_id(manager_id);
		mlVO.setPass(pass);
		int cnt=us.searchManager(mlVO);
		if( cnt ==1 ) {
			session.setAttribute("manager_id", manager_id);
		}
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("cnt", cnt);
		return jsonObj.toJSONString();
	}//login
	
	/**
	 * 로그아웃
	 * @param ss
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout.do", method = GET)
	public String logout( SessionStatus ss, HttpSession session) {
		String url="redirect:user_mainhome.do";
		ss.setComplete();
		session.invalidate();
		return url;
	}//logout
	
	/**
	 * 회원가입페이지 1이동
	 * @return
	 */
	@RequestMapping(value = "/signUpAgree.do", method = GET)
	public String signUpAgreePage() {
		return "login/jsp/service_check";
	}
	
	/**
	 * 이용약관1 이동
	 * @return
	 */
	@RequestMapping(value = "/tos1.do", method = GET)
	public String tos1() {
		return "login/jsp/tos1";
	}
	
	/**
	 * 이용약관2 이동
	 * @return
	 */
	@RequestMapping(value = "/tos2.do", method = GET)
	public String tos2() {
		return "login/jsp/tos2";
	}
	
	/**
	 * 회원가입1 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/signUp.do", method = GET)
	public String signUpPage1() {
		return "login/jsp/join";
	}
	
	/**
	 * 회원가입2 페이지 이동
	 * @param model
	 * @param uiVO
	 * @return
	 */
	@RequestMapping(value = "/signUp2.do", method = POST)
	public String signUpPage2(HttpServletRequest request, Model model, UserInfoVO uiVO, HttpSession session) {
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		if( month.length() == 1 ) {
			month="0"+month;
		}
		String day=request.getParameter("day");
		if( day.length() == 1 ) {
			day="0"+day;
		}
		String birth= year+"-"+month+"-"+day;
		uiVO.setBirth(birth);
		session.setAttribute("uiVO", uiVO);
		return "login/jsp/join_img";
	}
	
	/**
	 * 회원가입 3페이지 이동
	 * @param session
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signUp3.do", method = POST)
	public String signUpPage3(HttpServletRequest request, Model model, HttpSession session, UserInfoVO uiVO, SessionStatus ss) {
		File saveDir=new File("/home/ubuntu/potato_mvc/css/images/");
		int maxSize=1024*1024*20; //byte*kb*mb*gb;
		String url="redirect:user_mainhome.do";
		try {
			uiVO=(UserInfoVO)session.getAttribute("uiVO");
			if( uiVO == null ) {
				session.invalidate();
				return "redirect:user_mainhome.do";
			}
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(), 
					maxSize, "UTF-8", new DefaultFileRenamePolicy());
			//3. 파라메터를 받기( VO에 넣어야 한다면 VO를 생성하여 값을 넣는다.
			uiVO.setImg(mr.getFilesystemName("upfile"));
			//JSP에서 입력값을 보여주기위해 model에 VO를 넣는다.
			String rename=mr.getFilesystemName("upfile");
			if( rename == null && !"".equals(rename) ) {
				uiVO.setImg("basic.png");
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		ss.setComplete();
		session.invalidate();
		int cnt=us.addMember(uiVO);
		if( cnt == 1 ) {
			model.addAttribute("joinId", uiVO.getId());
			url="login/jsp/join_end";
		}
		return url;
	}
	
	/**
	 * 회원가입에서 메인페이지 이동
	 * @param ss
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/signUp4.do", method = GET)
	public String signUp4(SessionStatus ss, HttpSession session) {
		ss.isComplete();
		session.invalidate();
		return "redirect:user_mainhome.do";
	}
	
	/**
	 * 아이디 중복확인
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/duplChkId.do", method = POST)
	public String duplChkId(String id) {
		String jsonObj = us.searchDuplChkId(id);
		return jsonObj;
	}
	
	/**
	 * 닉네임 중복 확인
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "duplChkNick.do", method = POST)
	public String duplChkNick(String nick) {
		String jsonObj = us.searchDuplChkNick(nick);
		return jsonObj;
	}
	
	/**
	 * 아이디 찾기 페이지 이동
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/forgotId.do", method = GET)
	public String forgotUserId(HttpSession session) {
		session.invalidate();
		return "login/jsp/find_id";
	}
	
	/**
	 * 비밀번호 찾기 이동
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/forgotPw.do", method = GET)
	public String forgotUserPw(HttpSession session) {
		session.invalidate();
		return "login/jsp/find_pass";
	}
	
	/**
	 * 아이디찾기 팝업창
	 * @return
	 */
	@RequestMapping(value = "/forgotIdPop.do", method = GET)
	public String forgotIdPop() {
		return "login/jsp/find_id_popup";
	}
	
	/**
	 * 비밀번호찾기 팝업창
	 * @return
	 */
	@RequestMapping(value = "/forgotPwPop.do", method = GET)
	public String forgotPwPop() {
		return "login/jsp/find_pass_popup";
	}
	
	/**
	 * 아이디 찾기
	 * @param fiVO
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/forgotIdChk.do", method= POST) 
	public String forgotUserIdChk(ForgotIdVO fiVO, HttpSession session, String name, String birth, String phone) { 
		String id="";
		fiVO.setName(name);
		fiVO.setBirth(birth);
		fiVO.setPhone(phone);
		id=us.searchId(fiVO);
		session.setAttribute("findId", id);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("id", id);
		return jsonObj.toJSONString();
	}
	 
	
	/**
	 * 비밀번호 찾기
	 * @param fpVO
	 * @param session
	 * @param id
	 * @param name
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/forgotPwChk.do", method = POST)
	public String forgotUserPwChk(ForgotPwVO fpVO, HttpSession session, String id, String name, String phone) {
		String pass="";
		fpVO.setId(id);
		fpVO.setName(name);
		fpVO.setPhone(phone);
		pass=us.searchPw(fpVO);
		session.setAttribute("findPw", pass);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("pass", pass);
		return jsonObj.toJSONString();
	}
	
}//class
