package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Step 1: Load the original Mona Lisa image
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        // Step 2: Create a smaller image in the top left corner (one-fourth of the original image size)
        int smallerWidth = width / 2;
        int smallerHeight = height / 2;
        WritableImage smallImage = new WritableImage(smallerWidth, smallerHeight);
        PixelWriter smallImageWriter = smallImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < smallerHeight) {
            int xCoordinate = 0;
            while (xCoordinate < smallerWidth) {
                Color color = imageReader.getColor(xCoordinate * 2, yCoordinate * 2); // Scale down by 2
                smallImageWriter.setColor(xCoordinate, yCoordinate, color);
                xCoordinate++;
            }
            yCoordinate++;
        }

        // Step 3: Create a grid of four small images
        WritableImage collageImage = new WritableImage(width, height);
        PixelWriter collageImageWriter = collageImage.getPixelWriter();

        // Top-left quadrant
        for (yCoordinate = 0; yCoordinate < smallerHeight; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < smallerWidth; xCoordinate++) {
                Color color = smallImage.getPixelReader().getColor(xCoordinate, yCoordinate);
                collageImageWriter.setColor(xCoordinate, yCoordinate, color);
            }
        }

        // Top-right quadrant
        for (yCoordinate = 0; yCoordinate < smallerHeight; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < smallerWidth; xCoordinate++) {
                Color color = smallImage.getPixelReader().getColor(xCoordinate, yCoordinate);
                collageImageWriter.setColor(xCoordinate + smallerWidth, yCoordinate, color);
            }
        }

        // Bottom-left quadrant
        for (yCoordinate = 0; yCoordinate < smallerHeight; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < smallerWidth; xCoordinate++) {
                Color color = smallImage.getPixelReader().getColor(xCoordinate, yCoordinate);
                collageImageWriter.setColor(xCoordinate, yCoordinate + smallerHeight, color);
            }
        }

        // Bottom-right quadrant
        for (yCoordinate = 0; yCoordinate < smallerHeight; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < smallerWidth; xCoordinate++) {
                Color color = smallImage.getPixelReader().getColor(xCoordinate, yCoordinate);
                collageImageWriter.setColor(xCoordinate + smallerWidth, yCoordinate + smallerHeight, color);
            }
        }

        // Step 4: Convert the image to its negative
        for (yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < width; xCoordinate++) {
                Color color = collageImage.getPixelReader().getColor(xCoordinate, yCoordinate);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();
                Color newColor = new Color(red, green, blue, opacity);
                collageImageWriter.setColor(xCoordinate, yCoordinate, newColor);
            }
        }

        ImageView image = new ImageView(collageImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
