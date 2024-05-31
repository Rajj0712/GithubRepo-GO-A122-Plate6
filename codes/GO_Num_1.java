
public class GO_Num_1 {
    public static void main(String[] args) {
        Graph graph = Graph.takeEdgeInput();
        boolean connected = GraphHelper.isConnected(graph);

        if (connected) {
            System.out.println("\nThe graph is connected.");
        } else {
            System.out.println("\nThe graph is not connected.");
            int components = GraphHelper.getConnectedComponents(graph);
            System.out.printf("The number of connected components is %d.%n", components);
        }
    }
}
