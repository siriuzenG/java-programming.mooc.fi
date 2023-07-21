/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.Scanner;
public class UserInterface {
    private Scanner scan;
    private Statistics stats;
    
    public UserInterface(Scanner scan, Statistics stats) {
        this.scan = scan;
        this.stats = stats;
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while(true) {
            String input = this.scan.nextLine();
            int points = 0;
            try {
                points = Integer.valueOf(input);
            } catch(NumberFormatException e) {
                continue;
            }
            
            if(points == -1) {
                break;
            }
            
            stats.add(points);
        }
        System.out.println("Point average (all): " + (double)this.stats.summation()/this.stats.getSize() );
        System.out.print("Point average (passing): ");
        if(this.stats.getPassed()>0) {
            System.out.println( (double)this.stats.summation(50)/this.stats.getPassed() );
        } else {
            System.out.println("-");
        }
        System.out.println("Pass percentage: "+ (double) 100*this.stats.getPassed()/this.stats.getSize() );
        this.printGradeDistribution();
    }
    
    public void printGradeDistribution() {
        int grade = 5;
        System.out.println("Grade distribution:");
        while(grade >= 0) {
            System.out.print(grade+": ");
            for(int graded : this.stats.getGrades()) {
                if(grade == graded) {
                    System.out.print("*");
                }
            }
            System.out.println("");
            grade -= 1;
        }
    }
}
