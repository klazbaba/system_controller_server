/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_controller_server;

import java.io.IOException;
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
    private int connectionStatus = 0;
    Button btn = new Button();
    IndicatorWrapper topRegion = new IndicatorWrapper();
    Server server = null;

    private void updateConnectionStatus(Button button) {
        if(connectionStatus == 0) {
            connectionStatus = 1;
            button.setText("Stop Server");
        }else {
            connectionStatus = 0;
            button.setText("Start Server");
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderLayout = new BorderPane();
        
        btn.setText("Start Server");
        btn.setPrefWidth(100);
        btn.setOnAction((ActionEvent event) -> {
            try {
                toggleServer();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        
        StackPane root = new StackPane();
        
        borderLayout.setTop(topRegion.addHBox());
        borderLayout.setCenter(btn);
        root.getChildren().add(borderLayout);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("System Controller");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void toggleServer() throws IOException {
        if(connectionStatus == 0) {
            server = new Server(3000);
        }else {
            server.closeConnection();
        }
        topRegion.toggleCircleColor(connectionStatus);
        updateConnectionStatus(btn);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
