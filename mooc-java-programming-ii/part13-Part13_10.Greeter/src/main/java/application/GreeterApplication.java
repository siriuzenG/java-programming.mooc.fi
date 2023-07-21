package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{

    @Override
    public void start(Stage window) throws Exception {
        // 1. User view
        // 1.a Components
        Label lblUser = new Label("Enter your name and start.");
        TextField txtUser = new TextField();
        Button start = new Button("start");
        
        // 1.b Layout
        GridPane userLayout = new GridPane();
        
        // 1.b.1 Add components to layout
        userLayout.add(lblUser, 0, 0);
        userLayout.add(txtUser, 0, 1);
        userLayout.add(start, 0, 2);
        
        // 1.b.2 Styling layout
        userLayout.setPrefSize(400, 200);
        userLayout.setAlignment(Pos.CENTER);
        userLayout.setVgap(10);
        userLayout.setHgap(10);
        userLayout.setPadding(new Insets(20, 20, 20, 20));
        
        // 1.c Finalize by creating as a new Scene
        Scene userScene = new Scene(userLayout);
        
        // 2. Greetings view
        // 2.a Components
        Label lblGreet = new Label();
        
        // 2.b Layout
        StackPane welcomeLayout = new StackPane();
        
        // 2.b.1 Add components to layout
        welcomeLayout.getChildren().add(lblGreet);
        
        // 2.b.2 Styling layout
        welcomeLayout.setPrefSize(400, 200);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        // 2.c Finalize by creating as a new Scene
        Scene welcomeScene = new Scene(welcomeLayout);
        
        // 3. Handling changes
        // button handling
        start.setOnAction(e -> {
            lblGreet.setText("Welcome " + txtUser.getText() + "!");
            window.setScene(welcomeScene);
        });
        
        
        // 4. Finalize
        window.setScene(userScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
