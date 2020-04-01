package co.kr.repository;

import org.apache.ibatis.session.SqlSession;
import java.io.*;

import co.kr.model.Comment;

public class CommentSessionResultMapRepository extends AbstractRepository{
	private final String namespace="mybatisWebPrac.co.kr.repository.mapper.CommentMapperResultMap";
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		try {
			statement = namespace + ".selectCommentByPrimaryKey";
			
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sqlSession.close();
		}
		return sqlSession.selectOne(statement , commentNo);
	}
}
