public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        MyListTest.runAllTests(list);

        list = new MyLinkedList<>();
        MyListTest.runAllTests(list);

        MyStack<String> stack = new MyStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Java!");


        System.out.println(stack.size());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
