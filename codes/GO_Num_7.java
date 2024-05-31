import java.util.*;

public class GO_Num_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter edge (u v count): ");
            String[] input = sc.nextLine().split(" ");
            edges.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }

        int maxVertex = edges.stream().mapToInt(e -> Math.max(e[0], e[1])).max().orElse(-1) + 1;
        int[][] incidenceMatrix = new int[maxVertex][n];

        edges.forEach(edge -> {
            incidenceMatrix[edge[0]][edges.indexOf(edge)] = edge[2];
            incidenceMatrix[edge[1]][edges.indexOf(edge)] = edge[2];
        });

        Arrays.stream(incidenceMatrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\],]", "")).forEach(System.out::println);
    }
}
