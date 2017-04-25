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

    public Dataset() {
        // TODO Auto-generated constructor stub
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
}

