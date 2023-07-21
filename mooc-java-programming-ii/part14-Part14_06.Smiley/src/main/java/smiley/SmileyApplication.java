package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application{

    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private final int PIXEL_SIZE = 10; // Size of each pixel in pixels

    private final int[][] smileyFace = {
        {0, 0, 1, 1, 1, 1, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {1, 0, 1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 0, 1},
        {1, 0, 0, 1, 1, 0, 0, 1},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 1, 1, 1, 0, 0}
    };

    public static void main(String[] args) {
        System.out.println("Program starts...");
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext paint = canvas.getGraphicsContext2D();

        // Clear the canvas with a white background
        paint.setFill(Color.WHITE);
        paint.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw the smiley face pixel by pixel
        for (int y = 0; y < smileyFace.length; y++) {
            for (int x = 0; x < smileyFace[y].length; x++) {
                if (smileyFace[y][x] == 1) {
                    paint.setFill(Color.BLACK);
                } else {
                    paint.setFill(Color.WHITE);
                }
                int pixelX = x * PIXEL_SIZE;
                int pixelY = y * PIXEL_SIZE;
                paint.fillRect(pixelX, pixelY, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
        
        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(canvas);
        
        Scene view = new Scene(paintingLayout);
        
        window.setScene(view);
        window.show();
    }

}
