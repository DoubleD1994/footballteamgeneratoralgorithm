package com.dryburghsoftware.footballteamsalgorithm.teams;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.PlayersGroup;

public interface GenerateTeams {

	public void splitGroupOfPlayersIntoTeams(PlayersGroup groupOfPlayers);
	
	public List<Team> returnBothTeams();
	
}
