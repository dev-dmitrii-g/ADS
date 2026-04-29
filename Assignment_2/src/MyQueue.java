public class MyQueue<T extends Comparable<T>> {
    private final MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T getFront() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public T getRear() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
