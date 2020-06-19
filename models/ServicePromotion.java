/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Entities.Accessoire;
import Entities.Promotions;
import Service.IservicePromotion;
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouhamedahed
 */
public class ServicePromotion implements IservicePromotion<Promotions> {

    @Override
    public void AjoutPromotions(Promotions Pr) throws SQLException {
        
         try {
            String query = "INSERT INTO `integ`.`promotion` ( `accessoire_id`, `startDate`, `	finishDate`, `percentage`) values (?,?,?,?)";
            PreparedStatement ps;

            ps = MyConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,Pr.getAccessoire_id().getId());
            ps.setDate(2, Pr.getStartDate());
            ps.setDate(3, Pr.getFinishDate());
            ps.setInt(4, Pr.getPercentage());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAccessoire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public boolean deletePromotions(Promotions Ac) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePromotions(Promotions Ac) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Promotions> readAllPromotions() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Promotions> searchPromotionsByID(String ch) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accessoire GetPromotionsbyid(int b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
