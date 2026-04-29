public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public void insert(T item) {
        list.add(item);
        int i = list.size() - 1;

        while (i != 0 && list.get(i).compareTo(list.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public T extractMin() {
        if (list.size() == 0) throw new IllegalStateException("Heap is empty");
        if (list.size() == 1) {
            T root = list.getFirst();
            list.removeLast();
            return root;
        }
        T root = list.getFirst();
        list.set(0, list.getLast());
        list.removeLast();
        minHeapify(0);
        return root;
    }

    private void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int small = i;
        if (l < list.size() && list.get(l).compareTo(list.get(small)) < 0) {
            small = l;
        }
        if (r < list.size() && list.get(r).compareTo(list.get(small)) < 0) {
            small = r;
        }
        if (small != i) {
            swap(i, small);
            minHeapify(small);
        }
    }

    private void swap(int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public T getMin() {
        if (list.size() == 0) throw new IllegalStateException();
        return list.getFirst();
    }
}
