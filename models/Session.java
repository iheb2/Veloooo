/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



/**
 *
 * @author esprit
 */
public class Session {
    
    private static User connectedUser;

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        Session.connectedUser = connectedUser;
    }
    
    public static void logOut() {
        Session.connectedUser = null;
    }
    
    
}
