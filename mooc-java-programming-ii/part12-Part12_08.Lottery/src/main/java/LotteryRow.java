
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random random = new Random();
        
        while (numbers.size() < 7) {
            int randomNumber = random.nextInt(40) + 1;
            if ( !containsNumber(randomNumber) ) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return numbers.contains(number);
    }
}

