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

public class UserInterface {
    private JokeManager jokeManager;
    private Scanner scanner;
    
    public UserInterface(JokeManager jokeManager, Scanner scanner) {
        this.jokeManager = jokeManager;
        this.scanner = scanner;
    }
    
    public void start() {
        String commands = "Commands:\n" +
                "1 - add a joke\n" +
                "2 - draw a joke\n" +
                "3 - list jokes\n" +
                "X - stop";
        
        while(true) {
            System.out.println(commands);
            String cmd = scanner.nextLine();
            
            if(cmd.equals("X")) {
                break;
            }
            
            if(cmd.equals("1")) {
                System.out.println("Write the joke to be added:");
                String addJoke = scanner.nextLine();
                this.jokeManager.addJoke(addJoke);
                continue;
            }
            
            if(cmd.equals("2")) {
                System.out.println(this.jokeManager.drawJoke());
                continue;
            }
            
            if(cmd.equals("3")) {
                this.jokeManager.printJokes();
                continue;
            }
        }
    }
}
