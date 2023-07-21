
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be an odd integer.");
        }
        
        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int maxVal = size * size; // max value
        int val = 1; // starting value
        
        int x = size / 2; // starting posX (middle)
        int y = 0; // starting posY (top)
        
        while (val <= maxVal) {
            square.placeValue(x, y, val); // place the current value
            
            int nextX = (x + 1) % size; // move a step to the right;
            int nextY = (y - 1 + size) % size; // move a step above;
            
            if (square.readValue(nextX, nextY) != 0) {
                // if the next container is occupied move a step below
                y = (y + 1) % size;
            } else {
                // if it's not occupied proceed to move
                x = nextX;
                y = nextY;
            }
            
            val += 1; // proceed to the next value
        }
        
        return square;
    }

}
