package application;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        System.out.println("Program starting...");
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        // declare components
        DecimalFormat number = new DecimalFormat("#.0#");
        BorderPane layout = new BorderPane();
        
        VBox top = new VBox();
        
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        
        Label lblSliderMS = new Label("Monthly savings");
        Slider monthlySavings = new Slider(25, 250, 25);
        Label lblMSValue = new Label("25.0");
        
        Label lblSliderYIR = new Label("Yearly interest rate");
        Slider yearlyInterestRate = new Slider(0, 10, 0);
        Label lblYIRValue = new Label("0.0");
        
        XYChart.Series MS = new XYChart.Series();
        XYChart.Series YIR = new XYChart.Series();
        
        // set components properties
        
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(30);
        
        monthlySavings.setShowTickLabels(true);
        monthlySavings.setShowTickMarks(true);
        yearlyInterestRate.setShowTickLabels(true);
        yearlyInterestRate.setShowTickMarks(true);
        
        top.getChildren().addAll(
                new BorderPane(monthlySavings, null, lblMSValue, null, lblSliderMS),
                new BorderPane(yearlyInterestRate, null, lblYIRValue, null, lblSliderYIR)
        );
        
        lineChart.getData().add(MS);
        lineChart.getData().add(YIR);
        
        // set components handler
        monthlySavings.valueProperty().addListener(
            (obs, oldValue, newValue) -> {
                lblMSValue.setText(number.format(newValue));
            }
        );
        monthlySavings.setOnMouseReleased((e) -> {
            MS.getData().clear();
            double val = monthlySavings.getValue();
            for (int i = 0; i <= 30; i++) {
                MS.getData().add(new XYChart.Data(i, i*12*val));
            }
        });
        
        yearlyInterestRate.valueProperty().addListener(
            (obs, oldValue, newValue) -> {
                lblYIRValue.setText(number.format(newValue));
            }
        );
        yearlyInterestRate.setOnMouseReleased((e) -> {
            YIR.getData().clear();
            double interest = yearlyInterestRate.getValue()/100;
            double perYear = 12*monthlySavings.getValue() + 12*monthlySavings.getValue()*interest;
            double endYear = perYear;
            YIR.getData().add(new XYChart.Data(0,0));
            for (int i = 1; i <= 30; i++) {
                YIR.getData().add(new XYChart.Data(i, endYear));
                endYear = endYear + perYear + endYear * interest;
            }
        });
        
        layout.setTop(top);
        layout.setCenter(lineChart);
        
        Scene scene = new Scene(layout, 640, 480);
        window.setScene(scene);
        window.show();
    }
}
