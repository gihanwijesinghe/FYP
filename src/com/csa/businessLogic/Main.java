package com.csa.businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csa.entity.*;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.csa.util.InningsUtil;
import com.csa.util.MatchUtil;
import com.csa.util.PlayerUtil;
import com.csa.visualization.BatsmansInning;
import com.csa.visualization.InningByInningsResults;
import com.esotericsoftware.yamlbeans.YamlException;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import org.hibernate.query.Query;

public class Main {

	static int count=0;

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		List<String> playerNames = new ArrayList<String>();
		List<String> teamNames = new ArrayList<String>();

		for (int j = 335982; j <= 981019; j++) {
		//for (int j = 335982; j < 335988; j++) {
		//for (int j = 336028; j < 336032; j++) {
			String filepath = "resources/ipl/" + j + ".yaml";

			//Object object = new Object();
			try{
				YamlReader reader = new YamlReader(new FileReader(filepath));
				reader.read();

				System.out.println("okay");
			}catch (Exception e){
				System.out.println("nooo");
				continue;
				//list.add(i);
			}

			File file = null;
			file = new File(filepath);
//			try {
////				switch (j) {
////
////					case 336041: {
////						j = 392181;
////						continue;
////					}
////					case 392240: {
////						j = 419106;
////						continue;
////					}
////					case 419166: {
////						j = 501198;
////						continue;
////					}
////					case 501272: {
////						j = 548306;
////						continue;
////					}
////					case 548382: {
////						j = 597998;
////						continue;
////					}
////					case 598074: {
////						j = 729279;
////						continue;
////					}
////					case 734050: {
////						j = 829705;
////						continue;
////					}
//////					case 336030: {
//////						j = j++;
//////						continue;
//////					}
////					case 392187: {
////						j = j++;
////						continue;
////					}
////					case 392193: {
////						j = j++;
////						continue;
////					}
////					case 501217: {
////						j = j++;
////						continue;
////					}
////					default:
////						file = new File(filepath);
////				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			count++;
			MatchDetails match;
			Matchs newMatch;

			Innings innings1;
			Innings innings2;

			session.beginTransaction();

			try {
				match = MatchUtil.getMatchInfoFromFile(file);

				//match.setMatchId(count);
				innings1 = match.getFirstInnings();
				innings2 = match.getSecondInnings();

				teamNames = insertTeam(session, match, teamNames);
				newMatch = convertToMatch(session, match);
				playerNames = deliveryAnalysis(session, playerNames, innings1, newMatch);
				playerNames = deliveryAnalysis(session, playerNames, innings2, newMatch);


				session.getTransaction().commit();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (YamlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		session.close();
		sessionFactory.close();
	}

	private static List deliveryAnalysis(Session session, List playerNames, Innings innings1, Matchs match) {

		BowlByBall bowl;
		Ball ball;
		Player bats;
		Player baller;

		Map<Integer, BowlByBall> InningsDeliveries = innings1
				.getDeliveries();

		for (int i = 1; i <= InningsDeliveries.size(); i++) {
			//for (int i = 1; i <3; i++) {

			if(InningsDeliveries.get(i)!=null) {
				bowl = InningsDeliveries.get(i);
				System.out.println("boudaryyyyyyyy" + bowl.getBoundary());
				ball = convertToBall(bowl);
				System.out.println(ball.getBallNo() + "bowlnumber");
				bats = ball.getBatsman();
				baller = ball.getBowler();
				System.out.println(playerNames);

//                playerNames = checkForPlayerNew(session, playerNames, bats.getPlayerName());
//                playerNames = checkForPlayerNew(session, playerNames, baller.getPlayerName());
				if(checkForPlayer(playerNames, bats.getPlayerName()) == true){
					Query query =  session.createQuery("from Player where playername = :name ");
					query.setParameter("name", bats.getPlayerName());
					List<Player> list = query.list();
					if(!list.isEmpty())
						System.out.println("abc " + list.get(0).getPlayerId());
					bats.setPlayerId(list.get(0).getPlayerId());
				}
				else{
					playerNames.add(bats.getPlayerName());
					session.save(bats);
				}
				if(checkForPlayer(playerNames, baller.getPlayerName()) == true){
					Query query2 =  session.createQuery("from Player where playername = :name ");
					query2.setParameter("name", baller.getPlayerName());
					List<Player> list2 = query2.list();
					if(!list2.isEmpty())
						System.out.println("abc " + list2.get(0).getPlayerId());
					baller.setPlayerId(list2.get(0).getPlayerId());
				}
				else{
					playerNames.add(baller.getPlayerName());
					session.save(baller);
				}

				ball.setMatch(match);

				session.saveOrUpdate(ball);
			}
		}
		return playerNames;
	}

	public static boolean checkForPlayer(List playerNames, String name){
		if(playerNames.contains(name)){
			return true;
		}
		else {
			return false;
		}
	}

//    public static List checkForPlayerNew(Session session, List playerNames, String name){
//        Player player = new Player();
//        if(playerNames.contains(name)){
//					Query query =  session.createQuery("from Player where playername = :name ");
//					query.setParameter("name", "P Kumar");
//					List<Player> list = query.list();
//			System.out.println("wanted name" + name);
//			//List<Player> list = query.list();
//            if(!list.isEmpty())
//                System.out.println("abc " + list.get(0).getPlayerId());
//            player.setPlayerId(list.get(0).getPlayerId());
//            player.setPlayerName(name);
//        }
//        else {
//			System.out.println("not in the list" + name);
//			playerNames.add(name);
//            session.save(player);
//        }
//		return playerNames;
//    }

	public static Ball convertToBall(BowlByBall bowlByBall){

		Ball ball = new Ball();
		ball.setBowler(bowlByBall.getBaller());
		ball.setBallNo(bowlByBall.getBallNumber());
		ball.setBatsman(bowlByBall.getBats());
		ball.setRuns(bowlByBall.getRuns());
		ball.setBoundary(bowlByBall.getBoundary());
		ball.setWicketType(bowlByBall.getWicketType());

		return ball;
	}

	public static Matchs convertToMatch(Session session, MatchDetails matchDetails){
		Matchs match = new Matchs();

		Query query =  session.createQuery("from Team where teamname = :name ");
		query.setParameter("name", matchDetails.getFirstInnings().getBattingTeam().getTeamName());
		List<Team> list = query.list();
		Team team1 = list.get(0);

		Query query2 =  session.createQuery("from Team where teamname = :name ");
		query2.setParameter("name", matchDetails.getSecondInnings().getBattingTeam().getTeamName());
		List<Team> list2 = query2.list();
		Team team2 = list2.get(0);

		match.setBattingFirst(team1);
		match.setBattingSecond(team2);
		//match.setManOfMatch(matchDetails.getManOfMatch());
		match.setMatchDate(matchDetails.getMatchDate());
		match.setUmpireOne(matchDetails.getUmprie1());
		match.setUmpireTwo(matchDetails.getUmprie2());
		match.setVenue(matchDetails.getVenue());
		match.setOutcome(matchDetails.getMargin());

		if(team1.getTeamName().equals(matchDetails.getTossWinningTeam())){
			match.setTossWin(team1);
		}
		else {match.setTossWin(team2);}

		if(team1.getTeamName().equals(matchDetails.getWinner())){
			match.setWinner(team1);
		}
		else {match.setWinner(team2);}

		session.saveOrUpdate(match);
		return match;
	}

	public static List<String> insertTeam(Session session, MatchDetails matchDetails, List teamNames){
		if(teamNames.contains(matchDetails.getFirstInnings().getBattingTeam().getTeamName())){}
		else {
			teamNames.add(matchDetails.getFirstInnings().getBattingTeam().getTeamName());
			session.saveOrUpdate(matchDetails.getFirstInnings().getBattingTeam());
		}

		if(teamNames.contains(matchDetails.getSecondInnings().getBattingTeam().getTeamName())){}
		else {
			teamNames.add(matchDetails.getSecondInnings().getBattingTeam().getTeamName());
			session.saveOrUpdate(matchDetails.getSecondInnings().getBattingTeam());
		}
		return teamNames;
	}
}