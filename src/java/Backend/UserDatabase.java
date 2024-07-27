/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.User;
import java.sql.*;
import java.util.Set;

/**
 *
 * @author kaust
 */
public class UserDatabase {
    Connection con;
    
    public UserDatabase(Connection con) throws SQLException {
        this.con = con;
    }
    
    // For Registering User
    public boolean saveUser(User user) {
        boolean set = false;
        try {
            String query = "insert into user(name, email, password, dob, phone, gender, contact_method, bVerified, active_code) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getDob());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getContactMethod());
            stmt.setString(8, user.getVerified());
            stmt.setString(9, user.getActivationCode());
            
            stmt.executeUpdate();
            set = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return set;
    }
    
    public boolean verifyUser(String code) {
        boolean verified = false;
        try {
            String query = "select * from user where active_code=? and bVerified=?";
            String successQuery = "update user set bVerified=? where active_code=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, code);
            stmt.setString(2, "0");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                verified = true;
                System.out.println("THIS IS VERIFIED");
                PreparedStatement stmt2 = con.prepareStatement(successQuery);
                stmt2.setString(1, "1");
                stmt2.setString(2, code);
                stmt2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verified;
    }
    
    public User logUser(String email, String password) {
        User user = null;
        try {
            String query = "select * from user where email=? and password=?";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setDob(rs.getString("dob"));
                user.setPhone(rs.getString("phone"));
                user.setGender(rs.getString("gender"));
                user.setContactMethod(rs.getString("contact_method"));
                user.setAccountCreatedData(rs.getString("account_created"));
                user.setVerified(rs.getString("bVerified"));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }
}
