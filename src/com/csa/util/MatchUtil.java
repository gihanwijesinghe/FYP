/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csa.util;

import com.csa.entity.*;

import java.io.File;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sankha
 * 
 */
public class MatchUtil {
	/**
	 * @param match
	 */

	public void printMatch(MatchDetails match) {
		System.out.println("match Id: " + match.getMatchId());
		System.out.println("matchDate: " + match.getMatchDate());
		System.out.println("matchDayOrNight: " + match.getDayOrNight());
		System.out.println("idDLMethod: " + match.isDLMethod());
		System.out.println("teamOne: " + match.getTeamOne());
		System.out.println("teamTwo: " + match.getTeamTwo());
		System.out.println("umprie1: " + match.getUmprie1());
		System.out.println("umprie2: " + match.getUmprie2());
	}

	public static MatchDetails getMatchInfoFromFile(File filePath)
			throws FileNotFoundException, YamlException, ParseException {
		MatchDetails match = new MatchDetails();
		Object object = new Object();
		int count=0;

//		try {
			YamlReader reader = new YamlReader(new FileReader(filePath));

			 object = reader.read();
//		}catch(Exception e){
//			System.out.println("error");
//			MatchDetails error = new MatchDetails();
//			error.setCity("error");
//			return error;
//		}
		// System.out.println(object);
		Map map = (Map) object;
		System.out.println(map.size());

		Map info = (Map) map.get("info");
		System.out.println(info.size());

		ArrayList<String> teams = (ArrayList<String>) info.get("teams");
		System.out.println(info.get("teams"));
		match.setTeamOne(teams.get(0));
		match.setTeamTwo(teams.get(1));

		ArrayList<String> umpires = (ArrayList<String>) info.get("umpires");
		System.out.println(umpires);
		match.setUmprie1(umpires.get(0));
		match.setUmprie2(umpires.get(1));

		ArrayList<String> manOfMatchList = (ArrayList<String>) info.get("player_of_match");
		String manOfMatch = manOfMatchList.get(0);
		match.setManOfMatch(manOfMatch);

		Map toss = (Map) info.get("toss");
		System.out.println((String) toss.get("winner"));
		match.setTossWinningTeam((String) toss.get("winner"));
		match.setTossDecision((String) toss.get("decision"));

		System.out.println(info.get("city"));
		match.setCity((String) info.get("city"));

		// System.err.println(info.get("dates"));
		ArrayList<String> dates = (ArrayList<String>) info.get("dates");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = dates.get(0);
		Date date = sdf.parse(dateInString);
		match.setMatchDate(date);

		match.setVenue((String) info.get("venue"));

		Map outcome = (Map) info.get("outcome");
		String winner = (String) outcome.get("winner");
		if(winner == null){
			winner = "error";
		}
		match.setWinner(winner);
		// System.out.println("winner"+outcome.get("winner"));

		Map by = (Map) outcome.get("by");
		String margin;
		if(by.get("runs") != null){margin = (String) by.get("runs");}
		else if(by.get("wickets") != null){margin = (String) by.get("runs");}
		else {margin = "draw";}
		match.setMargin(margin);

		String by_which = "aa";
		int by_amount = 1;
		if(by != null) {
			by_which = (String) by.keySet().toArray()[0];
			by_amount = Integer.parseInt((String) by.get(by_which));
		}
		System.out.println("keyset" + by_amount);
		// end of extracting basic match info

		HashMap<String, Integer> extraMap = new HashMap<>();
		extraMap.put("byes", 1);
		extraMap.put("legbyes", 2);
		extraMap.put("noballs", 3);
		extraMap.put("wides", 4);

		ArrayList<Map> innings = (ArrayList<Map>) map.get("innings");

		Map inn1 = innings.get(0);
		Map inn1_info = (Map) inn1.get("1st innings");
		System.out.println(inn1_info.get("team"));

		Map inn2;
		Map inn2_info;
		if(innings.size()<2){
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			inn2 = innings.get(0);
			inn2_info = (Map) inn2.get("1st innings");
		}
		else{
			inn2 = innings.get(1);
			inn2_info = (Map) inn2.get("2nd innings");
		}
		System.out.println(inn2_info.get("team"));

		InningsType inni1_deli = getDeliveriesinfo(inn1_info,0);
		InningsType inni2_deli = getDeliveriesinfo(inn2_info,0);

		//first innings segments
		InningsType inni1_pp = getDeliveriesinfo(inn1_info,1);
		InningsType inni1_middle = getDeliveriesinfo(inn1_info,2);
		InningsType inni1_death = getDeliveriesinfo(inn1_info,3);

		//second innings segments
		InningsType inni2_pp = getDeliveriesinfo(inn2_info,1);
		InningsType inni2_middle = getDeliveriesinfo(inn2_info,2);
		InningsType inni2_death = getDeliveriesinfo(inn2_info,3);

		//System.out.println("doneee");
		String name_bat = (String) inn1_info.get("team"); ;
		String name_field = (String) inn2_info.get("team") ;
		//System.out.println("doneee2");
		Team battingTeam = new Team();
		battingTeam.setTeamName(name_bat);

		Team fieldingTeam = new Team();
		fieldingTeam.setTeamName(name_field);

		//add first innings segment details
		Innings first = updateInningsAttr(battingTeam,fieldingTeam,inni1_deli,1);
		first.setInnings_pp(updateInningsAttr(battingTeam,fieldingTeam,inni1_pp,1));
		first.setInnings_middle(updateInningsAttr(battingTeam,fieldingTeam,inni1_middle,1));
		first.setInnings_death(updateInningsAttr(battingTeam,fieldingTeam,inni1_death,1));
		match.setFirstInnings(first);

		//add second innings segment details
		Innings second = updateInningsAttr(fieldingTeam,battingTeam,inni2_deli,2);
		second.setInnings_pp(updateInningsAttr(fieldingTeam,battingTeam,inni2_pp,2));
		second.setInnings_middle(updateInningsAttr(fieldingTeam,battingTeam,inni2_middle,2));
		second.setInnings_death(updateInningsAttr(fieldingTeam,battingTeam,inni2_death,2));
		match.setSecondInnings(second);

		Result result = new Result();
		// r.setDLmethod(true); //don't know how to find this
		// r.setMatchId(); //which ID ??
		result.setWinningTeam(winner);
		if (winner.equals(battingTeam.teamName))
			result.setWonByFirstBatOrSecondBat(1);
		else
			result.setWonByFirstBatOrSecondBat(2);

		if (by_which.equals("runs"))
			result.setWonByRuns(by_amount);
		else
			result.setWonByWickets(by_amount);

		match.setResult(result);

		// return match object
		return match;
	}

