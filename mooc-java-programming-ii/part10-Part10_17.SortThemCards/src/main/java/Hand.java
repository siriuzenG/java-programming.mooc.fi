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
import java.util.Collections;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void sort() {
        Collections.sort(hand);
    }
    
    public int sum() {
        return this.hand.stream()
                .mapToInt(card -> card.getValue())
                .sum();
    }
    
    public void print() {
        hand.stream().forEach(card -> System.out.println(card));
    }
    
    public int compareTo(Hand hand) {
        return sum() - hand.sum();
    }
    
    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
