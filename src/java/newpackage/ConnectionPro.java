/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.*;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

/**
 *
 * @author kaust
 */
public class ConnectionPro {
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project", "root", "Coolkid@0629");
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(con);
        return con;
    }
    
}
