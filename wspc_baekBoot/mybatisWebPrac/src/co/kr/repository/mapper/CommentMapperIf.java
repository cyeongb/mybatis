package co.kr.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import co.kr.model.Comment;

public interface CommentMapperIf {
// 인터페이스만 사용하기
// 인터페이스에서는      >>>> 네임스페이스 = 패키지명 + 인터페이스이름
//	              >>>> 아이디 = 메서드 명
//	              >>>> resultType = 메서드 반환타입
//	              >>>> parametertype = 메서드 파라미터 타입

	// -----------------------------  어노테이션을 사용한 매핑
	@Select({ "select comment_no , user_id , comment_content , reg_date from  comment where comment_no = #{commentNo} "

	})
	Comment selectCommentByPrimaryKey(long commentNo);
	
	// provider로 조건에 따른 분기 처리하기
	// 어노테이션의  sql문은 조건에 따른 분기를 처리하기가 어렵다
	// 동적 sql을 만드는 다른 클래스와 메서드를 지정할 수 잇다.
	// 동적 sql을 만드는 자바 클래스는 CommentSqlProvider.class 이고 
	// 메서드를 실행한 결과물로 만들어지는 sql을 사용한다.

		@SelectProvider(type = CommentSqlProvider.class, method = "selectCommentByCondition")
		  List<Comment> selectCommentByCondition(Map<String, Object> condition);

}
