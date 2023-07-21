
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList> archive = new ArrayList<>();
        
        while(true) {
            System.out.println("Identifier? (empty will stop)");
            String id = scanner.nextLine();
            
            if(id.isEmpty()) {
                break;
            }
            
            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            
            if(name.isEmpty()) {
                break;
            }
            
            boolean inList = false;
            for(ArrayList<String> item:archive) {
                if(item.get(0).equals(id)) {
                    inList = true;
                    break;
                }
            }
            
            if(!inList) {
                ArrayList<String> list = new ArrayList<>();
                list.add(id);
                list.add(name);
                archive.add(list);
            }
        }
        
        System.out.println("==Items==");
        for(ArrayList<String> item:archive) {
            System.out.println(item.get(0)+": "+item.get(1));
        }

    }
}
