package com.swq.BlogSystem.pojo;

public class CartDto extends Cart{
	
	private int pageIndex;
	private int pageSize;
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
		CartDto other = (CartDto) obj;
		if (pageIndex != other.pageIndex)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartDto [pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
	}
	

}
