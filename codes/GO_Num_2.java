import org.ejml.simple.SimpleMatrix;
import java.util.Scanner;

public class GO_Num_2 {
    public static void main(String[] args) {
        SimpleMatrix matrix = takeAdjacencyMatrixInput();
        if (matrix != null) {
            final Graph g = new Graph(matrix);
            g.printEdgesWithCounts();
        } else {
            System.out.println("Failed to create the adjacency matrix.");
        }
    }

    public static SimpleMatrix takeAdjacencyMatrixInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        sc.nextLine();

        double[][] matrix = new double[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            System.out.printf("Enter row %d of adjacency matrix: ", i + 1);
            String[] input = sc.nextLine().split(" ");

            for (int j = 0; j < vertices; j++) {
                int val = Integer.parseInt(input[j]);
                if (val != 0 && matrix[i][val-1] == 0) { // Check if the edge is not already added
                    matrix[i][val-1] = 1;
                }
            }
        }

        return new SimpleMatrix(matrix);
    }
}
