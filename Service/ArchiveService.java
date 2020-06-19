/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Question;
import Entities.Reponse;
import Entities.archive;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import utils.DbConnection;

/**
 *
 * @author youssef
 */
public class ArchiveService {
    static Statement statement = null;
    PreparedStatement pst;

    DbConnection cnx = DbConnection.getInstance();
    Connection connection = cnx.getConnection();

    public int ajouterArchive(int id) {
        int status = 0;
        String req = "INSERT INTO archive(question_id) VALUES(?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public List<archive> ListArchives() {
        List<archive> questions = new ArrayList<archive>();
        String req = "select * from archive ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                archive ar=new archive(resultSet.getInt(1), resultSet.getInt(2));
                QuestionService service =new QuestionService();
                Question q =service.retournerQuestion(ar.getQuestionId());
                System.out.println("waaaaaa"+q);
                ar.setDate(q.getDateQuestion());
                ar.setNom(q.getNom());
                ar.setType(q.getType());
                ar.setEmail(q.getEmail());
                ar.setPhone(q.getPhone());
                ar.setMessage(q.getMessage());
                ar.setBtn_delete(new Button("Supprimer"));
                questions.add(ar);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    public void supprimerInscription(int id) {
        
         String req="DELETE FROM archive WHERE id="+id;
              
        try {
            pst = connection.prepareStatement(req);
            int res = pst.executeUpdate();

           
        } catch (SQLException e1) {
                e1.printStackTrace();
        }   
        
    }
}
