package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.PlayersGroup;
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
	
	public List<Team> getFairTeams(PlayersGroup groupOfPlayers) {
		createTwoTeams(groupOfPlayers);
		parentFitness = teamFitnessCalculator.calculateDiferenceInTeamQuality(theTeams);
		runAlgorithmUntilTeamsAreFair();
		return theTeams;
	}

	private void runAlgorithmUntilTeamsAreFair() {
		for(int i=0; i<1000; i++) {
			if(parentFitness >= 0 && parentFitness <= 2){ break; }
			swapPlayerAndCalculateFitnessOfNewTeam();
		}
	}

	private void swapPlayerAndCalculateFitnessOfNewTeam() {
		theTeams = playerSwap.swapOnePlayerFromEachTeam(theTeams);
		childFitness = teamFitnessCalculator.calculateDiferenceInTeamQuality(theTeams);
		isChildFitnessBetterThanParentFitness();
	}

	private void isChildFitnessBetterThanParentFitness() {
		if(childFitness < parentFitness) {
			parentFitness = childFitness;
		}
	}
	
	private void createTwoTeams(PlayersGroup groupOfPlayers) {
		teamGenerator.splitGroupOfPlayersIntoTeams(groupOfPlayers);
		theTeams = teamGenerator.returnBothTeams();
	}
}
