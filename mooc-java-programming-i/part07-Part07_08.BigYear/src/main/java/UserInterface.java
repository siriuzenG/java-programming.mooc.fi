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
import java.util.ArrayList;
public class UserInterface {
    private ArrayList<Bird> birds;
    private Scanner scan;
    
    public UserInterface(Scanner scanner) {
        this.birds = new ArrayList<>();
        this.scan = scanner;
    }
    
    public void start() {
        while(true) {
            System.out.println("?");
            String cmd = scan.nextLine().toLowerCase().trim();
            
            if(cmd.equals("quit")) {
                break;
            }
            
            if(cmd.equals("add")) {
                System.out.println("Name: ");
                String name = scan.nextLine().trim();
                
                System.out.println("Name in Latin: ");
                String latin = scan.nextLine().trim();
                
                if(!name.isEmpty() && !latin.isEmpty()) {
                    birds.add(new Bird(name, latin));
                } else {
                    System.out.println("Input error!");
                }
                continue;
            }
            
            if(cmd.equals("observation") || cmd.equals("one")) {
                System.out.println("Bird? ");
                String name = scan.nextLine().trim();
                boolean isFound = false;
                
                if(cmd.equals("observation")) {
                    for(Bird bird : birds) {
                        if(bird.getName().equals(name)) {
                            bird.gotObserved();
                            isFound = true;
                            break;
                        }
                    }
                }
                
                if(cmd.equals("one")) {
                    for(Bird bird : birds) {
                        if(bird.getName().equals(name)) {
                            System.out.println(bird);
                            isFound = true;
                            break;
                        }
                    }
                }
                
                if(!isFound) {
                    System.out.println("Not a bird!");
                }
                continue;
            }
            
            if(cmd.equals("all")) {
                if(birds.isEmpty()) {
                    System.out.println("No birds!");
                    continue;
                }
                
                for(Bird bird : birds) {
                    System.out.println(bird);
                }
                continue;
            }
            
            System.out.println("command not found!");
        }
    }
}
