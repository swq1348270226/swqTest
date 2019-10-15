package com.swq.BlogSystem.pojo;

public class Blog {
	
	private String bid;
	private String content;
	private String contentTxt;
	private String title;
	private String type;
	private String commit;
	private String comitTime;
	private String lastUpdateBy;
	private String isDelete;
	private String visitCount;
	private String collectionCount;
	private String commentCount;
	private String fever;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFever() {
		return fever;
	}
	public void setFever(String fever) {
		this.fever = fever;
	}
	public String getContentTxt() {
		return contentTxt;
	}
	public void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public String getComitTime() {
		return comitTime;
	}
	public void setComitTime(String comitTime) {
		this.comitTime = comitTime;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(String visitCount) {
		this.visitCount = visitCount;
	}
	public String getCollectionCount() {
		return collectionCount;
	}
	public void setCollectionCount(String collectionCount) {
		this.collectionCount = collectionCount;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((collectionCount == null) ? 0 : collectionCount.hashCode());
		result = prime * result + ((comitTime == null) ? 0 : comitTime.hashCode());
		result = prime * result + ((commentCount == null) ? 0 : commentCount.hashCode());
		result = prime * result + ((commit == null) ? 0 : commit.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((contentTxt == null) ? 0 : contentTxt.hashCode());
		result = prime * result + ((fever == null) ? 0 : fever.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((lastUpdateBy == null) ? 0 : lastUpdateBy.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((visitCount == null) ? 0 : visitCount.hashCode());
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
		Blog other = (Blog) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (collectionCount == null) {
			if (other.collectionCount != null)
				return false;
		} else if (!collectionCount.equals(other.collectionCount))
			return false;
		if (comitTime == null) {
			if (other.comitTime != null)
				return false;
		} else if (!comitTime.equals(other.comitTime))
			return false;
		if (commentCount == null) {
			if (other.commentCount != null)
				return false;
		} else if (!commentCount.equals(other.commentCount))
			return false;
		if (commit == null) {
			if (other.commit != null)
				return false;
		} else if (!commit.equals(other.commit))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (contentTxt == null) {
			if (other.contentTxt != null)
				return false;
		} else if (!contentTxt.equals(other.contentTxt))
			return false;
		if (fever == null) {
			if (other.fever != null)
				return false;
		} else if (!fever.equals(other.fever))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (lastUpdateBy == null) {
			if (other.lastUpdateBy != null)
				return false;
		} else if (!lastUpdateBy.equals(other.lastUpdateBy))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (visitCount == null) {
			if (other.visitCount != null)
				return false;
		} else if (!visitCount.equals(other.visitCount))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", content=" + content + ", contentTxt=" + contentTxt + ", title=" + title
				+ ", type=" + type + ", commit=" + commit + ", comitTime=" + comitTime + ", lastUpdateBy="
				+ lastUpdateBy + ", isDelete=" + isDelete + ", visitCount=" + visitCount + ", collectionCount="
				+ collectionCount + ", commentCount=" + commentCount + ", fever=" + fever + "]";
	}
	
	
}
