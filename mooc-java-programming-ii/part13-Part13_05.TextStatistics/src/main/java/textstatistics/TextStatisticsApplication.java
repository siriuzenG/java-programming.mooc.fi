package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        
        BorderPane layout = new BorderPane();
        TextArea txtArea = new TextArea();
        layout.setCenter(txtArea);
        
        HBox bottom = new HBox();
        bottom.setSpacing(10);
        
        Label letter = new Label("Letters: 0");
        Label number = new Label("Words: 0");
        Label longest = new Label("The longest word is:");
        
        bottom.getChildren().addAll(letter, number, longest);
        layout.setBottom(bottom);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
