package com.johfloresm.web.models;

import java.util.ArrayList;

public class Roster {	
	int id;
	ArrayList<Team> teams = new ArrayList<Team>();
	static int lastId = 0;
	
	public Roster() {
		this.id = ++lastId;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public static int getLastId() {
		return lastId;
	}
	
	public void addTeams(Team team) {
		this.teams.add(team);
	}
	
	public void deleteTeam(int idTeam ) {
		int index = this.getIndexTeam(idTeam);
		this.teams.remove(index);
	}
	
	@SuppressWarnings("null")
	public int getIndexTeam (int id) {
		for(int i=0; i< teams.size();i++) {
			if(teams.get(i).getId() == id) {
				return i;
			}
		}
		return (Integer) null;
	}
	
	public Team getTeam(int idTeam ) {
		int index = this.getIndexTeam(idTeam);
		return teams.get(index);
	}
	
	public void replaceTeam(int idTeam, Team team) {
		int index = this.getIndexTeam(idTeam);
		teams.set(index, team);
	}
	
}
