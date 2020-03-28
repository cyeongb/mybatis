package mybatis.repository.session;

import java.io.*;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.model.Comment;


// ---------- 조회 매핑 구문에 사용하는 마이바티스 코드
public class CommentSessionRepository {                           
	
	private final String namespace="mybatis_javaPrac.mybatis.repository.mapper.CommentMapper";
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";   //클래스 패스를 기준으로 가장 상위에 있다.
		InputStream inputStream;
		
		try {
			inputStream=Resources.getResourceAsStream(resource);
			
		}catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
		//마이바티스 설정 정보를 가진 객체 생성 이 객체는 어플리케이션 내에서 한 개만 생성된다.
		return new SqlSessionFactoryBuilder().build(inputStream);
		
		
	}
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Comment comment = null;
		try {
			comment= sqlSession.selectOne(namespace+".selectCommentByPrimaryKey",commentNo);
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sqlSession.close();
		}
		return comment;
	}
	
	public List<Comment> selectCommentByCondition(Map<String, Object>condition){
		SqlSession sqlSession= getSqlSessionFactory().openSession();
		List list=null;
		
		
		try {
			list= sqlSession.selectList(namespace+".selectCommentByCondition",condition);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return list;
	}
	
	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result=0;
		try {
			
			String statement = namespace + ".insertComment";
			result = sqlSession.insert(statement,comment);
			
			if(result>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return result;
		
	}
	
	public Integer updateComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result=0;
		
		try {
			String statement = namespace + ".updateComment";
		 result = sqlSession.update(statement, comment);
			
			if(result>0) {
				sqlSession.commit();
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			sqlSession.close();
			
		}
		return result;
	}
	
	public Integer deleteComment(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result=0;
		
		try {
			String statement = namespace +".deleteComment";
			result = sqlSession.delete(statement,commentNo);
			if(result>0) {
				sqlSession.commit();
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
		
	}
	
	
	
	
	
	
	

}
