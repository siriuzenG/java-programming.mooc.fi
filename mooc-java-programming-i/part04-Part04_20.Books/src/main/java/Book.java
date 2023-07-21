/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class Book {
    private String title;
    private int pages;
    private int pubYear;
    
    public Book (String title, int pages, int pubYear) {
        this.title = title;
        this.pages = pages;
        this.pubYear = pubYear;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getPages() {
        return this.pages;
    }
    
    public int getPubYear() {
        return this.pubYear;
    }
    
    public String toString() {
        return this.title+", "+this.pages+" pages, "+this.pubYear;
    }
}
