public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        sort(array);
        
    }
    
    public static int smallest(int[] array) {
        int smallestValue = array[0];
        for (int num : array) {
            if (num < smallestValue) {
                smallestValue = num;
            }
        }
        return smallestValue;
    }
    
    public static int indexOfSmallest(int[] array) {
        int smallestValue = smallest(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallestValue) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int smallestValue = array[startIndex];
        int smallestIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < smallestValue) {
                smallestValue = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    
    public static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
    
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallestIndex = indexOfSmallestFrom(array, i);
            swap(array, i, smallestIndex);
            
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j]);
                if (j != array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
