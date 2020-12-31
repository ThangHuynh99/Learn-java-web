package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private long[] ids;
	private List<T> listResult = new ArrayList<>(); 
	private Integer page;// page dang hien thi
	private Integer maxPageItem;// tong so page hien thi
	private Integer totalPage;// tong so page
	private Integer totalItems;
	private String sortName;
	private String sortBy;
	
	public List<T> getListResult() {
		return listResult;
	}


	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}


	public long[] getIds() {
		return ids;
	}


	public void setIds(long[] ids) {
		this.ids = ids;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public Timestamp getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getMaxPageItem() {
		return maxPageItem;
	}


	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public Integer getTotalItems() {
		return totalItems;
	}


	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}


	public String getSortBy() {
		return sortBy;
	}


	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}


	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	

}
