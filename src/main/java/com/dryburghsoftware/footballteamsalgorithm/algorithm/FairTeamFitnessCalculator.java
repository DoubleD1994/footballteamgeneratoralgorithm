package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.teams.OverallCalculator;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamOverallCalculator;

public class FairTeamFitnessCalculator implements TeamFitnessCalculator {

	private Team teamOne;
	private Team teamTwo;
	private OverallCalculator teamOverallCalculator;
	
	public FairTeamFitnessCalculator() {
		teamOverallCalculator = new TeamOverallCalculator();
	}
	
	public double calculateDiferenceInTeamQuality(List<Team> theTeams) {
		teamOne = theTeams.get(0);
		teamTwo = theTeams.get(1);
		return theDifferenceInTeamQuality();
	}
	
	private double theDifferenceInTeamQuality() {
		double teamOneOverall = teamOverallCalculator.calculateTeamOverall(teamOne);
		double teamTwoOverall = teamOverallCalculator.calculateTeamOverall(teamTwo);
		return (teamOneOverall > teamTwoOverall) ? teamOneOverall - teamTwoOverall : teamTwoOverall - teamOneOverall;
	}

}
