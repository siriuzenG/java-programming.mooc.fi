import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        while(true) {
            System.out.print("Title: ");
            String title = input.nextLine();
            System.out.println("");
            
            if(title.isEmpty()) {
                break;
            }
            
            System.out.print("Pages: ");
            int pages = Integer.valueOf(input.nextLine());
            System.out.println("");
            
            System.out.print("Publication year: ");
            int pubYear = Integer.valueOf(input.nextLine());
            System.out.println("");
            
            books.add(new Book(title, pages, pubYear));
        }
        
        System.out.print("What information will be printed? ");
        String print = input.nextLine();
        System.out.println("");
        if(print.equals("everything")) {
            for(Book book: books) {
                System.out.println(book);
            }
        } else if (print.equals("name")) {
            for(Book book: books) {
                System.out.println(book.getTitle());
            }
        }
        

    }
}
