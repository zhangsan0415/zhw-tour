package com.zhw.response;

import java.util.List;

public class PageResult extends BaseResult{
	
	public static final int pageSize = 20;
	
	private int currentPage;
	
	private int totalPages;
	
	private PageResult(int status) {
		super(status);
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public PageResult setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public PageResult setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		return this;
	}


	public int getPageSize() {
		return pageSize;
	}
	
	public static int getStartNumber(int currentPage) {
		return (currentPage - 1)*pageSize;
	}

	public static int getEndNumber(int currentPage) {
		return currentPage*pageSize;
	}
	
	public static int evaluteTotalPages(int totalCount ) {
		return totalCount%pageSize == 0? totalCount/pageSize:(totalCount/pageSize+1);
	}
	
	public static PageResult getOkInstance() {
		return new PageResult(SUCCESS_STATUS).setTotalPages(1);
	}
	
	public static <T> PageResult getPageInstance(List<T> list,int currentPage,int totalCount) {
		return ((PageResult)getOkInstance().setObj(list)).setCurrentPage(currentPage).setTotalPages(evaluteTotalPages(totalCount));
	}

}
