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
    private Scanner scan;
    private TodoList todolist;
    
    public UserInterface(TodoList todoList, Scanner scanner) {
        scan = scanner;
        todolist = todoList;
    }
    
    public void start() {
        while(true) {
            System.out.print("Command: ");
            String cmd = scan.nextLine();
            
            if (cmd.equals("stop")) {
                break;
            }
            
            if (cmd.equals("add")) {
                System.out.print("To add: ");
                String add = scan.nextLine();
                
                todolist.add(add);
                continue;
            }
            
            if (cmd.equals("list")) {
                todolist.print();
            }
            
            if (cmd.equals("remove")) {
                System.out.print("Which one is removed? ");
                int remove = Integer.valueOf(scan.nextLine());
                
                todolist.remove(remove);
            }
        }
    }
}
