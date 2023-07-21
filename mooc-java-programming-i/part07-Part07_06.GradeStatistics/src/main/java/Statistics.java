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
public class Statistics {
    private ArrayList<Integer> points;
    private ArrayList<Integer> grades;
    private int countPassed;
    
    public Statistics() {
        this.points = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.countPassed = 0;
    }

    public boolean add(int points) {
        if(points >=0 && points <= 100) {
            if(points >= 50) {
                this.countPassed += 1;
            }
            this.grades.add(this.gradeDistribution(points));
            this.points.add(points);
            return true;
        }
        return false;
    }
    
    public int getSize() {
        return this.points.size();
    }
    
    public int getPassed() {
        return this.countPassed;
    }
    
    public ArrayList<Integer> getGrades() {
        return this.grades;
    }
    
    public int summation(int filter) {
        int sum = 0;
        for(int point : points) {
            if(point >= filter) {
                sum += point;
            }
        }
        return sum;
    }
    
    public int summation() {
        int sum = this.summation(0);
        return sum;
    }
 
    public int gradeDistribution(int points) {
        if(points < 50) {
            return 0;
        } 
        if (points < 60) {
            return 1;
        } 
        if (points < 70) {
            return 2;
        } 
        if (points < 80) {
            return 3;
        } 
        if (points < 90) {
            return 4;
        }
        return 5;
    }
    
}
