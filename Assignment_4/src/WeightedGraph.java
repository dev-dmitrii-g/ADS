import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        if (hasVertex(data)) return;

        map.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);

        map.get(source).addAjacentVertex(map.get(dest), weight);

        if (undirected) {
            map.get(dest).addAjacentVertex(map.get(source), weight);
        }
    }

    public boolean hasVertex(V data) {
        return map.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return map.values();
    }
}
