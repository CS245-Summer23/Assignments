package hw;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void testGeneral(){
        int[] values = {1, 1, 1, 0, -1, 1,-1, 0, 1, -1, -1, 1, 0, 0};
        Sort.triValueSort(values);

        int[] expected = {1, 1, 1, 0, -1, 1,-1, 0, 1, -1, -1, 1, 0, 0};
        Arrays.sort(expected);
        assertTrue(Arrays.equals(values, expected));
    }

    @Test
    void testSmall(){
        int[] values = {0, 1, -1};
        Sort.triValueSort(values);

        int[] expected = {0, 1, -1};
        Arrays.sort(expected);

        assertTrue(Arrays.equals(values, expected));
    }

    @Test
    void testReversed(){
        int[] values = {1, 1, 1, 0, 0, 0, -1, -1};
        Sort.triValueSort(values);

        int[] expected = {1, 1, 1, 0, 0, 0, -1, -1};
        Arrays.sort(expected);

        assertTrue(Arrays.equals(values, expected));
    }
}