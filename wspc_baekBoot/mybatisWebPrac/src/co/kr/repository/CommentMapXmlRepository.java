package co.kr.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.kr.model.Comment;

public class CommentMapXmlRepository extends AbstractRepository{
	
	private final String namespace="mybatisWebPrac.co.kr.repository.mapper.CommentMapper";
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement= null;
		
		try {
			statement = namespace + ".selectCommentByPrimaryKey";
			
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sqlSession.close();
		}
		return sqlSession.selectOne(statement , commentNo);
	}
	
	public List<Comment> selectCommentByCondition(Map<String, Object> condition){
		SqlSession sqlSession  = getSqlSessionFactory().openSession();
		String statement = null;
		
		try {
			statement = namespace + ".selectCommentByCondition";
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sqlSession.close();
		}
		return sqlSession.selectList(statement,condition);
	}

}
