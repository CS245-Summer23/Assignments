package map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    public static List<String> generateTestKeys(int length){
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>();
        helper(length, keys, sb);
        return keys;
    }

    public static void helper(int length, List<String> keys, StringBuilder sb){
        if(length == 0){
            keys.add(sb.toString());
            return;
        }
        for(char x = 97; x < 123; x ++){
            sb.append(x);
            helper(length - 1, keys, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

   @Test
   void testSimpleInsert(){
       MyMap<String, Integer> testMap = new MyMap();
       testMap.put("Hello", 10);
       testMap.put("world", 7);
       assertTrue(testMap.get("Hello") == 10);
       assertTrue(testMap.get("world") == 7);
   }

    @Test
    void testSimpleUpdate(){
        MyMap<String, Integer> testMap = new MyMap();
        testMap.put("Hello", 10);
        testMap.put("world", 7);
        testMap.put("world", 20);
        assertTrue(testMap.get("Hello") == 10);
        assertTrue(testMap.get("world") == 20);
    }

    @Test
    void testSimpleDelete(){
        MyMap<String, Integer> testMap = new MyMap();
        testMap.put("Hello", 10);
        testMap.put("world", 7);
        testMap.remove("world");
        assertTrue(testMap.get("Hello") == 10);
        assertTrue(testMap.get("world") == null);
    }

    @Test
    void testSimpleContains(){
        MyMap<String, Integer> testMap = new MyMap();
        testMap.put("Hello", 10);
        testMap.put("world", 7);
        testMap.remove("world");
        assertTrue(testMap.contains("Hello"));
        assertFalse(testMap.contains("world"));
    }

    @Test
    public void testSimpleResize(){
        MyMap<String, Integer> myMap = new MyMap<>();
        List<String> keys = generateTestKeys(1);
        Collections.sort(keys);

        for(int i = 0; i < keys.size(); i ++){
            String key = keys.get(i);
            myMap.put(key, i + 1);
        }
        assertTrue(myMap.contains(keys.get(15)));
        assertTrue(myMap.get(keys.get(15)) == 16);
    }
}