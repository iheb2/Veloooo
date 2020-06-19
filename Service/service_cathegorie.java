/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import utils.MyConnection;
import Entities.cathegorie;
import Entities.evenements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhiro
 */
public class service_cathegorie {
     Connection con=MyConnection.getInstance().getCnx();
    
    
    private PreparedStatement pre;
    
      public void ajouter(cathegorie cat) throws SQLException {
        try{
        Statement ste = con.createStatement();
        String requeteInsert = "INSERT INTO cathegorie (type) VALUES ( '" + cat.getType() + "')";
        ste.executeUpdate(requeteInsert);}
         catch(SQLException e) {
             System.out.println(e.getMessage());
        }
       
    }
    
    
    
    
    
    
     
      public void delete(int id) throws SQLException {
            try { 
            String query ="DELETE FROM cathegorie WHERE id="+id; 
            Statement ste=con.createStatement();
            ste.executeUpdate(query) ; 
            System.out.println("la cathegorie de l id = "+id+"a été supprimée ") ; 
           
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
        
    }
    
   
     
    public void modifier( int id, String type )
      { 
          try 
       {
        String query ="UPDATE cathegorie SET type='"+type+"' WHERE id='"+id+"'";
        Statement ste=con.createStatement();
        ste.executeUpdate(query) ;
       System.out.println("La cathégorie a été modifié avec succés");
} catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
    
}
    
    
        public List<cathegorie> afficherCathegorie() throws SQLException {
    List<cathegorie> arr=new ArrayList<>();
    Statement ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from cathegorie");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String type=rs.getString(2);
              
               
                 
        cathegorie a = new cathegorie ( id ,type);
     arr.add(a);
     }
    return arr;
    
    
    
    
    
    
    
    
    
    
    
    
}
        
        
         public cathegorie GetCatById( int id )
{  try { 
            String query ="SELECT * FROM cathegorie WHERE id='"+id+"'" ; 
            Statement ste=con.createStatement();
            ResultSet rst = ste.executeQuery(query);
            rst.last();
            cathegorie a = new cathegorie ( );
            while (rst.next()) {                
               int idc=rst.getInt(1);
               String type=rst.getString(2);
                a.setId(idc);
                a.setType(type);
            }
              return a;
               
                 
        
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            return null;
        }
}
         public void chercherParId( int id )
{  try { 
            String query ="SELECT * FROM cathegorie WHERE id='"+id+"'" ; 
            Statement ste=con.createStatement();
           ResultSet rst = ste.executeQuery(query);
         rst.last();
          int nbr =rst.getRow() ;  
          if (nbr!=0)
          {
                  System.out.println("cathegorie est trouvée") ; 
          } else {
                  System.out.println("cathegorie n'est pas trouvée") ; 
          }
              
        
           
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage()) ; 
            
        }
}
}
