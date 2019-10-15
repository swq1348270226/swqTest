package com.swq.BlogSystem.pojo;

import java.util.List;

public class Comment {
	private String commentId;
	private String bid;
	private String userId;
	private String sysuserId;
	private String score;
	private String comment;
	private String commentTime;
	private String parseCount;
	private String status;
	private List<Reply> replyList;
	
	
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getParseCount() {
		return parseCount;
	}
	public void setParseCount(String parseCount) {
		this.parseCount = parseCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((parseCount == null) ? 0 : parseCount.hashCode());
		result = prime * result + ((replyList == null) ? 0 : replyList.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Comment other = (Comment) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (parseCount == null) {
			if (other.parseCount != null)
				return false;
		} else if (!parseCount.equals(other.parseCount))
			return false;
		if (replyList == null) {
			if (other.replyList != null)
				return false;
		} else if (!replyList.equals(other.replyList))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "Comment [commentId=" + commentId + ", bid=" + bid + ", userId=" + userId + ", sysuserId=" + sysuserId
				+ ", score=" + score + ", comment=" + comment + ", commentTime=" + commentTime + ", parseCount="
				+ parseCount + ", status=" + status + ", replyList=" + replyList + "]";
	}
}
