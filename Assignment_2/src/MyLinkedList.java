import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    public void set(int index, T item) {
        this.checkElementIndex(index);
        Node<T> node = this.node(index);
        node.data = item;
    }

    public void add(int index, T item) {
        this.checkPositionIndex(index);
        if (index == this.size) {
            add(item);
            return;
        }

        if (index == 0) {
            Node<T> node = new Node<>(item);
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            this.size++;
            return;
        }

        Node<T> nextNode = node(index);
        Node<T> prevNode = nextNode.prev;
        Node<T> newNode = new Node<>(item);

        newNode.next = nextNode;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        this.size++;
    }

    public void addFirst(T item) {
        this.add(0, item);
    }

    public void addLast(T item) {
        this.add(item);
    }

    public T get(int index) {
        this.checkElementIndex(index);
        return this.node(index).data;
    }

    public T getFirst() {
        this.checkElementIndex(0);
        return this.node(0).data;
    }

    public T getLast() {
        this.checkElementIndex(this.size - 1);
        return this.node(this.size - 1).data;
    }

    public void remove(int index) {
        this.checkElementIndex(index);
        this.unlink(this.node(index));

    }

    public void removeFirst() {
        this.checkElementIndex(0);
        this.remove(0);
    }

    public void removeLast() {
        this.checkElementIndex(this.size - 1);
        this.remove(this.size - 1);
    }

    public void sort() {
        this.head = sort(this.head);
        Node<T> tmp = this.head;
        if (tmp == null) return;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        this.tail = tmp;
    }

    private Node<T> sort(Node<T> head) {
        if (head == null || head.next == null) return head;
        Node<T> mid = split(head);
        Node<T> left = sort(head);
        Node<T> right = sort(mid);
        return mergeSort(left, right);
    }

    public int indexOf(Object object) {
        int index = 0;
        if (object == null) {
            for (Node<T> node = this.head; node != null; node = node.next) {
                if (node.data == null) {
                    return index;
                }
                ++index;
            }
        } else {
            for (Node<T> node = this.head; node != null; node = node.next) {
                if (object.equals(node.data)) {
                    return index;
                }
                ++index;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = this.size;
        if (object == null) {
            for (Node<T> node = this.tail; node != null; node = node.prev) {
                --index;
                if (node.data == null) {
                    return index;
                }
            }
        } else {
            for (Node<T> node = this.tail; node != null; node = node.prev) {
                --index;
                if (object.equals(node.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return this.indexOf(object) >= 0;
    }

    public Object[] toArray() {
        Object[] res = new Object[this.size];
        int i = 0;
        for (Node<T> node = this.head; node != null; node = node.next) {
            res[i++] = node.data;
        }
        return res;
    }

    public void clear() {
        Node<T> next;
        for (Node<T> node = this.head; node != null; node = next) {
            next = node.next;
            node.data = null;
            node.next = null;
            node.prev = null;
        }
        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < this.size)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
    }

    private void unlink(Node<T> node) {
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        --this.size;
    }

    private Node<T> mergeSort(Node<T> first, Node<T> second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.data.compareTo(second.data) <= 0) {
            first.next = mergeSort(first.next, second);
            if (first.next != null) first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = mergeSort(first, second.next);
            if (second.next != null) second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    private Node<T> split(Node<T> head) {
        Node<T> fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<T> tmp = slow.next;
        slow.next = null;
        if (tmp != null) tmp.prev = null;
        return tmp;
    }

    private Node<T> node(int index) {
        if (index < this.size >> 1) {
            Node<T> node = this.head;

            for (int i = 0; i < index; ++i) {
                node = node.next;
            }
            return node;
        } else {
            Node<T> node = this.tail;

            for (int i = this.size - 1; i > index; --i) {
                node = node.prev;
            }
            return node;
        }
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
            prev = next = null;
        }
    }

    private class MyIterator implements Iterator<T> {
        private Node<T> lastNode;
        private Node<T> nextNode;
        private int nextIdx;

        MyIterator() {
            this.nextNode = head;
            this.nextIdx = 0;
        }

        public boolean hasNext() {
            return nextIdx < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("Linked list is empty");
            }
            lastNode = nextNode;
            nextNode = nextNode.next;
            nextIdx++;
            return lastNode.data;
        }

        public void remove() {
            if (lastNode == null) {
                throw new IllegalStateException();
            }
            Node<T> lastNext = lastNode.next;
            unlink(lastNode);
            if (nextNode == lastNode) {
                nextNode = lastNext;
            } else {
                nextIdx--;
            }
            lastNode = null;
        }
    }
}
