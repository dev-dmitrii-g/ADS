import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        marked.add(current);

        Queue<V> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            V v = queue.remove();

            for (Vertex<V> vert : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (!marked.contains(vert.getData())) {
                    marked.add(vert.getData());
                    edgeTo.put(vert.getData(), v);
                    queue.add(vert.getData());
                }
            }
        }
    }
}
