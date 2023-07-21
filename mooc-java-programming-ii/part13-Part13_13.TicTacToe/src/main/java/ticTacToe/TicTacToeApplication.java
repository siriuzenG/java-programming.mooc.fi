package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private boolean turn = true;
    private Button[][] buttons = new Button[3][3];
    private boolean gameEnded = false;
    private Label headerText;

    @Override
    public void start(Stage window) {
        initializeUI(window);
        setupButtons();
    }

    private void initializeUI(Stage window) {
        BorderPane layout = new BorderPane();

        HBox header = new HBox();
        GridPane board = new GridPane();

        headerText = new Label("Turn: X");
        headerText.setFont(Font.font("Arial", 18));
        headerText.setPrefSize(200, 100);

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetGame());
        resetButton.setPrefSize(100, 50);
        
        header.getChildren().addAll(headerText, resetButton);
        header.setAlignment(Pos.CENTER);
        header.setPrefSize(300, 100);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button("");
                buttons[row][col].setPrefSize(100, 100);
                buttons[row][col].setFont(Font.font("Monospaced", 40));
                board.add(buttons[row][col], col, row);
            }
        }
        
        board.setAlignment(Pos.CENTER);
        board.setPrefSize(300, 300);
        
        layout.setTop(header);
        layout.setCenter(board);
        
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.setTitle("Tic Tac Toe");
        window.setResizable(false);
        window.show();
    }

    private void setupButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setOnAction(e -> handleButtonClick((Button) e.getSource()));
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (gameEnded || !button.getText().isEmpty()) return;

        String currentPlayer = turn ? "X" : "O";
        button.setText(currentPlayer);
        headerText.setText("Turn: " + (turn ? "O" : "X"));
        turn = !turn;

        checkForWin();
    }

    private void checkForWin() {
        String winner = null;
        int totalMoves = 0;

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().isEmpty() &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][0].getText().equals(buttons[i][2].getText())) {
                winner = buttons[i][0].getText();
                break;
            }
            if (!buttons[0][i].getText().isEmpty() &&
                    buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[0][i].getText().equals(buttons[2][i].getText())) {
                winner = buttons[0][i].getText();
                break;
            }
        }

        // Check diagonals
        if (!buttons[0][0].getText().isEmpty() &&
                buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[0][0].getText().equals(buttons[2][2].getText())) {
            winner = buttons[0][0].getText();
        }
        if (!buttons[0][2].getText().isEmpty() &&
                buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[0][2].getText().equals(buttons[2][0].getText())) {
            winner = buttons[0][2].getText();
        }

        // Check for a tie
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!buttons[row][col].getText().isEmpty()) {
                    totalMoves++;
                }
            }
        }

        if (winner != null) {
            headerText.setText("The end! Winner: " + winner);
            gameEnded = true;
        } else if (totalMoves == 9) {
            headerText.setText("It's a tie!");
            gameEnded = true;
        }
    }

    private void resetGame() {
        // Clear the board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }

        // Reset game state
        turn = true;
        gameEnded = false;

        // Reset header text
        headerText.setText("Turn: X");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
