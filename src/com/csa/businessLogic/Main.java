package com.csa.businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
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

public class Main {

	static int count=0;

	public static void main(String[] args) {

		// Result result = new Result();
		// Team team1 = new Team();
		// Team team2 = new Team();

		// Innings innings2 = new Innings();

		// innings1.setBattingTeam(team1);
		// innings1.setFieldingTeam(team2);

		// Wicket wicket = new Wicket();
		// bowl.setWicket(wicket);
		// match.setResult(result);
		// match.setFirstInnings(innings1);
		// match.setSecondInnings(innings2);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

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
			Innings innings1_pp;
			Innings innings1_middle;
			Innings innings1_death;
			Innings innings2;
			Innings innings2_pp;
			Innings innings2_middle;
			Innings innings2_death;

			// need to change, unnecessary
			Team battingTeam1;
			Team fieldingTeam1;

			Team battingTeam2;
			Team fieldingTeam2;

			BowlByBall bowl;
			Wicket wicket;

			Result result;

			//visualization
			HashMap<Integer, BatsmansInning> allBattingInnings;

			InningByInningsResults inningResults;
			BatsmansInning battingInnings;
			session.beginTransaction();

			try {
				match = MatchUtil.getMatchInfoFromFile(file);

				match.setMatchId(count);
				innings1 = match.getFirstInnings();
				innings1_pp = innings1.getInnings_pp();
				innings1_middle = innings1.getInnings_middle();
				innings1_death = innings1.getInnings_death();

				innings2 = match.getSecondInnings();
				innings2_pp = innings2.getInnings_pp();
				innings2_middle = innings2.getInnings_middle();
				innings2_death = innings2.getInnings_death();

				battingTeam1 = innings1.getBattingTeam();
				fieldingTeam1 = innings1.getFieldingTeam();

				battingTeam2 = innings2.getBattingTeam();
				fieldingTeam2 = innings2.getFieldingTeam();

				/*session.save(match);

				session.save(innings1);
				session.save(innings1_pp);
				session.save(innings1_middle);
				session.save(innings1_death);
				session.save(innings2);
				session.save(innings2_pp);
				session.save(innings2_middle);
				session.save(innings2_death);

				session.save(battingTeam1);
				session.save(fieldingTeam1);

				session.save(battingTeam2);
				session.save(fieldingTeam2);*/

				deliveryAnalysis(session, innings1);
				for(int is=0; is<5; is++){
					System.out.println("hellooooooooooooooooooooooooooooooooooooooooo");
				}
//				deliveryAnalysis(session, innings1_pp);
//				deliveryAnalysis(session, innings1_middle);
//				deliveryAnalysis(session, innings1_death);
//				deliveryAnalysis(session, innings2);
//				deliveryAnalysis(session, innings2_pp);
//				deliveryAnalysis(session, innings2_middle);
//				deliveryAnalysis(session, innings2_death);

				result = match.getResult();
				//session.save(result);

				// visualization
			/*	allBattingInnings = PlayerUtil
						.getScoreCardDetailsFirstInnings(match);

				for (int i = 1; i <= allBattingInnings.size(); i++) {
					// for (int i = 1; i < 2; i++) {
					battingInnings = allBattingInnings.get(i);
					session.save(battingInnings);
				}

				// visualization
				allBattingInnings = PlayerUtil
						.getScoreCardDetailsSecondInnings(match);

				for (int i = 1; i <= allBattingInnings.size(); i++) {
					// for (int i = 1; i < 2; i++) {
					battingInnings = allBattingInnings.get(i);
					session.save(battingInnings);
				}*/
				//innings Results visualization

//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings1);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings1_pp);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings1_middle);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings1_death);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings2);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings2_pp);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings2_middle);
//				session.save(inningResults);
//
//				inningResults = InningsUtil.generateInningsByInningsResults(match.getMatchId(),match.getResult().getWonByFirstBatOrSecondBat(),innings2_death);
//				session.save( inningResults);

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

	private static void deliveryAnalysis(Session session, Innings innings1) {

		BowlByBall bowl;
		Wicket wicket;
		Player bats;

		Map<Integer, BowlByBall> InningsDeliveries = innings1
				.getDeliveries();

		for (int i = 1; i <= InningsDeliveries.size(); i++) {

			if(InningsDeliveries.get(i)!=null) {
				bowl = InningsDeliveries.get(i);
				System.out.println(bowl.bowlnumber);
				session.save(bowl);

				wicket = bowl.getWicket();
				if (bowl.isWicket == 1) {
					session.save(wicket);
				}

				bats = bowl.getBats();
				session.save(bats);

			}
		}
	}
}