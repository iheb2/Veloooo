/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velo.Iservice;

import com.velo.Entity.Accessoire;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mouhamedahed
 */
public interface IserviceAccessoire<T>{
       void AjoutAccessoire(T t) throws SQLException;
    boolean deleteAccessoire(Accessoire Ac) throws SQLException;
    void updateAccessoire(Accessoire Ac) throws SQLException;
    List<T> readAllAccessoire() throws SQLException;
    public List<T>searchAccessoireByID(String ch) throws SQLException;
    public Accessoire GetAccessoirebyid(int b) throws SQLException;
     public List<Accessoire> RechercheAccessoireParNom(String recherche);
}
