package co.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.kr.model.Comment;
import co.kr.repository.mapper.CommentMapperIf;

/* xml을 사용할 때와 차이점
 *  xml 사용 -> sqlSession 객체가 제공하는 메서드를 사용한다. 
 *  어노테이션 사용 -> sqlSession 객체가 제공하는 getMapper()를 사용해 인터페이스가 제공하는 메서드를 그대로 호출해서 사용.
 * 
 * */

public class CommentMapIfRepository extends AbstractRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentMapIfRepository.class);
	
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Comment result= null;
		
		try {
			result=sqlSession.getMapper(CommentMapperIf.class).selectCommentByPrimaryKey(commentNo);
			
		}catch(Exception e) {
			LOGGER.warn("{}:{}",e.getMessage(),e);
		}finally {
			sqlSession.close();
		}
		return result;	
	}
}
