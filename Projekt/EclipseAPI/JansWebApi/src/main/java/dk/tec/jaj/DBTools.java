package dk.tec.jaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools 
{
	private String conStr = 
			"jdbc:sqlserver://localhost:1433;databaseName=ElevDB;encrypt=true;trustServerCertificate=true";
	
	Connection con;
	Statement stmt;
	
	public DBTools()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.print("Driver loaded");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
    private void connect() 
    {
		try {
			con = DriverManager.getConnection(conStr, "sa", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public Elev getElevById(int id) 
	{
		connect();
		String sqlStr = "Select * from Elev where Id = " + id;
		
		Elev elev = new Elev();
		
		try {
			ResultSet result =  stmt.executeQuery(sqlStr);
			if(result.next())
			{
				elev.setId(result.getInt("Id"));
				elev.setName(result.getString("Name"));
				elev.setJob(result.getString("Job"));
				elev.setShoe(result.getInt("Shoe"));	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return elev;
	}

	
}