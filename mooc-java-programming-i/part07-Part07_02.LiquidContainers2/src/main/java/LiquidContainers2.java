
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: "+first);
            System.out.println("Second: "+second);

            String input = scan.nextLine();
            String[] parts = input.split(" ");
            
            String command = parts[0];            
            if (command.equals("quit")) {
                break;
            }
            
            if(parts.length > 2) {
                continue;
            }
            
            int amount = Integer.valueOf(parts[1]);
            if(command.equals("add")) {
                first.add(amount);
                continue;
            }
            
            if(command.equals("move")) {
                if(first.contains() <= amount) {
                    second.add(first.contains());
                } else {
                    second.add(amount);
                }
                first.remove(amount);            
                continue;
            }
            
            if(command.equals("remove")) {
                second.remove(amount);
                continue;
            }
        }
    }

}
