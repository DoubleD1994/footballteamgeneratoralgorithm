package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public class PlayerSwapper implements PlayerSwap {

	private List<Team> newTeams;
	
	public List<Team> swapOnePlayerFromEachTeam(List<Team> theTeams) {
		Team teamOne = theTeams.get(0);
		Team teamTwo = theTeams.get(1);
		newTeams = new ArrayList<Team>();
		playersToSwapBetweenTeams(teamOne, teamTwo);
		return newTeams;
	}
	
	private void playersToSwapBetweenTeams(Team teamOne, Team teamTwo) {
		Player playerToSwapFromTeamOne = getPlayerInTeamToSwap(teamOne);
		Player playerToSwapFromTeamTwo = getPlayerInTeamToSwap(teamTwo);
		swapPlayersInTeam(teamOne, teamTwo, playerToSwapFromTeamOne, playerToSwapFromTeamTwo);
	}
	
	private Player getPlayerInTeamToSwap(Team theTeam) {
		Random rand = new Random();
		int randomPosition = rand.nextInt(theTeam.getTeamPlayers().size());
		return theTeam.getTeamPlayers().get(randomPosition);
	}
	
	private void swapPlayersInTeam(Team teamOne, Team teamTwo, Player teamOnePlayer, Player teamTwoPlayer) {
		teamOne.getTeamPlayers().remove(teamOnePlayer);
		teamTwo.getTeamPlayers().remove(teamTwoPlayer);
		teamOne.addTeamPlayer(teamTwoPlayer);
		teamTwo.addTeamPlayer(teamOnePlayer);
		newTeams.add(teamOne);
		newTeams.add(teamTwo);
	}

}
