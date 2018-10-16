package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public class TestTeamFitnessCalculator {

	private TeamFitnessCalculator teamFitnessCalculator;
	private GroupOfPlayers groupOfPlayers;
	private FairTeamSorter fairTeamAlgorithm;
	
	@Before
	public void setUp() throws Exception {
		groupOfPlayers = new GroupOfPlayers();
		fairTeamAlgorithm = new FairTeamAlgorithm();
		teamFitnessCalculator = new FairTeamFitnessCalculator();
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Steve", 20, 20, 20, 20, 20));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Bob", 10, 10, 10, 10, 10));
	}

	@Test
	public void test_AlgorithmCanCalculateDifferenceBetweenTwoTeams() {
		List<Team> theTeams = fairTeamAlgorithm.getFairTeams(groupOfPlayers);
		double differenceInTeamOverall = teamFitnessCalculator.calculateDiferenceInTeamQuality(theTeams);
		assertTrue(differenceInTeamOverall == 50);
	}

}
