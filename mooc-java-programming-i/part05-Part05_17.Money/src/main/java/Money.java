
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }
    
    public Money plus(Money add) {
        Money newMoney = new Money(
                this.euros + add.euros, 
                this.cents + add.cents
        );
        return newMoney;
    }
    
    public Money minus(Money subtract) {
        int euros = this.euros - subtract.euros;
        int cents = this.cents - subtract.cents;
        
        if(cents<-99) {
            euros = euros - cents / 100;
            cents = cents % 100;
        }
        
        if(cents<0) {
            euros = euros - 1;
            cents = 100 + cents;
        }
        
        if(euros>=0) {
            return new Money(euros, cents);
        }
        
        return new Money(0,0);
    }
    
    public boolean lessThan(Money compared) {
        if(this.euros<compared.euros) {
            return true;
        }
        if(this.euros>compared.euros) {
            return false;
        }
        
        if(this.cents<compared.euros) {
            return true;
        }
        return false;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}
