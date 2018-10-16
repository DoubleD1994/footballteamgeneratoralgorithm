package com.dryburghsoftware.footballteamsalgorithm.teams;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dryburghsoftware.footballteamsalgorithm.players.Player;

public class CalculateTeamsOverallTest {

	private Team teamOne;
	private OverallCalculator teamOverallCalculator;
	
	@Before
	public void setUp() throws Exception {
		teamOne = new Team("Team One");
		for(int i = 0; i<=5; i++) {
			teamOne.addTeamPlayer(new Player("John", 10, 10, 10, 10, 10));
		}
		teamOverallCalculator = new TeamOverallCalculator();
	}

	@Test
	public void test_TeamOverallCalculatorCanCalculateATeamsOverall() {
		double teamOverall = teamOverallCalculator.calculateTeamOverall(teamOne);
		assertTrue(teamOverall == 50);
	}

}
