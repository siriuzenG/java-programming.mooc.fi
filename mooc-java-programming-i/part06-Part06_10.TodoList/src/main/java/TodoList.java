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
    private ArrayList<String> tasks;
    public TodoList() {
        this.tasks = new ArrayList<>();
    }
    
    public void add(String task) {
        if(!task.isEmpty()) {
            this.tasks.add(task);
        }
    }
    
    public void print() {
        if(this.isEmpty()){
            System.out.println("no task");
            return;
        }
        
        int idx = 1;
        for(String task : this.tasks) {
            System.out.println(idx+": "+task);
            idx += 1;
        }
    }
    
    public void remove(int idx) {
        if(this.isEmpty() || idx > this.tasks.size() || idx <= 0) {
            return;
        }
        this.tasks.remove(idx-1);
    }
    
    public boolean isEmpty() {
        return this.tasks.isEmpty();
    }
}
