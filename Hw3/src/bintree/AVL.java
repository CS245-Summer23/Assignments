package bintree;

public class AVL<T extends Comparable> extends BST {
    public AVL(T rootValue){
        super(rootValue);
    }

    public AVL(){
        super();
    }

    /*
        Method to insert a new value into an AVL tree. You do not need to modify
        the insert method in any way. For this assignment, you are implementing the helper
        methods the insert function calls in order to ensure the tree is balanced.
     */
    @Override
    public void insert(Comparable newValue){
        int leftSkew = 0;
        int rightSkew = 0;

        super.insert(newValue); // Insert the value into the tree
        BSTNode nodeInserted = super.getNodeWithValue(root, newValue); // Get the node corresponding with the inserted value
        updateAugmentation(nodeInserted);
        BSTNode unbalancedNode = findLowestUnBalancedNode(nodeInserted); // find unbalanced node

        // Perform necessary rotations to maintain tree balance.
        if(unbalancedNode != null){
            if(unbalancedNode.left != null){
                leftSkew = skew(unbalancedNode.left);
            }
            if(unbalancedNode.right != null){
                rightSkew = skew(unbalancedNode.right);
            }

            if(rightSkew == 1){
                rotateLeft(unbalancedNode);
            } else if(leftSkew == -1){
                rotateRight(unbalancedNode);
            } else if(rightSkew == -1){
                rotateRight(unbalancedNode.right);
                rotateLeft(unbalancedNode);
            } else if(leftSkew == 1){
                rotateLeft(unbalancedNode.left);
                rotateRight(unbalancedNode);
            }
        }
    }

    // Perform a left rotation around nodeToRotate
    public void rotateLeft(BSTNode nodeToRotate){
        // TODO
    }

    // Perform a right rotation around nodeToRotate
    public void rotateRight(BSTNode nodeToRotate){
        //TODO
    }

    /*
        Find the lowest unbalanced node in the AVL tree after an insert operation.
        When this function is called by the insert method, the node passed in is the
        node that was most recently inserted.
     */
    public BSTNode findLowestUnBalancedNode(BSTNode currentNode){
        // TODO
        return null;
    }

    // Maintain the subtree properties after a node is inserted
    public void updateAugmentation(BSTNode startingNode){
        if(startingNode == null){
            return;
        }
        startingNode.height = height(startingNode);
        updateAugmentation(startingNode.parent);
    }

    // Determine the skew of a node.
    public int skew(BSTNode node){
        int rightHeight = 0;
        int leftHeight = 0;

        if(node.right != null){
            rightHeight = 1 + height(node.right);
        }
        if(node.left != null){
            leftHeight = 1 + height(node.left);
        }
        return rightHeight - leftHeight;
    }

    // Determine the height of a node.
    public static int height(BSTNode node){
        if(node == null){
            return 0;
        }else if(node.isLeaf()){
            return 0;
        } else if(node.left == null){
            return 1 + node.right.height;
        } else if(node.right == null){
            return 1 + node.left.height;
        }
        return 1 + Math.max(node.left.height, node.right.height);
    }
}
