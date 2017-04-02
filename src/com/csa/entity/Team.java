package com.csa.entity;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int teamId;
	public String teamName;
	public String captain;
	public String wicketKeper;
	
	@ElementCollection
	public Map<Integer,String> Playing11;  
	
	public Team() {
		// TODO Auto-generated constructor stub
	}

    /**
     * @return the teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the captain
     */
    public String getCaptain() {
        return captain;
    }

    /**
     * @param captain the captain to set
     */
    public void setCaptain(String captain) {
        this.captain = captain;
    }

    /**
     * @return the wicketKeper
     */
    public String getWicketKeper() {
        return wicketKeper;
    }

    /**
     * @param wicketKeper the wicketKeper to set
     */
    public void setWicketKeper(String wicketKeper) {
        this.wicketKeper = wicketKeper;
    }

    /**
     * @return the Playing11
     */
    public Map<Integer,String> getPlaying11() {
        return Playing11;
    }

    /**
     * @param Playing11 the Playing11 to set
     */
    public void setPlaying11(Map<Integer,String> Playing11) {
        this.Playing11 = Playing11;
    }

}
