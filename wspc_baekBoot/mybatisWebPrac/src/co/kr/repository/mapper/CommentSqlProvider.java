package co.kr.repository.mapper;

import java.util.Map;
import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;							
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;							
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;							
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;							
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;							



public class CommentSqlProvider {
	
	// 마이바티스에서는 sql을 작성할 때 sql예약어들을 자동으로 처리해주는 구문 빌더 API를 사용할 수 있다.
	// BEGIN , SELECT , FROM ...
	

	@SuppressWarnings("deprecation")
	public String selectCommentByCondition(Map<String, Object>condition) {
			
		BEGIN();
		SELECT("comment_no , user_id , comment_content , reg_Date");
		FROM("comment");
		WHERE("comment_no = #{commentNo}");
		return SQL();
	}

}
