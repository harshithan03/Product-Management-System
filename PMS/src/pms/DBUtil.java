package pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBconnection(){

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
            System.out.println("DataBase connected");
        }
        catch(SQLException e){

            System.out.println(e.getMessage());

        }

        return con;

    }

    public static void close() {

        try {
            getDBconnection().close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
