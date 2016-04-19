package problems.problem2;

import java.util.*;
import problems.problem2.KevinImp;

/**
 * Estudia la complejidad empirica de las diferentes implementaciones de numberOfMarks.
 * 
 * Se estudian las tallas....
 * 
 * @author carmocca 
 * @version (Abril 2016)
 */
public class EvaluaCosteBusqueda {

    // Tallas para la medida
    private static int TALLA_INI = 100000;
    private static int TALLA_FIN = 1000000;
    private static int TALLA_INCR = 100000;

    private static final int MARK = 50;
    private static final int TALLA_ARRAY = 100;
  
    public static void main(String args[]) {
        int [] vector;
        double t1, t2, tacum1;
        t1 = t2 = tacum1 = 0;
        System.out.println("#--------------------------------------------");
        System.out.println("#       Medidas de tiempos de busqueda: ");
        System.out.println("#          Notas de 0 a "+TALLA_ARRAY+"    ");
        System.out.println("#-------------------------------------------- ");
        System.out.println("#    Talla    Tiempo busquedas   Nº > "+MARK+"   ");
        System.out.println("#---------------------------------------------");
        for (int t = TALLA_INI; t <= TALLA_FIN; t += TALLA_INCR) {
			vector = generateIncreasingRandoms(t, TALLA_ARRAY);
			t1 = System.nanoTime();
			int foo = KevinImp.numberOfMarks(vector, MARK);
			t2 = System.nanoTime();
			tacum1 += t2 - t1;
			System.out.printf(Locale.US, "%1$8d \t%2$8.0f μs \t%3$8d\n",
			    t, 
			    tacum1 / 1e3,
			    foo);
        }
    }

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