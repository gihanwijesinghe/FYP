package com.csa.entity;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int wicketId;
	private int wicketNumber;
	private String bowler;
	private String batsman;
	private String wicketType;

	private ArrayList<String> fielder = new ArrayList<String>();

	public Wicket() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the wicketNumber
	 */
	public int getWicketNumber() {
		return wicketNumber;
	}

	/**
	 * @param wicketNumber
	 *            the wicketNumber to set
	 */
	public void setWicketNumber(int wicketNumber) {
		this.wicketNumber = wicketNumber;
	}

	/**
	 * @return the bowler
	 */
	public String getBowler() {
		return bowler;
	}

	/**
	 * @param bowler
	 *            the bowler to set
	 */
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	/**
	 * @return the batsman
	 */
	public String getBatsman() {
		return batsman;
	}

	/**
	 * @param batsman
	 *            the batsman to set
	 */
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	/**
	 * @return the wicketType
	 */
	public String getWicketType() {
		return wicketType;
	}

	/**
	 * @param wicketType
	 *            the wicketType to set
	 */
	public void setWicketType(String wicketType) {
		this.wicketType = wicketType;
	}

	/**
	 * @return the fielder
	 */
	public ArrayList<String> getFielder() {
		return fielder;
	}

	/**
	 * @param fielder
	 *            the fielder to set
	 */
	public void setFielder(ArrayList<String> fielder) {
		this.fielder = fielder;
	}

}
