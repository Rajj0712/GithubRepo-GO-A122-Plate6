import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.ejml.simple.SimpleMatrix;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public Graph(SimpleMatrix matrix) {
        this.numVertices = matrix.numCols();
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.numRows(); i++) {
            for (int j = 0; j < matrix.numCols(); j++) {
                if (matrix.get(i, j) != 0) {
                    addEdge(i, j);
                }
            }
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public static Graph takeEdgeInput() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter number of vertices: ");
        int numVertices = sc.nextInt();
        Graph g = new Graph(numVertices);
    
        sc.nextLine();
    
        String input;
    
        while (true) {
            System.out.print("Enter edge (u v for undirected, 'end' to stop): ");
            input = sc.nextLine();
    
            if (input.equals("end")) {
                break;
            }
    
            String[] parts = input.split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            g.addEdge(u, v);
        }
    
        return g;
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[numVertices];
        dfs(0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public int getConnectedComponents() {
        boolean[] visited = new boolean[numVertices];
        int components = 0;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                components++;
            }
        }
        return components;
    }

    public void printEdgesWithCounts() {
        // TODO: Implement this method
        System.out.println("Edges:");
        for (int i = 0; i < numVertices; i++) {
            for (int j : adjList.get(i)) {
                if (j > i) {
                    System.out.printf("{%d, %d}: 1%n", i, j);
                }
            }
        }
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(Graph graph) {
        int[] colors = new int[graph.getNumVertices()];
        for (int i = 0; i < graph.getNumVertices(); i++) {
            colors[i] = -1;
        }
    
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        colors[0] = 1;
    
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.getAdjList().get(u)) {
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                } else if (colors[v] == colors[u]) {
                    return false;
                }
            }
        }
    
        return true;
    }

    public static int[][] printAdjacencyMatrix(Graph graph) {
        List<List<Integer>> adjList = graph.getAdjList();
        int numVertices = graph.getNumVertices();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];
    
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = adjList.get(i).contains(j) ? 1 : 0;
            }
        }
    
        return adjacencyMatrix;
    }
    
    public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}
