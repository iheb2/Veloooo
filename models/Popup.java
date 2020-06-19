/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Entities.Velo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JLabel;

/**
 *
 * @author esprit
 */
public class Popup {

    public static void display(String imageUrl) {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Alerte de stock !");

        Label label1 = new Label("Pop up window now displayed");

        Button button1 = new Button("Close this pop up window");
        
        Label label = new Label( imageUrl);

        button1.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label);

        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }

}
