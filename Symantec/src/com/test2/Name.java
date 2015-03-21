package com.test2;

public class Name {
	private String fname;
	private String last;
	
	@Override
	public int hashCode() {
		return this.fname.hashCode() + this.last.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Emp)
		{
			Name e = (Name) obj;
			return this.fname.equals(e.fname) && this.last.equals(e.last) || 
					this.fname.equals(e.last) && this.last.equals(e.fname);
		}
		return false;
		
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
}
