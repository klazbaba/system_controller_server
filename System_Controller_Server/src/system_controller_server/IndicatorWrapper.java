/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_controller_server;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author macbookpro
 */
public class IndicatorWrapper {
    private Circle circle = new Circle(0, 0, 9);
    Text text = new Text("Server Disconnected");
    
    public HBox addHBox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(8, 16, 8, 8));
        hBox.setSpacing(8);
        
        circle.setFill(Color.RED);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(circle, text);
        
        return hBox;
    }
    
    public void toggleCircleColor(int connectionStatus) {
        if(connectionStatus == 0) {
            circle.setFill(Color.GREEN);
            text.setText("Server Connected");
        }
        else {
            circle.setFill(Color.RED);
            text.setText("Server Disconnected");
        }
    }
}
