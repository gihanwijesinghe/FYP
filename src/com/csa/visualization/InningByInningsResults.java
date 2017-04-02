package com.csa.visualization;

import javax.persistence.*;

@MappedSuperclass
public abstract class InningByInningsResults {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int inningsId;
	@GeneratedValue(strategy = GenerationType.AUTO)
	int matchId;

	int firstInningsOrSecondInnings;

	// Double dotBallPresentage_1_6;
	// Double dotBallPresentage_7_15;
	// Double dotBallPresentage_16_20;
	// Double sixHitingPresentage_1_6;
	// Double sixHitingPresentage_7_15;
	// Double sixHitingPresentage_16_20;
	// Double fourHitingPresentage_1_6;
	// Double fourHitingPresentage_7_15;
	// Double fourHitingPresentage_16_20;
	// Double runRate_1_6;
	// Double runRate_7_15;
	// Double runRate_16_20;
	int numberOfBattingSegments;
	Double avgRunsInBattingSegment; // totalRuns/numberOfSegments
	Double avgMeanRunsInBattingSegment; // (runsInTheSegment/numberOfBowls)+(runsInTheSegment/numberOfBowls)+(runsInTheSegment/numberOfBowls)...
	Double avgPressureFactor; // runs/dot ball number+1
	Double dotBowlPrerentage;
	int numberOfWicketsLost;
	Double sixHittingFrequency;
	Double fourHittingFrequency;
	Double BoundaryRunsPresentage;
	Double dotBowlToRunsRatio;
	String winOrLoss;
	int balls;
	boolean complete;
	int segment;
	Double runrate;
	public int totalRuns;

	public void setRunRate(double d){
		this.runrate=d;
	}

	public double getRunRate(){
		return runrate;
	}

	public void setComplete(boolean b){
		this.complete=b;
	}

	public boolean getComplete(){
		return complete;
	}

	public void setSegment(int b){
		this.segment=b;
	}

	public int getSegment(){
		return segment;
	}

	public void setBalls(int balls){
		this.balls=balls;
	}

	public int getBalls(){
		return balls;
	}

	public Double getSixHittingFrequency() {
		return sixHittingFrequency;
	}

	public void setSixHittingFrequency(Double sixHittingFrequency) {
		this.sixHittingFrequency = sixHittingFrequency;
	}

	public Double getFourHittingFrequency() {
		return fourHittingFrequency;
	}

	public void setFourHittingFrequency(Double fourHittingFrequency) {
		this.fourHittingFrequency = fourHittingFrequency;
	}

	public Double getBoundaryRunsPresentage() {
		return BoundaryRunsPresentage;
	}

	public void setBoundaryRunsPresentage(Double boundaryRunsPresentage) {
		BoundaryRunsPresentage = boundaryRunsPresentage;
	}

	public Double getDotBowlToRunsRatio() {
		return dotBowlToRunsRatio;
	}

	public void setDotBowlToRunsRatio(Double dotBowlToRunsRatio) {
		this.dotBowlToRunsRatio = dotBowlToRunsRatio;
	}

	public int getNumberOfWicketsLost() {
		return numberOfWicketsLost;
	}

	public void setNumberOfWicketsLost(int numberOfWicketsLost) {
		this.numberOfWicketsLost = numberOfWicketsLost;
	}

	public Double getDotBowlPrerentage() {
		return dotBowlPrerentage;
	}

	public void setDotBowlPrerentage(Double dotBowlPrerentage) {
		this.dotBowlPrerentage = dotBowlPrerentage;
	}

	public Double getAvgMeanRunsInBattingSegment() {
		return avgMeanRunsInBattingSegment;
	}

	public void setAvgMeanRunsInBattingSegment(
			Double avgMeanRunsInBattingSegment) {
		this.avgMeanRunsInBattingSegment = avgMeanRunsInBattingSegment;
	}

	public int getNumberOfBattingSegments() {
		return numberOfBattingSegments;
	}

	public void setNumberOfBattingSegments(int numberOfBattingSegments) {
		this.numberOfBattingSegments = numberOfBattingSegments;
	}

	public Double getAvgRunsInBattingSegment() {
		return avgRunsInBattingSegment;
	}

	public void setAvgRunsInBattingSegment(Double avgRunsInBattingSegment) {
		this.avgRunsInBattingSegment = avgRunsInBattingSegment;
	}

	public Double getAvgPressureFactor() {
		return avgPressureFactor;
	}

	public void setAvgPressureFactor(Double avgPressureFactor) {
		this.avgPressureFactor = avgPressureFactor;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getFirstInningsOrSecondInnings() {
		return firstInningsOrSecondInnings;
	}

	public void setFirstInningsOrSecondInnings(int firstInningsOrSecondInnings) {
		this.firstInningsOrSecondInnings = firstInningsOrSecondInnings;
	}

	public String getWinOrLoss() {
		return winOrLoss;
	}

	public void setWinOrLoss(String winOrLoss) {
		this.winOrLoss = winOrLoss;
	}

	public InningByInningsResults() {
		// TODO Auto-generated constructor stub
	}

}
