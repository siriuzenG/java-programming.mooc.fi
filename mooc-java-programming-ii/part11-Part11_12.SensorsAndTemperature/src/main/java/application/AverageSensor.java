/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAM
 */
public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    
    public AverageSensor() {
        sensors = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return !sensors.isEmpty();
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Sensor is off or no sensors added");
        }
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }
        return sum / sensors.size();
    }
    
    public List<Integer> readings() {
        List<Integer> allReadings = new ArrayList<>();
        for (Sensor sensor : sensors) {
            if (sensor.isOn()) {
                allReadings.add(sensor.read());
            }
        }
        return allReadings;
    }
}
