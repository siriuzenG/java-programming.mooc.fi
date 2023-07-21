
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare three = msFactory.createMagicSquare(3);
        System.out.println(three);
        System.out.println(three.sumsOfRows());
        System.out.println(three.sumsOfColumns());
        System.out.println(three.sumsOfDiagonals());
        
        
        System.out.println();
        MagicSquare non = new MagicSquare(3);
        int nonSize = non.getHeight();
        int val = 1;
        for (int i = 0; i < nonSize; i++) {
            for (int j = 0; j < nonSize; j++) {
                non.placeValue(j, i, val);
                val += 1;
            }
        }
        
        System.out.println(non);
        System.out.println(non.sumsOfRows());
        System.out.println(non.sumsOfColumns());
        System.out.println(non.sumsOfDiagonals());
    }
}
