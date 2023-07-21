/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.Scanner;
public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dictionary;
    
    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }
    
    public void start() {
        while(true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
            if(command.equals("end")) {
                break;
            }
            
            if(command.equals("add")) {
                System.out.print("Word: ");
                String word = scanner.nextLine();
                
                System.out.print("Translation: ");
                String translation = scanner.nextLine();
                
                this.dictionary.add(word, translation);
                continue;
            }
            
            if(command.equals("search")) {
                System.out.print("To be translated: ");
                String translate = scanner.nextLine();
                
                String translated = this.dictionary.translate(translate);
                if(translated == null) {
                    System.out.println("Word "+translate+" was not found");
                } else {
                    System.out.println("Translation: "+translated);
                }
                continue;
            }
            
            System.out.println("Unknown command");
        }
        System.out.println("Bye bye!");
    }
}
