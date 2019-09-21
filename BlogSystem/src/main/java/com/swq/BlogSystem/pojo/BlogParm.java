package com.swq.BlogSystem.pojo;

public class BlogParm  extends Blog{
	int pageIndex;
	int pageSize;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pageIndex;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogParm other = (BlogParm) obj;
		if (pageIndex != other.pageIndex)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BlogParm [pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
	}
	
}
