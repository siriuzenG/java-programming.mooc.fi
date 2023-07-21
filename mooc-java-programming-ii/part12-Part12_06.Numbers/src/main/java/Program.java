
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many random numbers should be printed?");
        int num = Integer.valueOf(scanner.nextLine());
        Random rand = new Random();
        while (num > 0) {
            System.out.println(rand.nextInt(11));
            num--;
        }
    }

}
