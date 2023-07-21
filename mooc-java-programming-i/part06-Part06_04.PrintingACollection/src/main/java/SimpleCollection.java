
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }
    
    public String toString() {
        String output = "The collection " + this.name;
        
        if(this.elements.isEmpty()) {
            return output + " is empty.";
        }
        
        output = output + " has " + this.elements.size() + " ";
        if(this.elements.size()>1) {
            output = output + "elements:\n";
            for(String element : this.elements) {
                output = output + element + "\n";
            }
        } else {
            output = output + "element:\n" + this.elements.get(0);
        }
        
        return output;
    }
}
