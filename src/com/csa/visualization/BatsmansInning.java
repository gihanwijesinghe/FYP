package com.csa.visualization;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sankha
 * 
 */
@Entity @Table(name="AllBatsman")
public class BatsmansInning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int battingInningsId;

	int matchId;
	String playerName;
	int battingPosition;
	int individualScore;
	int numberOfBowlsTaken;
	int numberOfDotBowls;
	int numberOfBoundries;
	int numberOfSixes;
	int firstInningsOrSecondInnings;
	String winOrLoss;

	// ArrayList<Integer> bowlByBowlScore = new ArrayList<Integer>();

	public int getBattingInningsId() {
		return battingInningsId;
	}

	public String getWinOrLoss() {
		return winOrLoss;
	}

	public void setWinOrLoss(String winOrLoss) {
		this.winOrLoss = winOrLoss;
	}

	public int getFirstInningsOrSecondInnings() {
		return firstInningsOrSecondInnings;
	}

	public void setFirstInningsOrSecondInnings(int firstInningsOrSecondInnings) {
		this.firstInningsOrSecondInnings = firstInningsOrSecondInnings;
	}

	public void setBattingInningsId(int battingInningsId) {
		this.battingInningsId = battingInningsId;
	}

	

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getBattingPosition() {
		return battingPosition;
	}

	public void setBattingPosition(int battingPosition) {
		this.battingPosition = battingPosition;
	}

	public int getIndividualScore() {
		return individualScore;
	}

	public void setIndividualScore(int individualScore) {
		this.individualScore = individualScore;
	}

	public int getNumberOfBowlsTaken() {
		return numberOfBowlsTaken;
	}

	public void setNumberOfBowlsTaken(int numberOfBowlsTaken) {
		this.numberOfBowlsTaken = numberOfBowlsTaken;
	}

	public int getNumberOfDotBowls() {
		return numberOfDotBowls;
	}

	public void setNumberOfDotBowls(int numberOfDotBowls) {
		this.numberOfDotBowls = numberOfDotBowls;
	}

	public int getNumberOfBoundries() {
		return numberOfBoundries;
	}

	public void setNumberOfBoundries(int numberOfBoundries) {
		this.numberOfBoundries = numberOfBoundries;
	}

	public int getNumberOfSixes() {
		return numberOfSixes;
	}

	public void setNumberOfSixes(int numberOfSixes) {
		this.numberOfSixes = numberOfSixes;
	}

	// public ArrayList<Integer> getBowlByBowlScore() {
	// return bowlByBowlScore;
	// }
	//
	// public void setBowlByBowlScore(ArrayList<Integer> bowlByBowlScore) {
	// this.bowlByBowlScore = bowlByBowlScore;
	// }

}
