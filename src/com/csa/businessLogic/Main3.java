package com.csa.businessLogic;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Gihan on 4/25/2017.
 */
public class Main3 {

    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = DBConnection.getDBConnection();

        String alterColumnOrderQuery1 = "ALTER TABLE DATASET ADD DUMMY TINYINT(1)";
        String alterColumnOrderQuery2 = "ALTER TABLE DATASET MODIFY RESULT VARCHAR(225) AFTER DUMMY";
        String alterColumnOrderQuery3 = "ALTER TABLE DATASET DROP DUMMY";

        // create the java statement
        Statement st = conn.createStatement();
        st.execute(alterColumnOrderQuery1);
        st.execute(alterColumnOrderQuery2);
        st.execute(alterColumnOrderQuery3);

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM DATASET";

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);


        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter("yourfile.csv"), ',');
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean includeHeaders = false;

        java.sql.ResultSet myResultSet = rs;
         //your resultset logic here

        writer.writeAll(myResultSet,includeHeaders);

        writer.close();
    }

}
