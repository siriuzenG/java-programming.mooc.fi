package buttonandtextfield;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{
    @Override
    public void start(Stage window) {
        TextField txt = new TextField();
        txt.setPromptText("Enter your name");
        
        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            String name = txt.getText();
            System.out.println("Hello, " + name + "!");
        });
        
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(txt, btn);
        
        Scene scene = new Scene(flowPane, 1280, 720);
        window.setScene(scene);
        
        
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
