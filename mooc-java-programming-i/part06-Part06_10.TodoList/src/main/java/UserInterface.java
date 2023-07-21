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
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while(true) {
            System.out.print("Command: ");
            String cmd = scanner.nextLine();
            
            if(cmd.equals("stop")) {
                break;
            }
            
            if(cmd.equals("add")) {
                System.out.print("To add: ");
                String addTask = scanner.nextLine();
                
                this.list.add(addTask);
            }
            
            if(cmd.equals("list")) {
                this.list.print();
            }
            
            if(cmd.equals("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = Integer.valueOf(scanner.nextLine());
                
                this.list.remove(toRemove);
            }
        }
    }
}
