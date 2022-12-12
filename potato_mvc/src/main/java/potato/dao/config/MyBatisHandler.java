package potato.dao.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *	MyBatis Handler를 반환하는 일. ( singleton pattern)
 * @author user
 */
public class MyBatisHandler {
	
	private static MyBatisHandler mbh;
	private static SqlSessionFactory ssf;
	
	private MyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	/**
	 * factory-method="getInstance"
	 * @return
	 */
	public static MyBatisHandler getInstance() {
		if(mbh==null) {
			mbh=new MyBatisHandler();
		}//end if
		return mbh;
	}//getInstance()
	
	private static SqlSessionFactory getSessionFactory() throws IOException {
		if( ssf == null ) {
			//1. 설정파일 연결
			String configPath="potato/dao/config/mybatis-config.xml";
			Reader reader=Resources.getResourceAsReader(configPath);
			//2. MyBatis Framework 생성
			//3. MyBatis Framework 할당
			ssf=new SqlSessionFactoryBuilder().build(reader);
			//3. 스트림 닫기
			if(reader != null) {
				reader.close();
			}//end if
		}//end if
		return ssf;
	}//getSessionFactory
	
	/**
	 * MyBatis Handler을 반환
	 * @return
	 */
	public SqlSession getHandler() {
		SqlSession session = null;
		
		try {
			session = getSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return session;
	}//getMyBatisHandler
	
	public void closeHandler(SqlSession session) {
		session.close();
	}//closeHandler
	
}
