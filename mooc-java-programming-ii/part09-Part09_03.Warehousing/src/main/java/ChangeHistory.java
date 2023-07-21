/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.ArrayList;
public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        history = new ArrayList<>();
    }
    
    public void add(double status) {
        history.add(status);
    }
    
    public void clear() {
        history.clear();
    }
    
    public double maxValue() {
        if (history.isEmpty()) {
            return 0.0;
        }
        
        double max = history.get(0);
        for(Double num : history) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
    
    public double minValue() {
        if (history.isEmpty()) {
            return 0.0;
        }
        
        double min = history.get(0);
        for(Double num : history) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
    
    public double average() {
        if (history.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for(Double num : history) {
            sum += num;
        }
        return sum/history.size();
    }
    
    @Override
    public String toString() {
        return history.toString();
    }
}
