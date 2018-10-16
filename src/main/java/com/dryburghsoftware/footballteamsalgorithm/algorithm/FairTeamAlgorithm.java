package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.GenerateTeams;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamGenerator;

public class FairTeamAlgorithm implements FairTeamSorter{

	private List<Team> theTeams;
	private double parentFitness;
	private double childFitness;
	
	private TeamGenerator teamGenerator;
	private TeamFitnessCalculator teamFitnessCalculator;
	
	public FairTeamAlgorithm() {
		teamGenerator = new GenerateTeams();
		teamFitnessCalculator = new FairTeamFitnessCalculator();
	}
	
	public List<Team> getFairTeams(GroupOfPlayers groupOfPlayers) {
		createTwoTeams(groupOfPlayers);
		parentFitness = teamFitnessCalculator.calculateDiferenceInTeamQuality(theTeams);
		swapOnePlayerFromEachTeam();
		return theTeams;
	}
	
	private void createTwoTeams(GroupOfPlayers groupOfPlayers) {
		teamGenerator.splitGroupOfPlayersIntoTeams(groupOfPlayers);
		theTeams = teamGenerator.returnBothTeams();
	}
	
	private void swapOnePlayerFromEachTeam() {
		Team teamOne = theTeams.get(0);
		Team teamTwo = theTeams.get(1);
		playerToSwap(teamOne, teamTwo);
	}
	
	private void playerToSwap(Team teamOne, Team teamTwo) {
		Random rand = new Random();
		int randomPositionInTeamOne = rand.nextInt(teamOne.getTeamPlayers().size());
		int randomPositionInTeamTwo = rand.nextInt(teamTwo.getTeamPlayers().size());
		Player playerToSwapFromTeamOne = teamOne.getTeamPlayers().get(randomPositionInTeamTwo);
		Player playerToSwapFromTeamTwo = teamTwo.getTeamPlayers().get(randomPositionInTeamOne);
		teamOne.addTeamPlayer(playerToSwapFromTeamTwo);
		teamOne.getTeamPlayers().remove(playerToSwapFromTeamOne);
		teamTwo.addTeamPlayer(playerToSwapFromTeamOne);
		teamTwo.getTeamPlayers().remove(playerToSwapFromTeamTwo);
		theTeams = new ArrayList();
		theTeams.add(teamOne);
		theTeams.add(teamTwo);
	}

}
