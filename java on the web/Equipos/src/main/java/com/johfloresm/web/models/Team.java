package com.johfloresm.web.models;

import java.util.ArrayList;

public class Team {
	int id;
	String name;
	ArrayList<Player> players = new ArrayList<Player>();
	static int lastId = 0;
	
	public Team(String name) {
		this.name = name;	
		this.id = ++lastId;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayers(Player player) {
		this.players.add(player);
	}

	public String getName() {
		return name;
	}
	
	public static int getLastId() {
		return lastId;
	}
	
	public int getId() {
		return id;
	}
	
	public void deletePlayer(int idPlayer ) {
		int index = this.getIndexPlayer(idPlayer);
		this.players.remove(index);
	}
	
	@SuppressWarnings("null")
	public int getIndexPlayer (int idPlayer) {
		for(int i=0; i< players.size();i++) {
			if(players.get(i).getId() == idPlayer) {
				return i;
			}
		}
		return (Integer) null;
	}
	
	public Player getPlayer(int idPlayer ) {
		int index = this.getIndexPlayer(idPlayer);
		return players.get(index);
	}
	
	
	
}
