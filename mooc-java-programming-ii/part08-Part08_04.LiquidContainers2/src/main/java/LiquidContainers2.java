
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container liquid1 = new Container();
        Container liquid2 = new Container();
        while (true) {
            System.out.println("First: "+liquid1);
            System.out.println("Second: "+liquid2);

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
            
            if (cmd.equals("add")) {
                liquid1.add(num);
                continue;
            }
            
            if (cmd.equals("move")) {
                if (num >= liquid1.contains()) {
                    liquid2.add(liquid1.contains());
                } else {
                    liquid2.add(num);
                }
                
                liquid1.remove(num);
                continue;
            }
            
            if (cmd.equals("remove")) {
                liquid2.remove(num);
                continue;
            }
        }
    }

}
