package com.datastructures;

import java.util.ArrayList;
import java.util.List;

// anything that is comparable
public class BinarySearchTree <T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        System.out.println(tree.size()); // 3
        tree.remove(5);
        tree.traverse(TreeTraversalOrder.IN_ORDER);
    }

    private int nodeCount = 0;
    private Node root = null;

    // check if empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // get the number of nodes in bTree
    public int size() {
        return nodeCount;
    }

    // add an element to bTree using private add(Node, T) method
    public boolean add(T element) {

        // if already in, ignore
        if (contains(element)) {
            return false;
        } else {
            root = add(root, element);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T element) {
        if (node == null) {
            node = new Node(null, null, element);
        } else {
            // place lower element values in left tree
            if (element.compareTo(node.data) < 0) {
                node.left = add(node.left, element);
            } else {
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node node, T elem) {
        // base case - no element
        if (node == null) return false;

        int comparedValue = elem.compareTo(node.data);
        // value we are looking for is smaller than current value, so it is in the left
        if (comparedValue < 0) {
            return contains(node.left, elem);
        }
        // value we are looking for is greater than current value, so it is in the right
        else if (comparedValue > 0) {
            return contains(node.right, elem);
        }
        // found it!
        else {
            return true;
        }
    }

    public boolean remove(T element) {
        if (contains(element)) {
            root = remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T element) {
        if (node == null) { return null; }

        int compareValue = element.compareTo(node.data);

        // value we are looking for is smaller than the current value,
        // so it must be in left subtree
        if (compareValue < 0) {
            node.left = remove(node.left, element);
        }
        // value we are looking for is smaller than the current value,
        // so it must be in right subtree
        else if (compareValue > 0) {
            node.right = remove(node.right, element);
        }
        // found it! remove it now!
        else {
            // just swap the node we wish to remove with its right child
            if (node.left == null) {
                Node rightChild = node.right;
                // remove the data
                node.data = null;
                node = null;
                return rightChild;
            }
            else if (node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            }
            // left + right subtree exist
            else {
                // find leftmost node in the right subtree
                Node temp = digLeft(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }

        return node;
    }

    private Node digLeft(Node node) {
        Node current = node;
        while(current.left != null) {
            current = current.left;
        }
        return current;
    }

    // find hight of the tree, O(n)
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max( height(node.left) , height(node.right) ) + 1;
    }

    // traverse different ways, just print the values
    public void traverse(TreeTraversalOrder order) {
        switch (order) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new UnsupportedOperationException("No such traversal operation implemented");
        }
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) { return; }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) { return; }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private enum TreeTraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER
    }

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(Node left, Node right, T element) {
            this.left  = left;
            this.right = right;
            this.data  = element;
        }
    }
}
