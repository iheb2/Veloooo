/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Entities.Accessoire;
import Entities.Commande;
import Service.IserviceCommande;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouhamedahed
 */
public class ServiceCommande implements IserviceCommande<Commande> {
 private Connection con;
    private Statement ste;

    public ServiceCommande() {
        con = MyConnection.getInstance().getConnection();

    }
    @Override
    public void AjoutCommande(Commande commande) throws SQLException {
       try {

            String query = "INSERT INTO `commande`(`Accessoire`,`datecom`,`user`,`prixtotale`, `valide`) values (?,?,?,?,?)";
            PreparedStatement ps; 
            ps = MyConnection.getInstance().getConnection().prepareStatement(query);
           ps.setInt(1, commande.getIdproduit().getId());
            ps.setDate(2,commande.getDatecom());
           ps.setInt(3,commande.getUser());
            ps.setDouble(4,commande.getPrixtotale());
            ps.setInt(5, commande.getValide());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAccessoire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean deleteCommande(int id) throws SQLException {
 String requete = "DELETE from commande where ID=?";
         
            PreparedStatement st =con.prepareStatement(requete);
            st.setInt(1,id);
            st.executeUpdate();
            System.out.println("Commande supprimer.");
        return true;     }

    @Override
    public boolean updateCommande(int id) throws SQLException {
          String requete = "UPDATE commande set prixtotale=? WHERE ID='"+id+"'";
        
            PreparedStatement st = con.prepareStatement(requete);
            st.setString(1,"5");
            st.executeUpdate();
            System.out.println(" Commande changee");
            return true;
        }

     public Accessoire findproduitbyid(int id)
    {
        try{

        Statement st=con.createStatement();
        ResultSet rest=st.executeQuery("SELECT * FROM Accessoire where id='"+id+"'");
            while (rest.next()){
                        Accessoire pr = new Accessoire();

     pr.setId(rest.getInt("id"));
                pr.setName(rest.getString("name"));
                pr.setPrice(rest.getDouble("price"));
                pr.setQuantite(rest.getInt("quantite"));
                pr.setImage(rest.getString("image"));
                pr.setModele(rest.getString("modele"));
                pr.setDescription(rest.getString("description"));
                    
                
                return pr;
            }
                
        }
        catch (SQLException e){
            
            
        }
             return null;                
    }

    
    public Commande getCommandeById(int id)
    {
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM commande where id='"+id+"'");
            while (rs.next())
            {
             Commande c=new Commande();
             c.setId(rs.getInt("id"));
              c.setDatecom(rs.getDate("datecom"));
                  c.setValide(rs.getInt("valide"));
             c.setPrixtotale(rs.getDouble("prixTotale"));
             return c;
            }
                
        }
        catch (SQLException e){
        }
                    return null;
    }

        @Override
    public List<Commande> readAllCommande() throws SQLException {
                List<Commande> arr = new ArrayList<>();
    
                
                
                ste = con.createStatement();
        
         ResultSet rs = ste.executeQuery("select * from commande");
        while (rs.next()) {
            
            
            Commande cmd=new Commande();


           int idp=rs.getInt(2);
        Date dat=rs.getDate(3);
            int user = rs.getInt(4);
            int valide=rs.getInt(6);
            double prixtotale = rs.getInt(5);
          // User c = findbyid(user);
       //  String nomuser=c.getUsername();
          //  System.out.println(nomuser);
          //cmd.setUser( ).getNomUser();
           Accessoire p=findproduitbyid(idp);
           cmd.getId();
           cmd.setIdproduit(p);
           cmd.setPrixtotale(prixtotale);
           cmd.setDatecom(dat);
           cmd.setValide(valide);
           arr.add(cmd);
        }
        return arr;
    }
       public void valide_btn(Commande a) throws SQLException
    {
        String query="update commande set valide=? where id=? ";
        PreparedStatement ps;
            ps = MyConnection.getInstance().getConnection().prepareStatement(query);
           
            ps.setInt(1,1);
            ps.setInt(2,a.getId());
           
        ps.executeUpdate();

    }
        public static java.util.Date convertirDate(int d){
         Timestamp stamp = new Timestamp(d);
         java.util.Date date = new java.util.Date(stamp.getTime());
         return(date);
     }

 
}
