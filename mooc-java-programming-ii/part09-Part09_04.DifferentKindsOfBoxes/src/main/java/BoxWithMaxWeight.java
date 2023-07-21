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
public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> box;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }
    
    public void add(Item item) {
        if (item.getWeight() <= canHandle()) {
            box.add(item);
        }
    }
    
    public boolean isInBox(Item item) {
        return box.contains(item);
    }
    
    private int canHandle() {
        if (box.isEmpty()) {
            return capacity;
        }
        
        int sum = 0;
        for (Item item : box) {
            sum += item.getWeight();
        }
        return capacity-sum;
    }
}
