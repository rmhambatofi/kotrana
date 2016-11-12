package fr.manitra.kotrana.ctci;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by manitra on 12/11/16.
 */
public class BinarySearchTree {
    private Node root;
    private int size;

    public void add(Integer value) {
        if (size == 0) {
            root = new Node(value);
        } else {
            add(root, value);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void preorder() {
        preorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    public void inorder() {
        inorder(root);
    }

    public void breadthFirst() {
        breadthFirst(root);
    }

    private Node add(Node parent, Integer value) {
        Node node = new Node(value);
        if (parent == null) {
            parent = node;
        } else if (value <= parent.value) {
            parent.left = add(parent.left, value);
        } else {
            parent.right = add(parent.right, value);
        }
        return parent;
    }

    private void preorder(Node node) {
        if (node != null) {
            visit(node);
            if (node.left != null) preorder(node.left);
            if (node.right != null) preorder(node.right);
        }
    }

    private void postorder(Node node) {
        if (node != null) {
            if (node.left != null) postorder(node.left);
            if (node.right != null) postorder(node.right);
            visit(node);
        }
    }

    private void inorder(Node node) {
        if (node != null) {
            if (node.left != null) inorder(node.left);
            visit(node);
            if (node.right != null) inorder(node.right);
        }
    }

    private void breadthFirst(Node node) {
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visit(current);
            if (current.left != null) queue.addLast(current.left);
            if (current.right != null) queue.addLast(current.right);
        }
    }

    private void visit(Node node) {
        if (node != null) System.out.println(node.value);
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int level;

        public Node(int value) {
            this.value = value;
        }
    }
}
