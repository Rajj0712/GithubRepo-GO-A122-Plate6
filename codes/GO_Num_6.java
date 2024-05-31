public class GO_Num_6 {
    public static void main(String[] args) {
        Graph graph = new Graph(0); 
        graph = Graph.takeEdgeInput(); 
        int[][] adjacencyMatrix = Graph.printAdjacencyMatrix(graph); 
        Graph.printAdjacencyMatrix(adjacencyMatrix); 
    }
}
