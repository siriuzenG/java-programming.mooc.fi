
import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while(true) {
            System.out.println("Input the name of the book, empty stops:");
            String book = scanner.nextLine();
            
            if (book.isEmpty()) {
                break;
            }
            
            System.out.println("Input the age recommendation:");
            int age = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(book, age));
            System.out.println("");
        }
        
        
        System.out.println(books.size() + " books in total.");
        
        System.out.println("Books:");
        books.stream()
                .sorted()
                .forEach(book -> System.out.println(book));
    }

}
