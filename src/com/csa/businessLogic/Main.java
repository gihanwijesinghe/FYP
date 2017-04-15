package com.csa.businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csa.entity.*;
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
		String [] teamNames;
		//for (int j = 335982; j <= 829823; j++) {
		for (int j = 335982; j < 335983; j++) {
			String filepath = "resources/ipl/" + j + ".yaml";

			File file = null;
			try {
				switch (j) {

					case 336041: {
						j = 392181;
						continue;
					}
					case 392240: {
						j = 419106;
						continue;
					}
					case 419166: {
						j = 501198;
						continue;
					}
					case 501272: {
						j = 548306;
						continue;
					}
					case 548382: {
						j = 597998;
						continue;
					}
					case 598074: {
						j = 729279;
						continue;
					}
					case 734050: {
						j = 829705;
						continue;
					}
					case 336030: {
						j = j++;
						continue;
					}
					case 392187: {
						j = j++;
						continue;
					}
					case 392193: {
						j = j++;
						continue;
					}
					case 501217: {
						j = j++;
						continue;
					}
					default:
						file = new File(filepath);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
			MatchDetails match;

			Innings innings1;
			Innings innings2;

			session.beginTransaction();

			try {
				match = MatchUtil.getMatchInfoFromFile(file);

				match.setMatchId(count);
				innings1 = match.getFirstInnings();
				innings2 = match.getSecondInnings();

				deliveryAnalysis(session, playerNames, innings1);
				deliveryAnalysis(session, playerNames, innings2);


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

	private static void deliveryAnalysis(Session session, List playerNames, Innings innings1) {

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
				ball = convertToBall(bowl);
				System.out.println(ball.getBallNo() + "bowlnumber");
				bats = ball.getBatsman();
				baller = ball.getBowler();
				System.out.println(playerNames);

//                checkForPlayerNew(session, playerNames, bats.getPlayerName());
//                checkForPlayerNew(session, playerNames, baller.getPlayerName());
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
					Query query =  session.createQuery("from Player where playername = :name ");
					query.setParameter("name", baller.getPlayerName());
					List<Player> list = query.list();
					if(!list.isEmpty())
						System.out.println("abc " + list.get(0).getPlayerId());
					baller.setPlayerId(list.get(0).getPlayerId());
				}
				else{
					playerNames.add(baller.getPlayerName());
					session.save(baller);
				}

				session.saveOrUpdate(ball);

			}

		}
	}

	public static boolean checkForPlayer(List playerNames, String name){
		if(playerNames.contains(name)){
			return true;
		}
		else {
			return false;
		}
	}

//    public static void checkForPlayerNew(Session session, List playerNames, String name){
//        Player player = new Player();
//        if(playerNames.contains(name)){
//            Query query =  session.createQuery("from Player where playername = :name ");
//            query.setParameter("name", name);
//            List<Player> list = query.list();
//            if(!list.isEmpty())
//                System.out.println("abc " + list.get(0).getPlayerId());
//            player.setPlayerId(list.get(0).getPlayerId());
//            player.setPlayerName(name);
//        }
//        else {
//            playerNames.add(name);
//            session.save(player);
//        }
//    }

	public static Ball convertToBall(BowlByBall bowlByBall){

		System.out.println(bowlByBall.getBats().getPlayerName());
		Ball ball = new Ball();
		ball.setBowler(bowlByBall.getBaller());
		ball.setBallNo(bowlByBall.getBallNumber());
		ball.setBatsman(bowlByBall.getBats());
		ball.setRuns(bowlByBall.getRuns());
		ball.setBoundary(bowlByBall.getBoundary());
		ball.setMatchId(bowlByBall.getMatchId());
		ball.setWicketType(bowlByBall.getWicketType());

		return ball;
	}
}