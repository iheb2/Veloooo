/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mouhamedahed
 */
public interface IserviceCommande<T> {
           void AjoutCommande(T t) throws SQLException;
    boolean deleteCommande(int  id) throws SQLException;
    boolean updateCommande(int id) throws SQLException;
    List<T> readAllCommande() throws SQLException;
}
