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
public class IOU {
    private HashMap<String, Double> debtList;
    
    public IOU() {
        debtList = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        double debt = debtList.getOrDefault(toWhom, 0.0);
        debt += amount;
        debtList.put(toWhom, debt);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return debtList.getOrDefault(toWhom, 0.0);
    }
}
