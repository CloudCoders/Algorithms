package problems.problem1;

public class Index {

    public int getIndex(int[] v, int init, int end) {
        int k = ((end + init)) >> 1;
        if (v[k] + v[k + 1] > 0) {
            return getIndex(v, init, k);
        } else if (v[k] + v[k + 1] < 0) {
            return getIndex(v, k + 1, end);
        } else {
            return k;
        }
    }

}
