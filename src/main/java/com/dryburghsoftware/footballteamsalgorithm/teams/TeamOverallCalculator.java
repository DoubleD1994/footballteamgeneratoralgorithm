package com.dryburghsoftware.footballteamsalgorithm.teams;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;

public class TeamOverallCalculator implements OverallCalculator {

	public TeamOverallCalculator() {}
	
	public double calculateTeamOverall(Team team) {
		double teamTotalOverall = 0;
		for(Player player : team.getTeamPlayers()) {
			teamTotalOverall += player.getOverall();
		}
		return teamTotalOverall / team.getTeamPlayers().size();
	}	
}
