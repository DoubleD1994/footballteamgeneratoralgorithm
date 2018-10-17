package com.dryburghsoftware.footballteamsalgorithm.teams;

import java.util.List;
import java.util.ArrayList;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;

public class Team {

	private String teamName;
	private List<Player> teamPlayers;
	
	public Team(String teamName) {
		super();
		this.teamName = teamName;
		this.teamPlayers = new ArrayList();
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getTeamPlayers() {
		return teamPlayers;
	}

	public void addTeamPlayer(Player player) {
		this.teamPlayers.add(player);
	}

	@Override
	public String toString() {
		return "\nteamName: " + teamName + "\nteamPlayers:\n" + teamPlayers;
	}
}
