import java.util.*;
import java.io.File;


// run: javac BellmanFordMain.java && java BellmanFordMain
public class BellmanFordMain {

	public static void main ( String args[] ) throws Exception {

		// read file and generate a graph for each graph problem
		Scanner sc = new Scanner(new File("ShortestPaths.txt"));

		int numCases = sc.nextInt();	

		// move to the next line
		sc.nextLine();

		// for every case, generate a graph
		// then feed it to the BellmanFord algorithm to solve the case
		for (int i = 0; i < numCases; ++i) {
			sc.nextLine();
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			int verticesCount = Integer.parseInt(parts[0]);
			int edgeCount = Integer.parseInt(parts[1]);
			// System.out.println(verticesCount + " " + edgeCount);

			Graph g = new Graph(i+1, verticesCount);

			for (int k=0; k<edgeCount; k++) {
				// System.out.println(sc.nextLine());
				String[] edgeParts = sc.nextLine().split(" ");
				int vertexFrom = Integer.parseInt(edgeParts[0]);
				int vertexTo = Integer.parseInt(edgeParts[1]);
				int weight = Integer.parseInt(edgeParts[2]);
				g.addEdge(vertexFrom, vertexTo, weight);
			}

			// Process the graph using the BellmanFord class
			BellmanFord.solve(g);

		}
		sc.close();
	}
}
