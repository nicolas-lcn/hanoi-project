package com.mycompany.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.net.URL;



public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	URL url = new File("src/main/resources/app/hanoiapp/view/hanoiapp.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Towers of Hanoi");
        stage.setScene(new Scene(root));
        stage.setMinHeight(700);
        stage.setMinWidth(1100);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}