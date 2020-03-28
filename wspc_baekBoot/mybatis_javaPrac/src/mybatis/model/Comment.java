package mybatis.model;

import java.io.Serializable;
import java.util.Date;


//캐시 사용을 위해 Serializable 추가
// 캐시 사용여부에 따라 다른곳에 캐시를 사용할 경우에 클래스를 선안하는 곳에 serializable을 구현한다.
@SuppressWarnings("serial")
public class Comment implements Serializable{
	private Long commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	
	
	
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	

}
