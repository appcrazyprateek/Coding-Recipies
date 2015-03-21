package com.test2;
public class Emp {
	
	private Name name;
	private int  age;
	private long salary;
	
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Emp)
		{
			Emp e = (Emp) obj;
			Name name  = e.getName();
			if(name!=null && this.name!=null)
			{
				return this.name.equals(name);
			}
				return false;
		}
		return false;
	}
	
	
	public int getAge() {
		return age;
	}
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
}
