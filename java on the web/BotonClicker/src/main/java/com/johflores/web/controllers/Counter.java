package com.johflores.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		 HttpSession session = request.getSession();
		 int contador = 0;
		 
		 if(session.getAttribute("countClicker") == null) {
			 session.setAttribute("countClicker", "0");
		 }
		 else {
			 String countClicker = (String) session.getAttribute("countClicker");
			 contador = Integer.parseInt(countClicker);
			 session.setAttribute("countClicker", Integer.toString(++contador));
		 }
		
        
    	request.setAttribute("countClicker", contador);		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Counter.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
