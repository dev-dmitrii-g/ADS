package bst;

import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = put(current.left, key, val);
        } else if (cmp > 0) {
            current.right = put(current.right, key, val);
        } else {
            current.val = val;
        }
        return current;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node current, K key) {
        if (current == null) return null;
        int cmp = key.compareTo(current.key);
        if (cmp < 0) return get(current.left, key);
        else if (cmp > 0) return get(current.right, key);
        else return current.val;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            size--;
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;

            Node t = current;
            current = min(t.right);
            current.right = deleteMin(t.right);
            current.left = t.left;
        }
        return current;
    }

    private Node min(Node current) {
        if (current.left == null) return current;
        else return min(current.left);
    }

    private Node deleteMin(Node current) {
        if (current.left == null) return current.right;
        current.left = deleteMin(current.left);
        return current;
    }

    @Override
    public Iterator<Node> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node> {
        private Stack<Node> stack = new Stack<>();

        public InOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            Node node = stack.pop();
            pushLeft(node.right);
            return node;
        }
    }
}
