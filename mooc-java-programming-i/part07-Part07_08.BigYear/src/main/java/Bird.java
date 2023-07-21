/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class Bird {
    private String name;
    private String latinName;
    private int observed;
    
    public Bird(String name, String latin) {
        this.name = name;
        this.latinName = latin;
        this.observed = 0;
    }
    
    public void gotObserved() {
        this.observed += 1;
    }
    
    public int getObserved() {
        return this.observed;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public String toString() {
        String output = this.name+" ("+this.latinName+"): "+this.observed;
        if(this.observed > 1) {
            return output += " observations";
        }
        return output += " observation";
    }
}
