

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        
        System.out.println("Files to read: ");
        String path = scanner.nextLine();
                
        try( Scanner file = new Scanner(Paths.get(path)) ) {
            ui.getInputsFromFiles(file);
            ui.start();
        } catch(Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

    }

}
