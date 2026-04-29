import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = new Object[0];
        } else {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }
    }

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        this.add(this.size, item);
    }

    public void set(int index, T item) {
        this.checkIndex(index, this.size);
        this.data[index] = item;
    }

    public void add(int index, T item) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        if (this.size == this.data.length) {
            this.grow();
        }

        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
        this.data[index] = item;
        this.size++;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }

        Object[] newData = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        this.data = newData;
        return this.data;
    }

    private Object[] grow() {
        return this.grow(this.size + 1);
    }

    public void addFirst(T item) {
        this.add(0, item);
    }

    public void addLast(T item) {
        this.add(item);
    }

    public T get(int index) {
        this.checkIndex(index, this.size);
        return (T) this.data[index];
    }

    private int checkIndex(int index, int length) {
        if (index >= 0 && index < length) {
            return index;
        } else {
            throw new IndexOutOfBoundsException("checkIndex: " + "index: " + index + ", length: " + length);
        }
    }

    public T getFirst() {
        if (this.size == 0) throw new RuntimeException("Array is Empty");
        return (T) this.data[0];
    }

    public T getLast() {
        if (this.size == 0) throw new RuntimeException("Array is Empty");
        return (T) this.data[this.size - 1];
    }

    public void remove(int index) {
        this.checkIndex(index, this.size);
        int shift = this.size - index - 1;
        if (shift > 0) {
            System.arraycopy(this.data, index + 1, this.data, index, shift);
        }
        this.data[--this.size] = null;
    }

    public void removeFirst() {
        if (this.size == 0) throw new RuntimeException("Array is Empty");
        this.remove(0);
    }

    public void removeLast() {
        if (this.size == 0) throw new RuntimeException("Array is Empty");
        this.remove(this.size - 1);
    }

    private int partition(int low, int high) {
        T pivot = (T) this.data[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (((T) data[j]).compareTo(pivot) < 0) {
                i++;
                this.swap(i, j);
            }
        }
        this.swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = this.partition(low, high);
            this.quickSort(low, pi - 1);
            this.quickSort(pi + 1, high);
        }
    }

    public void sort() {
        if (this.size > 1) {
            this.quickSort(0, this.size - 1);
        }
    }

    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < this.size; ++i) {
                if (this.data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.size; ++i) {
                if (object.equals(this.data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = this.size - 1; i >= 0; --i) {
                if (this.data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = this.size - 1; i >= 0; --i) {
                if (object.equals(this.data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return this.indexOf(object) >= 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.size];
        System.arraycopy(this.data, 0, result, 0, this.size);
        return result;
    }

    public void clear() {
        int size = this.size;
        for (int i = this.size = 0; i < size; ++i) {
            this.data[i] = null;
        }
    }

    public int size() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements java.util.Iterator<T> {
        private int cursor = 0;

        public boolean hasNext() {
            return cursor < size;
        }

        public T next() {
            if (!hasNext()) throw new RuntimeException("Array is empty");
            return (T) data[cursor++];
        }
    }
}
