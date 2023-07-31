package lists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class SolutionsTest {

    @Test
    void testSliceForward() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        int[] expectedValues = {4, 12, 3, -5};
        List<Integer> listToSlice = new ArrayList();
        List<Integer> expected = new ArrayList<>();

        for(int i: values){
            listToSlice.add(i);
        }

        for(int i: expectedValues){
            expected.add(i);
        }
        List<Integer> result = Solutions.slice(listToSlice, 1, 5, 1);
        assertTrue(expected.equals(result));
    }

    @Test
    void testSliceBackward() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        int[] expectedValues = {-4, -5, 3, 12};
        List<Integer> listToSlice = new ArrayList();
        List<Integer> expected = new ArrayList<>();

        for(int i: values){
            listToSlice.add(i);
        }

        for(int i: expectedValues){
            expected.add(i);
        }
        List<Integer> result = Solutions.slice(listToSlice, 5, 1, -1);
        assertTrue(expected.equals(result));
    }

    @Test
    void testSliceForwardMultiple() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        int[] expectedValues = {12, -5, -4, 10};
        List<Integer> listToSlice = new ArrayList();
        List<Integer> expected = new ArrayList<>();

        for(int i: values){
            listToSlice.add(i);
        }

        for(int i: expectedValues){
            expected.add(i);
        }
        List<Integer> result = Solutions.slice(listToSlice, 2, 9, 2);
        assertTrue(expected.equals(result));
    }

    @Test
    void testSliceBackwardMultiple() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        int[] expectedValues = {7, -4, 3};
        List<Integer> listToSlice = new ArrayList();
        List<Integer> expected = new ArrayList<>();

        for(int i: values){
            listToSlice.add(i);
        }

        for(int i: expectedValues){
            expected.add(i);
        }
        List<Integer> result = Solutions.slice(listToSlice, 9, 2, -3);
        assertTrue(expected.equals(result));
    }

    @Test
    void testSliceEmpty() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        List<Integer> listToSlice = new ArrayList();

        for(int i: values){
            listToSlice.add(i);
        }

        List<Integer> result = Solutions.slice(listToSlice, 5, 2, 4);
        assertTrue(result.size() == 0);
    }

    @Test
    void testSliceAll() {
        int[] values = {5, 4, 12, 3, -5, -4, -4, 2, 10, 7, 8};
        List<Integer> listToSlice = new ArrayList();
        List<Integer> expected = new ArrayList();
        for(int i: values){
            listToSlice.add(i);
            expected.add(i);
        }

        List<Integer> result = Solutions.slice(listToSlice, 0, 25, 1);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testSingletons(){
        String[] words = {"abc", "def", "a", "b", "c"};
        List<Set<String>> expected = new ArrayList<>();

        for(String s: words){
            Set<String> single = new HashSet<>();
            single.add(s);
            expected.add(single);
        }

        List<Set<String>> output = Solutions.groupAnagrams(words);
        assertTrue(expected.size() == output.size());
        for(Set<String> g: expected){
            assertTrue(output.contains(g));
        }
    }

    @Test
    public void testOneGroup(){
        String[] words = {"abcd", "bacd", "cabd", "dbca", "bcad"};
        List<Set<String>> expected = new ArrayList<>();
        Set<String> all = new HashSet<>();
        for(String s: words){
            all.add(s);
        }
        expected.add(all);

        List<Set<String>> output = Solutions.groupAnagrams(words);
        assertTrue(expected.size() == output.size());
        for(Set<String> g: expected){
            assertTrue(output.contains(g));
        }
    }

    @Test
    public void testMultiple(){
        List<Set<String>> expected = new ArrayList<>();
        String[][] words = {{"abcd", "bacd", "cabd", "dbca", "bcad"},
                {"xyz", "yzx"}, {"aaabbc", "bbcaaa", "caabab"}, {"x"}};
        for(String[] group: words){
            Set<String> anagrams = new HashSet<>();
            for(String s: group){
                anagrams.add(s);
            }
            expected.add(anagrams);
        }

        String[] input = {"abcd", "xyz", "yzx","aaabbc",
                          "cabd", "dbca", "bcad","bbcaaa",
                          "caabab", "x", "bacd",};

        List<Set<String>> output = Solutions.groupAnagrams(input);
        assertTrue(expected.size() == output.size());
        for(Set<String> g: expected){
            assertTrue(output.contains(g));
        }
    }

    @Test
    void testMergeEvenLists(){
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        int numLists = 4;
        Random r = new Random();

        for(int i = 0; i < numLists; i ++){
            List<Integer> singleList = new ArrayList<>();
            int listLen = r.nextInt(5, 10);
            for(int j = 0; j < listLen; j ++){
                int number = r.nextInt(0, 1000);
                singleList.add(number);
                expected.add(number);
            }
            Collections.sort(singleList);
            allLists.add(singleList);
        }
        Collections.sort(expected);
        List<Integer> output = Solutions.mergeAll(allLists);
        assertTrue(expected.equals(output));
    }

    @Test
    void testMergeOddLists(){
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        int numLists = 7;
        Random r = new Random();

        for(int i = 0; i < numLists; i ++){
            List<Integer> singleList = new ArrayList<>();
            int listLen = r.nextInt(5, 10);
            for(int j = 0; j < listLen; j ++){
                int number = r.nextInt(0, 1000);
                singleList.add(number);
                expected.add(number);
            }
            Collections.sort(singleList);
            allLists.add(singleList);
        }
        Collections.sort(expected);
        List<Integer> output = Solutions.mergeAll(allLists);
        assertTrue(expected.equals(output));
    }

    @Test
    void testMergeEvenLarge(){
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        int numLists = 100;
        Random r = new Random();

        for(int i = 0; i < numLists; i ++){
            List<Integer> singleList = new ArrayList<>();
            int listLen = r.nextInt(500, 1000);
            for(int j = 0; j < listLen; j ++){
                int number = r.nextInt(-1000, 1000);
                singleList.add(number);
                expected.add(number);
            }
            Collections.sort(singleList);
            allLists.add(singleList);
        }
        Collections.sort(expected);
        List<Integer> output = Solutions.mergeAll(allLists);
        assertTrue(expected.equals(output));
    }

    @Test
    void testMergeOddLarge(){
        List<List<Integer>> allLists = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        int numLists = 101;
        Random r = new Random();

        for(int i = 0; i < numLists; i ++){
            List<Integer> singleList = new ArrayList<>();
            int listLen = r.nextInt(500, 1000);
            for(int j = 0; j < listLen; j ++){
                int number = r.nextInt(-1000, 1000);
                singleList.add(number);
                expected.add(number);
            }
            Collections.sort(singleList);
            allLists.add(singleList);
        }
        Collections.sort(expected);
        List<Integer> output = Solutions.mergeAll(allLists);
        assertTrue(expected.equals(output));
    }

    @Test
    void testECV1(){
        int[] pins = {3, 1, 1, 9, 9, 2, -5, -5};
        assertTrue(Solutions.bowlingPins(pins) == 113);
    }

    @Test
    void testECV2(){
        int[] pins = {4, 9, 2, 3, -1};
        assertTrue(Solutions.bowlingPins(pins) == 42);
    }

    @Test
    void testECV3(){
        int[] pins = {-1, -1, -5, 5, -5};
        assertTrue(Solutions.bowlingPins(pins) == 10);
    }

    @Test
    void testECV4(){
        int[] pins = {2, 1, 2, 1, 2, 1, -10, 2, 1, 2, 1, 2, 1};
        assertTrue(Solutions.bowlingPins(pins) == 18);
    }
}