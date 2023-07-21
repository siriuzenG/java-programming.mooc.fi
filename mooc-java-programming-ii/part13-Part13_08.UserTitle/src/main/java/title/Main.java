package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = "--title=";
        
        System.out.println("Enter your title:");
        title += scanner.nextLine();
        
        Application.launch(UserTitle.class, title);
    }

}
