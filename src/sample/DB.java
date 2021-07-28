package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect()  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","arbi","torjmen2020");

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return con;
    }


}
