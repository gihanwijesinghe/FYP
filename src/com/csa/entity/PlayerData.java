package com.csa.entity;

/**
 * Created by Gihan on 4/20/2017.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int nu;

    private int playerId;
    private int runs;
    private int singles;
    private int fours;
    private int sixes;
    private int dotBalls;
    private double strikeRate;

    private int wickets;
    private int bowlingRuns;
    private int bowlingDots;
    private int bowlingSingles;
    private int bowlingFours;
    private int bowlingSixes;
    private int bowlingDeliveries;

    public PlayerData() {

    }


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getSingles() {
        return singles;
    }

    public void setSingles(int singles) {
        this.singles = singles;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getDotBalls() {
        return dotBalls;
    }

    public void setDotBalls(int dotBalls) {
        this.dotBalls = dotBalls;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getBowlingDots() {
        return bowlingDots;
    }

    public void setBowlingDots(int bowlingDots) {
        this.bowlingDots = bowlingDots;
    }

    public int getBowlingSingles() {
        return bowlingSingles;
    }

    public void setBowlingSingles(int bowlingSingles) {
        this.bowlingSingles = bowlingSingles;
    }

    public int getBowlingFours() {
        return bowlingFours;
    }

    public void setBowlingFours(int bowlingFours) {
        this.bowlingFours = bowlingFours;
    }

    public int getBowlingSixes() {
        return bowlingSixes;
    }

    public void setBowlingSixes(int bowlingSixes) {
        this.bowlingSixes = bowlingSixes;
    }

    public int getBowlingDeliveries() {
        return bowlingDeliveries;
    }

    public void setBowlingDeliveries(int bowlingDeliveries) {
        this.bowlingDeliveries = bowlingDeliveries;
    }

    public int getBowlingRuns() {
        return bowlingRuns;
    }

    public void setBowlingRuns(int bowlingRuns) {
        this.bowlingRuns = bowlingRuns;
    }

    public int getNu() {
        return nu;
    }

    public void setNu(int nu) {
        this.nu = nu;
    }
}

