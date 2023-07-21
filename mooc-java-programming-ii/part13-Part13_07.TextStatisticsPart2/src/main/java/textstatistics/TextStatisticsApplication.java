package textstatistics;

import java.util.Arrays;
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
        // title
        window.setTitle("Text Statistics");
        
        // ui components
        TextArea txtArea = new TextArea();
        Label numLetters = new Label("Letters: 0");
        Label numWords = new Label("Words: 0");
        Label longestWords = new Label("The longest word is: ");
        
        // ui layout
        HBox stats = new HBox();
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout);
        
        // if there is changes in text area
        txtArea.textProperty().addListener((change, oldValue, newValue) -> {
            int numLetter = newValue.length();
            numLetters.setText("Letters: " + numLetter);
            
            String[] parts = newValue.split(" ");
            int numWord = parts.length;
            numWords.setText("Words: " + numWord);
            
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longestWords.setText("The longest word is: " + longest);
        });
        txtArea.setWrapText(true);
        
        // stats layout
        stats.setSpacing(15);
        stats.getChildren().addAll(numLetters, numWords, longestWords);
        
        // window layout
        layout.setCenter(txtArea);
        layout.setBottom(stats);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
