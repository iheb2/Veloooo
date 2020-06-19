/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import models.User;
import utils.MyConnection;

/**
 *
 * @author YURI
 */
public class GererCrud {

    Connection cn2;
    Statement st;

    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getCnx();

    public GererCrud() {
        cn2 = MyConnection.getInstance().getCnx();

    }
    public void modifier(User A, int id) throws SQLException {

        String query = "update user set username='" + A.getFirstname() + "',email='" + A.getEmail() +   "',password='" + A.getLastname()+"' where user.id=" + id;

        st = cn2.createStatement();
        st.executeUpdate(query);

        System.out.println("bien modifiée");

    }
}
