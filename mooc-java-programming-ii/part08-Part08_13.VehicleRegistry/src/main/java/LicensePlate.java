public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof LicensePlate)) {
            return false;
        }
        
        final LicensePlate plate = (LicensePlate) obj;
        if (!this.country.equals(plate.country)) {
            return false;
        }
        
        if (!this.liNumber.equals(plate.liNumber)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.country.hashCode() + this.liNumber.hashCode();
    }
}
