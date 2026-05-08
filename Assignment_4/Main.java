public class Main {
    public static void main(String[] args) {
        Vertex<String> v = new Vertex<>("Hello");
        Vertex<String> v2 = new Vertex<>("World");
        v.addAjacentVertex(v2, 13.5);

        System.out.println(v);
        System.out.println(v2);
    }
}
