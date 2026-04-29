import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() { return this.key; }
        public V getVal() { return this.val; }
    }

    private int size;

    public int size() {
        return this.size;
    }

    public void put(K key, V val) {
        if (root == null) {
            this.root = new Node(key, val);
            this.size++;
            return;
        }

        Node head = this.root;
        Node parent = null;
        while (head != null) {
            if (key.compareTo(head.key) < 0) {
                parent = head;
                head = head.left;
            } else if (key.compareTo(head.key) > 0) {
                parent = head;
                head = head.right;
            } else {
                head.val = val;
                return;
            }
        }
        Node newNode = new Node(key, val);
        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
    }

    public V get(K key) {
        if (root == null) {
            return null;
        }

        Node head = this.root;
        while (head != null) {
            if (key.compareTo(head.key) < 0) {
                head = head.left;
            } else if (key.compareTo(head.key) > 0) {
                head = head.right;
            } else {
                return head.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        if (root == null) {
            return;
        }

        Node head = this.root;
        Node parent = null;
        while (head != null && head.key.compareTo(key) != 0) {
            parent = head;
            int compare = key.compareTo(head.key);
            head = (compare < 0) ? head.left : head.right;
        }

        if (head == null) return;

        if (head.left != null && head.right != null) {
            Node successor = head.right;
            Node successorParent = head;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            head.key = successor.key;
            head.val = successor.val;

            head = successor;
            parent = successorParent;
        }

        Node child = (head.left != null) ? head.left : head.right;

        if (parent == null) {
            root = child;
            size--;
        } else if (parent.left == head) {
            parent.left = child;
            size--;
        } else {
            parent.right = child;
            size--;
        }
    }

    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        if (root == null) return nodes;

        Stack<Node> stack = new Stack<>();
        Node head = root;

        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            nodes.add(head);
            head = head.right;
        }
        return nodes;
    }
}
