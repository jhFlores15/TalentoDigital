package com.johfloresm.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johfloresm.web.models.Roster;
import com.johfloresm.web.models.Team;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		Integer idTeam = null;
		if(session.getAttribute("rosters") != null && request.getParameter("idTeam") != null && request.getParameter("idPlayer") != null) {
			Roster roster = (Roster) session.getAttribute("rosters");
			idTeam = Integer.parseInt(request.getParameter("idTeam"));
			int idPlayer = Integer.parseInt(request.getParameter("idPlayer"));
			Team team = roster.getTeam(idTeam);
			team.deletePlayer(idPlayer);
			roster.replaceTeam(idTeam, team);
			session.setAttribute("rosters", roster);	
		}
		
		response.sendRedirect("Teams?id="+idTeam);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