	private static Innings updateInningsAttr(Team b, Team f, InningsType inningsType, int inning) {

		Map map = inningsType.deliveries;
		int count = inningsType.ballCount;
		int segment = inningsType.segment;
		boolean complete = inningsType.complete;

		Innings innings = new Innings();

		innings.setInning(inning);
		innings.setBattingTeam(b);
		innings.setFieldingTeam(f);
		innings.setDeliveries(map);
		innings.setBalls(count);
		innings.setSegment(segment);
		innings.setComplete(complete);

		// set the Number of Wickets lost in the innings
		int numOfWicketsLostInFirstInnings = getNumberOfWicketInInnings(map);
		innings.setNumberOfWickets(numOfWicketsLostInFirstInnings);

		// set Number of Runs Socred in an Innings
		int numOfRunsInInn1 = getNumberOfRunsScoredInAnInnings(map);
		innings.setNumberOfRunsScored(numOfRunsInInn1);

		// set Number of Runs Extras in an Innings
		int numOfExtrasInInn1 = getNumberOfExtrasInAnInnings(map);
		innings.setNumberOfExtras(numOfExtrasInInn1);

		double inni1_numberOfOvers =  getNumberOfOvers(inningsType); // don't know how to find this
		innings.setNumberOfOvers(inni1_numberOfOvers);

		innings.setRunrate(getSegmentRunRate(inningsType,numOfRunsInInn1));

		return innings;
	}

	private static double getSegmentRunRate(InningsType type, int numOfRunsInInn1) {

		double balls = type.legalBallCount;
		int runs = numOfRunsInInn1;
		double rate = 0;

		if(balls!=0)rate = (runs/balls)*6;

		System.out.println("RAAAAAATE: " + Math.round(rate * 100.0) / 100.0);
		return Math.round(rate * 100.0) / 100.0;



	}

	private static double getNumberOfOvers(InningsType type) {

		int count = type.legalBallCount;
		//System.out.println("OVERS: " + Double.parseDouble((count/6 + "." + count%6)) );
		return Double.parseDouble((count/6 + "." + count%6));
	}

