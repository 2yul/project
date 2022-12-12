package potato.manager.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.manager.vo.MgrPassChangeVO;

@Component
public class MgrPassChangeDAO {
	
	//비밀번호 변경
	public int updatePassword(MgrPassChangeVO mpcVO) {
		int cnt=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		cnt=session.update("potato.manager.mgrPassChangeMapper.updateMgrPass",mpcVO);
		
		if(cnt==1) {
			session.commit();
		}else {
			session.rollback();
		}
		
		mbh.closeHandler(session);
		
		return cnt;
	}//updatePassword
}
