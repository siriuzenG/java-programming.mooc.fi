
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int liquid1 = 0;
        int liquid2 = 0;

        while (true) {
            System.out.println("First: "+liquid1+"/100");
            System.out.println("Second: "+liquid2+"/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String cmd = "";
            int num = 0;
            if (parts.length >= 2) {
                cmd = parts[0];
                num = Integer.valueOf(parts[1]);
            } else {
                continue;
            }

            if (num < 0) {
                continue;
            }
            
            if (cmd.equals("add")) {
                liquid1 += num;
                if (liquid1 > 100) {
                    liquid1 = 100;
                }
                continue;
            }
            
            if (cmd.equals("move")) {
                if (num >= liquid1) {
                    liquid2 += liquid1;
                    liquid1 = 0;
                } else {
                    liquid1 -= num;
                    liquid2 += num;
                }
                
                if (liquid2 > 100) {
                    liquid2 = 100;
                }
                continue;
            }
            
            if (cmd.equals("remove")) {
                liquid2 -= num;
                if (liquid2 < 0) {
                    liquid2 = 0;
                }
                continue;
            }
        }
    }
}
