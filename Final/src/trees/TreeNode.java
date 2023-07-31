package trees;
import java.util.*;
public class TreeNode {
    public int value;
    private List<TreeNode> children;

    public TreeNode(int value, List<TreeNode> children){
        this.value = value;
        this.children = children;
    }

    public TreeNode(int value){
        this.value = value;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode n){
        this.children.add(n);
    }

    public void addChildren(List<TreeNode> children){
        for(TreeNode n: children){
            this.children.add(n);
        }
    }

    public List<TreeNode> getChildren(){
        return children;
    }

}
