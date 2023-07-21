/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class Literacy implements Comparable<Literacy>{
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercentage;
    
    public Literacy(String theme, String ageGroup, String gender, 
            String country, int year, double literacyPercentage) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercentage = literacyPercentage;
    }
    
    public double getLiteracyRate() {
        return this.literacyPercentage;
    }
    
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercentage;
    }
    
    @Override
    public int compareTo(Literacy literacy) {
        double compare = this.literacyPercentage - literacy.getLiteracyRate();
        if (compare > 0) {
            return 1;
        } 
        if (compare < 0) {
            return -1;
        }
        return 0;
    }
}
