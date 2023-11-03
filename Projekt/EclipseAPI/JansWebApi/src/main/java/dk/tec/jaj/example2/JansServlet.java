package dk.tec.jaj.example2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.Elev;


//@WebServlet("/Fisk")
public class JansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		PrintWriter out = response.getWriter();
	
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ArrayList<Elev> elever = new ArrayList<Elev>();
		elever.add(new Elev(0,"Anders", "Tagfejer og alt muligt", 47));
		elever.add(new Elev(1, "Marco", "Hals og næse kommunearbejder og fisker", 47));
		elever.add(new Elev(2,"Jimmy", "Lokums- og tastatur-renser", 39));
		elever.add(new Elev(3, "Anna", "Morderserier Kill Bill", 36));
		elever.add(new Elev(4, "Philip", "Gadefejer og andet", 32));
		elever.add(new Elev(5, "Frederik", "Omsorgsmedarbejerpraktikantaspirant", 56));
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			//out.print("Match på Elev med Id: " + analyze.getId());
			
			Elev e = elever.get(analyze.getId());
			String json = mapper.writeValueAsString(e);
			out.print(json);
			
			break;
		case MatchElev:
			//out.print("Match på Elev");
			
			out.print(mapper.writeValueAsString(elever));
			
			break;
		case MatchNo:
			out.print("Ingen match");
		break;
		}
		
	}

	
	
}
