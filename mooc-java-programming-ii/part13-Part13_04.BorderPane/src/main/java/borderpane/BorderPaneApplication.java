package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application{

    @Override
    public void start(Stage window) {
        // Create a BorderPane
        BorderPane borderPane = new BorderPane();

        // Create a label for the top edge
        Label northLabel = new Label("NORTH");
        borderPane.setTop(northLabel);

        // Create a label for the right edge
        Label eastLabel = new Label("EAST");
        borderPane.setRight(eastLabel);

        // Create a label for the bottom edge
        Label southLabel = new Label("SOUTH");
        borderPane.setBottom(southLabel);

        // Create the Scene with the BorderPane
        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
