/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import utils.DbConnection;

/**
 *
 * @author youssef
 */
public class ReponseService {
    static Statement statement = null;
    PreparedStatement pst;

    DbConnection cnx = DbConnection.getInstance();
    Connection connection = cnx.getConnection();
    public int ajouterCommentaireForum(Reponse cf) {
        int status = 0;
        String req = "INSERT INTO reponse(Reponse,Question_id) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, cf.getReponse());
            preparedStatement.setInt(2, cf.getQuestionId());
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
