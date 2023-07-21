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
public class TodoList {
    private ArrayList<String> list;
    
    public TodoList() {
        list = new ArrayList<>();
    }
    
    public void add(String todo) {
        list.add(todo);
    }
    
    public void print() {
        if(list.isEmpty()) {
            return;
        }
        
        for(int i = 0; i<list.size(); i++) {
            System.out.println((i+1)+": "+list.get(i));
        }
    }
    
    public void remove(int number) {
        if (number >= 1 && number <= list.size()) {
            list.remove(number-1);
        }
    }
}
