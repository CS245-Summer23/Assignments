package hw;
public class Edge implements Comparable<Edge>{
    private int source;
    private int target;
    private int weight;

    public Edge(int s, int t, int w){
        source = s;
        target = t;
        weight = w;
    }

    public Edge(int s, int t){
        source = s;
        target = t;
        weight = 1;
    }

    // Returns the node id from which the edge originates from
    public int getSource(){
        return source;
    }

    // Return the node id to which the edge points to
    public int getTarget(){
        return target;
    }

    // Return the weight associated with the edge
    public int getWeight(){
        return weight;
    }

    public int compareTo(Edge other){
        return getWeight() - other.getWeight();
    }

    public String toString(){
        return String.format("(%d, %d, %d)", source, target, weight);
    }
}
