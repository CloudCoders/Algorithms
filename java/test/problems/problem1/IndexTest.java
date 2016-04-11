package problems.problem1;

import org.junit.Test;

import static org.junit.Assert.*;

public class IndexTest {

    @Test
    public void testSmallIndex(){
        int[] v = new int[7];
        v[0] = -2;
        v[1] = -1;
        v[2] = 1;
        v[3] = 2;
        v[4] = 3;
        v[5] = 4;
        v[6] = 5;

        Index index = new Index();

        assertEquals(1, index.getIndex(v, 0, v.length));
    }

    @Test
    public void testVerySmallIndex(){
        int[] v = new int[7];
        v[0] = -1;
        v[1] = 1;
        v[2] = 2;
        v[3] = 3;
        v[4] = 4;
        v[5] = 5;
        v[6] = 6;

        Index index = new Index();

        assertEquals(0, index.getIndex(v, 0, v.length));
    }


    @Test
    public void testBigIndex(){
        int[] v = new int[7];
        v[0] = -4;
        v[1] = -3;
        v[2] = -2;
        v[3] = -1;
        v[4] = 1;
        v[5] = 2;
        v[6] = 3;

        Index index = new Index();

        assertEquals(3, index.getIndex(v, 0, v.length));
    }

    @Test
    public void testVeryBigIndex(){
        int[] v = new int[7];
        v[0] = -6;
        v[1] = -5;
        v[2] = -4;
        v[3] = -3;
        v[4] = -2;
        v[5] = -1;
        v[6] = 1;

        Index index = new Index();

        assertEquals(5, index.getIndex(v, 0, v.length));
    }

}