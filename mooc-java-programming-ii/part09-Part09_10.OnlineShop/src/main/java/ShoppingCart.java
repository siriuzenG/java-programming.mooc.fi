
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class ShoppingCart {
    private Map<String,Item> cart;
    
    public ShoppingCart() {
        cart = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if(cart.containsKey(product)) {
            cart.get(product).increaseQuantity();
            return;
        }
        cart.put(product, new Item(product, 1, price));
    }
    
    public int price() {
        if(cart.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        for(Item item : cart.values()) {
            sum += item.price();
        }
        return sum;
    }
    
    public void print() {
        if(cart.isEmpty()) {
            return;
        }
        
        for(Item item : cart.values()) {
            System.out.println(item);
        }
    }
}
