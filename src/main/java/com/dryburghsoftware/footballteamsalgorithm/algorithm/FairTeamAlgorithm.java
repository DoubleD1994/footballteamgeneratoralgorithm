package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.teams.GenerateTeams;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamGenerator;

public class FairTeamAlgorithm implements fairTeamSorter{

	private List<Team> theTeams;
	
	private TeamGenerator teamGenerator;
	
	public FairTeamAlgorithm() {
		teamGenerator = new GenerateTeams();
	}
	
	public List<Team> getFairTeams(GroupOfPlayers groupOfPlayers) {
		createTwoTeams(groupOfPlayers);
		return theTeams;
	}
	
	private void createTwoTeams(GroupOfPlayers groupOfPlayers) {
		teamGenerator.splitGroupOfPlayersIntoTeams(groupOfPlayers);
		theTeams = teamGenerator.returnBothTeams();
	}

}
