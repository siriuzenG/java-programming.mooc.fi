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
public class Box implements Packable{
    private ArrayList<Packable> box;
    private double weight;
    
    public Box(double weight) {
        this.weight = weight;
        this.box = new ArrayList<>();
    }
    
    public void add(Packable item) {
        if(!(item instanceof Packable) || item == null) {
            return;
        }
        
        if (item.weight() <= boxCanHandle()) {
            box.add(item);
        }
    }
    
    public double weight() {
        if(box.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (Packable item : box) {
            sum += item.weight();
        }
        return sum;
    }
    
    public double boxCanHandle() {
        return weight - weight();
    }
    
    @Override
    public String toString() {
        return "Box: "+box.size()+" items, total weight "+weight()+" kg";
    }
}
