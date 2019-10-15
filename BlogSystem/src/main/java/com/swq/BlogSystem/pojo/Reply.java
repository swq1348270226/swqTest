package com.swq.BlogSystem.pojo;

public class Reply {
	private String commentId;
	private String replyId;
	private String userId;
	private String sysuserId;
	private String content;
	private String praseCount;
	private String replyTime;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSysuserId() {
		return sysuserId;
	}
	public void setSysuserId(String sysuserId) {
		this.sysuserId = sysuserId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPraseCount() {
		return praseCount;
	}
	public void setPraseCount(String praseCount) {
		this.praseCount = praseCount;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((praseCount == null) ? 0 : praseCount.hashCode());
		result = prime * result + ((replyId == null) ? 0 : replyId.hashCode());
		result = prime * result + ((replyTime == null) ? 0 : replyTime.hashCode());
		result = prime * result + ((sysuserId == null) ? 0 : sysuserId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (praseCount == null) {
			if (other.praseCount != null)
				return false;
		} else if (!praseCount.equals(other.praseCount))
			return false;
		if (replyId == null) {
			if (other.replyId != null)
				return false;
		} else if (!replyId.equals(other.replyId))
			return false;
		if (replyTime == null) {
			if (other.replyTime != null)
				return false;
		} else if (!replyTime.equals(other.replyTime))
			return false;
		if (sysuserId == null) {
			if (other.sysuserId != null)
				return false;
		} else if (!sysuserId.equals(other.sysuserId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reply [commentId=" + commentId + ", replyId=" + replyId + ", userId=" + userId + ", sysuserId="
				+ sysuserId + ", content=" + content + ", praseCount=" + praseCount + ", replyTime=" + replyTime + "]";
	}
	
}
