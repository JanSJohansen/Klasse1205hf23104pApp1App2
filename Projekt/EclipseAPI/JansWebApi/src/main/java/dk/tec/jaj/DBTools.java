package dk.tec.jaj;

public class DBTools 
{
	private String conStr = 
			"jdbc:sqlserver://localhost:1433;databaseName=ElevDB;encrypt=true;trustServerCertificate=true";
	
	public DBTools()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.print("Driver loaded");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}