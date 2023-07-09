package trie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class TrieTest {
    @Test
    public void testCollect(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"hello", "hero", "apple", "sad", "same",
        "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            expectedSet.add(s);
        }

        List<String> allWords = wordTrie.collectKeys();
        Set<String> outputSet = new HashSet<>();
        for(String a: allWords){
            outputSet.add(a);
        }

        assertTrue(outputSet.equals(expectedSet));
    }

    @Test
    public void testPrefixCollectNoMatches(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        for(String s: keyWords){
            wordTrie.insert(s);
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("he");
        assertTrue(prefixWords.size() == 0);
    }

    @Test
    public void testPrefixCollectEmptyPrefix(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"head", "hero", "heroes", "hello",
                "help", "helping", "heed", "heaven", "height", "helium",
                "apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            expectedSet.add(s);
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("");
        Set<String> outPutSet = new HashSet<>();
        for(String pw: prefixWords){
            outPutSet.add(pw);
        }
        assertTrue(outPutSet.equals(expectedSet));
    }

    @Test
    public void testPrefixCollectAllMatches(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"head", "hero", "heroes", "hello",
            "help", "helping", "heed", "heaven", "height", "helium"};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            if(s.substring(0, 2).equals("he")){
                expectedSet.add(s);
            }
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("he");
        Set<String> outPutSet = new HashSet<>();
        for(String pw: prefixWords){
            outPutSet.add(pw);
        }
        assertTrue(outPutSet.equals(expectedSet));
    }
}
