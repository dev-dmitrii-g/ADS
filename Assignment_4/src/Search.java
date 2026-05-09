import java.util.*;

public class Search<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V data) {
        return marked.contains(data);
    }

    public Iterable<V> pathTo(V data) {
        if (!hasPathTo(data)) return null;

        LinkedList<V> ls = new LinkedList<>();
        for (V i = data; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }

        ls.push(source);
        return ls;
    }
}
