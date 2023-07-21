/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SAM
 */
public class SaveableDictionary {
   private Map<String, String> dictionary; 
   private String file;
   
   public SaveableDictionary() {
       this("");
   }
   
   public SaveableDictionary(String file) {
       this.file = file;
       dictionary = new HashMap<>();
   }
   
   public void add(String word, String translation) {
       dictionary.putIfAbsent(word, translation);
       dictionary.putIfAbsent(translation, word);
   }
   
   public String translate(String word) {
       return dictionary.getOrDefault(word, null);
   }
   
   public void delete(String word) {
        dictionary.remove(this.translate(word));
        dictionary.remove(word);
   }
   
   public boolean load() {
       try {
           Scanner file = new Scanner(Paths.get(this.file));
           while (file.hasNextLine()) {
               String[] input = file.nextLine().split(":");
               this.add(input[0], input[1]);
           }
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
   
   public boolean save() {
       try {
           PrintWriter writer = new PrintWriter(new FileWriter(this.file));
           for(Map.Entry<String, String> entry : dictionary.entrySet()) {
               if (entry.getKey().compareTo(entry.getValue()) < 0) {
                   writer.println(entry.getKey() + ":" + entry.getValue());
               }
           }
           writer.close();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
}
