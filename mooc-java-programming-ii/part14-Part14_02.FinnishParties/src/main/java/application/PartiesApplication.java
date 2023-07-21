package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{    
    
    private Map<String,Map<Integer, Double>> data;
    
    @Override
    public void start(Stage window) {
        if (readData("partiesdata.tsv")) {
            graph(window);
        }       
    }
    
    public void graph(Stage window) {
        // set x & y axis
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        
        // set axes properties
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1965);
        xAxis.setUpperBound(2010);
        
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(30);
        
        // create the line chart.
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        this.data.keySet().stream()
                .forEach(name -> {
                    XYChart.Series chart = new XYChart.Series();
                    chart.setName(name);
                    this.data.get(name).entrySet().stream()
                            .forEach(pair -> {
                                chart.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                            });
                    lineChart.getData().add(chart);
                });
        
        Scene view = new Scene(lineChart, 640, 480);
        window.setResizable(false);
        window.setScene(view);
        window.show();
    }
    
    public boolean readData(String fileName) {
        try (Scanner file = new Scanner(Paths.get(fileName));) {
            this.data = new HashMap<>();
            ArrayList<Integer> year = new ArrayList<>();
            
            while (file.hasNextLine()) {
                String[] parts = file.nextLine().split("\t");
                String key = parts[0];
                
                if (key.equals("Party")) {
                    for (int i = 1; i < parts.length; i++) {
                        year.add(Integer.valueOf(parts[i]));
                    }
                    continue;
                }
                
                Map<Integer, Double> data = new HashMap<>();
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("-")) {
                        continue;
                    }
                    data.put(year.get(i-1), Double.valueOf(parts[i]));
                }
                
                this.data.put(key, data);
            }
            
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Program starts...");
        launch(args);
    }

}
