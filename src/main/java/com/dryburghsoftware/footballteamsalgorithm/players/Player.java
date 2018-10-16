package com.dryburghsoftware.footballteamsalgorithm.players;

public class Player {

	private String name;
	private int shooting, passing, tackling, pace, dribbling, overall;
	
	public Player(String name, int shooting, int passing, int tackling, int pace, int dribbling) {
		super();
		this.name = name;
		this.shooting = shooting;
		this.passing = passing;
		this.tackling = tackling;
		this.pace = pace;
		this.dribbling = dribbling;
		calculatePlayerOverall();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
		calculatePlayerOverall();
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
		calculatePlayerOverall();
	}

	public int getTackling() {
		return tackling;
	}

	public void setTackling(int tackling) {
		this.tackling = tackling;
		calculatePlayerOverall();
	}

	public int getPace() {
		return pace;
	}

	public void setPace(int pace) {
		this.pace = pace;
		calculatePlayerOverall();
	}

	public int getDribbling() {
		return dribbling;
	}

	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
		calculatePlayerOverall();
	}

	public int getOverall() {
		return overall;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", shooting=" + shooting + ", passing=" + passing + ", tackling=" + tackling
				+ ", pace=" + pace + ", dribbling=" + dribbling + "]";
	}
	
	private void calculatePlayerOverall() {
		 this.overall = this.shooting +
				 		this.tackling +
				 		this.passing +
				 		this.pace +
				 		this.dribbling;
	}
}
