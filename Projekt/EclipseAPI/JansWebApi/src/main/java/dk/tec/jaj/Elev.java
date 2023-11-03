package dk.tec.jaj;

public class Elev 
{
	int id;
	String name;
	String job;
	int shoe;
	
	public Elev(int id, String name, String job, int shoe) 
	{
		this.id = id;
		this.name = name;
		this.job = job;
		this.shoe = shoe;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
