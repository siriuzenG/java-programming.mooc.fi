/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAM
 */
public class List<Type> {
    private Type[] values;
    private int indexSize;
    
    public List() {
        values = (Type[]) new Object[10];
        indexSize = 0;
    }
    
    public void add(Type value) {
        if (values.length == indexSize) {
            grow();
        }
        values[indexSize] = value;
        indexSize += 1;
    }
    
    public boolean contains(Type value) {
        if (indexOfValue(value) > 0) {
            return true;
        }
        return false;
    }
    
    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }
        
        moveToTheLeft(indexOfValue);
        indexSize -= 1;
    }
    
    public Type value(int index) {
        if (index < 0 || index >= indexSize) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + indexSize + "]");
        }
        
        return values[index];
    }
    
    public int indexOfValue (Type value) {
        for (int i = 0; i < indexSize; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    public int size() {
        return indexSize;
    }
    
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < indexSize; i++) {
            values[i] = values[i + 1];
        }
    }
    
    private void grow() {
        int newSize = indexSize + indexSize / 2;
        Type[] newValues  = (Type[]) new Object[newSize];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }
}
