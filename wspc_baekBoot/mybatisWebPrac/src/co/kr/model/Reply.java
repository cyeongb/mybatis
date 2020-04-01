package co.kr.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Reply implements Serializable{
	
	private long replyNo;
	private long commentNo;
	private String userId;
	private String replyContent;
	private Date regDate;
	
	
	public long getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(long replyNo) {
		this.replyNo = replyNo;
	}
	public long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
