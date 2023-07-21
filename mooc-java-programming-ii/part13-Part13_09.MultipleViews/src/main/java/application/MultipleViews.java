package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    @Override
    public void start(Stage window) {
        window.setTitle("Multiple Views");
        
        BorderPane bp = new BorderPane();
        Label lbl1 = new Label("First view!");
        Button btn1 = new Button("To the second view!");
        Scene firstScene = new Scene(bp);
        
        VBox vbox = new VBox();
        Button btn2 = new Button("To the third view!");
        Label lbl2 = new Label("Second view!");
        Scene secondScene = new Scene(vbox);
        
        GridPane gp = new GridPane();
        Label lbl3 = new Label("Third view!");
        Button btn3 = new Button("To the first view!");
        Scene thirdScene = new Scene(gp);
        
        bp.setTop(lbl1);
        bp.setCenter(btn1);
        btn1.setOnAction(e -> {
            window.setScene(secondScene);
        });
        
        vbox.getChildren().addAll(btn2, lbl2);
        btn2.setOnAction(e -> {
            window.setScene(thirdScene);
        });
        
        gp.add(lbl3, 0, 0);
        gp.add(btn3, 1, 1);
        btn3.setOnAction(e -> {
            window.setScene(firstScene);
        });
        
        window.setScene(firstScene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
