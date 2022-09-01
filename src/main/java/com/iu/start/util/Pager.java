package com.iu.start.util;

public class Pager {

	private Long page;
	private Long perPage;
	private Long perBlock;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	
	
	private String kind;
	private String search;
	
	private boolean pre;
	private boolean next;
	
	
	//생성자
	public Pager(){
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	
	public void getRow()throws Exception {
		this.startRow = (this.getPerPage() * this.getPage()) - (this.getPerPage()*1);
		this.lastRow = this.getPerPage() * this.getPage();
	}
	

	//총페이지,총블럭수,현재 블럭, 블럭시작번호, 블럭 끝번호, 이전&이후페이지
	public void getNum(Long totalCount)throws Exception {
		Long totalPage = (long)Math.ceil((double)totalCount/this.getPerPage());
		
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		Long totalBlock = (long) Math.ceil((double)totalPage/this.getPerBlock());
		Long curBlock = (long) Math.ceil((double)this.getPage()/this.getPerBlock());
		
		this.startNum = (curBlock*5) - 4;
		this.lastNum = curBlock*5;
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		if(curBlock > 1) {
			pre = true;
		}
		if(curBlock <totalBlock) {
			next = true;
		}
		
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
		lastNum = lastNum;
	}


	public Long getPage() {
		if(this.page ==null || this.page <= 0) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
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


	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search ="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}


	public boolean getPre() {
		return pre;
	}


	public void setPre(boolean pre) {
		this.pre = pre;
	}


	public boolean getNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}

	
}
