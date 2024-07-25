/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

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
            String query = "insert into user(name, email, password, dob, phone, gender, contact_method) values(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getDob());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getContactMethod());
            
            stmt.executeUpdate();
            set = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return set;
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
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }
}
