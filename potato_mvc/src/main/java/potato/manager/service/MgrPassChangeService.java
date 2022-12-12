package potato.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrPassChangeDAO;
import potato.manager.vo.MgrPassChangeVO;

@Component
public class MgrPassChangeService {
	
	@Autowired(required = false)
	private MgrPassChangeDAO mpcDAO;
	
	public int modifyPass(MgrPassChangeVO mpcVO) {
		int updateCnt=0;
		updateCnt=mpcDAO.updatePassword(mpcVO);
		return updateCnt;
	}
}
