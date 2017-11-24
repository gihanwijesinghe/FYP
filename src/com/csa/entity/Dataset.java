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
    private double result;
    private int runsPowerPlay;
    private int wicketsPowerPlay;
    private int numOfDots;
    private int numOfFours;
    private int numOfSixes;
    private int dotsInPP;
    private int foursInPP;
    private int sixesInPP;
    private int numOfBowledDel;
    private int numOfCaughtDel;
    private int numOfRunOutDel;
    private int numOfStumpedDel;
    private int highIndvWickets;
    private int highIndvRuns;
    private int numOfThirties;
    private int numOfFifties;
    private int runsInMO;
    private int runsInDO;
    private int dotsInMO;
    private int dotsInDo;

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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
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

    public int getNumOfBowledDel() {
        return numOfBowledDel;
    }

    public void setNumOfBowledDel(int numOfBowledDel) {
        this.numOfBowledDel = numOfBowledDel;
    }

    public int getNumOfCaughtDel() {
        return numOfCaughtDel;
    }

    public void setNumOfCaughtDel(int numOfCaughtDel) {
        this.numOfCaughtDel = numOfCaughtDel;
    }

    public int getNumOfRunOutDel() {
        return numOfRunOutDel;
    }

    public void setNumOfRunOutDel(int numOfRunOutDel) {
        this.numOfRunOutDel = numOfRunOutDel;
    }

    public int getNumOfStumpedDel() {
        return numOfStumpedDel;
    }

    public void setNumOfStumpedDel(int numOfStumpedDel) {
        this.numOfStumpedDel = numOfStumpedDel;
    }

    public int getHighIndvWickets() {
        return highIndvWickets;
    }

    public void setHighIndvWickets(int highIndvWickets) {
        this.highIndvWickets = highIndvWickets;
    }

    public int getHighIndvRuns() {
        return highIndvRuns;
    }

    public void setHighIndvRuns(int highIndvRuns) {
        this.highIndvRuns = highIndvRuns;
    }

    public int getNumOfThirties() {
        return numOfThirties;
    }

    public void setNumOfThirties(int numOfThirties) {
        this.numOfThirties = numOfThirties;
    }

    public int getNumOfFifties() {
        return numOfFifties;
    }

    public void setNumOfFifties(int numOfFifties) {
        this.numOfFifties = numOfFifties;
    }

    public int getRunsInMO() {
        return runsInMO;
    }

    public void setRunsInMO(int runsInMO) {
        this.runsInMO = runsInMO;
    }

    public int getRunsInDO() {
        return runsInDO;
    }

    public void setRunsInDO(int runsInDO) {
        this.runsInDO = runsInDO;
    }

    public int getDotsInMO() {
        return dotsInMO;
    }

    public void setDotsInMO(int dotsInMO) {
        this.dotsInMO = dotsInMO;
    }

    public int getDotsInDo() {
        return dotsInDo;
    }

    public void setDotsInDo(int dotsInDo) {
        this.dotsInDo = dotsInDo;
    }
}

