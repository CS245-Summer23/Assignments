package lists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class SListTest {

    @Test
    void testNoMerge() {
        int[] values = {1,4,3,7,3,100,56, 12, 16};
        SList<Integer> originalList = new SList();
        SList<Integer> expectedList = new SList();

        for(int idx = values.length - 1; idx >= 0; idx --) {
            originalList.addFirst(values[idx]);
            expectedList.addFirst(values[idx]);
        }
        originalList.mergeNodes();
        assertTrue(expectedList.equals(originalList));
    }

    @Test
    void testSingleMerge() {
        int[] values = {1,4,100,7,100,100,56,12,16};
        int[] expected = {1,4,100,7,200,56,12,16};
        SList<Integer> originalList = new SList();
        SList<Integer> expectedList = new SList();

        for(int idx = values.length - 1; idx >= 0; idx --) {
            originalList.addFirst(values[idx]);
        }

        for(int idx = expected.length - 1; idx >= 0; idx --){
            expectedList.addFirst(expected[idx]);
        }
        originalList.mergeNodes();
        assertTrue(expectedList.equals(originalList));
    }

    @Test
    void testHeadMerge() {
        int[] values = {4,4,4,4,4, 7};
        int[] expected = {20, 7};
        SList<Integer> originalList = new SList();
        SList<Integer> expectedList = new SList();

        for(int idx = values.length - 1; idx >= 0; idx --) {
            originalList.addFirst(values[idx]);
        }

        for(int idx = expected.length - 1; idx >= 0; idx --){
            expectedList.addFirst(expected[idx]);
        }
        originalList.mergeNodes();
        assertTrue(expectedList.equals(originalList));
    }

    @Test
    void testMultipleMerge() {
        int[] values = {4,4,4,4,100,7,100,100,100,56,12,16,16,16};
        int[] expected = {16,100,7,300,56,12,48};
        SList<Integer> originalList = new SList();
        SList<Integer> expectedList = new SList();

        for(int idx = values.length - 1; idx >= 0; idx --) {
            originalList.addFirst(values[idx]);
        }

        for(int idx = expected.length - 1; idx >= 0; idx --){
            expectedList.addFirst(expected[idx]);
        }
        originalList.mergeNodes();
        assertTrue(expectedList.equals(originalList));
    }

    @Test
    void testNoIntersection() {
        int[] s1Values = {1, 6, 9, 10, 15, 20, 25};
        int[] s2Values = {2, 4, 7, 11, 14, 18, 23};
        int[] expected = {16,100,7,300,56,12,48};

        SList<Integer> s1 = new SList();
        SList<Integer> s2 = new SList();

        for(int idx = s1Values.length - 1; idx >= 0; idx --) {
            s1.addFirst(s1Values[idx]);
        }

        for(int idx = s2Values.length - 1; idx >= 0; idx --){
            s2.addFirst(s2Values[idx]);
        }
        SList<Integer> result = SList.linkedIntersection(s1, s2);
        assertTrue(result.size() == 0);
    }

    @Test
    void testAllIntersection() {
        int[] s1Values = {1, 6, 9, 10, 15, 20, 25};
        int[] s2Values = {-10, -5, -3, 0, 1, 6, 9, 10, 15, 20, 25};
        int[] expected = {16,100,7,300,56,12,48};

        SList<Integer> s1 = new SList();
        SList<Integer> s2 = new SList();
        SList<Integer> SListExpected = new SList();

        for(int idx = s1Values.length - 1; idx >= 0; idx --) {
            s1.addFirst(s1Values[idx]);
            SListExpected.addFirst(s1Values[idx]);
        }

        for(int idx = s2Values.length - 1; idx >= 0; idx --){
            s2.addFirst(s2Values[idx]);
        }
        SList<Integer> result = SList.linkedIntersection(s1, s2);
        assertTrue(SListExpected.equals(result));
    }

    @Test
    void testSomeIntersection() {
        int[] s1Values = {-20, 3, 5, 6, 7, 8, 9, 15, 20, 25, 30, 35, 50, 100, 200, 300};
        int[] s2Values = {-20, -10, -4, 0, 2, 3, 4, 5, 9, 11, 13, 14, 15, 18, 300, 500, 501, 502};
        int[] expected = {-20,3,5,9,15,300};

        SList<Integer> s1 = new SList();
        SList<Integer> s2 = new SList();
        SList<Integer> SListExpected = new SList();

        for(int idx = s1Values.length - 1; idx >= 0; idx --) {
            s1.addFirst(s1Values[idx]);
        }

        for(int idx = s2Values.length - 1; idx >= 0; idx --){
            s2.addFirst(s2Values[idx]);
        }

        for(int idx = expected.length - 1; idx >= 0; idx --){
            SListExpected.addFirst(expected[idx]);
        }

        SList<Integer> result = SList.linkedIntersection(s1, s2);
        assertTrue(SListExpected.equals(result));
    }

}