package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.teams.GenerateTeams;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamGenerator;

public class FairTeamAlgorithm implements FairTeamSorter{

	private List<Team> theTeams;
	private double parentFitness;
	private double childFitness;
	
	private TeamGenerator teamGenerator;
	private TeamFitnessCalculator teamFitnessCalculator;
	private PlayerSwap playerSwap;
	
	public FairTeamAlgorithm() {
		teamGenerator = new GenerateTeams();
		teamFitnessCalculator = new FairTeamFitnessCalculator();
		playerSwap = new PlayerSwapper();
	}
	
	public List<Team> getFairTeams(GroupOfPlayers groupOfPlayers) {
		createTwoTeams(groupOfPlayers);
		parentFitness = teamFitnessCalculator.calculateDiferenceInTeamQuality(theTeams);
		theTeams = playerSwap.swapOnePlayerFromEachTeam(theTeams);
		return theTeams;
	}
	
	private void createTwoTeams(GroupOfPlayers groupOfPlayers) {
		teamGenerator.splitGroupOfPlayersIntoTeams(groupOfPlayers);
		theTeams = teamGenerator.returnBothTeams();
	}
}
