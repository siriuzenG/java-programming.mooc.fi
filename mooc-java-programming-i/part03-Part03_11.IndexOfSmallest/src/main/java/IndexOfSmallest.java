
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program that reads user input
        // until the user enters 9999
        ArrayList<Integer> list = new ArrayList<>();
        int small = 9999;
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 9999) {
                break;
            }
            if(input<small) {
                small = input;
            }
            list.add(input);
        }
        System.out.println("");
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        System.out.println("Smallest number: "+small);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == small){
                System.out.println(small+" is at index "+i);
            }
        }
    }
}
