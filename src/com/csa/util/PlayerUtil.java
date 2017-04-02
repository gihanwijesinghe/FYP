package com.csa.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.csa.entity.BowlByBall;
import com.csa.entity.MatchDetails;
import com.csa.visualization.BatsmansInning;

public class PlayerUtil {

	public static HashMap<Integer, BatsmansInning> getScoreCardDetailsFirstInnings(
			MatchDetails match) {

		// Playing11
		ArrayList<String> battingOrder = new ArrayList<String>();
		// Player
		// number of deliveries
		int numberOfDeliveries = match.getFirstInnings().getDeliveries().size();

		BowlByBall bowlDetails;
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		String batsmanName;
		Integer runs;
		for (int i = 1; i <= numberOfDeliveries; i++) {

			// get the bowlDetails
			bowlDetails = match.getFirstInnings().getDeliveries().get(i);
			batsmanName = bowlDetails.getBatsman();
			runs = bowlDetails.getRuns();

			if (!map.containsKey(batsmanName)) {
				// for new batsman
				battingOrder.add(batsmanName);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(runs);
				map.put(batsmanName, temp);
			} else {
				map.get(batsmanName).add(runs);
			}
		}

		HashMap<Integer, BatsmansInning> returnMap = new HashMap<>();
		int i = 1;
		for (String name : battingOrder) {
			// setting the parameter of batsman
			BatsmansInning batsman = new BatsmansInning();

			ArrayList<Integer> batsmanBowlByBowlScore = map.get(name);

			// batsman.setBowlByBowlScore(batsmanBowlByBowlScore);

			batsman.setMatchId(match.getMatchId());

			batsman.setPlayerName(name);

			batsman.setBattingPosition(i);

			batsman.setIndividualScore(individualScore(batsmanBowlByBowlScore));

			batsman.setNumberOfBoundries(countFours(batsmanBowlByBowlScore));

			batsman.setNumberOfSixes(countSixes(batsmanBowlByBowlScore));

			batsman.setNumberOfDotBowls(countDots(batsmanBowlByBowlScore));

			batsman.setFirstInningsOrSecondInnings(1);

			batsman.setNumberOfBowlsTaken(batsmanBowlByBowlScore.size());
			// for first innings
			int side = match.getResult().getWonByFirstBatOrSecondBat();
			// team 1 wins
			if (side == 1) {
				batsman.setWinOrLoss("win");
			} else if (side == 2) {
				batsman.setWinOrLoss("loss");
			} else {
				batsman.setWinOrLoss("draw");
			}

			returnMap.put(i, batsman);
			i++;
		}
		System.out.println("batting Order: " + battingOrder.toString());
		return returnMap;
	}

	public static HashMap<Integer, BatsmansInning> getScoreCardDetailsSecondInnings(
			MatchDetails match) {

		// Playing11
		ArrayList<String> battingOrder = new ArrayList<String>();
		// Player
		// number of deliveries
		int numberOfDeliveries = match.getSecondInnings().getDeliveries()
				.size();

		BowlByBall bowlDetails;
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		String batsmanName;
		Integer runs;
		for (int i = 1; i <= numberOfDeliveries; i++) {

			// get the bowlDetails
			bowlDetails = match.getSecondInnings().getDeliveries().get(i);
			batsmanName = bowlDetails.getBatsman();
			runs = bowlDetails.getRuns();

			if (!map.containsKey(batsmanName)) {
				// for new batsman
				battingOrder.add(batsmanName);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(runs);
				map.put(batsmanName, temp);
			} else {
				map.get(batsmanName).add(runs);
			}
		}
		HashMap<Integer, BatsmansInning> returnMap = new HashMap<>();
		int i = 1;
		for (String name : battingOrder) {
			// setting the parameter of batsman
			BatsmansInning batsman = new BatsmansInning();

			ArrayList<Integer> batsmanBowlByBowlScore = map.get(name);

			// batsman.setBowlByBowlScore(batsmanBowlByBowlScore);

			batsman.setMatchId(match.getMatchId());

			batsman.setPlayerName(name);

			batsman.setBattingPosition(i);

			batsman.setIndividualScore(individualScore(batsmanBowlByBowlScore));

			batsman.setNumberOfBoundries(countFours(batsmanBowlByBowlScore));

			batsman.setNumberOfSixes(countSixes(batsmanBowlByBowlScore));

			batsman.setNumberOfDotBowls(countDots(batsmanBowlByBowlScore));

			batsman.setNumberOfBowlsTaken(batsmanBowlByBowlScore.size());

			batsman.setFirstInningsOrSecondInnings(2);

			// for first innings
			int side = match.getResult().getWonByFirstBatOrSecondBat();
			// team 1 wins
			if (side == 2) {
				batsman.setWinOrLoss("win");
			} else if (side == 1) {
				batsman.setWinOrLoss("loss");
			} else {
				batsman.setWinOrLoss("draw");
			}

			returnMap.put(i, batsman);
			i++;
		}

		return returnMap;
	}

	public static int countFours(ArrayList<Integer> runsList) {
		int count = 0;
		for (int i : runsList) {
			if (i == 4) {
				count++;
			}
		}
		return count;
	}

	public static int countDots(ArrayList<Integer> runsList) {
		int count = 0;
		for (int i : runsList) {
			if (i == 0) {
				count++;
			}
		}
		return count;
	}

	public static int countSixes(ArrayList<Integer> runsList) {
		int count = 0;
		for (int i : runsList) {
			if (i == 6) {
				count++;
			}
		}
		return count;
	}

	public static int individualScore(ArrayList<Integer> runsList) {
		int count = 0;

		for (int i : runsList) {
			count = count + i;
		}

		return count;
	}
}
