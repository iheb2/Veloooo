/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Question;
import Entities.Reponse;
import Entities.Utilisateur;
import Entities.archive;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import utils.DbConnection;

/**
 *
 * @author youssef
 */
public class QuestionService {

    static Statement statement = null;
    PreparedStatement pst;

    DbConnection cnx = DbConnection.getInstance();
    Connection connection = cnx.getConnection();

    public List<Question> ListQuestion() {
        List<Question> questions = new ArrayList<Question>();
        String req = "select * from question where status LIKE 'Non Archive' ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                q.setDateQuestion(resultSet.getDate(3));
                q.setBtn_confirmer(new Button("Archiver"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    public List<Question> ListQuestionUtilisateur( int id) {
        List<Question> questions = new ArrayList<Question>();
        String req = "select * from question where user_id = "+id+" AND date >= NOW() - INTERVAL 1 DAY ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                q.setDateQuestion(resultSet.getDate(3));
                q.setBtn_delete(new Button("Supprimer"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    public List<Question> ListQuestionAnciensUtilisateur( int id) {
        List<Question> questions = new ArrayList<Question>();
        String req = "select * from question where user_id = "+id+" ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                q.setBtn_delete(new Button("Supprimer"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    public List<Reponse> ListReponse() {
        List<Reponse> questions = new ArrayList<Reponse>();
        String req = "select * from reponse ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reponse q=new Reponse(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));
                questions.add(q);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    public List<archive> ListArchive() {
        List<archive>  questions = new ArrayList<archive>();
        String req = "select * from archive ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                archive q=new archive(resultSet.getInt(1),resultSet.getInt(2));
                questions.add(q);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return questions;
    }
    
    public List<Question> rechercheQuestions(String str) {
         List<Question> questions=new ArrayList<Question>();
        String sql = "SELECT * FROM question WHERE Nom LIKE ? OR Message LIKE ? ";
        PreparedStatement statement;
        
        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + str + "%");
            statement.setString(2, "%" + str + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                
                questions.add(q);
            }
        } catch (SQLException ex) {
            
        }
        return questions;
    }
    public List<Question> ListTypes() {
        List<Question> types = new ArrayList<Question>();
        String req = "select distinct(Type) from question ORDER BY(id) DESC";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question q=new Question();
                q.setType(resultSet.getString(1));
                types.add(q);
                //types.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return types;
    }
    public List<Question> afficherParCategorie(String str) {
         List<Question> questions=new ArrayList<Question>();
        String sql = "SELECT * FROM question WHERE Type LIKE ? ";
        PreparedStatement statement;
        
        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + str + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                q.setBtn_confirmer(new Button("Archiver"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            
        }
        return questions;
    }
    public Question retournerQuestion(int str) {
         
        String sql = "SELECT * FROM question WHERE id = ?";
        PreparedStatement statement;
        Question q =new Question();
        try {

            statement = connection.prepareStatement(sql);
            statement.setInt(1,  str );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                
            }
        } catch (SQLException ex) {
            
        }
        return q;
    }
    
    public List<String> getState() {
        String req11 = "Select distinct(Type) from question";
        List<String> liste = new ArrayList<String>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(req11);

            while (rs.next()) {

                liste.add(rs.getString(1));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
    public Integer getState12(String x) {
        int g = 0;
        String req11 = "Select id From question where Type=? ";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(req11);

            ps.setString(1, x);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                g++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g;
    }
    public List<Question> afficherTri(String str) {
         List<Question> questions=new ArrayList<Question>();
        String sql = "SELECT * FROM question ORDER BY date "+str;
        PreparedStatement statement;
        
        try {

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Question q=new Question(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8) );
                q.setBtn_confirmer(new Button("Archiver"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            
        }
        return questions;
    }
    
    public Utilisateur retournerUtilisateur(int id ) {
        String req = "select username,email,Phone from fos_user where id = "+id;
         Utilisateur u =new Utilisateur();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               u.setNom(resultSet.getString(1));
               u.setEmail(resultSet.getString(2));
               u.setPhone(resultSet.getInt(3));                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return u;
    }
    
    
    public int ajouterQuestion(Question q) {
        int status = 0;
        String req = "INSERT INTO question(user_id,date,Nom,Type,Email,Phone,Message) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, q.getIdUser());
            preparedStatement.setDate(2, new java.sql.Date(q.getDateQuestion().getTime()));
            preparedStatement.setString(3, q.getNom());
            preparedStatement.setString(4, q.getType());
            preparedStatement.setString(5, q.getEmail());
            preparedStatement.setInt(6, q.getPhone());
            preparedStatement.setString(7, q.getMessage());
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public boolean archiver(int id) {
        String req = "UPDATE question SET status= 'Archive' WHERE id= "+id;
        try {
            pst = connection.prepareStatement(req);
            // System.out.println(c.getId());

            int res = pst.executeUpdate();

            if (res > 0) {
                return true;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return false;
    }
    public void supprimerQuestion(int id) {
        
         String req="DELETE FROM question WHERE id="+id;
              
        try {
            pst = connection.prepareStatement(req);
            int res = pst.executeUpdate();

           
        } catch (SQLException e1) {
                e1.printStackTrace();
        }   
        
    }
    
    public boolean modifierQuestion(Question c) {
        System.out.println(c.getId());
        System.out.println(c.getType());
        System.out.println(c.getMessage());
        String req = "UPDATE question SET Message= ?, Type= ? WHERE id= ?";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, c.getMessage());
            pst.setString(2, c.getType());
            pst.setInt(3, c.getId());
            
            int res = pst.executeUpdate();

            if (res > 0) {
                return true;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return false;
    }
}
