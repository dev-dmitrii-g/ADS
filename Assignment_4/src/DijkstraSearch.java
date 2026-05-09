import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<Vertex<V>> unsettledNodes;
    private final Map<Vertex<V>, Double> distances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distances.put(graph.getVertex(source), 0D);
        unsettledNodes.add(graph.getVertex(source));

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode.getData());
            unsettledNodes.remove(currentNode);

            for (Vertex<V> vertex : currentNode.getAdjacentVertices().keySet()) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, vertex);

                if (getShortestDistance(vertex) > newDistance) {
                    distances.put(vertex, newDistance);
                    edgeTo.put(vertex.getData(), currentNode.getData());
                    unsettledNodes.add(vertex);
                }
            }
        }
    }

    private double getDistance(Vertex<V> node, Vertex<V> target) {
        return node.getAdjacentVertices().get(target);
    }

    private Vertex<V> getVertexWithMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex<V> minimum = null;
            for (Vertex<V> vertex : vertices) {
                if (minimum == null) {
                    minimum = vertex;
                    continue;
                }
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
        }
        return minimum;
    }

    private double getShortestDistance(Vertex<V> dest) {
        Double d = distances.get(dest);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
