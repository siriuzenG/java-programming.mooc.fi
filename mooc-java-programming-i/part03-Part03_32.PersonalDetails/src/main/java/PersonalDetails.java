
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> birthYear = new ArrayList<>();
        String name = "";
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("")){
                break;
            }
            
            String[] details = input.split(",");
            birthYear.add(Integer.valueOf(details[1]));
            if(name.split("").length < details[0].split("").length) {
                name = details[0];
            }
        }
        
        int avg = 0;
        for(int year:birthYear){
            avg += year;
        }
        
        System.out.println("Longest name: "+name);
        System.out.println("Average of the birth years: "+(1.0*avg/birthYear.size()));
    }
}
