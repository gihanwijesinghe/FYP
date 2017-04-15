package com.csa.entity;

/**
 * Created by Gihan on 4/15/2017.
 */

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ball {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bowlId;

    private int matchId;
    private int runs;
    private String ballNo;
    private String wicketType;
    private int boundary;
   // private String nonStriker;
    //private int extras;


    @OneToOne
    private Player batsman;

    @OneToOne
    private Player bowler;

    public Ball() {
        // TODO Auto-generated constructor stub
    }

    public int getBowlId() {
        return bowlId;
    }

    public void setBowlId(int bowlId) {
        this.bowlId = bowlId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getBallNo() {
        return ballNo;
    }

    public void setBallNo(String ballNo) {
        this.ballNo = ballNo;
    }

    public String getWicketType() {
        return wicketType;
    }

    public void setWicketType(String wicketType) {
        this.wicketType = wicketType;
    }

    public int getBoundary() {
        return boundary;
    }

    public void setBoundary(int boundary) {
        this.boundary = boundary;
    }

//    public String getNonStriker() {
//        return nonStriker;
//    }
//
//    public void setNonStriker(String nonStriker) {
//        this.nonStriker = nonStriker;
//    }
//
//    public int getExtras() {
//        return extras;
//    }
//
//    public void setExtras(int extras) {
//        this.extras = extras;
//    }

    public Player getBatsman() {
        return batsman;
    }

    public void setBatsman(Player batsman) {
        this.batsman = batsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }
}