package dk.tec.jaj.example3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.DBTools;
import dk.tec.jaj.Elev;



public class JansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		PrintWriter out = response.getWriter();
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		ObjectMapper mapper = new ObjectMapper();
		
		DBTools db = new DBTools();
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			
			
			break;
		case MatchElev:
			
			
			break;
		case MatchNo:
			out.print("Ingen match");
		break;
		}
		
	}

	
	
}
