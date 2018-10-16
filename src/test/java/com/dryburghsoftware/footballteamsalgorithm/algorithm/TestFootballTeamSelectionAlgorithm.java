package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public class TestFootballTeamSelectionAlgorithm {

	private GroupOfPlayers groupOfPlayers;
	private FairTeamSorter fairTeamAlgorithm;
	private TeamFitnessCalculator fairTeamFitnessCalculator;
	private Player john = new Player("John", 20, 20, 20, 20, 20);
	private Player steve = new Player("Steve", 20, 20, 20, 20, 20);
	
	@Before
	public void setUp() throws Exception {
		groupOfPlayers = new GroupOfPlayers();
		fairTeamAlgorithm = new FairTeamAlgorithm();
		fairTeamFitnessCalculator = new FairTeamFitnessCalculator();
		groupOfPlayers.addPlayerToPlayingGroup(john);
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Bob", 10, 10, 10, 10, 10));
		groupOfPlayers.addPlayerToPlayingGroup(steve);
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Rob", 10, 10, 10, 10, 10));		
	}

	@Test
	public void test_AlgorithmReturnsTwoTeams() {
		List<Team> theTeams = fairTeamAlgorithm.getFairTeams(groupOfPlayers);
		assertTrue(theTeams.size() == 2);
	}
	
	@Test
	public void test_AlgorithmCanGenerateFairTeams() {
		List<Team> theTeams = fairTeamAlgorithm.getFairTeams(groupOfPlayers);
		Team teamOne = theTeams.get(0);
		boolean result = !(teamOne.getTeamPlayers().contains(john) && teamOne.getTeamPlayers().contains(steve));
		assertTrue(result);
	}

}
