package bst;

public class MainBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");
        tree.put(6, "Six");
        tree.put(8, "Eight");

        System.out.println("Tree size: " + tree.size());

        System.out.println("Value for 4: " + tree.get(4));
        System.out.println("Value for 10: " + tree.get(10));

        System.out.println("In-order traversal:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        System.out.println("\nDeleting key 3...");
        tree.delete(3);
        System.out.println("Tree size after delete: " + tree.size());

        System.out.println("In-order traversal after delete:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
