package com.dryburghsoftware.footballteamsalgorithm.players;

import java.util.ArrayList;
import java.util.List;

public class GroupOfPlayers implements PlayersGroup{

	private List<Player> playingPlayers;
	
	public GroupOfPlayers() {
		playingPlayers = new ArrayList();
	}
	
	public void addPlayerToPlayingGroup(Player playingPlayer) {
		playingPlayers.add(playingPlayer);
	}
	
	public List<Player> getPlayingPlayers(){
		return playingPlayers;
	}
	
}
