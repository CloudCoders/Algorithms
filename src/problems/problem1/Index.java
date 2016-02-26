package problems.problem1;

/**
 * Created by toni on 26/02/16.
 */
public class Index {

    public int getIndex(int[] v, int init, int end){
        int k = (int)((end+init))/2;
        if (v[k] + v[k+1] > 0){
            return getIndex(v, init, k);
        }else if (v[k] + v[k+1] < 0){
            return getIndex(v, k+1, end);
        }else{
            return k;
        }
    }

}
