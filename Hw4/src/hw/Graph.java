package hw;
import java.util.*;
import java.io.*;

public class Graph {
    ArrayList<Edge>[] graph;

    public Graph(int numVertices){
        graph = new ArrayList[numVertices];
        for(int nodeIdx = 0; nodeIdx < numVertices; nodeIdx ++){
            graph[nodeIdx] = new ArrayList<>();
        }
    }

    // Get the edges given a node id
    public List<Edge> getEdges(int nodeIdx){
        return graph[nodeIdx];
    }

    // Adds an edge to the graph
    public void addEdge(Edge e){
        int source = e.getSource();
        int target = e.getTarget();
        graph[source].add(e);
    }

    public void addEdges(List<Edge> edges){
        for(Edge e: edges){
            addEdge(e);
        }
    }

    // Gets number of vertices in the graph
    public int getNumVertices(){
        return graph.length;
    }

    // Read all the edges for a graph from a file
    public static void createGraph(Graph g, String edgeFiles, boolean isDirected){
        try {
            BufferedReader br = new BufferedReader(new FileReader(edgeFiles));
            List<Edge> edges = new ArrayList<>();
            String line;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }

                String[] values = line.split(",");
                Edge e = null;
                if(values.length == 3){
                    e = new Edge(Integer.parseInt(values[0]),
                            Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]));
                } else {
                    e = new Edge(Integer.parseInt(values[0]),
                                    Integer.parseInt(values[1]), 1);
                }

                edges.add(e);
                if(!isDirected){
                    e = new Edge(e.getTarget(), e.getSource(), e.getWeight());
                    edges.add(e);
                }
            }
            g.addEdges(edges);
        } catch(FileNotFoundException f){
            System.out.println("File not found: " + f.getMessage());
        } catch(IOException e){
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public static int numConnectedComponents(Graph g){
        // TODO
        return -1;
    }


    public static boolean hasNegativeCycle(Graph g, int sourceNode){
        // TODO
    }

}
