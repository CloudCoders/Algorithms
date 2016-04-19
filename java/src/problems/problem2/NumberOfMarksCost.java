package problems.problem2;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
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

    //Mark to be beaten
    private static final int MARK = 50;
    //Maximum mark possible
    private static final int MAX_ARRAY = 100;
  
    public static void main(String args[]) {
        try {
            int [] vector;
            double t1, t2, time;
            t1 = t2 = time = 0;
            System.out.println("Write the name of the class that implements ExamMarks:");
            Scanner sc = new Scanner(System.in);
			Class<?> c = Class.forName(sc.nextLine());
			Constructor constructor = c.getConstructor();
            Method method = c.getMethod("numberOfMarks", int[].class, int.class);
            System.out.println("\n#---------------------------------------------");
            System.out.println("#         Measurement of search times: ");
            System.out.println("#          Marks from 0 to "+MAX_ARRAY+"    ");
            System.out.println("#--------------------------------------------- ");
            System.out.println("#    Size    Search time   Nº Marks > "+MARK+"   ");
            System.out.println("#---------------------------------------------");
            for (int t = SIZE_INI; t <= SIZE_FIN; t += SIZE_INCR) {
                vector = generateIncreasingRandoms(t, MAX_ARRAY);
                t1 = System.nanoTime();
                int n = (int) method.invoke(constructor.newInstance(), vector, MARK);
                t2 = System.nanoTime();
                time += t2 - t1;
                System.out.printf(Locale.US, " %1$8d %2$8.0f μs      %3$8d\n",
                        t,
                        time / 1e3,
                        n);
            }
        } catch(Exception e) {
    		//e.printStackTrace(System.out);
			System.out.println("Class not found or not compiled");
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
