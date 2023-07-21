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
public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place targetAirPort;
    
    public Flight(Airplane airplane, Place departureAirport, Place targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirPort = targetAirport;
    }
    
    public Airplane getAirplane() {
        return this.airplane;
    }
    
    public Place getDeparturePlace() {
        return this.departureAirport;
    }
    
    public Place getTargetPlace() {
        return this.targetAirPort;
    }
    
    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.targetAirPort + ")";
    }
}
