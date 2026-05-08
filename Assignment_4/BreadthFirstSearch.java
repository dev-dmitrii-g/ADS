import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> current) {
        marked.add(current);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();

            for (Vertex<V> vert : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(vert)) {
                    marked.add(vert);
                    edgeTo.put(vert, v);
                    queue.add(vert);
                }
            }
        }
    }
}
