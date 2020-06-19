/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import utils.MyConnection;
import Entities.cathegorie;
import Entities.evenements;
import Service.ServiceMail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhiro
 */
public class service_evenements {
     Connection con=MyConnection.getInstance().getCnx();
    
    
    private PreparedStatement pre;
    
      public void ajouter(evenements ev) throws SQLException, Exception {
        try{
        Statement ste = con.createStatement();
        String requeteInsert = "INSERT INTO evenements ( nom,nbr,lieu,description,date,prix,cathegorie_id) VALUES ( '" + ev.getNom() + "', '" + ev.getNbr() + "', '" + ev.getLieu() + "', '" + ev.getDescription() + "' , '" + ev.getDate() + "', '" + ev.getPrix() + "', '"+ev.getIdcathegorie()+"')";
        System.out.println(requeteInsert);
        ste.executeUpdate(requeteInsert);
        ServiceMail.SendMail("pirmato00@gmail.com", "chere client on vous informe que l'evenement "+ev.getNom()+" vien d'etre ajouter sur notre site vélo.tn");

        }
         catch(SQLException e) {
             System.out.println(e.getMessage());
        }
       
    }
    
    
    
    
    
    
     
    public void delete(int id) throws SQLException, Exception {
        String query ="DELETE FROM evenements WHERE id="+id; 
        Statement ste=con.createStatement();
        ste.executeUpdate(query) ; 
        ServiceMail.SendMail("pirmato00@gmail.com", "chere client on vous informe qu'un evenement a été supprimé");
    }
    
   
     
    public void modifier( int id, String nom, int nbr, String lieu, String description, String date ,int prix ) throws Exception
      { 
          try 
       {
        String query ="UPDATE evenements SET nom='"+nom+"',nbr='"+nbr+"',description='"+description+"',date='"+date+"',prix='"+prix+"',lieu='"+lieu+"'  WHERE id='"+id+"'";
        Statement ste=con.createStatement();
        ste.executeUpdate(query) ;
       System.out.println("L'évenement  a été modifié avec succés");
      ServiceMail.SendMail("pirmato00@gmail.com", "chere client on vous informque qu'il eu des modification a nos evenements sur notre site vélo.tn");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
    
    /**
     * List All events from Mysql
     * @return Table containing all items
     * @throws SQLException if Sql error occurs
     */
    public List<evenements> afficherEvenement() throws SQLException {
        List<evenements> arr=new ArrayList<>();
        Statement ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from evenements");
        while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString(3);
               int nbr=rs.getInt(4);
               String lieu=rs.getString(5);
               String description=rs.getString(6);
               String date = rs.getString(7);
               int prix = rs.getInt(8);
               int zaglala=rs.getInt("cathegorie_id");
               
            evenements a = new evenements ( id , nom ,  nbr ,  lieu , description , date , prix, zaglala);
           /*service_cathegorie sc = new service_cathegorie();
            cathegorie cat =sc.GetCatById(a.getIdcathegorie());*/
            arr.add(a);
        }
        return arr;
   
    }
         public void chercherParId( int id )
{  try { 
            String query ="SELECT * FROM classe WHERE id='"+id+"'" ; 
            Statement ste=con.createStatement();
           ResultSet rst = ste.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("l'evenement est trouvée") ; 
          } else {
                  System.out.println("l'evenement n'est pas trouvée") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
         
         
         /**
          * Participate to an event
          */
         public void participateToEvent(evenements event, Integer userid) {
             String query = "INSERT INTO participant VALUES("+event.getId()+"," + userid +")";
             try{
                Statement ste=con.createStatement();
                ste.executeUpdate(query);
                try{
                    ServiceMail.SendMail("pirmato00@gmail.com", "chere client on vous informque que vous vennez de particiaper dans l'evenement " +event.getNom()+" qui aura lieu le "+event.getDate()+" ");
                }catch(Exception e){
                    Logger.getLogger(service_evenements.class.getName()).log(Level.WARNING, "Error lors de l'envoie du mail", e);
                }
             }catch(SQLException e){
                 Logger.getLogger(service_evenements.class.getName()).log(Level.SEVERE, "Error lors de la particiaption de l'utilisateur", e);
             }
             
         }
         
         
         
          /**
          * Annuler participation to an event
          */
         public void annulerParticipation(evenements event, Integer userid) {
             String query = "DELETE FROM  participant WHERE id_evenement = "+event.getId()+" AND  user_id = " + userid;
             try{
                Statement ste=con.createStatement();
                ste.executeUpdate(query);
                try{
                    ServiceMail.SendMail("pirmato00@gmail.com", "chere participant on vous informe que vous avez annuler votre participation dans l'evenement  "+ event.getNom()+ "");
                }catch(Exception e){
                    Logger.getLogger(service_evenements.class.getName()).log(Level.WARNING, "Error lors de l'envoie du mail", e);
                }
             }catch(SQLException e){
                 Logger.getLogger(service_evenements.class.getName()).log(Level.SEVERE, "Error lors de l'annulation de la participation de l'utilisateur", e);
             }
             
         }
}
