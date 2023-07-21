/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.HashMap;
public class Abbreviations {
    private HashMap<String, String> abbreviations;
    
    public Abbreviations() {
        abbreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String meaning) {
        abbreviation = sanitize(abbreviation);
        this.abbreviations.put(abbreviation, meaning);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        abbreviation = sanitize(abbreviation);
        if (this.abbreviations.containsKey(abbreviation)) {
            return true;
        }
        return false;
    }
    
    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitize(abbreviation);
        if (hasAbbreviation(abbreviation)) {
            return this.abbreviations.get(abbreviation);
        }
        return null;
    }
    
    public String sanitize(String name) {
        if (name == null) {
            return "";
        }
        
        name = name.toLowerCase();
        return name.trim();
    }
}
