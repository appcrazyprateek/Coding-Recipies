package com.ibibo;

/**
 * @author PRATEEK
 */
public class Student implements Comparable<Student>{

	private int rank;
	private int roll;
	private String name;
	private int maths;
	private int phy;
	private int chem;
	private int total;
	
	public Student(int roll, String name,int maths, int phy, int chem)
	{
		this.roll=roll;
		this.name=name;
		this.maths=maths;
		this.phy=phy;
		this.chem=chem;
		this.total = maths + phy + chem;
	}
	
	@Override
	public int hashCode() {
		return 100*maths + 10*phy + chem;
	}
	
	@Override
	public boolean equals(Object obj) {
	Student that = (Student)obj;
	
	if(this.maths == that.maths && this.phy == that.phy && this.chem == that.chem)
		return true;
	return false;
	}
	
	@Override
	public String toString(){
		return this.rank + "       " + this.roll + "      " + this.name + "        " + this.total+"      "+this.maths + "      " + this.phy + "      " + this.chem;
	}
	
	/**
	 * Descending order of students as per specification
	 */
	@Override
	public int compareTo(Student that)
	{
		if(this.total > that.total)
			return -1;
		else if(this.total < that.total)
			return 1;
		else //equal marks
		{
			if(this.maths > that.maths)
				return -1;
			else if(this.maths < that.maths)
				return 1;
			else //equal maths marks
			{
				if(this.phy > that.phy)
					return -1;
				else if(this.phy < that.phy)
					return 1;
				else //equal phy marks
				{
					if(this.chem > that.chem)
						return -1;
					else if(this.chem < that.chem)
						return 1;
					else //equal chem marks, everything equal
						return 0;
				}
			}
		}
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		this.phy = phy;
	}

	public int getChem() {
		return chem;
	}

	public void setChem(int chem) {
		this.chem = chem;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
