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
public class Hold {
    private int maxWeight;
    private ArrayList<Suitcase> holding;
    
    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.holding = new ArrayList<>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if(suitcase.totalWeight()+this.totalWeight() <= this.maxWeight) {
            this.holding.add(suitcase);
        }
    }
    
    public void printItems() {
        if(this.holding.isEmpty()) {
            System.out.println("no items");
            return;
        }
        
        for(Suitcase suitcase : this.holding) {
            suitcase.printItems();
        }
    }
    
    public int totalWeight() {
        if(this.holding.isEmpty()) {
            return 0;
        }
        
        int totalWeight = 0;
        for(Suitcase suitcase : this.holding) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }
    
    public String toString() {
        String output = this.holding.size()+
                (this.holding.size() > 1 ? " suitcases " : " suitcase ");
        if(!this.holding.isEmpty()) {
            return output+"("+this.totalWeight()+" kg)";
        }
        return "no suitcase(0 kg)";
    }
}
