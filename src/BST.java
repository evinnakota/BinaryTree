import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Eshu Vinnakota
 * @version: Dec 9, 2025
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.getLast());
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return searchHelper(root, val);
    }

    private boolean searchHelper(BSTNode node, int val) {
        if (node == null) return false;

        if (val == node.getVal()) return true;
        else if (val < node.getVal()) return searchHelper(node.getLeft(), val);
        else return searchHelper(node.getRight(), val);
    }



    public void traverse(ArrayList<BSTNode> list, boolean l, boolean r) {
        if (l && root.getLeft() != null) traverse(list, l, r);
        if (r && root.getRight() != null) traverse(list, l, r);
        list.add(this.getRoot());
        if (!l && root.getLeft() != null) traverse(list, l, r);
        if (!r && root.getRight() != null) traverse(list, l, r);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */

    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> results = new ArrayList<>();
        inorderHelper(root, results);
        return results;
    }

    private void inorderHelper(BSTNode node, ArrayList<BSTNode> list) {
        if (node == null) return;
        inorderHelper(node.getLeft(), list);
        list.add(node);
        inorderHelper(node.getRight(), list);
    }

    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> results = new ArrayList<>();
        preorderHelper(root, results);
        return results;
    }

    private void preorderHelper(BSTNode node, ArrayList<BSTNode> list) {
        if (node == null) return;
        list.add(node);
        preorderHelper(node.getLeft(), list);
        preorderHelper(node.getRight(), list);
    }
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> results = new ArrayList<>();
        postorderHelper(root, results);
        return results;
    }

    private void postorderHelper(BSTNode node, ArrayList<BSTNode> list) {
        if (node == null) return;
        postorderHelper(node.getLeft(), list);
        postorderHelper(node.getRight(), list);
        list.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        root = insertHelper(root, val);
    }

    public BSTNode insertHelper(BSTNode node, int val) {
        if (node == null) return new BSTNode(val);
        if (val == node.getVal()) return node;
        else if (val < node.getVal()) node.setLeft(insertHelper(node.getLeft(), val));
        else node.setRight(insertHelper(node.getRight(), val));
        return node;  // return the (possibly unchanged) subtree root
    }


        /**
         * Determines if the current BST is
         * a valid BST.
         * @return true if valid false otherwise
         */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTHelper(BSTNode node, int min, int max) {
        if (node == null) return true;
        if (node.getVal() <= min || node.getVal() >= max) return false;
        return isValidBSTHelper(node.getLeft(), min, node.getVal()) && isValidBSTHelper(node.getRight(), node.getVal(), max);
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("Is valid BST? " + tree.isValidBST());

    }
}