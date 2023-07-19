package Utils;

import java.io.IOException;
import java.util.Map;

public class TreeSerializer {
    /*
        Helper function to write the beginning bits of the compressed file. The
        first 32 bits represents an integer K. The next K bits (i.e bits [33, 332 + K])
        store the serialization of the tree.

        Do not modify this method.
     */
    public static void writeHeader(BufferedBitWriter bw, HuffmanNode root){
        int numLeaves = getNumLeaves(root);
        int numNonLeaves = getNumInternalNodes(root);

        int totalbits = numLeaves * 9 + numNonLeaves;
        String bitString = Integer.toBinaryString(totalbits);
        bitString = String.format("%32s", bitString).replaceAll(" ", "0");  // 32-bit Integer
        try {
            for(int i = 0; i < bitString.length(); i ++){
                if (bitString.charAt(i) == '1'){
                    bw.writeBit(1);
                } else {
                    bw.writeBit(0);
                }
            }
            serializeTree(bw, root);
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /*
        Generate the serialized version of the Huffman tree. For every internal (non-leaf)
        node, write a bit value of 0. For leaf nodes, write the bit value of 1 followed by the
        8-bit representation of the character. Since we are dealing with the ASCII character set,
        we can represent each character using 8 bits.
     */
    public static void serializeTree(BufferedBitWriter bw, HuffmanNode node) throws IOException{
        // TODO
    }

    /*
        Get the number of leaf nodes in the Huffman tree.
     */
    public static int getNumLeaves(HuffmanNode node){
        // TODO
        return -1;
    }

    /*
        Get the number of non-leaf nodes in the Huffman tree.
     */
    public static int getNumInternalNodes(HuffmanNode node){
        // TODO
        return -1;
    }
}
