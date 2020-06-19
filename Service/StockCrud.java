/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Stock;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author YURI
 */
public class StockCrud {

    Connection cn2;
    Statement st;

    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getCnx();

    public StockCrud() {
        cn2 = MyConnection.getInstance().getCnx();

    }

    public void supprimer(int id) throws SQLException {

        st = cn2.createStatement();
        String q = "delete from stock where id= " + id;
        PreparedStatement pre = cn2.prepareStatement(q);
        st.executeUpdate(q);
        System.out.println("tu as bien supprimé");

    }

    public void ajouterStock(Stock a) {
        try {
            String requete = "INSERT INTO stock (cte,marque) VALUES (?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete);

            pst.setInt(1, a.getCte());
            pst.setString(2, a.getMarque());

            pst.executeUpdate();
            System.out.println("stock ajouter avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Stock> afficher(Stock A) throws SQLException {

        
        
        
        
        
        ObservableList<Stock> arr = FXCollections.observableArrayList();
        st = cn2.createStatement();
        ResultSet rs = st.executeQuery("select * from stock");
        while (rs.next()) {
            arr.add(new Stock(rs.getInt("id"), rs.getInt("cte"), rs.getString("marque")));

        }
        return arr;

    }

    public void modifier(Stock A, int id) throws SQLException {

        try {
            
            if ((A.getMarque() != "") && (A.getCte() != 0)) {
                String query = "update stock set cte='" + A.getCte() + "',marque='" + A.getMarque() + "' where Stock.id=" + id;

                st = cn2.createStatement();
                st.executeUpdate(query);

                System.out.println("bien modifiée");

            } else {
                System.out.println("tu dois inserer tous les elements");
            }
        } catch (SQLException ex) {

        }

    }

    public List<Stock> rechercher(String ld, String la) {

        ArrayList<Stock> ann = new ArrayList<>();
        try {
            String requete4 = "SELECT * FROM Stock WHERE cte = ? AND marque = ? ORDER BY cte  ";
            PreparedStatement pst4 = cn2.prepareStatement(requete4);
            pst4.setString(1, ld);
            pst4.setString(2, la);
            ResultSet rs = pst4.executeQuery();

            while (rs.next()) {
                Stock a = new Stock();
                a.setId(rs.getInt("id"));
                a.setCte(rs.getInt("cte"));
                a.setMarque(rs.getString("marque"));

                ann.add(a);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ann;
    }

    public List<Stock> findAll() {

        String sql = "SELECT * FROM stock  ";
        List<Stock> list = new ArrayList<>();
        try {
            PreparedStatement pst4 = cn2.prepareStatement(sql);

            ResultSet rs = pst4.executeQuery();
            while (rs.next()) {

                Stock a = new Stock(rs.getInt("id"), rs.getInt("cte"), rs.getString("marque"));

                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Stock findById(int id) {

        String sql = "select * from stock where id=?";

        try {
            PreparedStatement statement = cn2.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return new Stock(result.getInt("id"), result.getInt("cte"), result.getString("marque"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(StockCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
