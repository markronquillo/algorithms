

public class BellmanFord 
{
	/**
	 * Will run the BellmanFord algorithm for the graph instance
	 */
	public static void solve(Graph g) {
		// put the algorithm here.	
		// the initialization is in the graph object

		int noOfVertices = g.getNoOfVertices();

		// run the relaxation on all edges noOfVertices-1 times; 
		for (int i=1; i<noOfVertices; i++) {
			relaxation(g);
		}
	
		// run the relaxation again
		// if it succeed then there is a negative cycle	
		if (relaxation(g))	{
			System.out.println();
			System.out.println("Case #" + g.getCaseNumber() + ":");
			System.out.println("\tNo solution -- graph has a negative cycle.");
		} else {
			// if there are no negative cycle. print the distance relationship
			System.out.println();
			System.out.println("Case #" + g.getCaseNumber() + ":");
			for (int i=0; i<g.getNoOfVertices(); i++) {
				System.out.println("\t0 ---> " + i + " : " + g.getDistanceValue(i));
			}
		}
	}

	/**
	 *	This function traverse all edges in the graph
	 *	and tests for the relaxation step and will update the 
	 *	distance value if it tests for true
	 *
	 *	Returns true if a relaxation occured
	 *	else false if it didn't even once.
	 */
	private static Boolean relaxation(Graph g) {
		boolean success = false;
		int noOfVertices = g.getNoOfVertices();

		// traverse all edges
		for ( int k=0; k<noOfVertices; k++ ) {
			Node node= g.getEdge(k);

			// apply relaxation on all edges
			while (node != null) {
				int weight = node.getEdgeWeight();
				int destination = node.getNodeId();

				double dv = g.getDistanceValue(destination);
				double ds = g.getDistanceValue(k);
				if (dv > ds + weight) {
					success = true; // holds a flag value if relaxation occurs even once
					g.setDistanceValue(destination, ds+weight);
				}

				node = node.getNext();
			}
		}	

		return success;
	}
}