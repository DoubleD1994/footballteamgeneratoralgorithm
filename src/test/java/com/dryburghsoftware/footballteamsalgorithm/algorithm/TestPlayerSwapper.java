package com.dryburghsoftware.footballteamsalgorithm.algorithm;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;

public class TestPlayerSwapper {

	private PlayerSwap playerSwapper;
	private Team teamOne;
	private Team teamTwo;
	
	private Player john;
	private Player steve;
	
	private List<Team> theTeams;
	
	@Before
	public void setUp() throws Exception {
		playerSwapper = new PlayerSwapper();
		steve = new Player("Steve", 20, 20, 20, 20, 20);
		john = new Player("John", 20, 20, 20, 20, 20);
		theTeams = new ArrayList<Team>();
		teamOne = new Team("Team One");
		teamTwo = new Team("Team Two");
		
		teamOne.addTeamPlayer(steve);
		teamTwo.addTeamPlayer(john);
		teamOne.addTeamPlayer(new Player("Bob", 10, 10, 10, 10, 10));
		teamTwo.addTeamPlayer(new Player("Bob", 10, 10, 10, 10, 10));
		
		theTeams.add(teamOne);
		theTeams.add(teamTwo);
	}

	@Ignore
	@Test
	public void test_PlayerSwapperCanSwapPlayersBetweenTeams() {
		theTeams = playerSwapper.swapOnePlayerFromEachTeam(theTeams);
		Team teamOne = theTeams.get(0);
		boolean result = !(teamOne.getTeamPlayers().contains(john) && teamOne.getTeamPlayers().contains(steve));
		assertTrue(result);
	}

}
