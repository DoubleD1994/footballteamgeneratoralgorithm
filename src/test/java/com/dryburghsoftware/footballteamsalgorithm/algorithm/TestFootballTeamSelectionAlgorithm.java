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
	private fairTeamSorter fairTeamAlgorithm;
	
	
	
	@Before
	public void setUp() throws Exception {
		groupOfPlayers = new GroupOfPlayers();
		fairTeamAlgorithm = new FairTeamAlgorithm();
		groupOfPlayers.addPlayerToPlayingGroup(new Player("John", 20, 20, 20, 20, 20));
		for(int i=0; i<7; i++) {
			groupOfPlayers.addPlayerToPlayingGroup(new Player("Bob", 10, 10, 10, 10, 10));
		}
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Steve", 20, 20, 20, 20, 20));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Bob", 10, 10, 10, 10, 10));
		
	}

	@Test
	public void test_AlgorithmReturnsTwoTeams() {
		List<Team> theTeams = fairTeamAlgorithm.getFairTeams(groupOfPlayers);
		assertTrue(theTeams.size() == 2);
	}

}
