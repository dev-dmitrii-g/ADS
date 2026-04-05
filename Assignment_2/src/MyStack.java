public class MyStack<T extends Comparable<T>>  {
    private final MyArrayList<T> list;

    public MyStack() {
        this.list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() <= 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}