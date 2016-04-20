package eda.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(value = Parameterized.class)
public class SortingTest {

    private Sorting sortingTest;

    public SortingTest(Sorting sortingTest) {
        this.sortingTest = sortingTest;
    }

    @Test
    public void should_sort_when_random() {
        Integer[] h = new Integer[5000];
        for (int i = 0; i < h.length; i++) {
            h[i] = (int) Math.random() * 100;
        }

        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(res, h);
    }

    @Test
    public void should_sort_when_ascending_array() {
        Integer[] h = new Integer[5000];
        for (int i = 0; i < h.length; i++) {
            h[i] = i;
        }

        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(res, h);
    }

    @Test
    public void should_sort_when_descending_array() {
        Integer[] h = new Integer[5000];
        for (int i = h.length - 1; i >= 0; i--) {
            h[i] = i;
        }

        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(res, h);
    }

    @Test
    public void should_sort_when_all_equals_array() {
        Integer[] h = new Integer[5000];
        for (int i = 0; i < h.length; i++) {
            h[i] = 0;
        }

        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(h, res);
    }

    @Test
    public void should_sort_when_mostly_sorted_ascending_array() {
        Integer[] h = new Integer[5000];
        for (int i = 0; i < h.length; i++) {
            h[i] = i + (int) Math.random() * 10;
        }

        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(res, h);
    }

    @Test
    public void should_sort_when_mostly_sorted_descending_array() {
        Integer[] h = new Integer[5000];
        for (int i = h.length - 1; i >= 0; i--) {
            h[i] = i - (int) Math.random() * 10;
        }
        Integer[] res = Arrays.copyOf(h, h.length);
        Arrays.sort(res);
        sortingTest.sort(h);
        assertArrayEquals(res, h);
    }

    @Test
    public void should_return_empty_array_when_empty_array() {
        Comparable h[] = new Comparable[0];
        Comparable res[] = new Comparable[0];

        sortingTest.sort(h);

        Assert.assertArrayEquals(res, h);
    }

    @Test
    public void should_sort_when_pred_array() {
        Integer h[] = new Integer[]{1, 2, 1, 2, 3, 4, 5, 4, 3, 4, 3, 4};
        Integer r[] = new Integer[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5};
        sortingTest.sort(h);
        Assert.assertArrayEquals(h, r);
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new SortingFactory().create();
    }

}