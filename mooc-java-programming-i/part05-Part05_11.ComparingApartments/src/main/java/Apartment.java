
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }
    
    public boolean largerThan(Apartment compared) {
        if(this.rooms > compared.rooms) {
            return true;
        }
        
        if(this.rooms < compared.rooms) {
            return false;
        }
        
        if(this.squares > compared.squares) {
            return true;
        }
        
        return false;
    }
    
    public int priceDifference(Apartment compared) {
        int diff = this.squares * this.pricePerSquare - compared.squares * compared.pricePerSquare;
        if (diff<0) {
            return diff*-1;
        }
        return diff;
    }
    
    public boolean moreExpensiveThan(Apartment compared) {
        if(this.squares * this.pricePerSquare > compared.squares * compared.pricePerSquare) {
            return true;
        }
        return false;
    }
}
