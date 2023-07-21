/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class Employees {
    private List<Person> employees;
    
    public Employees() {
        employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        Iterator<Person> employer = peopleToAdd.iterator();
        while (employer.hasNext()) {
            employees.add(employer.next());
        }
    }
    
    public void print() {
        Iterator<Person> employee = this.employees.iterator();
        while (employee.hasNext()) {
            System.out.println(employee.next());
        }
    }
    
    public void print(Education degree) {
        Iterator<Person> employee = this.employees.iterator();
        while (employee.hasNext()) {
            Person curr = employee.next();
            if(curr.getEducation().equals(degree)) {
                System.out.println(curr);
            }
        }
    }
    
    public void fire(Education degree) {
        Iterator<Person> employee = this.employees.iterator();
        while (employee.hasNext()) {
            Person curr = employee.next();
            if(curr.getEducation().equals(degree)) {
                employee.remove();
            }
        }
    }
}
