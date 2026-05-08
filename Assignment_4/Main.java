import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("Almaty", "Astana", 720);
        graph.addEdge("Home", "AITU", 150.42);
        graph.addEdge("AITU", "Astana Hub", 15.3);
        graph.addEdge("AITU", "Lab Optic", 25.67);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, graph.getVertex("Home"));
        Vertex<String> dest = graph.getVertex("Lab Optic");

        if (bfs.hasPathTo(dest)) {
            System.out.println("Found!");
            System.out.println("Path: " + bfs.pathTo(dest));
        } else {
            System.out.println("Not found!");
        }

        Vertex<String> aitu = graph.getVertex("AITU");
        Collection<Vertex<String>> vertices = graph.getVertices();

        for (Vertex<String> vert : vertices) {
            System.out.println(vert.getData() + " is connected to: " + vert.getAdjacentVertices());
        }
    }
}
