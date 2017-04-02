package com.csa.entity;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int matchId;

	Date matchDate;
	int dayOrNight;
	boolean isDLMethod;

	String teamOne;
	String teamTwo;

	String umprie1;
	String umprie2;

	String tossWinningTeam;
	String tossDecision;

	String city;
	String venue;

	@OneToOne
	Innings firstInnings;

	@OneToOne
	Innings secondInnings;

	@OneToOne
	Result result;

	public MatchDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public int getDayOrNight() {
		return dayOrNight;
	}

	public void setDayOrNight(int dayOrNight) {
		this.dayOrNight = dayOrNight;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getUmprie1() {
		return umprie1;
	}

	public void setUmprie1(String umprie1) {
		this.umprie1 = umprie1;
	}

	public String getUmprie2() {
		return umprie2;
	}

	public void setUmprie2(String umprie2) {
		this.umprie2 = umprie2;
	}

	public String getTossWinningTeam() {
		return tossWinningTeam;
	}

	public void setTossWinningTeam(String tossWinningTeam) {
		this.tossWinningTeam = tossWinningTeam;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Innings getFirstInnings() {
		return firstInnings;
	}

	public void setFirstInnings(Innings firstInnings) {
		this.firstInnings = firstInnings;
	}

	public Innings getSecondInnings() {
		return secondInnings;
	}

	public void setSecondInnings(Innings secondInnings) {
		this.secondInnings = secondInnings;
	}

	/*public Innings getFirstInnings_pp() {
		return firstInnings_pp;
	}

	public void setFirstInnings_pp(Innings firstInnings) {
		this.firstInnings_pp = firstInnings;
	}

	public Innings getFirstInnings_middle() {
		return firstInnings_middle;
	}

	public void setFirstInnings_middle(Innings firstInnings) {
		this.firstInnings_middle = firstInnings;
	}

	public Innings getFirstInnings_death() {
		return firstInnings_death;
	}

	public void setFirstInnings_death(Innings firstInnings) {
		this.firstInnings_death = firstInnings;
	}

	public Innings getSecondInnings_pp() {
		return secondInnings_pp;
	}

	public void setSecondInnings_pp(Innings secondInnings) {
		this.secondInnings_pp= secondInnings;
	}

	public Innings getSecondInnings_middle() {
		return secondInnings_middle;
	}

	public void setSecondInnings_middle(Innings secondInnings) {
		this.secondInnings_middle= secondInnings;
	}

	public Innings getSecondInnings_death() {
		return secondInnings_death;
	}

	public void setSecondInnings_death(Innings secondInnings) {
		this.secondInnings_death = secondInnings;
	}*/


	public Result getResult() {
		return result;
	}

	public boolean isDLMethod() {
		return isDLMethod;
	}

	public void setDLMethod(boolean isDLMethod) {
		this.isDLMethod = isDLMethod;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
