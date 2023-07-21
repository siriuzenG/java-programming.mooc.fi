
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eldest = 0;
        String name = "";
        while(true) {
            String str = scanner.nextLine();
            if(str.equals("")) {
                break;
            }
            
            String[] person = str.split(",");
            int age = Integer.valueOf(person[1]);
            if(eldest<age) {
                eldest = age;
                name = person[0];
            }
        }
        System.out.println("Name of the oldest: "+name);

    }
}
