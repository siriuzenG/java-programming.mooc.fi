package notifier;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    private TextField textField;
    private Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create the components
        textField = new TextField();
        Button button = new Button("Copy");
        label = new Label();

        // Set the action for the button
        button.setOnAction(e -> copyText());

        // Create the VBox layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(textField, button, label);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Notifier Application");
        primaryStage.show();
    }

    private void copyText() {
        String text = textField.getText();
        label.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
