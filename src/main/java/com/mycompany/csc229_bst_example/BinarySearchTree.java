package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    // Method to check if the tree is empty
    public boolean isEmpty() {
        return (this.root == null);
    }

    // Method to insert a new node into the tree
    public void insert(Integer data) {
        System.out.print("[input: " + data + "]");
        // If the tree is empty, create a new node as the root
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        // Otherwise, recursively insert the node into the appropriate position
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    // Recursive method to insert a new node into the tree
    private BstNode insertNode(BstNode root, Integer data) {
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        // If the data is less than or equal to the current node's data, go left
        if (root.getData() >= data) {
            System.out.print(" [L]");
            // If the left child is null, create a new node and set it as the left child
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                // Otherwise, recursively insert into the left subtree
                tmpNode = root.getLeft();
            }
        } else { // If the data is greater than the current node's data, go right
            System.out.print(" [R]");
            // If the right child is null, create a new node and set it as the right child
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                // Otherwise, recursively insert into the right subtree
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    // Method to perform an in-order traversal of the tree
    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    // Recursive method to perform in-order traversal
    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft()); // Traverse left subtree
        System.out.print(root.getData() + " "); // Visit current node
        doInOrder(root.getRight()); // Traverse right subtree
    }

    // Method to perform a pre-order traversal of the tree
    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    // Recursive method to perform pre-order traversal
    private void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " "); // Visit current node
        doPreOrder(root.getLeft()); // Traverse left subtree
        doPreOrder(root.getRight()); // Traverse right subtree
    }

    // Method to find the height of the tree
    public Integer findHeight() {
        return findHeight(this.root);
    }

    // Recursive method to find the height of the tree
    private Integer findHeight(BstNode node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = findHeight(node.getLeft());
        int rightHeight = findHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1; // Height of the current node is the maximum height of its subtrees + 1
    }

    // Method to get the depth of a specific node in the tree
    public int getDepth(BstNode node) {
        return getDepth(this.root, node, 0);
    }

    // Recursive method to get the depth of a node
    private int getDepth(BstNode root, BstNode node, int depth) {
        if (root == null) {
            return -1; // Node not found
        }
        if (root == node) {
            return depth; // Node found, return its depth
        }
        int leftDepth = getDepth(root.getLeft(), node, depth + 1); // Search left subtree
        if (leftDepth != -1) {
            return leftDepth;
        }
        return getDepth(root.getRight(), node, depth + 1); // If not found in left subtree, search right subtree
    }

    // Method to print the tree
    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    // Recursive method to print the tree
    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData());
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true); // Print left subtree
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false); // Print right subtree
        }
    }
}
