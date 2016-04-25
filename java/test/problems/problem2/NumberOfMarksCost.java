package problems.problem2;

import java.util.*;


/**
 * This class studies the efficiency of numberOfMarks.
 *
 *
 * @author carmocca
 * @version (Abril 2016)
 */
public class NumberOfMarksCost {

    //Change these values to test different array sizes
    private static int SIZE_INI = 100000;
    private static int SIZE_FIN = 1000000;
    private static int SIZE_INCR = 100000;

    //Maximum mark possible
    private static final int MAX_ARRAY = 1000;

    //Change this value to have better averages *WARNING* Big values will make this very slow
    private static final int N = 20;

    public static void main(String args[]) {

        //Array with each implementation of numberOfMarks
        List<ExamMarks> list = new ExamMarksFactory().create();

        //Array that contains different random marks for each size
        List<List<Integer>> randomNumList = new ArrayList<>();
        //List of arrays to be generated randomly
        List<List<int[]>> randomArrayList = new ArrayList<>();

        //Fill both lists
        for (int t = SIZE_INI, u = 0; t <= SIZE_FIN; t += SIZE_INCR, u++) {
            randomArrayList.add(new ArrayList<>());
            randomNumList.add(new ArrayList<>());
            for (int v = 0; v < N; v++) {
                randomArrayList.get(u).add(v, generateIncreasingRandoms(t, MAX_ARRAY));
                randomNumList.get(u).add(v, new Random().nextInt(MAX_ARRAY + 1));
            }
        }

        System.out.println("#----------------------------------");
        System.out.println("#   Measurement of search times:");
        System.out.println("#      Marks from 0 to "+MAX_ARRAY);
        System.out.println("#    Average of " + N + " searches");
        System.out.println("#---------------------------------- ");
        System.out.println("#   Size       Search time");

        for (int temp = 0; i < 2; i++){
            for (ExamMarks ex : list){

                String clazz = ex.getClass().getName();
                double t1, t2, time;

                System.out.println("#----------------------------------");
                System.out.println("#  \t" + clazz.replaceFirst("problems.problem2.", "") + " implementation.");
                System.out.println("#----------------------------------");

                for(int i = 0; i <randomArrayList.size(); i++){
                    t1 = System.nanoTime();
                    for(int j = 0; j < randomArrayList.get(i).size(); j++){
                        ex.numberOfMarks(randomArrayList.get(i).get(j), randomNumList.get(i).get(j));
                    }
                    t2 = System.nanoTime();
                    time = t2 - t1;
                    System.out.printf(Locale.US, " %1$8d     %2$8.3f μs%n",
                            randomArrayList.get(i).get(0).length,
                            time / N / 1e3);
                }
            }
        }
    }
    
    /**
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
