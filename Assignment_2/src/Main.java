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
        stack.pop();
        if (stack.size() != 2 || !stack.peek().equals("World")) {
            throw new RuntimeException();
        } else {
            System.out.println("SUCCESS: MyStack passed all tests\n");
        }

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        if (queue.size() != 3 || !queue.getRear().equals(5) || !queue.getFront().equals(3)) {
            throw new RuntimeException();
        } else {
            System.out.println("SUCCESS: MyQueue passed all tests\n");
        }

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);
        if (!heap.extractMin().equals(1)) {
            throw new RuntimeException();
        } else {
            System.out.println("SUCCESS: MyMinHeap passed all tests\n");
        }
    }
}
