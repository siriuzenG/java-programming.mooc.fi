package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{

    @Override
    public void start(Stage window) {
        
        // Components
        Button btn1Menu = new Button("Joke");
        Button btn2Menu = new Button("Answer");
        Button btn3Menu = new Button("Explanation");
        
        // Layout
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        StackPane explanation = createView("What do you call a bear with no teeth?");
        
        // Layout add components
        menu.getChildren().addAll(btn1Menu, btn2Menu, btn3Menu);
        layout.setTop(menu);
        layout.setCenter(explanation);
        
        // Layout styles
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        // Button handling
        btn1Menu.setOnAction(e -> {
            layout.setCenter(explanation);
        });
        
        btn2Menu.setOnAction(e -> {
            layout.setCenter(createView("A gummy bear."));
        });
        
        btn3Menu.setOnAction(e -> {
            layout.setCenter(createView("This the joke explanation"));
        });
        
        window.setScene(new Scene(layout));
        window.show();
    }
    
    private StackPane createView(String txt) {
        StackPane layout = new StackPane();
        Label lbl = new Label(txt);
        
        layout.getChildren().add(lbl);
        layout.setPrefSize(400, 200);
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
