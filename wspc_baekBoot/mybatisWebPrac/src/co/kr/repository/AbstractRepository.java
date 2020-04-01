package co.kr.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AbstractRepository {
	private static SqlSessionFactory sqlSessionFactory;
		
		static {
			setSqlSessionFactory();
		}
		
		private static void setSqlSessionFactory() {
			String resource="mybatis-config.xml";   //클래스 패스를 기준으로 가장 상위에 있다.
			InputStream inputStream;
		
		try {
			inputStream=Resources.getResourceAsStream(resource);
			
		}catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
		//마이바티스 설정 정보를 가진 객체 생성 이 객체는 어플리케이션 내에서 한 개만 생성된다.
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		}
		
		protected SqlSessionFactory getSqlSessionFactory() {
			return sqlSessionFactory;
		}
		
	
}
