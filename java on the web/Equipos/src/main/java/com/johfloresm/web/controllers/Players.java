package com.johfloresm.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.johfloresm.web.models.Player;
import com.johfloresm.web.models.Roster;
import com.johfloresm.web.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idTeam = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("idTeam" , idTeam);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		

		String name = (String) request.getParameter("name");
		String lastName = (String) request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		int idTeam = Integer.parseInt(request.getParameter("idTeam"));
		
		Player player = new Player(name,lastName,age);
		
		Roster roster;
		
		if(session.getAttribute("rosters") == null) {
			roster = new Roster();
		}else {
			roster = (Roster) session.getAttribute("rosters");
		}
		
		Team team = roster.getTeam(idTeam);		
		team.addPlayers(player);
		
		roster.replaceTeam(idTeam, team);
		
		session.setAttribute("rosters", roster);
		
		response.sendRedirect("Teams?id="+idTeam);
	}

}
