/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class Book implements Comparable<Book> {
    private String name;
    private int ageRecommend;
    
    public Book(String name, int ageRecommend) {
        this.name = name;
        this.ageRecommend = ageRecommend;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.ageRecommend;
    }
    
    @Override
    public String toString() {
        return this.name + " (recommended for " + this.ageRecommend + " year-olds or older)";
    }
    
    @Override
    public int compareTo(Book book) {
        int diff = this.ageRecommend - book.getAge();
        
        if (diff != 0) {
            return diff;
        }
        
        return this.name.compareTo(book.getName());
    }
}
