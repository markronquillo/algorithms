import java.util.*;

/**
 *	Blueprint for Adjacency list representation
 *  of graphs
 */
public class Graph {

	/**
	 *	Holds the case number value for the exercise
	 */
	private int caseNumber;


	/**
	 * Holds the number of vertices in a given problem case
	 */
	private int noOfVertices;

	/**
	 * This holds the head of linked-list 
	 * represents edges for each vertex
	 */
	private Hashtable<Integer, Node> vertices;


	/**
	 *	This holds the minimum distance computed
	 *	from the Relaxation part of the algorithm
	 *	for each vertex
	 *	
	 *	Note: the initial value of each is infinity
	 *	and this array is connected to vertices
	 *	= vertices[n] = distance[n]
	 *	
	 *	** used double for the infinity value
	 */
	private double[] distance;

	public Graph(int cn, int nv) {
		caseNumber = cn;
		noOfVertices = nv;
		vertices = new Hashtable<Integer, Node>();
		distance = new double[nv];

		// since java sets the int array to zero values
		// I'll set the first item as the root node (=0)
		// and set the rest to infinity
		for (int i=1; i<noOfVertices; i++) {
			distance[i] = Double.POSITIVE_INFINITY;
		}
	}

	/**
	 *	Adds a node to a specific linkedlist in the vertices hashtable
	 */
	public void addEdge(int vertexIdFrom, int vertexIdTo, int weight) {
		Node n = new Node(vertexIdTo, weight);
		Node head = vertices.get(vertexIdFrom);

		if (head == null) {
			vertices.put(vertexIdFrom, n);
			return;
		}

		while (head.getNext() != null) {
			head = head.getNext();
		}
		head.setNext(n);
	}

	/**
	 *	Getter for caseNumber
	 */
	public int getCaseNumber() {
		return this.caseNumber;
	}

	/**
	 *	Return the head of the linkedlist 
	 *	for a given vertex
	 */
	public Node getEdge(int vertexId) {
		return vertices.get(vertexId);
	}

	/**
	 *	Returns current distance value of a vertex
	 * 	from the source
	 */
	public double getDistanceValue(int vertexId) {
		return this.distance[vertexId];
	}

	/**
	 * Setter for distance value of a verter from the source node
	 */
	public void setDistanceValue(int vertexId, double distanceValue) {
		this.distance[vertexId]	 = distanceValue;
	}

	/**
	 *	Getter for noOfVertices
	 */
	public int getNoOfVertices() {
		return this.noOfVertices;
	}

	/**
	 *	Overrides toString function
	 *	prints the Graph info, vertices and edge
	 *	for viewing purposes.
	 */
	public void printSelf() {
		// System.out.println(noOfVertices);

		for (int i=0; i<noOfVertices; i++) {
			Node n = vertices.get(i);
			while (n != null) {
				System.out.println( i + " " + n.toString() );
				n = n.getNext()	;
			}
		}

		System.out.println("Distance:");
		for (int i=0; i<noOfVertices; i++) {
			System.out.println("vertex: " + i + " value: " + distance[i]);
		}
	}
}