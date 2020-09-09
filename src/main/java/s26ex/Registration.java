package s26ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 SQL
     Table Services
     service_id INT service_name VARCHAR(30)
        33434      dentista
 JAVA
     JavaBean Service
         int id
         String name
     
     ServiceDAO
         getAll()
         
     ServiceReservationSvl
         DAO.getAll()
         
         serviceReservation.jsp HTML
     
     ServiceFilter su ServiceReservationSvl
         loggato OK
         altrimenti -> login
         
 
 
 */

/**
 * Servlet implementation class Registration
 */
@WebServlet("/s26ex/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 
	    
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
