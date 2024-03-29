/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author oXCToo
 */
public class User {

    private String id;

    private String email;

    private String dob;

    private String gender;

    private String lastname;

    private String firstname;
     private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId ()
    {
        return id;
    }

    public User(String id, String lastname) {
        this.id = id;
        this.lastname = lastname;
    }

    public User(String email, String dob, String gender, String lastname) {
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.lastname = lastname;
    }

    
    public User(String email, String dob, String gender, String lastname, String firstname) {
      
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public User() {
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getDob ()
    {
        return dob;
    }

    public void setDob (String dob)
    {
        this.dob = dob;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getLastname ()
    {
        return lastname;
    }

    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname ()
    {
        return firstname;
    }

    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", email = "+email+", dob = "+dob+", gender = "+gender+", lastname = "+lastname+", firstname = "+firstname+"]";
    }
}