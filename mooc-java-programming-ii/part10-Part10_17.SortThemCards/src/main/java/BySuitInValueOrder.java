
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class BySuitInValueOrder implements Comparator<Card>{
    public int compare(Card c1, Card c2) {
        int suit = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        if (suit != 0) {
            return suit;
        }
        return c1.getValue() - c2.getValue();
    }
}
