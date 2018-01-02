package com.zhw.response;

public class PageResult extends BaseResult{
	
	private final int pageSize = 20;
	
	private int currentPage;
	
	private int totalPages;
	
	
	private PageResult(int status) {
		super(status);
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	public int getPageSize() {
		return pageSize;
	}
	

}
