public class GO_Num_3 {
    public static void main(String[] args) {
        Graph graph = GraphHelper.takeEdgeInput();
        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}