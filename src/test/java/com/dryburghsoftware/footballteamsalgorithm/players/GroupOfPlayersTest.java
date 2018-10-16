package com.dryburghsoftware.footballteamsalgorithm.players;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroupOfPlayersTest {
	
	private Player testPlayer;
	private PlayersGroup groupOfPlayers;
	
	@Before
	public void setUp() throws Exception {
		testPlayer = new Player("David", 10, 10, 10, 10, 10);
		groupOfPlayers = new GroupOfPlayers();
	}

	@Test
	public void test_addingPlayerToGroupOfPlayersPlaying() {
		groupOfPlayers.addPlayerToPlayingGroup(testPlayer);
		assertTrue(groupOfPlayers.getPlayingPlayers().contains(testPlayer));
	}
	
	@Test
	public void test_addingMultiplePlayersToGroupOfPlayersPlaying() {
		groupOfPlayers.addPlayerToPlayingGroup(testPlayer);
		groupOfPlayers.addPlayerToPlayingGroup(testPlayer);
		groupOfPlayers.addPlayerToPlayingGroup(testPlayer);
		assertTrue(groupOfPlayers.getPlayingPlayers().size() == 3);
	}

}
