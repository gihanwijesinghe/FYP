package com.csa.entity;

import java.util.HashMap;

import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Innings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int InningsId;

	@AttributeOverrides({
			@AttributeOverride(name = "teamId", column = @Column(name = "tea")),
			@AttributeOverride(name = "teamName", column = @Column(name = "tem")),
			@AttributeOverride(name = "captain", column = @Column(name = "cap")),
			@AttributeOverride(name = "wicketKeper", column = @Column(name = "wick")) })
	@OneToOne
	private Team battingTeam;

	@OneToOne
	private Team fieldingTeam;

	@OneToOne
	private Innings innings_pp;

	@OneToOne
	private Innings innings_middle;

	@OneToOne
	private Innings innings_death;

	public void setInnings_pp(Innings innings){
		this.innings_pp=innings;
	}

	public Innings getInnings_pp(){
		return innings_pp;
	}

	public void setInnings_middle(Innings innings){
		this.innings_middle=innings;
	}

	public Innings getInnings_middle(){
		return innings_middle;
	}

	public void setInnings_death(Innings innings){
		this.innings_death=innings;
	}

	public Innings getInnings_death(){
		return innings_death;
	}


	private double numberOfOvers;

	@ElementCollection

	private Map<Integer, BowlByBall> deliveries = new HashMap<Integer, BowlByBall>();

	private int numberOfWickets;

	private int numberOfRunsScored;

	private int numberOfExtras;

	private int inning;

	private int balls;

	private int segment;

	private double runrate;

	private boolean complete;

	public void setSegment(int b){
		this.segment=b;
	}

	public int getSegment(){
		return segment;
	}


	public void setComplete(boolean b){
		this.complete=b;
	}

	public boolean getComplete(){
		return complete;
	}

	public void setRunrate(double d){
		this.runrate=d;
	}

	public double getRunrate(){
		return runrate;
	}

	public void setBalls(int balls){
		this.balls=balls;
	}

	public int getBalls(){
		return balls;
	}

	public void setInning(int inn){
		this.inning=inn;
	}

	public int getInning(){
		return inning;
	}

	public Innings() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the battingTeam
	 */
	public Team getBattingTeam() {
		return battingTeam;
	}

	/**
	 * @param battingTeam
	 *            the battingTeam to set
	 */
	public void setBattingTeam(Team battingTeam) {
		this.battingTeam = battingTeam;
	}

	/**
	 * @return the fieldingTeam
	 */
	public Team getFieldingTeam() {
		return fieldingTeam;
	}

	/**
	 * @param fieldingTeam
	 *            the fieldingTeam to set
	 */
	public void setFieldingTeam(Team fieldingTeam) {
		this.fieldingTeam = fieldingTeam;
	}

	/**
	 * @return the numberOfOvers
	 */
	public double getNumberOfOvers() {
		return numberOfOvers;
	}

	/**
	 * @param numberOfOvers
	 *            the numberOfOvers to set
	 */
	public void setNumberOfOvers(double numberOfOvers) {
		this.numberOfOvers = numberOfOvers;
	}

	/**
	 * @return the deliveries
	 */
	public Map<Integer, BowlByBall> getDeliveries() {
		return deliveries;
	}

	/**
	 * @param deliveries
	 *            the deliveries to set
	 */
	public void setDeliveries(Map<Integer, BowlByBall> deliveries) {
		this.deliveries = deliveries;
	}

	public int getNumberOfWickets() {
		return numberOfWickets;
	}

	public void setNumberOfWickets(int numberOfWickets) {
		this.numberOfWickets = numberOfWickets;
	}

	public int getNumberOfRunsScored() {
		return numberOfRunsScored;
	}

	public void setNumberOfRunsScored(int numberOfRunsScored) {
		this.numberOfRunsScored = numberOfRunsScored;
	}

	public int getNumberOfExtras() {
		return numberOfExtras;
	}

	public void setNumberOfExtras(int numberOfExtras) {
		this.numberOfExtras = numberOfExtras;
	}

}
