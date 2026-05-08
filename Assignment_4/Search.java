import java.util.*;

public class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.contains(vertex);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) return null;

        LinkedList<Vertex<V>> ls = new LinkedList<>();
        for (Vertex<V> i = vertex; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }

        ls.push(source);
        return ls;
    }
}
