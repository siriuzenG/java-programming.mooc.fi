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
public class Suitcase {
    private int maxWeight;
    private ArrayList<Item> suitcase;
    
    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcase = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        // if item exceed max weight reject
        if(item.getWeight() > this.maxWeight) {
            return;
        }
        
        // if suitcase is empty just add the item
        if(this.suitcase.isEmpty()) {
            this.suitcase.add(item);
            return;
        }
        
        // if total weight plus adding the item does not exceed the max weight
        if(item.getWeight()+this.totalWeight() <= this.maxWeight) {
            this.suitcase.add(item);
        }
    }
    
    public void printItems() {
        if(this.suitcase.isEmpty()) {
            System.out.println("no items");
            return;
        }
        
        for(Item item : this.suitcase) {
            System.out.println(item);
        }
    }
    
    public int totalWeight() {
        if(this.suitcase.isEmpty()) {
            return 0;
        }
        
        int totalWeight = 0;
        for(Item item : this.suitcase) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    public Item heaviestItem() {
        if(this.suitcase.isEmpty()) {
            return null;
        }
        
        Item heaviest = this.suitcase.get(0);
        for(Item item : this.suitcase) {
            if(heaviest.getWeight()<item.getWeight()) {
                heaviest = item;
            }
        }
        return heaviest;
    }
    
    public String toString() {
        String output = this.suitcase.size()+
                (this.suitcase.size() > 1 ? " items " : " item ");
        if(!this.suitcase.isEmpty()) {
            return output+"("+this.totalWeight()+" kg)";
        }
        return "no items(0 kg)";
    }
}
