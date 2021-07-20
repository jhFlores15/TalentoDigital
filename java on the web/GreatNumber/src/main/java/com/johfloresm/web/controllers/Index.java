package com.johfloresm.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johfloresm.web.models.Generate;

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
	
		HttpSession session = request.getSession();
		String message = null;
		int attempts = 0;
		boolean isCorrect = false;
		String greatNumber = null;
		if(session.getAttribute("message") != null) {
			message = (String) session.getAttribute("message");
			attempts = Integer.parseInt((String) session.getAttribute("attempts")) ;
			greatNumber = (String) session.getAttribute("greatNumber");
			
			String result =  (String) session.getAttribute("isCorrect");
			isCorrect = result == "true" ? true : false;
		}
		
		request.setAttribute("message" , message);
		request.setAttribute("attempts" , attempts);
		request.setAttribute("greatNumber" , greatNumber);
		request.setAttribute("isCorrect" , isCorrect);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int attempts = 1;
		int numberUser = Integer.parseInt(request.getParameter("number"));
		if(session.getAttribute("greatNumber") == null || (String) session.getAttribute("isCorrect") == "true" ) {
			session.setAttribute("greatNumber",Integer.toString(Generate.numberInRange(1, 2)));
			session.setAttribute("attempts", "1");
		}
		else {
			attempts = Integer.parseInt((String) session.getAttribute("attempts"));
			if(attempts < 5 ) {
				session.setAttribute("attempts", Integer.toString(++attempts));
			}else {
				session.setAttribute("attempts", "1");
				session.setAttribute("greatNumber", Integer.toString(Generate.numberInRange(1, 2)));
			}
		}
		
		int greatNumber = Integer.parseInt((String) session.getAttribute("greatNumber"));
		
		if(numberUser == greatNumber) {
			session.setAttribute("message", greatNumber + " es el Número! Vuelve a Jugar!");
			session.setAttribute("isCorrect", "true");
		}
		else if(numberUser > greatNumber) {
			session.setAttribute("message", "Muy Alto!");	
			session.setAttribute("isCorrect", "false");
		}
		else {
			session.setAttribute("message", "Muy Bajo!");		
			session.setAttribute("isCorrect", "false");
		}
		
		
		doGet(request, response);
	}

}
