package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble {
	private Integer page;
	private Integer maxPageItem;
	private Sorter Sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.Sorter = sorter;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getOffset() {
		if(this.page != null && this.maxPageItem != null){
			return (this.page - 1) * this.maxPageItem;
		}
		else
			return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}

	public Sorter getSorter() {
		if(this.Sorter != null)
			return this.Sorter;
		return null;
	}

	public Integer getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSorter(Sorter sorter) {
		this.Sorter = sorter;
	}

}
