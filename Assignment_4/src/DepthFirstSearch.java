public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<V> graph, V current) {
        marked.add(current);

        for (Vertex<V> vert : graph.getVertex(current).getAdjacentVertices().keySet()) {
            if (!marked.contains(vert.getData())) {
                edgeTo.put(vert.getData(), current);
                dfs(graph, vert.getData());
            }
        }
    }
}
