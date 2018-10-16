package com.dryburghsoftware.footballteamsalgorithm.teams;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.players.PlayersGroup;

public class SplitGroupOfPlayersIntoTwoTeamsTest {

	private Player testPlayer;
	private PlayersGroup groupOfPlayers;
	private Team teamOne;
	private Team teamTwo;
	private GenerateTeams generateTeams;
	
	@Before
	public void setUp() throws Exception {
		testPlayer = new Player("John", 10, 10, 10, 10, 10);
		groupOfPlayers = new GroupOfPlayers();
		
		for(int i = 0; i<10; i++) {
			groupOfPlayers.addPlayerToPlayingGroup(testPlayer);
		}
		generateTeams = new TeamGenerator();
	}

	@Test
	public void test_TeamGeneratorCanCreateTwoTeams() {
		generateTeams.splitGroupOfPlayersIntoTeams(groupOfPlayers);
		teamOne = generateTeams.returnBothTeams().get(0);
		teamTwo = generateTeams.returnBothTeams().get(1);
		boolean result = (teamOne.getTeamPlayers().size() == 5) && (teamTwo.getTeamPlayers().size() == 5);
		assertTrue(result);
	}
}
