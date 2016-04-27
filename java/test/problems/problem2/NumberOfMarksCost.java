package problems.problem2;

import java.util.*;

public class NumberOfMarksCost {

    //Change these values to test different array sizes
    private static int SIZE_INI = 100000;
    private static int SIZE_FIN = 1000000;
    private static int SIZE_INCR = 100000;

    //Change these values to test with more or less repetitions
    private static int REPETITIONS = 20;

    //Maximum mark possible
    private static final int MAX_ARRAY = 100;

    public static void main(String args[]) {
        int [][][] vectors = new int[SIZE_FIN/SIZE_INCR][REPETITIONS][];
        int [][] marksVector = new int[SIZE_FIN/SIZE_INCR][REPETITIONS];

        int countMarks;
        double t1, t2, time;
        Random random = new Random();
        List<ExamMarks> list = new ExamMarksFactory().create();

        System.out.println("#-----------------------------------------");
        System.out.println("#       Measurement of search times: ");
        System.out.println("#        Marks from 0 to "+MAX_ARRAY+"    ");
        System.out.println("#----------------------------------------- ");
        System.out.println("#  Size    Search time                     ");

        for (int t = SIZE_INI; t <= SIZE_FIN; t += SIZE_INCR) {
            for(int r = 0; r < REPETITIONS; r++) {
                int i = t/SIZE_INCR -1;
                //The mark should be random and not predefined
                marksVector[i][r] = random.nextInt(MAX_ARRAY-1);
                vectors[i][r] = generateIncreasingRandoms(t, MAX_ARRAY);
            }
        }

        for (ExamMarks ex : list){
            String clazz = ex.getClass().getName();
            System.out.println("#--------------------------------------------------");
            System.out.println("#  \t\t" + clazz.replaceFirst("problems.problem2.", "") + " implementation.");
            System.out.println("#--------------------------------------------------");
            for (int t = 0; t < vectors.length; t++) {
                //Reset time
                time = 0;
                countMarks = 0;
                //The boolean correct check if the algorithm work correctly. Is correct until proven otherwise.
                boolean correct = true;
                for(int r = 0; r < REPETITIONS; r++) {
                    int[] vector = vectors[t][r];
                    int mark = marksVector[t][r];
                    t1 = System.nanoTime();
                    int n = ex.numberOfMarks(vector, mark);
                    t2 = System.nanoTime();
                    time += t2 - t1;
                    countMarks += n;
                    correct = correct && vector[vector.length-n-1]<=mark && (n==0 || vector[vector.length-n]>mark);
                }
                time = time/REPETITIONS;
                countMarks = countMarks/REPETITIONS;
                System.out.printf(Locale.US, " %1$8d    %2$10.0f ns     %3$8d   %4$8b\n",
                        t*SIZE_INCR+SIZE_INI,
                        time,
                        countMarks,
                        correct
                );
            }
        }
    }

    /**
     *
     * @param amount "size of the array"
     * @param max "maximum possible number"
     * @return int "array of elements from 0 to max, with duplicates."
     */
    public static int[] generateIncreasingRandoms(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(max);
        }
        Arrays.sort(randomNumbers);
        return randomNumbers;
    }
}
