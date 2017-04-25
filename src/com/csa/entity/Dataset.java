package com.csa.entity;

/**
 * Created by Gihan on 4/20/2017.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dataset {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int dataId;

    private int totalRuns;
    private double runRate;
    private int totalWickets;
    private String result;
    private int runsPowerPlay;
    private int wicketsPowerPlay;
    private int numOfDots;
    private int numOfFours;
    private int numOfSixes;
    private int dotsInPP;
    private int foursInPP;
    private int sixesInPP;

    public Dataset() {

    }


    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public double getRunRate() {
        return runRate;
    }

    public void setRunRate(double runRate) {
        this.runRate = runRate;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getRunsPowerPlay() {
        return runsPowerPlay;
    }

    public void setRunsPowerPlay(int runsPowerPlay) {
        this.runsPowerPlay = runsPowerPlay;
    }

    public int getWicketsPowerPlay() {
        return wicketsPowerPlay;
    }

    public void setWicketsPowerPlay(int wicketsPowerPlay) {
        this.wicketsPowerPlay = wicketsPowerPlay;
    }

    public int getNumOfDots() {
        return numOfDots;
    }

    public void setNumOfDots(int numOfDots) {
        this.numOfDots = numOfDots;
    }

    public int getNumOfFours() {
        return numOfFours;
    }

    public void setNumOfFours(int numOfFours) {
        this.numOfFours = numOfFours;
    }

    public int getNumOfSixes() {
        return numOfSixes;
    }

    public void setNumOfSixes(int numOfSixes) {
        this.numOfSixes = numOfSixes;
    }

    public int getDotsInPP() {
        return dotsInPP;
    }

    public void setDotsInPP(int dotsInPP) {
        this.dotsInPP = dotsInPP;
    }

    public int getFoursInPP() {
        return foursInPP;
    }

    public void setFoursInPP(int foursInPP) {
        this.foursInPP = foursInPP;
    }

    public int getSixesInPP() {
        return sixesInPP;
    }

    public void setSixesInPP(int sixesInPP) {
        this.sixesInPP = sixesInPP;
    }
}

