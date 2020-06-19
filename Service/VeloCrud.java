/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Velo;
import java.io.FileNotFoundException;
import java.io.IOException;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author YURI
 */
public class VeloCrud {

    Connection cn2;
    Statement st;
    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getCnx();

    public VeloCrud() {
        cn2 = MyConnection.getInstance().getCnx();

    }

    public ObservableList<Velo> afficher(Velo A) throws SQLException {

        ObservableList<Velo> arr = FXCollections.observableArrayList();
        st = cn2.createStatement();
        ResultSet rs = st.executeQuery("select * from velo");
        while (rs.next()) {

            arr.add(new Velo(rs.getInt("id"), rs.getInt("stock_id"), rs.getString("nom"), rs.getDouble("prixachat"), rs.getDouble("prixvente"), rs.getString("description"), rs.getInt("nbvue"), rs.getInt("nbcommande"),rs.getString("img")));

        }
        return arr;

    }

    public void supprimer(int id) throws SQLException {

        st = cn2.createStatement();
        String q = "delete from velo where id= " + id;
        PreparedStatement pre = cn2.prepareStatement(q);
        st.executeUpdate(q);
        System.out.println("tu as bien supprimé");

    }
    //type boolean pour testerr avant d utiliser refrech and clear fielsets

    public boolean ajouterVelo(Velo a) throws FileNotFoundException, IOException {
        try {
            String requete = "INSERT INTO velo( stock_id, nom, prixachat, prixvente, description, nbvue, nbcommande,img) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setInt(1, a.getStock_id());
            pst.setString(2, a.getNom());
            pst.setDouble(3, a.getPrixachat());
            pst.setDouble(4, a.getPrixvente());
            pst.setString(5, a.getDescription());
            pst.setInt(6, a.getNbvue());
            pst.setInt(7, a.getNbcommande());
            pst.setString(8,a.getImg());
            
            
            
            pst.executeUpdate();
            System.out.println("Velo ajouter avec succes");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Velo> afficherVelo() {

        ArrayList<Velo> ann = new ArrayList<>();
        try {
            String requete3 = "SELECT * FROM velo";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Velo a = new Velo();
                a.setId(rs.getInt("id"));
                a.setStock_id(rs.getInt("stock_id"));
                a.setNom(rs.getString("nom"));
                a.setPrixachat(rs.getDouble("prixachat"));
                a.setPrixvente(rs.getDouble("prixvente"));
                a.setDescription(rs.getString("description"));
                a.setNbvue(rs.getInt("nbvue"));
                a.setNbcommande(rs.getInt("nbcommande"));
                a.setImg(rs.getString("Img"));


                ann.add(a);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ann;
    }

    //type boolean pour testerr avant d utiliser refrech and clear fielsets
    public boolean modifier(Velo A, int id) throws SQLException {

        try {
            if ((A.getNom() != "") && (A.getPrixachat() != 0) && (A.getPrixvente() != 0) && (A.getDescription() != "")) {
                String query = "update velo set nom='" + A.getNom() + "',prixachat='" + A.getPrixachat() + "',prixvente='" + A.getPrixvente() + "',description='" + A.getDescription() + "',nbvue='" + A.getNbvue() + "',nbcommande='" + A.getNbcommande() + "' where Velo.id=" + id;
                st = cn2.createStatement();
                st.executeUpdate(query);
                System.out.println("bien modifiée");
                return true;

            } else {
                System.out.println("tu dois inserer tous les elements");
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public List<Velo> rechercher(String ld, String la) {

        ArrayList<Velo> ann = new ArrayList<>();
        try {
            String requete4 = "SELECT * FROM velo WHERE marque = ? AND description = ? ORDER BY nbvue  ";
            PreparedStatement pst4 = cn2.prepareStatement(requete4);
            pst4.setString(1, ld);
            pst4.setString(2, la);
            ResultSet rs = pst4.executeQuery();

            while (rs.next()) {
                Velo a = new Velo();
                a.setId(rs.getInt("id"));
                a.setStock_id(rs.getInt("stock_id"));
                a.setNom(rs.getString("nom"));
                a.setPrixachat(rs.getInt("prixachat"));
                a.setPrixvente(rs.getInt("prixvente"));
                a.setDescription(rs.getString("description"));
                a.setNbvue(rs.getInt("nbvue"));
                a.setNbcommande(rs.getInt("nbcommande"));
                ann.add(a);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ann;
    }
    
    
       public void afficherVelo(int id) {

        try {
            String sql = "SELECT * FROM velo where id= ?";

            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String nom_club = result.getString(2);
                String domaine_club = result.getString(3);
                int placeDesponible_club = result.getInt(4);

               
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
public boolean     modifiernbvue (Velo A, int id) throws SQLException {

        try {
                String query = "update velo set nbvue='" + A.getNbvue() + "' where Velo.id=" + id;

                st = cn2.createStatement();
                st.executeUpdate(query);
                System.out.println("bien modifiée");
                return true;

           
        } catch (SQLException ex) {
            return false;
        }
        
    }

}