	public static InningsType getDeliveriesinfo(Map inn1_info, int segment) {

		double start=0.1;
		double end = 20.1;
		int limit=inn1_info.size();
		int count=0;
		int legalCount=0;

		if(segment==1){
			start =0.1;
			end = 6.1;
			limit = inn1_info.size();
		}
		else if(segment==2){
			start =6.1;
			end = 15.1;
			limit = inn1_info.size();
		}
		else if (segment==3){
			start =15.1;
			end = 20.1;
			limit = inn1_info.size();
		}

		HashMap<Integer, BowlByBall> inni1_deli = new HashMap<>();

		ArrayList<Map> deli_list = (ArrayList<Map>) inn1_info.get("deliveries");
		int inni1_wicketNumber = 0; //
		int bowlNumber = 0;
		BowlByBall bowl;
		System.out.println("SIZEEE: " + deli_list.size());
		for (int i = 0; i < deli_list.size(); i++) {

			Map deli_map = deli_list.get(i);
			String deli_name = (String) deli_map.keySet().toArray()[0];
			Double deli_num = Double.parseDouble(deli_name);

			if(deli_num>=start && deli_num < end) {

				count++;
				legalCount++;
				bowl = new BowlByBall();

				System.out.println("nameeeee: " + deli_num);
				int overNumber = Integer.parseInt(deli_name.split("\\.")[0]);

				Map delivery = (Map) deli_map.get(deli_name);
				System.out.println(delivery.get("runs"));

				Map run_map = (Map) delivery.get("runs");
				int extras = Integer.parseInt((String) run_map.get("extras"));

				Map extras_map = (Map) delivery.get("extras");

				if(extras_map!=null) {
					if (extras_map.get("wides") != null || extras_map.get("noballs") != null) {
						legalCount--;
					}
				}

				int total = Integer.parseInt((String) run_map.get("total"));
				int runs = Integer.parseInt((String) run_map.get("batsman"));

				bowl.setBatsman((String) delivery.get("batsman"));
				bowl.setNonStriker((String) delivery.get("non_striker"));
				bowl.setBowler((String) delivery.get("bowler"));
				bowl.setOverNumber(overNumber);

				bowlNumber = i + 1;
				bowl.setBowlnumber(bowlNumber); // what is this ????? 3.2 or 20th
				// ball

				if (delivery.containsKey("extras"))
					bowl.setExtraType(extras); // type int ??? ;for now it's string

				bowl.setRuns(runs);
				bowl.setExtras(extras);
				bowl.setTotalRuns(total);
				// runs and totoal runs ????
				Player bats = new Player();
				Player baller = new Player();
				bats.setPlayerName((String) delivery.get("batsman"));
				baller.setPlayerName((String) delivery.get("bowler"));
				bowl.setBats(bats);
				bowl.setBaller(baller);
				bowl.setBallNumber(String.valueOf(deli_num));

				if (delivery.containsKey("wicket")) {

					Map wicket_map = (Map) delivery.get("wicket");
					String player_out = (String) wicket_map.get("player_out");
					@SuppressWarnings("unchecked")
					ArrayList<String> fielders = (ArrayList<String>) wicket_map
							.get("fielders");

					String kind = (String) wicket_map.get("kind");

					inni1_wicketNumber++;
					Wicket wicket = new Wicket();
					wicket.setWicketNumber(inni1_wicketNumber);
					wicket.setBowler((String) delivery.get("bowler"));
					wicket.setBatsman(player_out);
					wicket.setFielder(fielders);
					wicket.setWicketType(kind);

					bowl.setIsWicket(1); // boolean or int;
					//bowl.setWicket(wicket);
				}
				System.out.println("segment: " + segment);

				System.out.println("inserted");
			}
			else{
				bowl=null;
				bowlNumber = i + 1;
			}

			inni1_deli.put(bowlNumber, bowl);
		}

		InningsType inningsType = new InningsType();

		if(segment==1 ){

			if(count<36)inningsType.complete=false;
			else inningsType.complete=true;
		}
		else if(segment==2){
			if(count<54)inningsType.complete=false;
			else inningsType.complete=true;
		}
		else if (segment==3){
			if(count<30)inningsType.complete=false;
			else inningsType.complete=true;
		}
		else{
			if(count<120)inningsType.complete=false;
			else inningsType.complete=true;
		}
		System.out.println("return");

		inningsType.ballCount = count;
		inningsType.legalBallCount = legalCount;
		inningsType.deliveries= inni1_deli;
		inningsType.segment = segment;

		return inningsType;
	}

	/**
	 * @param diliveries
	 * @return number of wickets in an Inning
	 */

	public static int getNumberOfWicketInInnings(Map<Integer, BowlByBall> diliveries) {
		int maxWicketNumber = 0;

		for (int i = 1; i <= diliveries.size(); i++) {

			if(diliveries.get(i)!=null) {
				BowlByBall bowl = diliveries.get(i);

				if (bowl.getIsWicket() == 1) {
					maxWicketNumber++;
				}
			}
		}
		return maxWicketNumber;
	}

	public static int getNumberOfRunsScoredInAnInnings(
			Map<Integer, BowlByBall> diliveries) {
		int numberOfRuns = 0;
		for (int i = 1; i <= diliveries.size(); i++) {

			if(diliveries.get(i)!=null) {
				BowlByBall bowl = diliveries.get(i);
				numberOfRuns = numberOfRuns + bowl.getTotalRuns();
			}
		}
		return numberOfRuns;
	}

	public static int getNumberOfExtrasInAnInnings(Map<Integer, BowlByBall> diliveries) {
		int numberOfExtras = 0;
		for (int i = 1; i <= diliveries.size(); i++) {
			if(diliveries.get(i)!=null) {
				BowlByBall bowl = diliveries.get(i);
				numberOfExtras = numberOfExtras + bowl.getExtras();
			}

		}
		return numberOfExtras;
	}

}

class InningsType{

	Map<Integer, BowlByBall> deliveries;
	int ballCount;
	int legalBallCount;
	int segment;
	boolean complete;
}