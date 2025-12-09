import java.util.ArrayList;

/**
 * The Node for an Integer Binary Tree
 *
 * @author: Nandhini Namasivayam
 * @version: 03/22/22
 */

public class BSTNode {
    private BSTNode left;
    private BSTNode right;
    private int val;
    // depth is the largest possible number of generations below you
    private int depth;

    public BSTNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
        this.depth = 0;
    }

    /** Getters and Setters **/
    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
        recomputeDepth();
    }

    public BSTNode getRight() {
        return right;

    }

    public void setRight(BSTNode right) {
        this.right = right;
        recomputeDepth();
    }

    public int getVal() {
        return val;
    }

    private void recomputeDepth() {
        depth = 0;
        if (left != null && left.depth >= depth) depth = left.depth+1;
        if (right != null && right.depth >= depth) depth = right.depth+1;
    }

    public boolean search(int value) {
        // if value exists in tree return true, otherwise false
        if (val == value) return true;
        if (value < val && left != null) {
            return left.search(value);
        }
        if (value > val && right != null) {
            return right.search(value);
        }
        return false;


    }
    public void traverse(ArrayList<BSTNode> list, boolean l, boolean r) {
        if (l && left != null) left.traverse(list,l,r);
        if (r && right != null) right.traverse(list,l,r);
        list.add(this);
        if (!l && left != null) left.traverse(list,l,r);
        if (!r && right != null) right.traverse(list,l,r);
    }

    public void insert(int value) {
        if (val == value) return;
        if (value < val && left != null) left.insert(value);
        if (value < val && left == null) left = new BSTNode(value);
        if (value > val && right != null) right.insert(value);
        if (value > val && right == null) right = new BSTNode(value);
        recomputeDepth();

    }

    public String toString() {
        return Integer.toString(this.val);
    }

    public boolean equals(BSTNode other) {
        return this.val == other.val;
    }
}
