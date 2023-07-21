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
public class Hideout<T> {
    private ArrayList<T> hideout;
    
    public Hideout() {
        this.hideout = new ArrayList<>();
    }
    
    public void putIntoHideout(T toHide) {
        if(!hideout.isEmpty()) {
            hideout.remove(0);
        }
        hideout.add(toHide);
    }
    
    public T takeFromHideout() {
        return hideout.remove(0);
    }
    
    public boolean isInHideout() {
        return hideout.size() > 0;
    }
}
