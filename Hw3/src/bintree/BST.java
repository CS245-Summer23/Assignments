package bintree;
import java.util.*;
public class BST<T extends Comparable> {
    public static class BSTNode<T extends Comparable>{
        BSTNode left;
        BSTNode right;
        BSTNode parent;
        T item;
        int height;

        public BSTNode(T value){
            item = value;
            height = 0;
        }

        // Get first node in the in-order traversal of the subBST
        public BSTNode getFirst(){
            BSTNode leftRunner = this;
            while(leftRunner.left != null){
                leftRunner = leftRunner.left;
            }
            return leftRunner;
        }

        // Get the successor node in the in-order traversal of the subBST
        public BSTNode getSuccessor(){
            BSTNode traverser = this;
            if(this.right != null){
                return this.right.getFirst();
            }

            while(traverser != traverser.parent.left){
                traverser = traverser.parent;
            }
            return traverser.parent;
        }

        // Check if a node is a leaf
        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }

        public String toString(){
            return item.toString();
        }
    }

    BSTNode root;
    public BST(T rootValue){
        root = new BSTNode(rootValue);
    }

    public BST(){
        root = null;
    }

    // Insert a value into the BST
    public void insert(T newValue){
        if(this.root == null){
            this.root = new BSTNode(newValue);
        } else {
            insert(this.root, newValue);
        }
    }

    // Helper function to insert a value into the BST
    public BSTNode insert(BSTNode node, T newValue){
        if(node == null){
            return new BSTNode(newValue);
        } else if(node.item.compareTo(newValue) > 0){
            node.left = insert(node.left, newValue);
            node.left.parent = node;
        } else if(node.item.compareTo(newValue) < 0){
            node.right = insert(node.right, newValue);
            node.right.parent = node;
        }
        return node;
    }

    public boolean contains(T value){
        return contains(root, value);
    }

    public boolean contains(BSTNode node, T value){
        if(node == null){
            return false;
        } else if(node.item.compareTo(value) == 0){
            return true;
        } else if(node.item.compareTo(value) > 0){
            return contains(node.left, value);
        }
        return contains(node.right, value);
    }


    // Delete the value from the BST
    public void delete(T valueToDelete){
        if(contains(valueToDelete)){
            BSTNode nodeToDelete = getNodeWithValue(root, valueToDelete);
            delete(nodeToDelete);
        }
    }

    public BSTNode getNodeWithValue(BSTNode node, T value){
        if(node.item.compareTo(value) == 0){
            return node;
        } else if(node.item.compareTo(value) > 0){
            return getNodeWithValue(node.left, value);
        }
        return getNodeWithValue(node.right, value);
    }

    public void delete(BSTNode nodeToDelete){
        if(nodeToDelete.isLeaf()){
            BSTNode parent = nodeToDelete.parent;
            if(parent == null){ // Handle case where nodeToDelete is root
                root = null;
                return;
            }
            if(parent.left == nodeToDelete){
                parent.left = null;
            } else {
                parent.right = null;
            }
            nodeToDelete.parent = null;
        } else if(nodeToDelete.left != null && nodeToDelete.right != null){ // two children
            BSTNode successor = nodeToDelete.getSuccessor();
            swap(successor, nodeToDelete);
            delete(successor);
        } else if(nodeToDelete.left != null){ // nodeToDelete only has left child
            BSTNode parent = nodeToDelete.parent;
            if(parent == null){ // Handle case where nodeToDelete is root
                root = nodeToDelete.left;
                nodeToDelete.left.parent = null;
                nodeToDelete.left = null;
            } else {
                if(parent.left == nodeToDelete){
                    parent.left = nodeToDelete.left;
                } else {
                    parent.right = nodeToDelete.left;
                }
                nodeToDelete.left.parent = parent;
                nodeToDelete.left = null;
                nodeToDelete.parent = null;
            }
        } else if(nodeToDelete.right != null){ // nodeToDelete only has right child
            BSTNode parent = nodeToDelete.parent;
            if(parent == null){ // Handle case where nodeToDelete is root
                root = nodeToDelete.right;
                nodeToDelete.right.parent = null;
                nodeToDelete.right = null;
            } else {
                if(parent.left == nodeToDelete){
                    parent.left = nodeToDelete.right;
                } else {
                    parent.right = nodeToDelete.right;
                }
                nodeToDelete.right.parent = parent;
                nodeToDelete.right = null;
                nodeToDelete.parent = null;
            }
        }
    }

    public void swap(BSTNode a, BSTNode b){
        Comparable aValue = a.item;
        a.item = b.item;
        b.item = aValue;
    }

    // Find all the values in the BST between lowerBound and upperBound inclusive
    public List<T> rangeQuery(T lowerBound, T upperBound){
        List<T> values = new ArrayList<>();
        // TODO
        return values;
    }

    /*
       Code used from https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/

       Do not delete or modify any the functions below.
     */
    public static int height(BSTNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static void printBST(String[][] M, BSTNode root, int col, int row, int height) {
        if (root == null)
            return;
        if(root.item == null){
            M[row][col] = null;
        } else {
            M[row][col] = root.item.toString();
        }
        printBST(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printBST(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }

    public String toString() {
        int h = height(root);
        int col = getcol(h);
        String[][] M = new String[h][col];
        StringBuilder result = new StringBuilder();
        printBST(M, root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == null){
                    result.append("  ");
                } else{
                    result.append(M[i][j] + " ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
