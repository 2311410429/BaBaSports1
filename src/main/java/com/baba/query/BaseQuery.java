package com.baba.query;

import com.baba.utils.Constants;

import java.io.Serializable;

/**
 * 条件对象公用对象
 */
public class BaseQuery implements Serializable{
	private static final long serialVersionUID = 1L;

	protected String fields;	//Sql查询字段

	protected int pageSize = Constants.PER_PAGE_SIZE;	//每页数
	protected int startRow; //起始行
	protected int pageNo = 1;	//页码


	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo-1)*this.pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public BaseQuery setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo-1)*this.pageSize;
		return this;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	

	
}
