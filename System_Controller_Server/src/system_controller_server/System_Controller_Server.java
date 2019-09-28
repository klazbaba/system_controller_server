/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_controller_server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 *
 * @author macbookpro
 */
public class System_Controller_Server extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Circle circle = new Circle(0, 0, 6);
        
        btn.setText("Start Server");
        btn.setOnAction((ActionEvent event) -> {
            Server server = new Server(3000);
            btn.setVisible(false);
            System.out.println(server);
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(circle);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
