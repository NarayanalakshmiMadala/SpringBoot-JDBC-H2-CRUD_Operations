package com.learning.jdbc;
public class CourceInfo 
{
	private Integer id;
	private String cname;
	private Integer courceFee;
	
	public CourceInfo()
	{
		super();
	}
	
	public CourceInfo(Integer id, String cname,Integer courceFee) {
		super();
		this.id = id;
		this.cname = cname;
		this.courceFee=courceFee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Integer getCourceFee() {
		return courceFee;
	}

	public void setCourceFee(Integer courceFee) {
		this.courceFee = courceFee;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", cname=" + cname + ", courceFee=" + courceFee + "]";
	}
}
