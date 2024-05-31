public class GO_Num_4 {
    public static void main(String[] args) {
        Graph graph = GraphHelper.takeEdgeInput();
        printDegrees(graph);
    }

    public static void printDegrees(Graph graph) {
        for (int i = 0; i < graph.getNumVertices(); i++) {
            System.out.printf("Vertex %d has %d degree%n", i, graph.getAdjList().get(i).size());
        }
    }
}
