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
public class Herd implements Movable {
    private ArrayList<Movable> herd;
    
    public Herd() {
        herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    public void move(int dx, int dy) {
        if(herd.isEmpty()) {
            return;
        }
        
        for(Movable movable : herd) {
            movable.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String output = "";
        for(Movable movable : herd) {
            output += movable.toString() + "\n";
        }
        return output;
    }
}
