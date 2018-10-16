package com.dryburghsoftware.footballteamsalgorithm.players;

import java.util.List;

public interface PlayersGroup {

	public void addPlayerToPlayingGroup(Player playingPlayer);
	
	public List<Player> getPlayingPlayers();
}
