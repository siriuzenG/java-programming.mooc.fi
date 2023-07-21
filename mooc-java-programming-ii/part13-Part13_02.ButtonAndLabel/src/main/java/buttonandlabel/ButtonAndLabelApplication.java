package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application{

    @Override
    public void start(Stage window) {
        Label label = new Label("This is a Label");
        Button button = new Button("This is a Button");
        
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(label, button);
        
        Scene scene = new Scene(flowPane, 1280, 720);
        window.setScene(scene);
        
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
