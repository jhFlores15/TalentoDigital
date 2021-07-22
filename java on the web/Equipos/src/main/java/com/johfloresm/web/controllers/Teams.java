package com.johfloresm.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johfloresm.web.models.Roster;
import com.johfloresm.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		Team team = null;
		if(request.getParameter("id") != null && session.getAttribute("rosters") != null) {
			Roster roster = (Roster) session.getAttribute("rosters");
			int id = Integer.parseInt(request.getParameter("id"));
			team = roster.getTeam(id);
			
		}		
		
		request.setAttribute("team" , team);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();	
		
		String name = (String) request.getParameter("name");
		Team team = new Team(name);
		Roster roster;
		
		if(session.getAttribute("rosters") == null) {
			roster = new Roster();
		}else {
			roster = (Roster) session.getAttribute("rosters");
		}
		
		roster.addTeams(team);
		session.setAttribute("rosters", roster);
		
		response.sendRedirect("Home");
	}

}
