package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.OverallCalculator;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamOverallCalculator;

public class TestFootballTeamSelectionAlgorithm {

	private GroupOfPlayers groupOfPlayers;
	private FairTeamSorter fairTeamAlgorithm;
	private Player john;
	private Player steve;
	private OverallCalculator teamOverallCalculator;
	
	@Before
	public void setUp() throws Exception {
		groupOfPlayers = new GroupOfPlayers();
		fairTeamAlgorithm = new FairTeamAlgorithm();
		teamOverallCalculator = new TeamOverallCalculator();
		
		groupOfPlayers.addPlayerToPlayingGroup(new Player("A", 20, 20, 20, 20, 20));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("B", 15, 15, 15, 15, 15));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("C", 20, 20, 20, 20, 20));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("D", 10, 10, 10, 10, 10));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("E", 15, 15, 15, 15, 15));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("F", 10, 10, 10, 10, 10));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("G", 5, 5, 5, 5, 5));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("H", 1, 1, 1, 1, 1));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("I", 5, 5, 5, 5, 5));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("J", 1, 1, 1, 1, 1));
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
		Team teamTwo = theTeams.get(1);
		boolean result = teamOverallCalculator.calculateTeamOverall(teamOne) == teamOverallCalculator.calculateTeamOverall(teamTwo);
		assertTrue(result);
	}
	
}
