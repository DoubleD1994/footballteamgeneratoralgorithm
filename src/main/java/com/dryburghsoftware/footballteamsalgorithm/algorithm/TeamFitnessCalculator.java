package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public interface TeamFitnessCalculator {

	public double calculateDiferenceInTeamQuality(List<Team> theTeams);
	
}
