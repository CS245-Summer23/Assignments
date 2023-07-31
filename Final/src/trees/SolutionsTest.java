package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SolutionsTest {

    @Test
    void testBinaryTree() {
        int[] leftValues = {1,10, 4, -1};
        int[] rightValues = {56, 4, 4, 1};
        int[] expected = {1, 4, 4, 56, -1, 4, 10, 1, -98, 56, 5};
        List<Integer> expectedOutput = new ArrayList<>();

        for(int e: expected){
            expectedOutput.add(e);
        }

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(56);
        TreeNode right = new TreeNode(-98);

        for(int n: leftValues){
            TreeNode c = new TreeNode(n);
            left.addChild(c);
        }

        for(int n: rightValues){
            TreeNode c = new TreeNode(n);
            right.addChild(c);
        }
        root.addChild(left);
        root.addChild(right);
        List<Integer> result = Solutions.reverseLevelOrder(root);
        assertTrue(expectedOutput.equals(result));
    }

    @Test
    void testLine() {
        int[] values = {5, -10, 4, 3, 2, 18, 23, 18, 22};
        int[] expected = {22, 18, 23, 18, 2, 3, 4, -10, 5, 100};
        List<Integer> expectedOutput = new ArrayList<>();

        for(int e: expected){
            expectedOutput.add(e);
        }

        TreeNode root = new TreeNode(100);
        TreeNode parent = root;
        for(int n: values){
            TreeNode child = new TreeNode(n);
            parent.addChild(child);
            parent = parent.getChildren().get(0);
        }
        List<Integer> result = Solutions.reverseLevelOrder(root);
        assertTrue(expectedOutput.equals(result));
    }

    @Test
    void testVaryingDepths() {
        List<Integer> expectedOutput = new ArrayList<>();

        for(int i = 99; i >= 0; i --){
            expectedOutput.add(i);
        }
        expectedOutput.add(54);
        expectedOutput.add(-500);
        expectedOutput.add(-98);
        expectedOutput.add(56);
        expectedOutput.add(5);

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(56);
        TreeNode right = new TreeNode(-98);
        root.addChild(left);
        root.addChild(right);

        right.addChild(new TreeNode(-500));
        right.addChild(new TreeNode(54));

        TreeNode n = right.getChildren().get(0);
        for(int i = 0; i < 100; i ++){
            n.addChild(new TreeNode(i));
        }

        List<Integer> result = Solutions.reverseLevelOrder(root);
        assertTrue(expectedOutput.equals(result));
    }

    @Test
    void testBasicHeritage() {
        Person mother = new Person("USA", null, null);
        Person father = new Person("Canada", null, null);
        Person child = new Person("Mexico", mother, father);

        HashMap<String, Double> expectedHeritage = new HashMap<>();
        expectedHeritage.put("USA", 0.5);
        expectedHeritage.put("Canada", 0.5);

        HashMap<String, Double> result = Solutions.nationalHeritage(child);

        for(String country: expectedHeritage.keySet()){
            assertTrue(result.containsKey(country));
        }

        for(String country: expectedHeritage.keySet()){
            double expected = expectedHeritage.get(country);
            double output = result.get(country);
            assertTrue(Math.abs(expected - output) <= .0001);
        }
    }

    @Test
    void testBasicHeritageV2() {
        Person mother = new Person("USA", null, null);
        Person father = new Person("USA", null, null);
        Person child = new Person("Mexico", mother, father);

        HashMap<String, Double> expectedHeritage = new HashMap<>();
        expectedHeritage.put("USA", 1.0);

        HashMap<String, Double> result = Solutions.nationalHeritage(child);

        for(String country: expectedHeritage.keySet()){
            assertTrue(result.containsKey(country));
        }

        for(String country: expectedHeritage.keySet()){
            double expected = expectedHeritage.get(country);
            double output = result.get(country);
            assertTrue(Math.abs(expected - output) <= .0001);
        }
    }

    @Test
    void testHeritageV3() {
        Person mGrandma = new Person("Britain", null, null);
        Person mGrandpa = new Person("France", null, null);

        Person pGrandma = new Person("Britain", null, null);
        Person pGrandpa = new Person("Netherlands", null, null);
        Person mother = new Person("USA", mGrandma, mGrandpa);
        Person father = new Person("USA", pGrandma, pGrandpa);

        Person child = new Person("Mexico", mother, father);

        HashMap<String, Double> expectedHeritage = new HashMap<>();
        expectedHeritage.put("Britain", 0.5);
        expectedHeritage.put("Netherlands", 0.25);
        expectedHeritage.put("France", 0.25);

        HashMap<String, Double> result = Solutions.nationalHeritage(child);

        for(String country: expectedHeritage.keySet()){
            assertTrue(result.containsKey(country));
        }

        for(String country: expectedHeritage.keySet()){
            double expected = expectedHeritage.get(country);
            double output = result.get(country);
            assertTrue(Math.abs(expected - output) <= .0001);
        }
    }
}