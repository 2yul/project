package potato.service;

import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.UserDAO;
import potato.domain.UserDomain;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;
import java.security.SecureRandom;
import java.util.Date;

/**
 * 유저 로그인/회원가입 관련 서비스
 * @author user
 */
@Component
public class UserService {
	
	@Autowired(required = false)
	private UserDAO uDAO;
	
	public int searchMember(LoginVO lVO) {
		int cnt= uDAO.selectLogin(lVO);
		return cnt;
	}
	
	/**
	 * 유저 로그인
	 * @param lVO
	 * @return
	 */
	public UserDomain searchMemberInfo(LoginVO lVO) {
		UserDomain ud = uDAO.selectLoginInfo(lVO);
		return ud;
	}
	
	/**
	 * 매니저 로그인
	 * @param mlVO
	 * @return
	 */
	public int searchManager(ManagerLoginVO mlVO) {
		int cnt=0;
		cnt=uDAO.selectManager(mlVO);
		return cnt;
	}
	
	/**
	 * 유저 회원가입
	 * @param uiVO
	 * @return
	 */
	public int addMember(UserInfoVO uiVO) {
		int cnt = 0;
		cnt=uDAO.insertMember(uiVO);
		return cnt;
	}
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 */
	public String searchDuplChkId(String id) {
		int cnt =0;
		cnt=uDAO.selectMDuplChkId(id);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("idCnt", cnt);
		return jsonObj.toJSONString();
	}
	
	/**
	 * 닉네임 중복확인
	 * @param nick
	 * @return
	 */
	public String searchDuplChkNick(String nick) {
		int cnt =0;
		cnt=uDAO.selectMDuplChkNick(nick);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("nickCnt", cnt);
		return jsonObj.toJSONString();
	}
	
	
	/**
	 * 아이디 찾기
	 * @param fiVO
	 * @return
	 */
	public String searchId(ForgotIdVO fiVO) { 
		String id="";
		id=uDAO.selectId(fiVO); 
		return id; 
	 }//searchId
	 
	/**
	 * 비밀번호 찾기
	 * @param fpVO
	 * @return
	 */
	public String searchPw(ForgotPwVO fpVO) {
		String temp=null;
		int cnt = 0;
		cnt=uDAO.selectPw(fpVO);
		if( cnt == 1 ) {
			UserService us = new UserService();
			temp=us.getRamdomPassword(10);
			fpVO.setTemp(temp);
			uDAO.updatePw(fpVO);
		}//end if
		return temp;
	}//searchPw
	
	/**
	 * 임시 비밀번호 만들기
	 * @param size
	 * @return
	 */
	public String getRamdomPassword(int size) {
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<size; i++) {
            // idx = (int) (len * Math.random());
            idx = sr.nextInt(len);    // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.
            sb.append(charSet[idx]);
        }

        return sb.toString();
    }//getRamdomPassword
	
}//class
