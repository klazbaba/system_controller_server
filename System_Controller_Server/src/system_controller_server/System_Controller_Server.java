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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author macbookpro
 */
public class System_Controller_Server extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderLayout = new BorderPane();
        Button btn = new Button();
        
        btn.setText("Start Server");
        btn.setOnAction((ActionEvent event) -> {
            Server server = new Server(3000);
            btn.setVisible(false);
            System.out.println(server);
        });
        
        StackPane root = new StackPane();
        IndicatorWrapper topRegion = new IndicatorWrapper();
        
        borderLayout.setTop(topRegion.addHBox());
        borderLayout.setCenter(btn);
        root.getChildren().add(borderLayout);
        
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
