package infoUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String favoriteLanguaje = request.getParameter("favoriteLanguaje");
		String homeTown = request.getParameter("homeTown");
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String htmlOut = "<h1>Welcome, " + getParameter(firstName) +" "+ getParameter(lastName) +"</h1>";
        htmlOut+= "<p> Your favorite languaje is: "+ getParameter(favoriteLanguaje) +"</p><br>";
        htmlOut+= "<p> Your Hometown is: "+ getParameter(homeTown) +"</p";
        
        out.write(htmlOut);
	}
	
	private String getParameter(String parameter) {
		return (parameter != null) ? parameter : "Unknown";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
