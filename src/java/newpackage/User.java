/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author kaust
 */
public class User {
    int id;
    String name;
    String email;
    String password;
    String dob;
    String phone;
    String gender;
    String contact_method;
    String account_created;
    int active_code;
    
    public User() {
        
    }
    
    public User(int id, String name, String email, String password, String dob, String phone, String gender, String contact_method, String account_created) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.contact_method = contact_method;
        this.account_created = account_created;
    }
    
    public User(String name, String email, String password, String dob, String phone, String gender, String contact_method) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.contact_method = contact_method;
        this.setNewCode();
    }
    
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDob() {
        return this.dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getContactMethod() {
        return this.contact_method;
    }
    
    public void setContactMethod(String contact_method) {
        this.contact_method = contact_method;
    }
    
    public String getAccountCreatedData() {
        return this.account_created;
    }
    
    public void setAccountCreatedData(String account_created) {
        this.account_created = account_created;
    }
    
    public int getActivationCode() {
        return this.active_code;
    }
    
    public void setActivationCode(int active_code) {
        this.active_code = active_code;
    }
    
    private void setNewCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        this.setActivationCode(code);
    }
}
