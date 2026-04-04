public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        MyListTest.runAllTests(list);

        list = new MyLinkedList<>();
        MyListTest.runAllTests(list);
    }
}
