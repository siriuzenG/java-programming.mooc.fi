package application;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{
    
    @Override
    public void start(Stage stage) {
        String str = "2007 73\n" +
                "2008 68\n" +
                "2009 72\n" +
                "2010 72\n" +
                "2011 74\n" +
                "2012 73\n" +
                "2013 76\n" +
                "2014 73\n" +
                "2015 67\n" +
                "2016 56\n" +
                "2017 56";
        List<String> strRow = Arrays.asList(str.split("\n"));
        
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        
        // set uppper and lower boundaries
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(2006);
        xAxis.setUpperBound(2018);
        
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");
        
        // create the data set that is going to be added to the line chart
        XYChart.Series data = new XYChart.Series();
        data.setName("Shanghai Ranking");
        
        // and single points into the data set
        for (String datas : strRow) {
            String[] piece = datas.split(" ");
            int year = Integer.valueOf(piece[0]);
            int rank = Integer.valueOf(piece[1]);
            data.getData().add(new XYChart.Data(year, rank));
        }
        
        // add the data set to the line chart
        lineChart.getData().add(data);

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world!");
    }

}
