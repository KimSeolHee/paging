package com.iu.start.util;

public class Pager {
	
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	private String kind;
	private String search;
	private boolean pre;
	private boolean next;
	
	public void getRow() {
		this.startRow = this.perPage * this.getPage()-(this.perPage-1);
		this.lastRow = this.perPage * this.getPage();
	}
	
	public void getNum(Long totalCount) {
		Long totalPage = (long) Math.ceil((double)totalCount/this.getPerPage());
		Long totalBlock = (long) Math.ceil((double)totalPage/this.getPerBlock());
		Long curBlock = (long) Math.ceil((double)this.getPage()/this.getPerBlock());
		
		this.startNum = this.perBlock * curBlock - 4;
		this.lastNum = this.perBlock * curBlock; 
			
		if(curBlock > 1) {
			this.pre = true;
		}
		if(curBlock < totalBlock) {
			this.next = true;
		}
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			this.setSearch("");
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		if(this.perBlock ==null) {
			this.perBlock = 5L;
		}
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
