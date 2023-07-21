
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eldest = 0;
        while(true) {
            String str = scanner.nextLine();
            if(str.equals("")) {
                break;
            }
            
            String[] person = str.split(",");
            int age = Integer.valueOf(person[1]);
            if(eldest<age) {
                eldest = age;
            }
        }
        System.out.println("Age of the oldest: "+eldest);
    }
}
