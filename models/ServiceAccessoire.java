/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Entities.Accessoire;
import Service.IserviceAccessoire;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouhamedahed
 */
public class ServiceAccessoire implements IserviceAccessoire<Accessoire> {
    private Connection con;
    private Statement ste;

    public ServiceAccessoire() {
        con = MyConnection.getInstance().getConnection();

    }
    @Override
    public void AjoutAccessoire(Accessoire A) throws SQLException {
 try {
            String query = "INSERT INTO `integ`.`accessoire` ( `name`, `quantite`, `price`, `description`, `modele`, `image`) values (?,?,?,?,?,?)";
            PreparedStatement ps;

            ps = MyConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, A.getName());
            ps.setInt(2, A.getQuantite());
            ps.setDouble(3, A.getPrice());
            ps.setString(4, A.getDescription());
            ps.setString(5, A.getImage());
            ps.setString(6, A.getModele());
      
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAccessoire.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Override
    public boolean deleteAccessoire(Accessoire Ac) throws SQLException {
     String requete = "DELETE from accessoire where ID=?";

        PreparedStatement st = con.prepareStatement(requete);
        st.setInt(1, Ac.getId());
        st.executeUpdate();
        System.out.println("accessoire supprime.");
        return true;    }

    @Override
    public void updateAccessoire(Accessoire Ac) throws SQLException {
               //-------------------- Update ----------//

        String reqUp = "update product set quantite=?, name=? ,description=? where id=?";
        PreparedStatement st = con.prepareStatement(reqUp);

        st.setInt(1, Ac.getQuantite());
        st.setString(2, Ac.getName());
        st.setString(3, Ac.getDescription());
        st.setInt(4, Ac.getId());
        st.executeUpdate();
             
    }

    @Override
    public List<Accessoire> readAllAccessoire() throws SQLException {
       Statement ste = con.createStatement();

        List<Accessoire> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from accessoire");
        while (rs.next()) {
       int id = rs.getInt(1);
            String name = rs.getString(2);
            int quantite = rs.getInt(3);
            Double price = rs.getDouble(4);
            String description = rs.getString(5);
            String modele = rs.getString(6);
            String image = rs.getString(7);
            Accessoire a = new Accessoire(id, name, quantite, price, description, modele, image);
            arr.add(a);
        }
        return arr;    }


    @Override
       public Accessoire GetAccessoirebyid(int b) throws SQLException {
        //-------------------- Update ----------//
        Accessoire pr = new Accessoire();

        String query = "select * from Accessoire where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, b);
            ResultSet rest = ps.executeQuery();

            while (rest.next()) {

                pr.setId(rest.getInt("id"));
                pr.setName(rest.getString("name"));
                pr.setPrice(rest.getDouble("price"));
                pr.setQuantite(rest.getInt("quantite"));
                pr.setImage(rest.getString("image"));
                pr.setModele(rest.getString("modele"));
                pr.setDescription(rest.getString("description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAccessoire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;

    }
      @Override 
    public List<Accessoire> RechercheAccessoireParNom(String recherche) {

        List ALLproducts = new ArrayList();
        try {
            String query = "select * from Accessoire WHERE name LIKE '%" + recherche + "%';";
            ste = con.createStatement();
            ResultSet rest = ste.executeQuery(query);
            while (rest.next()) {
                Accessoire pr = new Accessoire();

     pr.setId(rest.getInt("id"));
                pr.setName(rest.getString("name"));
                pr.setPrice(rest.getDouble("price"));
                pr.setQuantite(rest.getInt("quantite"));
                pr.setImage(rest.getString("image"));
                pr.setModele(rest.getString("modele"));
                pr.setDescription(rest.getString("description"));
                ALLproducts.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAccessoire.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ALLproducts;

    }

    @Override
    public List<Accessoire> searchAccessoireByID(String ch) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void u(Accessoire P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
