
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: "+first+"/100");
            System.out.println("Second: "+second+"/100");

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
                if(amount < 0) {
                    continue;
                }
                
                first += amount;
                if(first > 100) {
                    first = 100;
                }
                continue;
            }
            
            if(command.equals("move")) {
                if(amount < 0) {
                    continue;
                }
                
                if(first-amount<=0) {
                    second += first;
                    first = 0;
                } else {
                    second += amount;
                    first -= amount;
                }
                
                if(second > 100) {
                    second = 100;
                }
                continue;
            }
            
            if(command.equals("remove")) {
                if(amount < 0) {
                    continue;
                }
                
                second -= amount;
                if(second < 0) {
                    second = 0;
                }
                continue;
            }

        }
    }

}
