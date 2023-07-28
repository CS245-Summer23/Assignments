package hw;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void testSingleComponentSmall(){
        Graph g = new Graph(4);
        Graph.createGraph(g, "graphs/SmallConnected.txt", false);
        assertTrue(Graph.numConnectedComponents(g) == 1);
    }

    @Test
    void testMultipleComponentSmall(){
        Graph g = new Graph(4);
        Graph.createGraph(g, "graphs/SmallMultiple.txt", false);
        assertTrue(Graph.numConnectedComponents(g) == 2);
    }


    @Test
    void testSmallNoNegativeCycle(){
        Graph g = new Graph(5);
        Graph.createGraph(g, "graphs/SmallNoNegativeCycle.txt", true);
        assertFalse(Graph.hasNegativeCycle(g, 1));
    }

    @Test
    void testSmallNegativeCycle(){
        Graph g = new Graph(5);
        Graph.createGraph(g, "graphs/SmallNegativeCycle.txt", true);
        assertTrue(Graph.hasNegativeCycle(g, 1));
        assertTrue(Graph.hasNegativeCycle(g, 3));
        assertTrue(Graph.hasNegativeCycle(g, 0));
    }

}