import java.util.*;
import java.util.stream.Collectors;

public class GO_Num_8 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Input vertices for graph A: ");
        var gVerts = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        System.out.print("Input vertices for graph B: ");
        var hVerts = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        if (gVerts.size() != hVerts.size()) {
            System.out.println("The graphs are not isomorphic.");
        } else {
            Map<String, String> mapping = new HashMap<>();
            if (areIsomorphic(gVerts, hVerts, mapping)) {
                System.out.println("The graphs are isomorphic.");
            } else {
                System.out.println("The graphs are not isomorphic.");
            }
        }
    }

    public static boolean areIsomorphic(List<String> gVerts, List<String> hVerts, Map<String, String> mapping) {
        Set<String> mappedVertices = new HashSet<>();
        for (int i = 0; i < gVerts.size(); i++) {
            String gVertex = gVerts.get(i);
            String hVertex = hVerts.get(i);

            if (mapping.containsKey(gVertex)) {
                if (!mapping.get(gVertex).equals(hVertex)) {
                    return false; // The current mapping does not match
                }
            } else {
                if (mappedVertices.contains(hVertex)) {
                    return false; // The hVertex is already mapped to another gVertex
                }

                mapping.put(gVertex, hVertex);
                mappedVertices.add(hVertex);
            }
        }
        return true;
    }
}
