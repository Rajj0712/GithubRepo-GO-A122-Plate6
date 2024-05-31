import java.util.Scanner;

public class GraphHelper {
    public static Graph takeEdgeInput(boolean multiEdge) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        Graph g = new Graph(sc.nextInt());

        sc.nextLine();

        while (true) {
            System.out.print("Enter edge (u v for undirected, (u,v) for directed, 'end' to stop): ");
            String input = sc.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] edgeParts = input.split(" ");
            if (edgeParts.length == 2) {
                int u = Integer.parseInt(edgeParts[0]);
                int v = Integer.parseInt(edgeParts[1]);
                g.addEdge(u, v);
            } else {
                System.out.println("Invalid input format. Please enter edges in the correct format.");
            }
        }

        return g;
    }

    public static Graph takeEdgeInput() {
        return takeEdgeInput(false);
    }

    public static int getConnectedComponents(Graph graph) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        int components = 0;
        for (int i = 0; i < graph.getNumVertices(); i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }
        return components;
    }

    public static boolean isConnected(Graph graph) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        dfs(0, graph, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int vertex, Graph graph, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.getAdjList().get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
