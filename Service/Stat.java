

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author amena
 */
public class Stat {
    
    
    
              
    public static int totaleSP = 0;
    public static int totaleP = 0;
      public static int totalePR = 0;
      public static int totaleAD = 0;
    
    Connection con=MyConnection.getInstance().getCnx();

    public void calculatereportspermonth() throws SQLException {
 
        
        
        
        
        
        

        

             Statement statement =con.createStatement();
   
       
                String request = "SELECT * FROM evenements ";
            
            
            
            ResultSet rs = statement.executeQuery(request);
            while (rs.next()) {
                
                if ((rs.getInt(2)==1)) {
                    totaleSP += 1;
                   

               }
                
                
                else if ((rs.getInt(2)==2)) {
                    totaleP += 1;
                
                }  
                    
                
                else if ((rs.getInt(2)==3)) {
                    totalePR += 1;
                
                }  
                
                
                
                 else if ((rs.getInt(2)==5)) {
                    totaleAD += 1;}  

            }

        } 

    } 
    

    
    
    
    
    
    
    
    
    
    
    
    
