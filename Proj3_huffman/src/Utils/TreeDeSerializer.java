package Utils;

import java.io.IOException;

public class TreeDeSerializer {

    public int bitsRead;
    public int bitsToRead;

    public TreeDeSerializer(){
        bitsToRead = 0;
        bitsRead = 0;
    }

    /*
        Get the number of bits that is used to represent the serialized tree.
     */
    public int getSerializedSize(BufferedBitReader br){
        // TODO
        return -1;
    }

    /*
        Recreate the HuffMan tree using a pre-order traversal.
     */
    public HuffmanNode deserializeTree(BufferedBitReader br){
        // TODO
        return null;
    }

    public HuffmanNode readHeader(BufferedBitReader br){
        this.bitsToRead = getSerializedSize(br);
        HuffmanNode root = deserializeTree(br);
        return root;
    }
}
