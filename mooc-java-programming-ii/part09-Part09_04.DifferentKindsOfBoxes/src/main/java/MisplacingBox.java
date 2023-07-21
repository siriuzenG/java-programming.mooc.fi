
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
public class MisplacingBox extends Box{
    private ArrayList<Item> box;
    
    public MisplacingBox() {
        this.box = new ArrayList<>();
    }
    
    public void add(Item item) {
        return;
    }

    public boolean isInBox(Item item) {
        return box.contains(item);
    }
    
}
