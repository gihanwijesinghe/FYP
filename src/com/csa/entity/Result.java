package com.csa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int resultmanId;
	String winningTeam;
	int wonByFirstBatOrSecondBat;
	boolean isDLmethod;
	int wonByRuns;
	int wonByWickets;
	
	String plyerOfTheMatch; 
	
	public String getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}

	public int getWonByFirstBatOrSecondBat() {
		return wonByFirstBatOrSecondBat;
	}

	public void setWonByFirstBatOrSecondBat(int wonByFirstBatOrSecondBat) {
		this.wonByFirstBatOrSecondBat = wonByFirstBatOrSecondBat;
	}

	public boolean isDLmethod() {
		return isDLmethod;
	}

	public void setDLmethod(boolean isDLmethod) {
		this.isDLmethod = isDLmethod;
	}

	public int getWonByRuns() {
		return wonByRuns;
	}

	public void setWonByRuns(int wonByRuns) {
		this.wonByRuns = wonByRuns;
	}

	public int getWonByWickets() {
		return wonByWickets;
	}

	public void setWonByWickets(int wonByWickets) {
		this.wonByWickets = wonByWickets;
	}

	public Result() {
		// TODO Auto-generated constructor stub
	}
}
