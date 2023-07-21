/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Warehouse {
    private Map<String,Integer> price;
    private Map<String,Integer> stock;
    public Warehouse() {
        price = new HashMap<>();
        stock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.stock.putIfAbsent(product, stock);
        this.price.putIfAbsent(product, price);
    }
    
    public int price(String product) {
        return price.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return stock.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if(stock(product) > 0) {
            int currentStock = stock.get(product);
            stock.put(product, currentStock-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return stock.keySet();
    }
}
