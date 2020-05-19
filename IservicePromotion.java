/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velo.Iservice;

import com.velo.Entity.Accessoire;
import com.velo.Entity.Promotions;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mouhamedahed
 */
public interface IservicePromotion <T>{
        void AjoutPromotions(T t) throws SQLException;
    boolean deletePromotions(Promotions Ac) throws SQLException;
    void updatePromotions(Promotions Ac) throws SQLException;
    List<T> readAllPromotions() throws SQLException;
    public List<T>searchPromotionsByID(String ch) throws SQLException;
    public Accessoire GetPromotionsbyid(int b) throws SQLException;
    
    
    
}
