package com.dryburghsoftware.footballteamsalgorithm;

import java.util.List;

import com.dryburghsoftware.footballteamsalgorithm.algorithm.FairTeamAlgorithm;
import com.dryburghsoftware.footballteamsalgorithm.algorithm.FairTeamSorter;
import com.dryburghsoftware.footballteamsalgorithm.players.GroupOfPlayers;
import com.dryburghsoftware.footballteamsalgorithm.players.Player;
import com.dryburghsoftware.footballteamsalgorithm.players.PlayersGroup;
import com.dryburghsoftware.footballteamsalgorithm.teams.OverallCalculator;
import com.dryburghsoftware.footballteamsalgorithm.teams.Team;
import com.dryburghsoftware.footballteamsalgorithm.teams.TeamOverallCalculator;

public class App {
	
    public static void main( String[] args ){
    	
    	PlayersGroup groupOfPlayers = new GroupOfPlayers();
		FairTeamSorter fairTeamAlgorithm = new FairTeamAlgorithm();
		OverallCalculator overallCalculator = new TeamOverallCalculator();
		
		/**
		 * 
		 * Player constructor paramater order (name, shooting, passing, tackling, pace, dribbling).
		 * All scored out of 20	.
		 * 
		 * */
		
		groupOfPlayers.addPlayerToPlayingGroup(new Player("David", 13, 16, 12, 14, 15));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Blue", 9, 12, 16, 17, 10));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Grant", 12, 17, 12, 13, 15));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Liam", 18, 14, 14, 16, 18));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Parkin", 20, 14, 12, 12, 15));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Fester", 16, 10, 7, 17, 14));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Lumsden", 11, 11, 14, 7, 7));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Pip", 9, 8, 4, 3, 6));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Sean", 11, 9, 11, 8, 10));
		groupOfPlayers.addPlayerToPlayingGroup(new Player("Walker", 10, 14, 13, 7, 10));
		
		List<Team> theTeams = fairTeamAlgorithm.getFairTeams(groupOfPlayers);
		Team teamOne = theTeams.get(0);
		double teamOneOverall = overallCalculator.calculateTeamOverall(teamOne);
		Team teamTwo = theTeams.get(1);
		double teamTwoOverall = overallCalculator.calculateTeamOverall(teamTwo);
		
        System.out.println("Team One: " + teamOne + "\nTeam One Overall: " + teamOneOverall);
        System.out.println();
        System.out.println("v");
        System.out.println();
        System.out.println("Team Two: " + teamTwo + "\nTeam Two Overall: " + teamTwoOverall);
    }
}
