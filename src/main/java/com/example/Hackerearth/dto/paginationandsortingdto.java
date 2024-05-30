package com.example.Hackerearth.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class paginationandsortingdto {
	private List<propertiesofsellersdtowithsellerinfo> data;
	private int pageno;
	private int pagesize;
	private int totalresults;
	private String sortedvia;
	public paginationandsortingdto() {
		super();
	}
	public List<propertiesofsellersdtowithsellerinfo> getData() {
		return data;
	}
	public void setData(List<propertiesofsellersdtowithsellerinfo> data) {
		this.data = data;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalresults() {
		return totalresults;
	}
	public void setTotalresults(int totalresults) {
		this.totalresults = totalresults;
	}
	public String getSortedvia() {
		return sortedvia;
	}
	public void setSortedvia(String sortedvia) {
		this.sortedvia = sortedvia;
	}
}
