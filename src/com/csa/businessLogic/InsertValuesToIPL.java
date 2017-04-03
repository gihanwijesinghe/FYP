/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csa.businessLogic;

import com.csa.entity.BowlByBall;
import com.csa.entity.Player;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leshan
 */
public class InsertValuesToIPL {

    private static Connection conn = DBConnection.getDBConnection();

    public static void insertValuesToPlayer(Player player){
        if(conn!=null){
            try {
                // the mysql insert statement
                String query = " INSERT INTO player(name) VALUES (?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                //preparedStmt.setString (1, "Sachin Tendulkar");
                preparedStmt.setString (1, player.getPlayerName());

                // execute the preparedstatement
                preparedStmt.execute();


            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }
    }

    public static void insertValuesToTeam(){

        if(conn!=null){
            try {
                // the mysql insert statement
                String query = " INSERT INTO team(name) VALUES (?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, "Kolkata Knight Riders");

                // execute the preparedstatement
                preparedStmt.execute();


            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }
    }

    public static void insertValuesToTeamPlayers(){
        if(conn!=null){
            try {
                // the mysql insert statement
                String query = " INSERT INTO team_player(team_id, player_id, year) VALUES (?, ? , ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, 1);
                preparedStmt.setInt(2, 1);
                preparedStmt.setInt(3, 2021);

                // execute the preparedstatement
                preparedStmt.execute();


            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }
    }

    public static void insertValuesToMatch(){
        if(conn!=null){
            try {
                // the mysql insert statement
                String query = "INSERT INTO match1 (toss_win_team_id, first_inning_team_id, second_inning_team_id, winning_team_id, venue, date, player_of_the_match_id, outcome, first_umpire_name, second_umpire_name) VALUES (?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, 1);
                preparedStmt.setInt(2, 2);
                preparedStmt.setInt(3, 1);
                preparedStmt.setInt(4, 1);
                preparedStmt.setString(5, "Colombo RPS" );
                preparedStmt.setDate(6, java.sql.Date.valueOf("2016-05-29"));
                preparedStmt.setInt(7, 1);
                preparedStmt.setString(8, "won by 66 runs" );
                preparedStmt.setString(9, "Aleem Dar" );
                preparedStmt.setString(10, "Steve Davis" );

                // execute the preparedstatement
                preparedStmt.execute();


            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }

    }
    public static void insertValuesToBallByBallDetails(BowlByBall bowl){

        if(conn!=null){
            try {
                // the mysql insert statement
                String query = "INSERT INTO ball_by_ball_details (match_id, baller_id, batsman_id, ball_no, runs, wicket_type, boundary) VALUES (?, ?, ?, ?, ?, ?, ? )";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, 1);
                preparedStmt.setInt(2, 2);
                preparedStmt.setInt(3, 1);
                preparedStmt.setInt(4, 1);
                preparedStmt.setInt(5, 4 );
                preparedStmt.setString(6, "");
                preparedStmt.setInt(7, 4);


                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }



    }

    public static void findDetails(String bats){
        List list;

        if(conn!=null){
            try {
                String query = "SELECT * from player where name = " + bats;
                Statement stmt = null;

                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    //Retrieve by column name
                    int id  = rs.getInt("player_id");

                    //Display values
                    System.out.print("ID: " + id);
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(InsertValuesToIPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("connection was not successful.");
        }
        //return list;
    }
}
