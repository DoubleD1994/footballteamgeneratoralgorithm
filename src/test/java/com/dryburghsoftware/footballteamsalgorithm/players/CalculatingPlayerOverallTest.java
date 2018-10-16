package com.dryburghsoftware.footballteamsalgorithm.players;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatingPlayerOverallTest {

	Player testPlayer;
	
	@Before
	public void setUp() throws Exception {
		testPlayer = new Player("David", 10, 10, 10, 10, 10);
	}
	
	@Test
	public void test_PlayerCanCalculateOverallWhenCreated() {
		assertTrue(testPlayer.getOverall() == 50);
	}
	
	@Test
	public void test_PlayerUpdatesOverallWhenStatUpdated() {
		testPlayer.setShooting(15);
		assertTrue(testPlayer.getOverall() == 55);
	}
	
	@Test
	public void test_PlayerUpdatesOverallWhenMultipleStatsUpdated() {
		testPlayer.setShooting(15);
		testPlayer.setTackling(15);
		testPlayer.setPace(20);
		testPlayer.setDribbling(15);
		testPlayer.setPassing(15);
		assertTrue(testPlayer.getOverall() == 80);
	}

}
