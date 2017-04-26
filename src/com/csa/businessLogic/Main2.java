package com.csa.businessLogic;

import com.csa.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gihan on 4/20/2017.
 */

public class Main2 {
    final static double WON = 1;
    final static double LOSE = 0;
    final static double DRAW = 0.5;

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        long count = (long) session.createQuery("select count(*) from  Matchs").getSingleResult();

        for (int i = 1; i < count + 1; i++) {
            insertDataSet(session, i);

        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static void insertDataSet(Session session, int matchId) {
        Dataset inn1 = new Dataset();
        Dataset inn2 = new Dataset();
        List<Ball> inn1PowerPlay = new ArrayList<>();
        List<Ball> inn2PowerPlay = new ArrayList<>();

        Query query1 = session.createQuery("from Matchs where matchId = :name ");
        query1.setParameter("name", matchId);
        List<Matchs> list1 = query1.list();

        Query query = session.createQuery("from Ball bb where bb.match.matchId = :name ");
        query.setParameter("name", matchId);
        List<Ball> list = query.list();
        int inn1TotalRuns, inn2TotalRuns = 0;
        int inn1TotalWickets = 0, inn2TotalWickets = 0;
        int inn1NumOfDots = 0, inn2NumOfDots = 0;
        int inn1NumOfFours = 0, inn2NumOfFours = 0;
        int inn1NumOfSixes = 0, inn2NumOfSixes = 0;
        inn1TotalRuns = list.get(0).getRuns();
        if (list.get(0).getWicketType() != null) {
            inn1TotalWickets++;
        }
        if (list.get(0).getRuns() == 0) {
            inn1NumOfDots++;
        }
        if (list.get(0).getRuns() == 4) {
            inn1NumOfFours++;
        }
        if (list.get(0).getRuns() == 6) {
            inn1NumOfSixes++;
        }
        int i, j;
        int break1 = 0, break2 = 0;
        for (i = 1; !list.get(i).getBallNo().equals("0.1"); i++) {
            if (Double.parseDouble(list.get(i).getBallNo()) <= 6.1) {
                break1 = i;
            }
            inn1TotalRuns = inn1TotalRuns + list.get(i).getRuns();
            if (list.get(i).getWicketType() != null) {
                inn1TotalWickets++;
            }
            if(list.get(i).getRuns() == 0) {
                inn1NumOfDots++;
            }
            if(list.get(i).getRuns() == 4) {
                inn1NumOfFours++;
            }
            if(list.get(i).getRuns() == 6) {
                inn1NumOfSixes++;
            }
        }
        double inn1RunRate = getRunRate(inn1TotalRuns, list.get(i - 1).getBallNo());
        inn1.setTotalRuns(inn1TotalRuns);
        inn1.setRunRate(inn1RunRate);
        inn1.setTotalWickets(inn1TotalWickets);
        inn1.setNumOfDots(inn1NumOfDots);
        inn1.setNumOfFours(inn1NumOfFours);
        inn1.setNumOfSixes(inn1NumOfSixes);
        inn1.setRunsPowerPlay(powerPlay(list.subList(0, break1))[0]);
        inn1.setWicketsPowerPlay(powerPlay(list.subList(0, break1))[1]);
        inn1.setDotsInPP(powerPlay(list.subList(0, break1))[2]);
        inn1.setFoursInPP(powerPlay(list.subList(0, break1))[3]);
        inn1.setSixesInPP(powerPlay(list.subList(0, break1))[4]);

        for (j = i; j < list.size(); j++) {
            if (Double.parseDouble(list.get(j).getBallNo()) <= 6.1) {
                break2 = j;
            }
            inn2TotalRuns = inn2TotalRuns + list.get(j).getRuns();
            if (list.get(j).getWicketType() != null) {
                inn2TotalWickets++;
            }
            if(list.get(j).getRuns() == 0) {
                inn2NumOfDots++;
            }
            if(list.get(j).getRuns() == 4) {
                inn2NumOfFours++;
            }
            if(list.get(j).getRuns() == 6) {
                inn2NumOfSixes++;
            }
        }
        double inn2RunRate = getRunRate(inn2TotalRuns, list.get(j - 1).getBallNo());
        inn2.setTotalRuns(inn2TotalRuns);
        inn2.setRunRate(inn2RunRate);
        inn2.setTotalWickets(inn2TotalWickets);
        inn2.setNumOfDots(inn2NumOfDots);
        inn2.setNumOfFours(inn2NumOfFours);
        inn2.setNumOfSixes(inn2NumOfSixes);
        inn2.setRunsPowerPlay(powerPlay(list.subList(i, break2))[0]);
        inn2.setWicketsPowerPlay(powerPlay(list.subList(i, break2))[1]);
        inn2.setDotsInPP(powerPlay(list.subList(i, break2))[2]);
        inn2.setFoursInPP(powerPlay(list.subList(i, break2))[3]);
        inn2.setSixesInPP(powerPlay(list.subList(i, break2))[4]);

            String outcome = list1.get(0).getOutcome();
            String[] splitStr = outcome.split("\\s+");
            if(splitStr.length == 2){
                if(splitStr[1].equals("runs")){
                    inn1.setResult(WON);
                    inn2.setResult(LOSE);
                }
                else{
                    inn2.setResult(WON);
                    inn1.setResult(LOSE);
                }
            }
            else{inn1.setResult(DRAW);inn2.setResult(DRAW);}

            session.saveOrUpdate(inn1);
            session.saveOrUpdate(inn2);
        }

    public static double getRunRate(int runs, String ballNo) {
        double ball = Double.parseDouble(ballNo);
        double runRate;
        if (ball >= 19.6) {
            runRate = (double) runs / 20;
        } else {
            String[] arr = ballNo.split("\\.");
            int[] intArr = new int[2];
            intArr[0] = Integer.parseInt(arr[0]); // 1
            intArr[1] = Integer.parseInt(arr[1]); // 9
            double factor;
            if (intArr[1] >= 6) {
                factor = 1.0;
            } else {
                factor = ((double) intArr[1] / 6.0);
            }
            double overs = (double) intArr[0] + factor;
            runRate = (double) runs / overs;
        }
        return runRate;
    }

    public static int[] powerPlay(List<Ball> list) {
        int runs = 0, wickets = 0, dots = 0, fours = 0, sixes = 0;
        for (int i = 0; i < list.size(); i++) {
            runs = runs + list.get(i).getRuns();
            if (list.get(i).getWicketType() != null) {
                wickets++;
            }
            if(list.get(i).getRuns() == 0) {
                dots++;
            }
            if(list.get(i).getRuns() == 4) {
                fours++;
            }
            if(list.get(i).getRuns() == 6) {
                sixes++;
            }
        }
        int[] data = new int[5];
        data[0] = runs;
        data[1] = wickets;
        data[2] = dots;
        data[3] = fours;
        data[4] = sixes;

        return data;
    }

}
