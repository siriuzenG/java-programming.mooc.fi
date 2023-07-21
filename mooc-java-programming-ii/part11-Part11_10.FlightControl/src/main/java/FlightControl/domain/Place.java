/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author SAM
 */
public class Place {
    public String ID;
    
    public Place(String ID) {
       this.ID = ID;
    }
    
    @Override
    public String toString() {
        return this.ID;
    }
}
