package com.csa.businessLogic;

import com.csa.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gihan on 4/20/2017.
 * Extracting and inserting player data to the database// Make sure the hibernate configurations are on update mode
 * (As mentioned in the Main2.java)
 */

public class Main4 {
    final static double WON = 1;
    final static double LOSE = 0;
    final static double DRAW = 0.5;

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        long count = (long) session.createQuery("select count(*) from  Matchs").getSingleResult();

        //for (int i = 1; i < 2; i++) {
        for (int i = 1; i < count + 1; i++) {
            insertData(session, i);
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static void insertData(Session session, int matchId) {

        Query query1 = session.createQuery("from Matchs where matchId = :name ");
        query1.setParameter("name", matchId);
        List<Matchs> list1 = query1.list();

        Query query = session.createQuery("from Ball bb where bb.match.matchId = :name ");
        query.setParameter("name", matchId);
        List<Ball> list = query.list();

        List<Integer> playerIdList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(playerIdList.contains(list.get(i).getBatsman().getPlayerId()) ||
                playerIdList.contains(list.get(i).getBowler().getPlayerId())){
            }
            else{
                playerIdList.add(list.get(i).getBatsman().getPlayerId());
            }
        }


        for(int j=0; j<playerIdList.size(); j++){
            List<Ball> aa = new ArrayList<>();
            List<Ball> bb = new ArrayList<>();
            PlayerData playerData = new PlayerData();
            for(int k=0; k<list.size(); k++){
                if(list.get(k).getBatsman().getPlayerId() == playerIdList.get(j)){
                    aa.add(list.get(k));
                }
                if(list.get(k).getBowler().getPlayerId() == playerIdList.get(j)){
                    bb.add(list.get(k));
                }
            }
            playerData = calculateBatsmanDetails(aa, playerData);
            playerData = calculateBowlerDetails(bb, playerData);
            playerData.setPlayerId(playerIdList.get(j));
            session.saveOrUpdate(playerData);
        }
    }


    public static PlayerData calculateBatsmanDetails(List<Ball> battingList, PlayerData playerData){
        int runs = 0, singles=0, fours =0, sixes =0, dotBalls=0;
        double strikeRate = 0;
        for(int i=0; i<battingList.size(); i++){
            runs = runs + battingList.get(i).getRuns();
            if(battingList.get(i).getRuns() == 0){dotBalls++;}
            else if(battingList.get(i).getRuns() == 1){singles++;}
            else if(battingList.get(i).getRuns() == 4){fours++;}
            else if(battingList.get(i).getRuns() == 6){sixes++;}
        }
        playerData.setStrikeRate((double)runs/ (double) battingList.size());
        playerData.setRuns(runs);
        playerData.setSingles(singles);
        playerData.setFours(fours);
        playerData.setSixes(sixes);
        playerData.setDotBalls(dotBalls);
        return playerData;
    }

    public static PlayerData calculateBowlerDetails(List<Ball> bowlingList, PlayerData playerData){
        int wickets=0, runs=0, dotBalls=0, singles=0, fours=0, sixes=0, deliveries=0;
        for(int i=0; i<bowlingList.size(); i++){
            runs = runs + bowlingList.get(i).getRuns();
            if(bowlingList.get(i).getWicketType() != null){wickets++;}
            if(bowlingList.get(i).getRuns() == 0){dotBalls++;}
            else if(bowlingList.get(i).getRuns() == 1){singles++;}
            else if(bowlingList.get(i).getRuns() == 4){fours++;}
            else if(bowlingList.get(i).getRuns() == 6){sixes++;}
        }
        playerData.setBowlingRuns(runs);
        playerData.setWickets(wickets);
        playerData.setBowlingSingles(singles);
        playerData.setBowlingFours(fours);
        playerData.setBowlingSixes(sixes);
        playerData.setBowlingDots(dotBalls);
        playerData.setBowlingDeliveries(bowlingList.size());
        return playerData;
    }


}
