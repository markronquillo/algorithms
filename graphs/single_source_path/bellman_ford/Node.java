
/**
 *	Vertex class for the graph
 */
public class Node 
{
	private int nodeId;
	private int edgeWeight = 0;
	private Node next = null;

	public Node(int id, int eW) {
		this.nodeId = id;
		this.edgeWeight = eW;
	}

	public int getEdgeWeight() {
		return this.edgeWeight;
	}

	public int getNodeId() {
		return this.nodeId;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public Node getNext() {
		return this.next;
	}

	public String toString() {
		return this.nodeId + " " + this.edgeWeight;
	}

}