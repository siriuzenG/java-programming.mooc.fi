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
import java.util.ArrayList;
public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> translation;
    
    public DictionaryOfManyTranslations() {
        translation = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        this.translation.putIfAbsent(word, new ArrayList<>());
        this.translation.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return this.translation.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        if(this.translation.containsKey(word)) {
            this.translation.remove(word);
        }
    }
}
