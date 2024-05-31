
public class GO_Num_5 {
    public static void main(String[] args) {
        Graph graph = Graph.takeEdgeInput();
        if (Graph.isBipartite(graph)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
