package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public interface FairTeamSorter {

	public List<Team> getFairTeams(GroupOfPlayers groupOfPlayers);
	
}
