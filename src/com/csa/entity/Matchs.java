package com.csa.entity;

/**
 * Created by Gihan on 4/15/2017.
 */

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Matchs {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int matchId;

    private Date matchDate;
    private String venue;
    private String outcome;
    private String umpireOne;
    private String umpireTwo;


//    @OneToOne
//    private
//    Player manOfMatch;

    @OneToOne
    private
    Team tossWin;

    @OneToOne
    private
    Team battingFirst;

    @OneToOne
    private
    Team battingSecond;

    @OneToOne
    private
    Team winner;

    public Matchs() {
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUmpireOne() {
        return umpireOne;
    }

    public void setUmpireOne(String umpireOne) {
        this.umpireOne = umpireOne;
    }

    public String getUmpireTwo() {
        return umpireTwo;
    }

    public void setUmpireTwo(String umpireTwo) {
        this.umpireTwo = umpireTwo;
    }

    public Team getTossWin() {
        return tossWin;
    }

    public void setTossWin(Team tossWin) {
        this.tossWin = tossWin;
    }

    public Team getBattingFirst() {
        return battingFirst;
    }

    public void setBattingFirst(Team battingFirst) {
        this.battingFirst = battingFirst;
    }

    public Team getBattingSecond() {
        return battingSecond;
    }

    public void setBattingSecond(Team battingSecond) {
        this.battingSecond = battingSecond;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

//    public Player getManOfMatch() {
//        return manOfMatch;
//    }
//
//    public void setManOfMatch(Player manOfMatch) {
//        this.manOfMatch = manOfMatch;
//    }
}
