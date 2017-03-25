/**
 * This class tests the FHsort times and sees if there is a correlation between the array length and recursion limit
 * An array of random values are made and is timed for each recursion limit of increment by 2
 */
public class TestFile {

    public static void main (String args[]) {

        //arraylengths chosen are  20k, 50k, 100k, 200k, 350k, 500k, 700k, 1m, 1.25m, and 1.5m
        int arrayLength = 100*1000;
        long startTime, estimatedTime;

        /**
         * The recursion limit incrementation
         * creates a new array and initiates random values
         * tracks an estimated time quick sort
         */
        for (int recursionLimit = 2; recursionLimit <= 300; recursionLimit += 2) {
            FHsort.setRecursionLimit(recursionLimit);
            //creating new array
            Integer[] testArray = new Integer[arrayLength];
            //populating the array
            for (int i = 0; i < arrayLength; i++) {
                testArray[i] = (int)Math.random() * 1000 + 1;
            }

            startTime = System.nanoTime();
            FHsort.quickSort(testArray);
            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Recursion Limit " + recursionLimit + " -->  " + TimeConverter.convertTimeToString(estimatedTime));
        }

    }
}
