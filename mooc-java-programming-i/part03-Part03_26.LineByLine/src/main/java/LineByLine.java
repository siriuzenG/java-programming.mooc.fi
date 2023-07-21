
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            String str = scanner.nextLine();
            if(str.equals("")){
                break;
            } else {
                String[] strArr = str.split(" ");
                for(String word:strArr) {
                    System.out.println(word);
                }
            }
        }
    }
}
