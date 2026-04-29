void main() {
    BST<Integer, String> tree = new BST<>();
    tree.put(15, "Fifteen");
    tree.put(11, "Eleven");
    tree.put(3, "Three");
    tree.put(47, "Forty Seven");
    tree.delete(11);

    System.out.println(tree.get(47));

    Iterable<BST<Integer, String>.Node> iter = tree.iterator();
    for (var elem : iter) {
        System.out.println("key is " + elem.getKey() + " and value is " + elem.getVal());
    }
}
