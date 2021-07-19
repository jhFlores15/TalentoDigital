package com.johfloresm.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johfloresm.web.models.Word;

/**
 * Servlet implementation class Index
 */
@WebServlet("/")
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
		int counter = 0;
		Word word = null;
		if(session.getAttribute("counterWords") != null) {
			String ObjCounter = (String) session.getAttribute("counterWords");
			word = (Word) session.getAttribute("lastWord");
			counter = Integer.parseInt(ObjCounter);
		}
		
		request.setAttribute("counterWords", counter);	
		request.setAttribute("lastWord", (Word) session.getAttribute("lastWord"));	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 int contador = 1;
		 if(session.getAttribute("counterWords") == null) {
			 session.setAttribute("counterWords", "1");
		 }
		 else {
			 String counterWords = (String) session.getAttribute("counterWords");
			 contador = Integer.parseInt(counterWords);
			 session.setAttribute("counterWords", Integer.toString(++contador));
		 }
		 
		 Word word = new Word();		 
		 session.setAttribute("lastWord", word );
		 session.setAttribute("counterWords", Integer.toString(contador));		
		
		doGet(request, response);
	}

}
