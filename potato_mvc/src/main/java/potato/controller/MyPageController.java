package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.domain.UserDomain;
import potato.service.MyPageService;
import potato.service.UserService;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
@Controller
public class MyPageController {
	
	@Autowired(required = false)
	private MyPageService mps;
	@Autowired(required = false)
	private UserService us;
	//마이페이지 진입화면
	@RequestMapping(value="myPageIn.do", method=GET)
	public String myPageIn(HttpSession session,String pass, LoginVO LVO) {
		String url="mypages/jsp/mypage_in";
	
		  if(session.getAttribute("id")==null) {
			url="redirect:user_mainhome.do"; }
		return "mypages/jsp/mypage_in";
	}//myPageIn
	
	//아이디, 비밀번호 확인
	@RequestMapping(value="chkIdPass.do",method=POST)
	public String chkIdPass(HttpSession session, LoginVO LVO,Model model) {
		String result="redirect:myPageIn.do";
		LVO.setId((String)session.getAttribute("id"));
		int cnt = us.searchMember(LVO);
		if(  cnt == 1 ) {
			result= "redirect:my_info_edit.do";
		}else {
			session.setAttribute("passFlag", false);
		}
		return result;
	}//chkIdPass
	
	//내 정보 수정 폼
	//정보 수정페이지를 불러오는 메소드와 회원정보 수정을 처리해주는 메소드 두개로 만든다.
	//정보 수정이기 때문에 forward보다는 redirect로 처리하는 것이 좋다.
	@RequestMapping(value="my_info_edit.do",method = GET)
	public String myInfoEdit(HttpSession session, Model model) {
		
		model.addAttribute("MyInfoList", mps.searchInfo((String)session.getAttribute("id")));
		
		return "mypages/jsp/my_info_edit";
	}//myInfoEdit
	
	//내 정보 수정(처리) 기본이미지는 삭제되지 않게 처리하기
	@RequestMapping(value="my_info_edit_process.do",method = POST)
		public String myEditProcess(HttpSession session, MyPageMyInfoEditVO mieVO, Model model, HttpServletRequest request) {
		mieVO.setId((String)session.getAttribute("id"));
		
		
		File saveDir=new File("/home/ubuntu/potato_mvc/css/images/");
		int maxSize=1024*1024*20*20; // byte * kb * mb *gb
		//String responseURL="day1104/upload_err";
		try {
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(),maxSize, "UTF-8",
					new DefaultFileRenamePolicy() );
			String rename=mr.getFilesystemName("upfile");
			mieVO.setImg(mr.getFilesystemName("upfile"));
			mieVO.setBirth(mr.getParameter("birth"));
			mieVO.setEmail(mr.getParameter("email"));
			mieVO.setPhone(mr.getParameter("phone"));

			
			if( rename == null  ) {
				mieVO.setImg("basic.png");
			}
			mps.updateInfo(mieVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
			return "redirect:login_page.do";
	}//myInfoEditProcess
	
	//프로필 사진등록
	@RequestMapping(value = "addProfileImg.do",method=GET)
		public String addProfileImg(String string) {
			return "addProfileImg";
	}//addProfileImg
	
	//프로필 사진삭제
	@RequestMapping(value = "delProfileImg.do",method=GET)
		public String delProfileImg(String string) {
			return "delProfileImg";
	}//delProfileImg
	
	//비밀번호 수정 폼
	@RequestMapping(value="password_edit.do",method ={GET,POST})
		public String pwEdit(HttpSession session) {
			String url="login/jsp/login.jsp";
			
			if(session.getAttribute("id")==null) {
				url="forward:login_page.do"; 
			}
		
			return "mypages/jsp/password_edit";
	}//pwEdit
	
	//비밀번호 수정 처리
	@RequestMapping(value = "password_edit_process.do" ,method= {GET,POST})
		public String pwEditProcess(HttpSession session, MyPagePwEditVO peVO, Model model ) {
		peVO.setId((String)session.getAttribute("id"));
		int updateCnt=mps.modifyPw(peVO);
			model.addAttribute("updateCnt", updateCnt);
		
		return "forward:password_edit.do";
	}//pwEditProcess
	
	//회원 탈퇴 폼
	@RequestMapping(value = "unregister.do", method = GET)
		public String unregister(HttpSession session) {
		
			return "mypages/jsp/unregister";
	}//quit
	
	//회원 탈퇴 처리
	@RequestMapping(value = "unregister_process.do", method = POST)
		public String quitProcess(HttpSession session, MyPageQuitVO mqVO) {
		mqVO.setId((String)session.getAttribute("id"));
		String url="";
		int quitCount=mps.updateQuit(mqVO);
		
		session.setAttribute("quitCount", quitCount);
		return "redirect:unregister.do";
	}//quitProcess
	
	//회원 탈퇴 처리
	@RequestMapping(value = "unregister_process2.do", method = GET)
	public String quitProcess(HttpSession session) {
		session.invalidate();
		return "redirect:user_mainhome.do";
	}//quitProcess
	
	
	
	
	//즐겨찾기한 휴게소
	@RequestMapping(value = "bookmark.do", method=GET)
		public String bookmark(HttpSession session, Model model) {
		model.addAttribute("bookmarklist",mps.searchBookmark((String)session.getAttribute("id")));
		
		return "mypages/jsp/bookmark";
	}//bookmark
	
	//즐겨찾기한 휴게소 삭제
	@RequestMapping(value = "delBookmark.do", method=POST)
		public String delBookmark(HttpSession session,MyPageBookmarkVO bVO, Model model) {
			int cnt=mps.removeBookmark(session, bVO);
			model.addAttribute("delBookmark", cnt);
		return "redirect:bookmark.do";
	}//bookmark
	
	
}//class
