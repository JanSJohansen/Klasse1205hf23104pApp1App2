package dk.tec.jaj;

public class Elev 
{
	String name;
	String job;
	int shoe;
	
	public Elev(String name, String job, int shoe) 
	{	
		this.name = name;
		this.job = job;
		this.shoe = shoe;
	}
	public Elev() {	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getShoe() {
		return shoe;
	}
	public void setShoe(int shoe) {
		this.shoe = shoe;
	}
}
