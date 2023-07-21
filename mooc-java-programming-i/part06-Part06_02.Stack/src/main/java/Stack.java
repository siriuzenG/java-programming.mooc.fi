/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;
    
    public Stack() {
        this.stack = new ArrayList<>();
    }
    
    public void add(String value) {
        this.stack.add(value);
    }

    public String take() {
        String top = this.stack.get(this.stack.size()-1);
        this.stack.remove(this.stack.size()-1);
        return top;
    }
    
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    
    public ArrayList<String> values() {
        return this.stack;
    }
}
