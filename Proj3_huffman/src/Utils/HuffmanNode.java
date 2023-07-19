package Utils;

public class HuffmanNode implements Comparable<HuffmanNode> {
    public int frequency;
    public char letter;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(char c, int frequency){
        this.letter = c;
        this.frequency = frequency;
    }

    public boolean isLeaf(){
        return left == null  && right == null;
    }

    public int compareTo(HuffmanNode hn){
        return this.frequency - hn.frequency;
    }
}

