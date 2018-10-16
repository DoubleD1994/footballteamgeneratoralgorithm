package com.dryburghsoftware.footballteamsalgorithm.teams;

import java.util.ArrayList;
import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.players.PlayersGroup;

public class TeamGenerator implements GenerateTeams {

	private Team teamOne;
	private Team teamTwo;
	private List<Team> bothTeams;
	private int counter;
	
	public TeamGenerator() {
		super();
		counter = 0;
		this.teamOne = new Team("team one");
		this.teamTwo = new Team("team two");
		bothTeams = new ArrayList();
	}


	public void splitGroupOfPlayersIntoTeams(PlayersGroup groupOfPlayers) {
		for(Player player : groupOfPlayers.getPlayingPlayers()){
			addPlayerToTeam(player);
		}
	}
	
	public List<Team> returnBothTeams() {
		bothTeams.add(teamOne);
		bothTeams.add(teamTwo);
		return bothTeams;
	}

	private void addPlayerToTeam(Player player) {
		if(teamOneOrTeamTwo(counter)) {
			teamOne.addTeamPlayer(player);
		} else {
			teamTwo.addTeamPlayer(player);
		}
		counter++;
	}
	
	private boolean teamOneOrTeamTwo(int counter) {
		return counter % 2 == 0;
	}
}
